package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Centroeducativo;
import models.Nivel;

public class ControladorNivel {
	private static Connection conn = null;

	public static Nivel guardar(Nivel nv) {
		try {

			if (nv.getId() != 0) {
				update(nv);
				return null;
			} else {
				return guardarNuevo(nv);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 */
	private static Nivel guardarNuevo(Nivel nv) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into nivelesymaterias.curso set id = ?, descripcion = ?, idNivel = ?");

			ps.setInt(1, nv.getId());

			ps.setString(2, nv.getDescri());

			ps.setInt(3, nv.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return nv;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	private static void update(Nivel nv) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn
				.prepareStatement("update nivelesymaterias.curso set descripcion = ? where id =" + nv.getId());

		ps.setString(1, nv.getDescri());

		ps.setInt(2, nv.getId());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}

	public static Nivel cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Nivel curs = null;
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymateria.nivel order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs = new Nivel();
				curs.setId(rs.getInt(1));
				curs.setDescri(rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();
			return curs;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static List<Nivel> findAll() {
		List<Nivel> lc = new ArrayList<Nivel>();
		Nivel c = cargarPrimerRegistro();
		do {
			lc.add(c);
		} while (c != null);
		return lc;
	}
}

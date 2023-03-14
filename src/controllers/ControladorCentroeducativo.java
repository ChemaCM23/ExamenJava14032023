package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Centroeducativo;

public class ControladorCentroeducativo {
	private static Connection conn = null;

	public static Centroeducativo guardar(Centroeducativo ce) {
		try {

			if (ce.getId() != 0) {
				update(ce);
				return null;
			} else {
				return guardarNuevo(ce);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 */
	private static Centroeducativo guardarNuevo(Centroeducativo ce) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into nivelesymaterias.centroeducativo set id = ?, descripcion = ? ");

			ps.setInt(1, ce.getId());

			ps.setString(2, ce.getDescri());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ce;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	private static void update(Centroeducativo ce) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update nivelesymaterias.centroeducativo set descripcion = ? where id =" + ce.getId());

		ps.setString(1, ce.getDescri());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}

	public static Centroeducativo cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Centroeducativo curs = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from nivelesymaterias.centroeducativo order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs = new Centroeducativo();
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

	public static List<Centroeducativo> findAll() {
		List<Centroeducativo> lc = new ArrayList<Centroeducativo>();
		Centroeducativo c = cargarPrimerRegistro();
		do {
			lc.add(c);
		} while (c != null);
		return lc;
	}
}

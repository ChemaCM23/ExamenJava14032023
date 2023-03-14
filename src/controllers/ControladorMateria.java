package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Centroeducativo;
import models.Materia;

public class ControladorMateria {
	private static Connection conn = null;

	public static List<Materia> cargarMaterias(int id) {
		List<Materia> lc = new ArrayList<Materia>();
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from nivelesymaterias.materia where curso_id = " + id);
			ResultSet rs = ps.executeQuery();
			Materia m = null;
			while (rs.next()) {
				m = new Materia();
				m.setId(rs.getInt(1));
				m.setNombre(rs.getString(2));
				Centroeducativo c = new Centroeducativo();
				c.setId(rs.getInt(3));
				m.setCurso(c);
				m.setMatricula(rs.getBoolean("matricula"));
				m.setFecha(rs.getDate("fecha"));
				lc.add(m);

			}
			rs.close();
			ps.close();
			conn.close();
			return lc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Materia guardar(Materia mat) {
		try {

			if (mat.getId() != 0) {
				update(mat);
				return null;
			} else {
				return guardarNuevo(mat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 
	 */
	private static Materia guardarNuevo(Materia mat) {
		try {

			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"insert into nivelesymaterias.materia set id = ?, nombre = ?, acronimo = ?, curso_id = ?");

			ps.setInt(1, mat.getId());

			ps.setString(2, mat.getNombre());
//			ps.setString(3, mat.getAcronimo());
			ps.setInt(3, mat.getCurso().getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mat;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static void update(Materia mat) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update nivelesymaterias.materia set nombre = ?, acronimo = ?, curso_id = ? where id =" + mat.getId());

		ps.setString(1, mat.getNombre());
//		ps.setString(2, mat.getAcronimo());
		ps.setInt(3, mat.getCurso().getId());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}

	public static Materia cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Materia mat = null;
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.materia order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				mat = new Materia();
				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getString(2));
				Centroeducativo c = new Centroeducativo();
				c.setId(rs.getInt(3));
				mat.setCurso(c);

				rs.close();
				ps.close();
				conn.close();
				return mat;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Materia> findAll() {
		List<Materia> lc = new ArrayList<Materia>();
		Materia ma = cargarPrimerRegistro();
		do {
			lc.add(ma);

		} while (ma != null);
		return lc;
	}

}

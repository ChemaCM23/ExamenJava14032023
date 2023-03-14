package models;

import java.sql.Date;

public class Materia {
	private int id;
	private String nombre;
	private int idNivel;
	private String codigo;
	private String urlClassroom;
	private boolean matricula;
	private Date fecha;
	private Centroeducativo curso;

	public Materia() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param idNivel
	 * @param codigo
	 * @param urlClassroom
	 * @param matricula
	 * @param fecha
	 * @param curso
	 */
	public Materia(int id, String nombre, int idNivel, String codigo, String urlClassroom, boolean matricula,
			Date fecha, Centroeducativo curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idNivel = idNivel;
		this.codigo = codigo;
		this.urlClassroom = urlClassroom;
		this.matricula = matricula;
		this.fecha = fecha;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUrlClassroom() {
		return urlClassroom;
	}

	public void setUrlClassroom(String urlClassroom) {
		this.urlClassroom = urlClassroom;
	}

	public boolean isMatricula() {
		return matricula;
	}

	public void setMatricula(boolean matricula) {
		this.matricula = matricula;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Centroeducativo getCurso() {
		return curso;
	}

	public void setCurso(Centroeducativo curso) {
		this.curso = curso;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Materia) obj).id;
	}

}

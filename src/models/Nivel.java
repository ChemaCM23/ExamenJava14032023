package models;

public class Nivel {

	private int id;
	private String descri;

	public Nivel() {

	}

	public Nivel(int id, String descri) {
		super();
		this.id = id;
		this.descri = descri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Override
	public String toString() {
		return "Curso " + descri;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Nivel) obj).id;
	}

}

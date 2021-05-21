package model.beans;

public class Editora {
	private int idEditora;
	private String editora;
	
	
	
	public Editora() {
		super();
	}
	
	
	
	public Editora(int idEditora, String editora) {
		super();
		this.idEditora = idEditora;
		this.editora = editora;
	}



	public int getIdEditora() {
		return idEditora;
	}
	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
	
}

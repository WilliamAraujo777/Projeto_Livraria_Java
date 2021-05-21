package model.beans;

public class Autores {
	private int idAutor;
	private String nomeAutor;
	private String sobrenomeAutor;
	
	public Autores() {
		super();
	}
	
	public Autores(int idAutor, String nomeAutor, String sobrenomeAutor) {
		super();
		this.idAutor = idAutor;
		this.nomeAutor = nomeAutor;
		this.sobrenomeAutor = sobrenomeAutor;
	}

	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getSobrenomeAutor() {
		return sobrenomeAutor;
	}
	public void setSobrenomeAutor(String sobrenomeAutor) {
		this.sobrenomeAutor = sobrenomeAutor;
	}
	
}

package model.beans;

public class Assunto {
	
	private int idAssunto;
	private String assunto;
	
	public Assunto() {
		super();	
	}
	
	public Assunto(int idAssunto, String assunto) {
		super();
		this.idAssunto = idAssunto;
		this.assunto = assunto;
	}

	public int getIdAssunto() {
		return idAssunto;
	}
	public void setIdAssunto(int idAssunto) {
		this.idAssunto = idAssunto;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	
	

}

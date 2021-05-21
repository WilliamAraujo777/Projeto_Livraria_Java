package model.beans;

public class Livros {
	
	private	int    idLivro;
	private String nomeLivro;
	private String isbn13;
	private String dataPub;
	private Double preco;
	private int paginas;
	private Editora editora;
	private Assunto assunto;

	public Livros() {
		super();
	}
	
	
	public Livros(int idLivro, String nomeLivro, String isbn13, String dataPub, Double preco, int paginas,
			Editora editora, Assunto assunto) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.isbn13 = isbn13;
		this.dataPub = dataPub;
		this.preco = preco;
		this.paginas = paginas;
		this.editora = editora;
		this.assunto = assunto;
	}


	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public String getDataPub() {
		return dataPub;
	}
	public void setDataPub(String dataPub) {
		this.dataPub = dataPub;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public Assunto getAssunto() {
		return assunto;
	}
	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}
	
	

	
	

}

package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.connectionFactory;
import model.beans.Assunto;
import model.beans.Editora;
import model.beans.Livros;



public class livroDAO {
	
	private Connection con = null;
	
	
	public livroDAO() {
		
	}
	
	
	
	/* INSERIR LIVROS */
	public boolean save(Livros livro) {
		
		String sql = "INSERT INTO tbl_livros (nomeLivro , ISBN13, dataPub, precoLivro, numeroPaginas, idEditora, idAssunto)"
				+ "VALUES (?,?,?,?,?,?,?)";
		
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, livro.getNomeLivro());
			stmt.setString(2, livro.getIsbn13());
			stmt.setString(3, livro.getDataPub());
			stmt.setDouble(4, livro.getPreco());
			stmt.setInt   (5, livro.getPaginas());
			stmt.setInt(6, livro.getEditora().getIdEditora());
			stmt.setInt(7, livro.getAssunto().getIdAssunto());
			stmt.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			connectionFactory.closeConnection(con,stmt);
		}
		
		
	}
	
	/* LISTAR TODOS OS LIVROS */
	public List<Livros> listarLivros() {
		List<Livros> livros = new ArrayList<>();
		String read = "select * from tbl_livros";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read);
			rs = stmt.executeQuery();
			//o laço abaixo sera executado enquanto houver contatos
			while(rs.next()) {
				Livros livro = new Livros();
				Editora editora = new Editora();
				Assunto assunto = new Assunto();
				
				livro.setIdLivro(rs.getInt("Idlivro"));
				livro.setNomeLivro(rs.getString("nomeLivro"));
				livro.setIsbn13(rs.getString("isbn13"));
				livro.setDataPub(rs.getString("dataPub"));
				livro.setPreco(rs.getDouble("precoLivro"));
				livro.setPaginas(rs.getInt("numeroPaginas"));
				editora.setIdEditora(rs.getInt("idEditora"));
				assunto.setIdAssunto(rs.getInt("idAssunto"));
				
				livro.setEditora(editora);
				livro.setAssunto(assunto);
				//populando arraylist
				livros.add(livro);
				
				
			}
			
		} catch (SQLException e){
			System.err.println("Erro: " +e);
			return null;
		}finally {
			connectionFactory.closeConnection(con,stmt,rs);
		}
		return livros;
	}
	
	/*EDITAR LIVRO*/
	public void selecionarLivro(Livros livro) {
		String read2 = "SELECT * FROM tbl_livros WHERE idLivro = ?";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read2);
			stmt.setInt(1, livro.getIdLivro());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Editora editora = new Editora();
				Assunto assunto = new Assunto();
				livro.setIdLivro(rs.getInt(1));
				livro.setNomeLivro(rs.getString(2));
				livro.setIsbn13(rs.getString(3));
				livro.setDataPub(rs.getString(4));
				livro.setPreco(rs.getDouble(5));
				livro.setPaginas(rs.getInt(6));
				editora.setIdEditora(rs.getInt(7));
				assunto.setIdAssunto(rs.getInt(8));
				livro.setEditora(editora);
				livro.setAssunto(assunto);
			
			}
		} catch (Exception e) {
			System.err.println("Erro: " +e);
		} finally {
			connectionFactory.closeConnection(con,stmt,rs);
		}
	}
	
	/*public boolean update (Livros livro) {
		String sql = "UPDATE tbl_livros SET (";
		
	}*/
}
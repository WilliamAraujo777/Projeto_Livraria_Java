package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionFactory;
import model.beans.Assunto;
import model.beans.Editora;
import model.beans.Livros;

public class LivroDAO {
	
	private Connection con = null;
	
	public LivroDAO() {
		
	}
	/* INSERIR LIVROS */

	public boolean save(Livros livro) {
		
			String sql = "INSERT INTO tbl_livros (nomeLivro , ISBN13, dataPub, precoLivro, numeroPaginas, idEditora, idAssunto)"
					+ "VALUES (?,?,?,?,?,?,?)";
			
			con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, livro.getNomeLivro());
				stmt.setString(2, livro.getIsbn13());
				stmt.setString(3, livro.getDataPub());
				stmt.setDouble(4, livro.getPreco());
				stmt.setInt   (5, livro.getPaginas());
				stmt.setInt   (6, livro.getEditora().getIdEditora());
				stmt.setInt   (7, livro.getAssunto().getIdAssunto());
				stmt.executeUpdate();
	            return true;
			} catch (SQLException e) {
				System.err.println("Erro: " +e);
				return false;
		}finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
	}
	/* LISTAR TODOS OS LIVROS */
	public List<Livros> listarLivros() {
		List<Livros> livros = new ArrayList<>();
		String read = "SELECT * FROM vw_livros_editora_assunto";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read);
			rs = stmt.executeQuery();
			//o laco abaixo sera executado enquanto houver l
			while(rs.next()) {
				Livros livro = new Livros();
				Editora editora = new Editora();
				Assunto assunto = new Assunto();
				
				livro.setIdLivro(rs.getInt(1));
				livro.setNomeLivro(rs.getString(2));
				livro.setIsbn13(rs.getString(3));
				livro.setDataPub(rs.getString(4));
				livro.setPreco(rs.getDouble(5));
				livro.setPaginas(rs.getInt(6));
				editora.setEditora(rs.getString(7));
				assunto.setAssunto(rs.getString(8));
				
				livro.setEditora(editora);
				livro.setAssunto(assunto);
				//populando arraylist
				livros.add(livro);
			}
			
		} catch (SQLException e){
			System.err.println("Erro: " +e);
			return null;
		}finally {
			ConnectionFactory.closeConnection(con,stmt,rs);
		}
		return livros;
	}
	
	/*EDITAR LIVRO*/
	public void selecionarLivro(Livros livro) {
		String read2 = "SELECT * FROM vw_livros_editora_assunto WHERE idLivro = ?";
		con = ConnectionFactory.getConnection();
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
				editora.setEditora(rs.getString(7));
				assunto.setAssunto(rs.getString(8));
				livro.setEditora(editora);
				livro.setAssunto(assunto);
			
			}
		} catch (Exception e) {
			System.err.println("Erro: " +e);
		} finally {
			ConnectionFactory.closeConnection(con,stmt,rs);
		}
	}
	
	//CRUD **UPDATE LIVRO**
	public boolean update (Livros livro) {
		String sql = "UPDATE tbl_livros set nomeLivro=?, ISBN13=?, dataPub=?, precoLivro=?, numeroPaginas=? where idLivro = ?";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, livro.getNomeLivro());
			stmt.setString(2, livro.getIsbn13());
			stmt.setString(3, livro.getDataPub());
			stmt.setDouble(4, livro.getPreco());
			stmt.setInt   (5, livro.getPaginas());
			stmt.setInt   (6, livro.getIdLivro());
			stmt.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
	}
	
	//CRUD **DELETE LIVRO**
	public boolean delete(Livros livro) {
		String sql = "DELETE FROM tbl_livros WHERE idLivro = ? ";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, livro.getIdLivro());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
	}
}

package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Autores;






public class AutorDAO {
	
	private Connection con = null;
	
	
	public AutorDAO() {
		
	}
	
	
	
	public boolean save(Autores autor) {
		
		String sql = "INSERT INTO tbl_autores (NomeAutor, SobrenomeAutor) VALUES (?,?)";
		
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, autor.getNomeAutor());
			stmt.setString(2, autor.getSobrenomeAutor());
			stmt.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
		
	}
	
	public List<Autores> listarAutor() {
		List<Autores> autores = new ArrayList<>();
		String read = "select * from tbl_autores";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read);
			rs = stmt.executeQuery();
			//o laço abaixo sera executado enquanto houver autores
			while(rs.next()) {
				Autores autor = new Autores();
				autor.setIdAutor(rs.getInt("IdAutor"));
				autor.setNomeAutor(rs.getString("NomeAutor"));
				autor.setSobrenomeAutor(rs.getString("SobrenomeAutor"));
				//populando arraylist
				autores.add(autor);
			}
			return autores;
		} catch (SQLException e){
			System.err.println("Erro: " +e);
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	//CRUD **UPDATE AUTOR**
		public void selecionarAutor(Autores autor) {
			String sql = "SELECT * FROM tbl_autores WHERE IdAutor = ?";
			con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, autor.getIdAutor());
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					autor.setIdAutor(rs.getInt(1));
					autor.setNomeAutor(rs.getString(2));
					autor.setSobrenomeAutor(rs.getString(3));
				
				}
			} catch (SQLException e) {
				System.err.println("Erro: " +e);
			} finally {
				ConnectionFactory.closeConnection(con,stmt,rs);
			}
		}
		
		public boolean update (Autores autor) {
			String sql = "UPDATE tbl_autores set NomeAutor=?, SobrenomeAutor=? where IdAutor = ?";
			con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, autor.getNomeAutor());
				stmt.setString(2, autor.getSobrenomeAutor());
				stmt.setInt   (3, autor.getIdAutor());
				stmt.executeUpdate(); 
				return true;
			} catch (SQLException e) {
				System.err.println("Erro: " +e);
				return false;
			}finally {
				ConnectionFactory.closeConnection(con,stmt);
			}
			
			
		}
		//CRUD **DELETE AUTOR**
		public boolean delete(Autores autor) {
			String sql = "DELETE FROM tbl_autores WHERE IdAutor = ? ";
			con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, autor.getIdAutor());
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
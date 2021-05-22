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

public class editoraDAO {
	
	private Connection con = null;
	
	
	public editoraDAO() {
		
	}
	public boolean save(Editora editora) {
		
		String sql = "INSERT INTO tbl_editoras (NomeEditora) VALUES (?)";
		
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, editora.getEditora());
			stmt.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			connectionFactory.closeConnection(con);
		}
		
	}
	
	public List<Editora> listarEditora() {
		List<Editora> editoras = new ArrayList<>();
		String read = "select * from tbl_editoras";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read);
			rs = stmt.executeQuery();
			//o laço abaixo sera executado enquanto houver editoras
			while(rs.next()) {
				Editora edit = new Editora();
				edit.setIdEditora(rs.getInt("IdEditora"));
				edit.setEditora(rs.getString("NomeEditora"));
				//populando arraylist
				editoras.add(edit);
			}
			return editoras;
		} catch (SQLException e){
			System.err.println("Erro: " +e);
			return null;
		}finally {
			connectionFactory.closeConnection(con);
		}
	}
	
	/*EDITAR EDITORA*/
	public void selecionarEditora(Editora edit) {
		String sql = "SELECT * FROM tbl_editoras WHERE IdEditora = ?";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, edit.getIdEditora());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				edit.setIdEditora(rs.getInt(1));
				edit.setEditora(rs.getString(2));
			
			}
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
		} finally {
			connectionFactory.closeConnection(con,stmt,rs);
		}
	}
	
	//CRUD **UPDATE EDITORA**
	public boolean update (Editora edit) {
		String sql = "UPDATE tbl_editoras set NomeEditora=? where IdEditora = ?";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, edit.getEditora());
			stmt.setInt   (2, edit.getIdEditora());
			stmt.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			connectionFactory.closeConnection(con,stmt);
		}
		
		
	}
	
	//CRUD **DELETE EDITORA**
	public boolean delete(Editora edit) {
		String sql = "DELETE FROM tbl_editoras WHERE IdEditora = ? ";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, edit.getIdEditora());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			connectionFactory.closeConnection(con,stmt);
		}
	}
	
	
	
	
	}
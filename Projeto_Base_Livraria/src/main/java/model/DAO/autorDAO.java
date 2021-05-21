package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.connectionFactory;
import model.beans.Autores;






public class autorDAO {
	
	private Connection con = null;
	
	
	public autorDAO() {
		
	}
	
	
	
	public boolean save(Autores autor) {
		
		String sql = "INSERT INTO tbl_autores (NomeAutor, SobrenomeAutor) VALUES (?,?)";
		
		con = connectionFactory.getConnection();
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
			connectionFactory.closeConnection(con);
		}
		
	}
	
	public List<Autores> listarAutor() {
		List<Autores> autores = new ArrayList<>();
		String read = "select * from tbl_autores";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read);
			rs = stmt.executeQuery();
			//o laço abaixo sera executado enquanto houver editoras
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
			connectionFactory.closeConnection(con);
		}
	}
	
	
	
	
	}
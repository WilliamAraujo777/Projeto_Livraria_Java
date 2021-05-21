package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.connectionFactory;
import model.beans.Assunto;






public class assuntoDAO {
	
	private Connection con = null;
	
	
	public assuntoDAO() {
		
	}
	
	
	
	public boolean save(Assunto assunto) {
		
		String sql = "INSERT INTO tbl_assuntos (Assunto) VALUES (?)";
		
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, assunto.getAssunto());
			stmt.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			connectionFactory.closeConnection(con,stmt);
		}
		
	}
	
	public List<Assunto> listarAssunto() {
		List<Assunto> assuntos = new ArrayList<>();
		String read = "select * from tbl_assuntos";
		con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read);
			rs = stmt.executeQuery();
			//o laço abaixo sera executado enquanto houver editoras
			while(rs.next()) {
				Assunto assunto = new Assunto();
				assunto.setIdAssunto(rs.getInt("IdAssunto"));
				assunto.setAssunto(rs.getString("Assunto"));
				//populando arraylist
				assuntos.add(assunto);
			}
			return assuntos;
		} catch (SQLException e){
			System.err.println("Erro: " +e);
			return null;
		}finally {
			connectionFactory.closeConnection(con);
		}
	}
	
	
	
	
	}
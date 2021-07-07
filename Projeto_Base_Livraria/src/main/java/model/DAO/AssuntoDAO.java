package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.beans.Assunto;

public class AssuntoDAO {
	
	private Connection con = null;
	
	
	public AssuntoDAO() {
		
	}

	public boolean save(Assunto assunto) {
		
		String sql = "INSERT INTO tbl_assuntos (Assunto) VALUES (?)";
		
		con = ConnectionFactory.getConnection();
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
			ConnectionFactory.closeConnection(con,stmt);
		}
		
	}
	
	public List<Assunto> listarAssunto() {
		List<Assunto> assuntos = new ArrayList<>();
		String read = "select * from tbl_assuntos";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read);
			rs = stmt.executeQuery();
			//o laço abaixo sera executado enquanto houver assuntos
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
			ConnectionFactory.closeConnection(con);
		}
	}

	/*EDITAR ASSUNTO*/
	public void selecionarAssunto(Assunto assunto) {
		String read2 = "SELECT * FROM tbl_assuntos WHERE IdAssunto = ?";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(read2);
			stmt.setInt(1, assunto.getIdAssunto());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				assunto.setIdAssunto(rs.getInt(1));
				assunto.setAssunto(rs.getString(2));
			
			}
		} catch (Exception e) {
			System.err.println("Erro: " +e);
		} finally {
			ConnectionFactory.closeConnection(con,stmt,rs);
		}
	}
	
	//CRUD **UPDATE ASSUNTO**
	public boolean update (Assunto assunto) {
		String sql = "UPDATE tbl_assuntos set Assunto=? where IdAssunto = ?";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, assunto.getAssunto());
			stmt.setInt   (2, assunto.getIdAssunto());
			stmt.executeUpdate(); 
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " +e);
			return false;
		}finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		
	}
	
	//CRUD **DELETE ASSUNTO**
	public boolean delete(Assunto assunto) {
		String sql = "DELETE FROM tbl_assuntos WHERE IdAssunto = ? ";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, assunto.getIdAssunto());
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
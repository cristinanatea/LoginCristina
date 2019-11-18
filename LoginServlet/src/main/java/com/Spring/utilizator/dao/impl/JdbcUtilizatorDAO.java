package com.Spring.utilizator.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.Spring.utilizator.dao.UtilizatorDAO;
import com.Spring.utilizator.model.Utilizator;

public  class JdbcUtilizatorDAO implements UtilizatorDAO
{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Utilizator utilizator){
		
		String sql = "INSERT INTO Utilizator " +
				"(username, email, password) VALUES (?,?,?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, utilizator.getUsername());
			ps.setString(2, utilizator.getEmail());
			ps.setString(3, utilizator.getPassword());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Utilizator findBUtilizatorId(int utilizatorID){
		
		String sql = "SELECT * FROM Utilizator WHERE utilizatorID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, utilizatorID);
			Utilizator utilizator = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				utilizator = new Utilizator(
					rs.getInt("utilizatorID"),
					rs.getString("username"),
					rs.getString("email"), 
					rs.getString("password")
				);
			}
			rs.close();
			ps.close();
			return utilizator;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Utilizator getUser(String email, String password){
		
		String sql = "SELECT * FROM Utilizator WHERE email = ? and password = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			Utilizator utilizator = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				utilizator = new Utilizator(
					rs.getInt("utilizatorID"),
					rs.getString("username"),
					rs.getString("email"), 
					rs.getString("password")
				);
			}
			rs.close();
			ps.close();
			return utilizator;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
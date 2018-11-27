package DAO;

import java.sql.*;

public class DAO {
	private final String name = "root";
	private final String url = "jdbc:mysql://localhost:3306/car";
	private final String pass = "";
	private final String dbClass = "com.mysql.cj.jdbc.Driver";
	private Connection connection = null;

	public DAO() {
		if (connection == null) {
			try {
				Class.forName(dbClass);
				this.connection = DriverManager.getConnection(url, name, pass);
			} catch (SQLException e) {
				System.out.println("Error to conect Database");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection conn) {
		this.connection = conn;
	}
	public void openConnection() {
		try {
			Class.forName(dbClass);
			this.connection = DriverManager.getConnection(url, name, pass);
		} catch (SQLException e) {
			System.out.println("Error to conect Database");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ResultSet excuteSelectById(int id, String table) {
		String sql = "SELECT * FROM " + table + " WHERE id = ?";
		ResultSet rs = null;
		try {
			PreparedStatement pr = this.connection.prepareStatement(sql);
			pr.setString(1, "" + id);
			rs = pr.executeQuery();
			pr.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return rs;
	}

	public ResultSet excuteSelectByName(String s, String table) {
		String sql = "SELECT * FROM " + table + " WHERE name LIKE ?";
		ResultSet rs = null;
		try {
			PreparedStatement pr = this.connection.prepareStatement(sql);
			pr.setString(1, "%" + s + "%");
			rs = pr.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rs;
	}

	public ResultSet excuteSql(String sql) {
		ResultSet rs = null;
		try {
			PreparedStatement pr = this.connection.prepareStatement(sql);
			rs = pr.executeQuery();
			pr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rs;
	}

	public int excuteDeleteById(int id, String table) {
		int rows = 0;
		String sql = "DELETE FROM " + table + " WHERE id = ?";
		try {
			PreparedStatement pr = this.connection.prepareStatement(sql);
			pr.setString(1, "" + id);
			rows = pr.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rows;
	}
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

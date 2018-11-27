package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import model.entity;

public class UserDAO extends DAO implements entityDAO {

	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<entity> search(String name) {
		// TODO Auto-generated method stub
		ArrayList<entity> listUser = new ArrayList<>();
		String sql = "SELECT * FROM tbluser WHERE name LIKE ?";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setDateOfBirth(rs.getInt(3));
				user.setGender(rs.getString("gender"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setDecentralization(rs.getString("decentralization"));
				user.setAvatar(rs.getString("avatar"));
				listUser.add(user);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return listUser;
	}

	@Override
	public void insert(entity e) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tbluser(name, date_of_birth, gender,username, password,decentralization,avatar)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			User u = (User) e;
			ps.setString(1, u.getUsername());
			ps.setInt(2, u.getDateOfBirth());
			ps.setString(3, u.getGender());
			ps.setString(4, u.getUsername());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getDecentralization());
			ps.setString(7, u.getAvatar());
			ps.execute();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void update(int id, entity e) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tbluser SET name = ?," + "date_of_birth = ?," + "gender=?," + "username=?," + "password=?,"
				+ "decentralization=?," + "avatar=?" + " WHERE id = ?";
		try {
			User u = new User();
			u = (User) e;
			System.out.println(u.getName());
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			pr.setString(1, u.getName());
			pr.setInt(2, u.getDateOfBirth());
			pr.setString(3, u.getGender());
			pr.setString(4, u.getUsername());
			pr.setString(5, u.getPassword());
			pr.setString(6, u.getDecentralization());
			pr.setString(7, u.getAvatar());
			pr.setInt(8, id);
			pr.executeUpdate();
			pr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.excuteDeleteById(id, "tbluser");

	}

	@Override
	public entity selectById(int id) {
		// TODO Auto-generated method stub
		User e = new User();
		String sql = "SELECT * FROM tbluser WHERE id =" + id;
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setName(rs.getString(2));
				e.setDateOfBirth(rs.getInt(3));
				e.setGender(rs.getString("gender"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setDecentralization(rs.getString("decentralization"));
				e.setAvatar(rs.getString("avatar"));
			}
			ps.close();
			rs.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		return e;
	}

	@Override
	public ArrayList<entity> selectAll() {
		// TODO Auto-generated method stub
		

		ArrayList<entity> listEntity = new ArrayList<>();
		try {
			PreparedStatement ps = this.getConnection().prepareStatement("SELECT * FROM tbluser");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User e = new User();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString(2));
				e.setDateOfBirth(rs.getInt(3));
				e.setGender(rs.getString("gender"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setDecentralization(rs.getString("decentralization"));
				e.setAvatar(rs.getString("avatar"));
				listEntity.add(e);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listEntity;
	}
	public User getUserByUserName(String username) {
		User e = new User();
		String sql = "SELECT * FROM tbluser WHERE username =" + username;
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setName(rs.getString(2));
				e.setDateOfBirth(rs.getInt(3));
				e.setGender(rs.getString("gender"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setDecentralization(rs.getString("decentralization"));
				e.setAvatar(rs.getString("avatar"));
			}
			ps.close();
			rs.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		return e;
	}

}

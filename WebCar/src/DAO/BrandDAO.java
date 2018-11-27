package DAO;

import java.sql.*;
import java.util.ArrayList;


import model.*;

public class BrandDAO extends DAO implements entityDAO {
	private final String table = "tblbrand";
	public BrandDAO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<entity> search(String name) {
		// TODO Auto-generated method stub
		ArrayList<entity> listBrand = new ArrayList<>();
		String sql = "SELECT * FROM "+this.table+" WHERE name LIKE ?";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setName(rs.getString("name"));
				brand.setHeadQuater(rs.getString("headquarter"));
				brand.setShortName(rs.getString("short_name"));;
				brand.setAvatar(rs.getString("avatar"));
				brand.setUser((User) new UserDAO().selectById(rs.getInt("id_manager")));
				listBrand.add(brand);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return listBrand;
	}

	@Override
	public void insert(entity e) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO "+this.table+"(name, headquarter, short_name,avatar, id_manager)"
				+ "VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			Brand br = (Brand) e;
			ps.setString(1, br.getName());
			ps.setString(2, br.getHeadQuater());
			ps.setString(3, br.getShortName());
			ps.setString(4, br.getAvatar());
			ps.setInt(5, br.getUser().getId());
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
		String sql = "UPDATE "+this.table+" SET name = ?,"
				+ "headquarter=?,"
				+ "short_name=?,"  
				+ "avatar=?,"
				+ "id_manager=?" + " WHERE id = ?";
		try {
			Brand u = (Brand) e;
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			pr.setString(1, u.getName());
			pr.setString(2, u.getHeadQuater());
			pr.setString(3, u.getShortName());
			pr.setString(4, u.getAvatar());
			pr.setInt(5, u.getUser().getId());
			pr.setInt(6, id);
			pr.executeUpdate();
			pr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM " + this.table + " WHERE id = ?";
		try {
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			pr.setString(1, "" + id);
			pr.executeUpdate();
			pr.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public entity selectById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM " + this.table + " WHERE id ="+id;
		Brand e = new Brand();
		
		
		try {
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setName(rs.getString(2));
				e.setHeadQuater(rs.getString("headquarter"));
				e.setAvatar(rs.getString("avatar"));
				e.setShortName(rs.getString("short_name"));
				e.setUser((User) new UserDAO().selectById(rs.getInt("id_manager")));
			}
			rs.close();
			pr.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public ArrayList<entity> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<entity> listEntity = new ArrayList<>();
		try {
			PreparedStatement pr = this.getConnection().prepareStatement("SELECT * FROM " + this.table );
			ResultSet rs = pr.executeQuery();
			UserDAO udao = new UserDAO();
			while (rs.next()) {	
				Brand e = new Brand();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString(2));
				e.setHeadQuater(rs.getString("headquarter"));
				e.setShortName(rs.getString("short_name"));
				e.setAvatar(rs.getString("avatar"));
				e.setUser((User) udao.selectById(rs.getInt("id_manager")));
				listEntity.add(e);
			}
			udao.closeConnection();
			rs.close();
			pr.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return listEntity;
	}

}

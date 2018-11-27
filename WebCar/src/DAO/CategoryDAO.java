package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import model.Category;
import model.User;
import model.entity;

public class CategoryDAO extends DAO implements entityDAO {
	private final String table = "tblcategory";
	public CategoryDAO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<entity> search(String name) {
		// TODO Auto-generated method stub
		ArrayList<entity> listCategory = new ArrayList<>();
		String sql = "SELECT * FROM "+this.table+" WHERE name LIKE ?";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				UserDAO udao = new UserDAO();
				cate.setId(rs.getInt("id"));
				cate.setName(rs.getString("name"));
				cate.setCategoryCount(rs.getInt("category_detail_count"));
				cate.setUser((User) udao.selectById(rs.getInt("id_manager")));
				cate.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
				udao.closeConnection();
				listCategory.add(cate);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return listCategory;
	}

	@Override
	public void insert(entity e) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO "+this.table+"(name, category_detail_count, id_manager,last_update)"
				+ "VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			Category br = (Category) e;
			ps.setString(1, br.getName());
			ps.setInt(2, br.getCategoryCount());
			ps.setInt(3, br.getUser().getId());
			ps.setTimestamp(4, new Timestamp(br.getLastUpdate().getTime()));
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
				+ "category_detail_count=?,"  
				+ "id_manager=?,"
				+ "last_update=?" + " WHERE id = ?";
		try {
			Category u = (Category) e;
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			pr.setString(1, u.getName());
			pr.setInt(2, u.getCategoryCount());
			pr.setInt(3, u.getUser().getId());
			pr.setTimestamp(4, new Timestamp(u.getLastUpdate().getTime()));
			pr.setInt(5, id);
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
			pr.setInt(1,id);
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
		Category e = new Category();
		UserDAO udao = new UserDAO();
		try {
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setName(rs.getString(2));
				e.setCategoryCount(rs.getInt("category_detail_count"));
				e.setUser((User) new UserDAO().selectById(rs.getInt("id_manager")));
				e.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
			}
			udao.closeConnection();
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
		String sql = "SELECT * FROM "+this.table;
		ArrayList<entity> listEntity = new ArrayList<>();
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				UserDAO udao = new UserDAO();
				cate.setId(rs.getInt("id"));
				cate.setName(rs.getString("name"));
				cate.setCategoryCount(rs.getInt("category_detail_count"));
				cate.setUser((User) udao.selectById(rs.getInt("id_manager")));
				cate.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
				udao.closeConnection();
				listEntity.add(cate);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return listEntity;
	}
}

package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import model.Category;
import model.News;
import model.User;
import model.entity;

public class NewsDAO extends DAO implements entityDAO {
	private final String table = "tblnews";
	public NewsDAO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<entity> search(String name) {
		// TODO Auto-generated method stub
		ArrayList<entity> listNews = new ArrayList<>();
		String sql = "SELECT * FROM "+this.table+" WHERE title LIKE ?";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				News model = new News();
				UserDAO udao = new UserDAO();
				CategoryDAO cdao = new CategoryDAO();
				model.setId(rs.getInt("id"));
				model.setTitle(rs.getString("title"));
				model.setContent(rs.getString("content"));
				model.setImage(rs.getString("image"));
				model.setUser((User) udao.selectById(rs.getInt("author")));
				model.setCategory((Category) cdao.selectById(rs.getInt("id_category")));
				model.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
				model.setViews(rs.getInt("views"));
				udao.closeConnection();
				listNews.add(model);
				udao.closeConnection();
				cdao.closeConnection();
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return listNews;
	}

	@Override
	public void insert(entity e) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO "+this.table+"(title, content, image,author,id_category,last_update,views)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			News br = (News) e;
			ps.setString(1, br.getTitle());
			ps.setString(2, br.getContent());
			ps.setString(3, br.getImage());
			ps.setInt(4, br.getUser().getId());
			ps.setInt(5, br.getCategory().getId());
			ps.setTimestamp(6, new Timestamp(br.getLastUpdate().getTime()));
			ps.setInt(7, br.getViews());
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
		String sql = "UPDATE "+this.table+" SET title = ?,"
				+ "content=?,"  
				+ "image=?,"
				+ "author=?,"
				+ "id_category=?,"
				+ "last_update=?,"
				+ "views=?" + " WHERE id = ?";
		try {
			News u = (News) e;
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			pr.setString(1, u.getTitle());
			pr.setString(2, u.getContent());
			pr.setString(3, u.getImage());
			pr.setInt(4, u.getUser().getId());
			pr.setInt(5, u.getCategory().getId());
			pr.setTimestamp(6, new Timestamp(u.getLastUpdate().getTime()));
			pr.setInt(7, u.getViews());
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
		News e = new News();
		UserDAO udao = new UserDAO();
		CategoryDAO cdao = new CategoryDAO();
		try {
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setId(rs.getInt("id"));
				e.setTitle(rs.getString("title"));
				e.setContent(rs.getString("content"));
				e.setImage(rs.getString("image"));
				e.setUser((User) udao.selectById(rs.getInt("author")));
				e.setCategory((Category) cdao.selectById(rs.getInt("id_category")));
				e.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
				e.setViews(rs.getInt("views"));
			}
			udao.closeConnection();
			cdao.closeConnection();
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
				News model = new News();
				UserDAO udao = new UserDAO();
				CategoryDAO cdao = new CategoryDAO();
				model.setId(rs.getInt("id"));
				model.setTitle(rs.getString("title"));
				model.setContent(rs.getString("content"));
				model.setImage(rs.getString("image"));
				model.setUser((User) udao.selectById(rs.getInt("author")));
				model.setCategory((Category) cdao.selectById(rs.getInt("id_category")));
				model.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
				model.setViews(rs.getInt("views"));
				udao.closeConnection();
				listEntity.add(model);
				udao.closeConnection();
				cdao.closeConnection();
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

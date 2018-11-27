package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import model.Brand;
import model.Car;
import model.User;
import model.entity;

public class CarDAO extends DAO implements entityDAO {

	private final String table = "tblcar";
	public CarDAO() {
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
				Car car = new Car();
				BrandDAO bdao = new BrandDAO();
				UserDAO udao = new UserDAO();
				car.setId(rs.getInt("id"));
				car.setName(rs.getString("name"));
				car.setDescription(rs.getString("description"));
				car.setPrice(rs.getFloat("price"));
				car.setImage(rs.getString("images"));
				car.setViews(rs.getInt("views"));
				car.setBrand((Brand) bdao.selectById(rs.getInt("id_brand")));
				car.setUser((User) udao.selectById(rs.getInt("id_manager")));
				car.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
				bdao.closeConnection();
				udao.closeConnection();
				listBrand.add(car);
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
		String sql = "INSERT INTO "+this.table+"(name, description, price,images,id_brand, id_manager,views,last_update)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			Car br = (Car) e;
			ps.setString(1, br.getName());
			ps.setString(2, br.getDescription());
			ps.setFloat(3, br.getPrice());
			ps.setString(4, br.getImage());
			ps.setInt(5, br.getBrand().getId());
			ps.setInt(6, br.getUser().getId());
			ps.setInt(7, br.getViews());
			ps.setTimestamp(8, new Timestamp(br.getLastUpdate().getTime()));
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
				+ "description=?,"  
				+ "price=?,"
				+ "images=?,"
				+ "id_brand=?,"
				+ "id_manager=?,"
				+ "views=?,"
				+ "last_update=?" + " WHERE id = ?";
		try {
			Car u = (Car) e;
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			pr.setString(1, u.getName());
			pr.setString(2, u.getDescription());
			pr.setFloat(3, u.getPrice());
			pr.setString(4, u.getImage());
			pr.setInt(5, u.getBrand().getId());
			pr.setInt(6, u.getUser().getId());
			pr.setInt(7, u.getViews());
			pr.setTimestamp(8, new Timestamp(u.getLastUpdate().getTime()));
			pr.setInt(9, id);
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
		Car e = new Car();
		BrandDAO bdao = new BrandDAO();
		UserDAO udao = new UserDAO();
		try {
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setName(rs.getString(2));
				e.setDescription(rs.getString("description"));
				e.setPrice(rs.getFloat("price"));
				e.setImage(rs.getString("images"));
				e.setBrand( (Brand) bdao.selectById(rs.getInt("id_brand")));
				bdao.closeConnection();
				e.setUser((User) new UserDAO().selectById(rs.getInt("id_manager")));
				udao.closeConnection();
				e.setViews(rs.getInt("views"));
				e.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
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
			BrandDAO bdao = new BrandDAO();
			while (rs.next()) {
				Car e = new Car();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setDescription(rs.getString("description"));
				e.setPrice(rs.getFloat("price"));
				e.setImage(rs.getString("images"));
				e.setBrand((Brand) bdao.selectById(rs.getInt("id_brand")));
			
				e.setUser((User) udao.selectById(rs.getInt("id_manager")));
				
				e.setViews(rs.getInt("views"));
				e.setLastUpdate(new Date(rs.getTimestamp("last_update").getTime()));
				listEntity.add(e);
			}
			bdao.closeConnection();
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

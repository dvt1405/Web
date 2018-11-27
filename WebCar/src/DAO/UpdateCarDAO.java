package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import model.*;

public class UpdateCarDAO extends DAO implements entityDAO {
	private final String table = "tblupdatecar";

	public UpdateCarDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<entity> search(String name) {
		// TODO Auto-generated method stub
		ArrayList<entity> listUpdate = new ArrayList<>();
		String sql = "SELECT * FROM " + this.table + " WHERE content_update LIKE ?";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UpdateCar cate = new UpdateCar();
				UserDAO udao = new UserDAO();
				CarDAO cdao = new CarDAO();
				cate.setId(rs.getInt("id"));
				cate.setContent_update(rs.getString("content_update"));
				cate.setUser((User) udao.selectById(rs.getInt("id_manager")));
				cate.setCar((Car) cdao.selectById(rs.getInt("id_car")));
				cate.setTimeUpdate(new Date(rs.getTimestamp("time").getTime()));
				udao.closeConnection();
				listUpdate.add(cate);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return listUpdate;
	}

	@Override
	public void insert(entity e) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO " + this.table + "(content_update, id_car, id_manager,time)"
				+ "VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			UpdateCar br = (UpdateCar) e;
			ps.setString(1, br.getContent_update());
			ps.setInt(2, br.getCar().getId());
			ps.setInt(3, br.getUser().getId());
			ps.setTimestamp(4, new Timestamp(br.getTimeUpdate().getTime()));
//			Update last_update in tblcar			
			CarDAO cdao = new CarDAO();
			br.getCar().setLastUpdate(br.getTimeUpdate());
			cdao.update(br.getCar().getId(), br.getCar());		
			cdao.closeConnection();
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
		String sql = "UPDATE " + this.table + " SET content_update = ?," + "id_car=?," + "id_manager=?," + "time=?"
				+ " WHERE id = ?";
		try {
			UpdateCar u = (UpdateCar) e;
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			pr.setString(1, u.getContent_update());
			pr.setInt(2, u.getCar().getId());
			pr.setInt(3, u.getUser().getId());
			pr.setTimestamp(4, new Timestamp(u.getTimeUpdate().getTime()));
			pr.setInt(5, id);
			pr.executeUpdate();
//			Update last_update in tblcar			
			CarDAO cdao = new CarDAO();
			u.getCar().setLastUpdate(u.getTimeUpdate());
			cdao.update(u.getCar().getId(), u.getCar());		
			cdao.closeConnection();
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
			pr.setInt(1, id);
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
		String sql = "SELECT * FROM " + this.table + " WHERE id =" + id;
		UpdateCar e = new UpdateCar();
		UserDAO udao = new UserDAO();
		CarDAO cdao = new CarDAO();
		try {
			PreparedStatement pr = this.getConnection().prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				UpdateCar cate = new UpdateCar();
				cate.setId(rs.getInt("id"));
				cate.setContent_update(rs.getString("content_update"));
				cate.setUser((User) udao.selectById(rs.getInt("id_manager")));
				cate.setCar((Car) cdao.selectById(rs.getInt("id_car")));
				cate.setTimeUpdate(new Date(rs.getTimestamp("time").getTime()));
				udao.closeConnection();
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
		String sql = "SELECT * FROM " + this.table;
		ArrayList<entity> listEntity = new ArrayList<>();
		try {
			PreparedStatement ps = this.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UpdateCar cate = new UpdateCar();
				UserDAO udao = new UserDAO();
				CarDAO cdao = new CarDAO();
				cate.setId(rs.getInt("id"));
				cate.setContent_update(rs.getString("content_update"));
				cate.setUser((User) udao.selectById(rs.getInt("id_manager")));
				cate.setCar((Car) cdao.selectById(rs.getInt("id_car")));
				cate.setTimeUpdate(new Date(rs.getTimestamp("time").getTime()));
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

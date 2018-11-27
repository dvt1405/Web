package DAO;

import java.util.ArrayList;

import model.entity;

public interface entityDAO {
	public ArrayList<entity> search(String name);
	public void insert(entity e);
	public void update(int id, entity e);
	public void delete(int id);
	public entity selectById (int id);
	public ArrayList<entity> selectAll();
}

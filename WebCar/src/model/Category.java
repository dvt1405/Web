package model;

import java.util.Date;;

public class Category extends entity{
	private int id,categoryCount;
	private String name;
	private Date lastUpdate;
	private User user;
	public Category() {

	}

	

	public Category(int id, int categoryCount, String name, Date lastUpDate, User user) {
		super();
		this.id = id;
		this.categoryCount = categoryCount;
		this.name = name;
		this.lastUpdate = lastUpDate;
		this.user = user;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getCategoryCount() {
		return categoryCount;
	}

	public void setCategoryCount(int categoryCount) {
		this.categoryCount = categoryCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpDate) {
		this.lastUpdate = lastUpDate;
	}

}

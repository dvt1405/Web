package model;

import java.util.Date;

public class Car extends entity {
	private int id, views;
	private float price;
	private String name, description, image;
	private Date lastUpdate;
	private Brand brand;
	private User user;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int id, int views, float price, String name, String description, String image, Date lastUpdate,
			Brand brand, User user) {
		super();
		this.id = id;
		this.views = views;
		this.price = price;
		this.name = name;
		this.description = description;
		this.image = image;
		this.lastUpdate = lastUpdate;
		this.brand = brand;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

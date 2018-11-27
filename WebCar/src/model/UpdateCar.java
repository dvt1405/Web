package model;

import java.util.Date;

public class UpdateCar extends entity {
	private int id;
	private Date timeUpdate;
	private Car car;
	private User user;
	private String content_update;
	

	public UpdateCar() {
		// TODO Auto-generated constructor stub
	}

	

	public UpdateCar(int id, Date timeUpdate, Car car, User user, String content_update) {
		super();
		this.id = id;
		this.timeUpdate = timeUpdate;
		this.car = car;
		this.user = user;
		this.content_update = content_update;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}



	public void setCar(Car car) {
		this.car = car;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Date getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}



	public String getContent_update() {
		return content_update;
	}



	public void setContent_update(String content_update) {
		this.content_update = content_update;
	}
	

}

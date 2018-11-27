package model;

public class Brand extends entity{
	private int id;
	private User user;
	private String name, shortName, avatar, headQuater;

	public Brand() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Brand(int id, User user, String name, String shortName, String avatar, String headQuater) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.shortName = shortName;
		this.avatar = avatar;
		this.headQuater = headQuater;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getHeadQuater() {
		return headQuater;
	}
	public void setHeadQuater(String headQuater) {
		this.headQuater = headQuater;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}

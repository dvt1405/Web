package model;

import java.util.Date;

public class News extends entity {
	private int id, views;
	private String title, content, image;
	private Date lastUpdate;
	private  User user;
	private Category category;
	public News() {
		// TODO Auto-generated constructor stub
	}


	public News(int id, int views, String title, String content, String image, Date lastUpDate, User user,
			Category category) {
		super();
		this.id = id;
		this.views = views;
		this.title = title;
		this.content = content;
		this.image = image;
		this.lastUpdate = lastUpDate;
		this.user = user;
		this.category = category;
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


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public void setLastUpdate(Date lastUpDate) {
		this.lastUpdate = lastUpDate;
	}

}

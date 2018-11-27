package model;

import java.util.Date;

public class UpdateNews extends entity{
	private int id;
	private Date timeUpdate;
	private User user;
	private News news;
	private String content_update;
	
	public UpdateNews() {
		// TODO Auto-generated constructor stub
	}
	
	public UpdateNews(int id, Date timeUpdate, User user, News news,String content_update) {
		super();
		this.id = id;
		this.timeUpdate = timeUpdate;
		this.user = user;
		this.news = news;
		this.content_update = content_update;
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

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
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

package model;

public class User extends entity {
	private String avatar, name, gender, username, password, decentralization;
	private int id;
	private int dateOfBirth;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, int dateOfBirth, String gender, String username, String password, String avatar,
			String decentralazition) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.decentralization = decentralazition;
		this.avatar = avatar;
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

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDecentralization() {
		return decentralization;
	}

	public void setDecentralization(String decentralization) {
		this.decentralization = decentralization;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}

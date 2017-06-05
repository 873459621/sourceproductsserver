package cn.edu.njupt.sourceproductsserver.domain;

/**
 * 用户表的Javabean对象
 * 
 * @author hhw
 */
public class User {

	private int uid;
	private String username;
	private String password;
	private String email;
	private String phone;

	public User(int uid, String username, String password, String email,
			String phone) {
		this(username, password, email, phone);
		this.uid = uid;
	}

	public User(String username, String password, String email, String phone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

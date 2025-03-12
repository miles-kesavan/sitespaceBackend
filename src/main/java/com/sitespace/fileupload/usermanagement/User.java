package com.sitespace.fileupload.usermanagement;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private Long id;
	private String username;
	private String email;
	private String password;
	private String userId;
	private String userPhone;
	private String profilePic;
	private Integer creditpoint;
	private String role;
	private String dob;
	
	public Integer getCreditpoint() {
		return creditpoint;
	}

	public void setCreditpoint(Integer creditpoint) {
		this.creditpoint = creditpoint;
	}


	public User() {
		}
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
		public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

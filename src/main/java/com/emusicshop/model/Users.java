package com.emusicshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private int usersId;
	private String username;
	private String password;
	private boolean enabled;
	private int customerId;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public int getUsersId() {
		return usersId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	

}

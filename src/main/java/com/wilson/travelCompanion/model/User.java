package com.wilson.travelCompanion.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private long userId;
	private String name;
	private String emailId;
	private String password;
	
	public User(){
		
	}
	
	public User(long userId, String name, String emailId, String password) {
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	

}

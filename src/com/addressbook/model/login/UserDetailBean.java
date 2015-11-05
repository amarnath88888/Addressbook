package com.addressbook.model.login;

public class UserDetailBean {
	private long userPk;
	private String userName = null;
	private String password = null;
	private String firstName = null;
	private String lastName = null;
	private String mobileNo = null;
	private String emailId = null;
	
	public long getUserPk() {
		return userPk;
	}
	public void setUserPk(long i) {
		this.userPk = i;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}

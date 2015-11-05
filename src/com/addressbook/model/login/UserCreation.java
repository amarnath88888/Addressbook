package com.addressbook.model.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.addressbook.model.dbAccess.DbAccess;

public class UserCreation {
	private String userName = null;
	private String password = null;
	private String firstName = null;
	private String lastName = null;
	private String mobileNo = null;
	private String emailId = null;
	
	private DbAccess dbAccess;
	
	public UserCreation(String userName, String password, String firstName, String lastName, String mobileNo, String emailId) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;		
	}
	
	public boolean isUserAvailable() {
		dbAccess = DbAccess.getInstance();
		boolean isUserAvailable = false;
		String selectUserQuery = "select * from UserDetails where User_Name = '"
				+ userName + "' or Email_Id = '" + emailId + "'";
		ResultSet rs = dbAccess.executeQuery(selectUserQuery);
		try {
			if (null != rs && rs.next()) {
				isUserAvailable = true;
			}
		} catch (SQLException sqlException) {
			System.out.println("SQL Exception occurred. ");
		} finally {
			dbAccess.closeResultSet(rs);
		}
		return isUserAvailable;
	}

	public boolean createUser() {
		dbAccess = DbAccess.getInstance();
		String insertUserQuery = "insert into UserDetails (User_Name, Password, First_Name, Last_Name, Mobile_No, Email_Id) values ('"
				+ userName
				+ "','"
				+ password
				+ "','"
				+ firstName
				+ "','"
				+ lastName 
				+ "','"
				+ mobileNo 
				+ "','"
				+ emailId + "')";
		if (dbAccess.executeUpdate(insertUserQuery) < 0) {
			return false;
		} else {
			return true;
		}
	}
}

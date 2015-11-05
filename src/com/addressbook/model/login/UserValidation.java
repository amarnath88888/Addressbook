package com.addressbook.model.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.addressbook.model.dbAccess.DbAccess;

public class UserValidation {
	private String userName = null;
	private String password = null;
	
	private DbAccess dbAccess;
	private UserDetailBean userDetailBean;

	public UserValidation(String userName, String password) {
		this.userName = userName;
		this.password = password;
		userDetailBean = new UserDetailBean();
	}

	public boolean isValidUser() {
		dbAccess = DbAccess.getInstance();
		boolean isValidUser = false;
		String selectUserQuery = "select * from UserDetails where User_Name = '"
				+ userName + "' AND Password = '" + password + "'";
		ResultSet rs = dbAccess.executeQuery(selectUserQuery);
		try {
			if (null != rs && rs.next()) {
				userDetailBean.setUserPk(rs.getLong("User_Pk"));
				userDetailBean.setFirstName(rs.getString("First_Name"));
				userDetailBean.setLastName(rs.getString("Last_Name"));
				isValidUser = true;
			} else {
				System.out.println("Invalid user.");
			}
		} catch (SQLException sqlException) {
			System.out.println("SQL Exception occurred. ");
		} finally {
			dbAccess.closeResultSet(rs);
		}
		return isValidUser;
	}

	public UserDetailBean getUserDetail() {
		return userDetailBean;
	}

}
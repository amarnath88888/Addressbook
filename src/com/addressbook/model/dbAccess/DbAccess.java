package com.addressbook.model.dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.addressbook.model.constants.ApplicationConstants;
import com.addressbook.model.property.ProperyInitializer;

public class DbAccess {

	private ProperyInitializer propertyInitializer;
	private Properties properties;
	
	private String driver = null;
	private String url = null;
	private Connection con = null;
	private String username = null;
	private String password = null;
	private Statement statement = null;

	private static DbAccess instance = null;
	
	public DbAccess() {
		propertyInitializer = new ProperyInitializer("C:\\Documents and Settings\\akaliyugap001\\Desktop\\Workspace\\Addressbook\\properties\\Dbdetails.properties");
		properties = propertyInitializer.getProperties();
		driver = properties.getProperty(ApplicationConstants.DRIVER);
		url = properties.getProperty(ApplicationConstants.URL);
		username = properties.getProperty(ApplicationConstants.USERNAME);
		password = properties.getProperty(ApplicationConstants.PASSWORD);
		if (null == instance) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,username,password);
				statement = con.createStatement();
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println("Driver not found.");
			} catch (SQLException sqlException) {
				System.out.println("Could not able to connect to db.");
			}
		}
	}
	
	public static DbAccess getInstance() {
		if (null == instance) {
			instance = new DbAccess();
		}
		return instance;
	}

	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException sqlException) {
			System.out.println("Invalid query"+sqlException);
		}
		return rs;
	}
	
	public int executeUpdate(String sql) {
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException sqlException) {
			System.out.println("Invalid query"+sqlException);
		}
		return -1;
	}
	
	public void closeResultSet(ResultSet rs) {
		try {
			if (null != rs) {
				rs.close();
			}
		} catch (SQLException sqlException) {
			System.out.println("Exception while closing result set.");
		}
	}

}

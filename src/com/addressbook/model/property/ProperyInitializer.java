package com.addressbook.model.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.addressbook.model.constants.ApplicationConstants;

public class ProperyInitializer {

	private Properties properties;
	
	//public static final Logger logger = Logger.getLogger(ProperyInitializer.class);
	
	public ProperyInitializer(String path) {
		//DOMConfigurator.configure("log4j.xml");
		properties = new Properties();
		initializeProperties(path);
	}
	
	public Properties getProperties() {
		return properties;
	}

	public void initializeProperties(String path) {
		FileInputStream input_stream = null;		
		try {
			if (path == null)	{
			input_stream = new FileInputStream(new File(ApplicationConstants.PROPERTIES_DBPATH));
			}
			else	{
				input_stream = new FileInputStream(new File(path));
			}
		} catch (FileNotFoundException exception) {
			//logger.error(exception);
			exception.printStackTrace();
		}
		try {
			properties.load(input_stream);
			System.out.println("Property file loaded");
			//logger.debug("Property file loaded");
		} catch (IOException exception) {
			//logger.error(exception);
			exception.printStackTrace();
		}
		if(input_stream != null){
			try {
				input_stream.close();
				//logger.debug(LoggerConstants.RESOURCES_RELEASED);
			} catch (IOException exception) {
				//logger.error(exception);
				exception.printStackTrace();
			}
		}
	}
}

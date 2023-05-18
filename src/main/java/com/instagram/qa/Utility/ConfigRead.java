package com.instagram.qa.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {

public Properties prop;
	
	public ConfigRead() {
		String filePath=System.getProperty("user.dir")+"\\Configuration\\config.properties";
		try {
		FileInputStream fis=new FileInputStream(filePath);
		prop=new Properties();
		prop.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getBaseURL() {
		String value= prop.getProperty("baseUrl");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("URL is not available in config file");
		}
	}
	
	public String getBrowser() {
		String value=prop.getProperty("browser");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Browser is not available in config file");
		}
	}
	
	public String getUsername() {
		String value=prop.getProperty("email");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Email is not available in config file");
		}
	}
	public String getPassword() {
		String value=prop.getProperty("password");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Password is not available in config file");
		}
	}
}

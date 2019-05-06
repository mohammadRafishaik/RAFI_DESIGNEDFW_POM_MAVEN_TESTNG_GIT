package com.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Configfiledata {
	public Properties pro;
	public  Configfiledata() {
		File f=new File("./config/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(f);
			 pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
		System.out.println(" properties file not loaded "+e.getMessage());
		}
		
	}

	public String getdatafromconfig(String KeyToSearch) {
		return pro.getProperty(KeyToSearch);
	}
	public String getbrowser() {
		return pro.getProperty("Browser");
		
	}
public String getweburl() {
		
return	pro.getProperty("QAUrl");
	
}
}

package com.cts.mom.assign.util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public Properties getProperty() {
		FileInputStream input=null;
		Properties prop = null;
		try {
			input = new FileInputStream("src/main/resources/application.properties");
			//input = PropertiesUtil.class.getResourceAsStream("src/main/resources/application.properties");
			// load a properties file
			prop = new Properties();
			prop.load(input);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
			if(input!=null) {
				input.close();
			}
			}catch(Exception ignore) {}
			
		}
		return prop;
	}

}

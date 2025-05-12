package com.autoarc.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws Exception {
		
		
		Properties config = new Properties();
		Properties object = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Object.properties"); 
		object.load(fis);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(object.getProperty("bankManagerLogin"));
	}
	
}

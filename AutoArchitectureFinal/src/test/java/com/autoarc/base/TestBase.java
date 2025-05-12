package com.autoarc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	/*
	 WebDriver
	 Properties
	 Logs - log4j jar, .log file, log4j properties
	 ExtentReports
	 DB
	 Excel
	 Mail
	 ReportNG, ExtendReport
	 Jenkins
	 */

	public static WebDriver driver;
	
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static FileInputStream fis;
	
	@BeforeSuite
	public void setUp() throws Exception {
		
		if(fis == null)
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Object.properties"); 
			object.load(fis);
		}
		
		if(config.getProperty("browser").equals("chrome"))
		{
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--remote-allow-origins=*");
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();    
		}
		
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}

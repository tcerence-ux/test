package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	
	public static WebDriver driver;
	public static Logger logger;
	public Properties properties;
	public JavascriptExecutor exe;



	

	public void setup(String br) {
		logger= LogManager.getLogger(getClass());
		try {
	
		properties= new Properties();
		properties.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties")));
		
		switch(br) {
		
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			logger.error("Invalid browsername is provided pelase check and provide correct name");
			return;
			}
		
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		exe=(JavascriptExecutor) driver;
		}
		catch(Exception e) {
			logger.error(e);
		}
			}
	
	public void tearDown() {
		driver.quit();

	}
	
	
	
	
	
	
	
	
	
}

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
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	
	public static WebDriver driver;
	public static Logger logger;
	public static Properties properties;

	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports reports;
    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
	
	public void TestSetup(String br) {
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
		
		driverThread.set(driver);
		driverThread.get().get(properties.getProperty("url"));
		driverThread.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driverThread.get().manage().window().maximize();
	}


	

	public void setup() {
		logger= LogManager.getLogger(getClass());
		try {
	
		properties= new Properties();
		properties.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties")));
		logger.info("Starting the report generation part....");
	    sparkreporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+
	    		properties.getProperty("reports")+"_"+System.currentTimeMillis()+".html"));
	    sparkreporter.config().setDocumentTitle("Document");
	    sparkreporter.config().setReportName("Report");
	    sparkreporter.config().setTheme(Theme.DARK);
	    reports = new ExtentReports();
	    reports.attachReporter(sparkreporter);
		

		}
		catch(Exception e) {
			logger.error(e);
		}
			}
	
	public void tearDown() {
		driverThread.get().quit();

	}
	
	public void suiteTeardown() {
		reports.flush();
	}
	
	
	
	
	
	
	
	
	
}

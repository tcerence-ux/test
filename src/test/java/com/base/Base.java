package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	
	public static WebDriver driver;
	public static Logger logger;
	public static Properties properties;

	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports reports;
    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
	
	public void TestSetup(String br, String os) {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		switch(br) {
		
		case "chrome":
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			//driver = new ChromeDriver();
			break;
		case "firefox":
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);
			//driver = new FirefoxDriver();
			break;
		case "edge":
			cap.setBrowserName("edge");
			//driver = new EdgeDriver();
			break;
		default:
			logger.error("Invalid browsername is provided pelase check and provide correct name");
			return;
			}
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

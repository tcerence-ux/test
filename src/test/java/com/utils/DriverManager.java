package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {


	    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	    public static void setDriver(String browserType) {
	        WebDriver driver;
	        if (browserType.equalsIgnoreCase("chrome")) {
	            // Set system property or use WebDriverManager library (e.g., WebDriverManager.chromedriver().setup())
	            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
	            driver = new ChromeDriver();
	        } else if (browserType.equalsIgnoreCase("firefox")) {
	             // Set system property or use WebDriverManager library (e.g., WebDriverManager.firefoxdriver().setup())
	            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
	            driver = new FirefoxDriver();
	        } else {
	            throw new IllegalArgumentException("Browser type not supported: " + browserType);
	        }
	        driverThread.set(driver);
	    }

	    public static WebDriver getDriver() {
	        return driverThread.get();
	    }

	    public static void quitDriver() {
	        WebDriver driver = driverThread.get();
	        if (driver != null) {
	            driver.quit();
	            driverThread.remove(); // Remove the driver from ThreadLocal memory
	        }
	    }
	}




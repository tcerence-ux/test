package com.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.Base;

public class BaseTest extends Base{
	

	
	@BeforeTest
	@Parameters({"browsername"})
	public void testSetup(String br) {
		TestSetup(br);
	}
	
	@BeforeSuite
	
	public void suitSetup() {
		setup();
	}
	
	
	@AfterTest
	public void suiteTearDown() {
		tearDown();
	}
	
	@AfterSuite
	public void suiteTeardownT() {
		suiteTeardown();
	}

			
		
		
		
	
	
	

}

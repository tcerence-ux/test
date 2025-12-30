package com.utils;

import java.io.File;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.Base;
import com.tests.BaseTest;

public class Listeners extends BaseTest implements ITestListener{

	public ExtentTest test;
	  
	  public  void onTestSuccess(ITestResult result) {
		  test= reports.createTest(result.getTestContext().getCurrentXmlTest().getName()+result.getName());
		  test.pass(result.getTestContext().getCurrentXmlTest().getName()+result.getName()+ "Passed ");
		  logger.info("Test - >" + result.getName() +" Is Passed");
		  }
	  
	  
	  public  void onTestFailure(ITestResult result) {
		  test= reports.createTest(result.getTestContext().getCurrentXmlTest().getName()+result.getName());
		  test.fail(result.getTestContext().getCurrentXmlTest().getName()+result.getName()+ "Failed ");
		  logger.info("Test - >" + result.getName() +" Is Failed");
		  }
	  
	  
	  public void onTestSkipped(ITestResult result) {
		  test= reports.createTest(result.getTestContext().getCurrentXmlTest().getName()+result.getName());
		  test.skip(result.getTestContext().getCurrentXmlTest().getName()+result.getName()+ "Skipped ");
		  logger.info("Test - >" + result.getName() +" Is Skipped");
		  }
	

	

}

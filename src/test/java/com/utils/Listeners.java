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
	public ExtentSparkReporter sparkreporter;
	public ExtentReports reports;
	public ExtentTest test;

	
	  public void onStart(ITestContext context) {
		  try {
			logger.info("Starting the report generation part....");
		    sparkreporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+
		    		properties.getProperty("reports")+"_"+context.getName()+"_"+System.currentTimeMillis()+".html"));
		    sparkreporter.config().setDocumentTitle(context.getName());
		    sparkreporter.config().setReportName(context.getCurrentXmlTest().getSuite().getName());
		    sparkreporter.config().setTheme(Theme.DARK);
		    reports = new ExtentReports();
		    reports.attachReporter(sparkreporter);
		    
		    
		  }catch(Exception e) {
			  
		  }
		  }
	
	  public void onTestStart(ITestResult result) {
		
		   logger.info("Test -> "+ result.getName()+ " Is Starting");
		  }
	  
	  public  void onTestSuccess(ITestResult result) {
		  test= reports.createTest(result.getName());
		  test.pass(result.getName()+ "Passed ");
		  logger.info("Test - >" + result.getName() +" Is Passed");
		  }
	
	  public void onFinish(ITestContext context) {
		  reports.flush();
		  logger.info(context.getName() + " is Finished");
		 
		  }
	

}

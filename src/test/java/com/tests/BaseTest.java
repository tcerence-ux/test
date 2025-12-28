package com.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.base.Base;

public class BaseTest extends Base{
	
	@BeforeSuite
	@Parameters({"browsername"})
	public void suitSetup(String br) {
		setup(br);
	}
	
	
	@AfterSuite
	public void suiteTearDown() {
		tearDown();
	}

			
		
		
		
	
	
	

}

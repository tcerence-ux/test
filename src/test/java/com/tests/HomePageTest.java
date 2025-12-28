package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.HomePage;

public class HomePageTest extends BaseTest {
     HomePage page;
  
	@BeforeClass
	public void setupClass() {
		page = new HomePage(driver);
	
		
		
	}
	
	@AfterMethod
	public void waitSome() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 0)
	public void testSearchBox() {
	    page.setSearchbox("iMac");
	    
	    if(page.getSearchvalue()=="iMac") {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority = 1)
	public void testSearchbtn() {
		
		page.clickSearchbtn();
		if(page.getProductSize()>=0) {
			logger.info("The ProdcutsSize is = "+ page.getProductSize() );
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void testAddToCart() {
		page.addProductToCart("iMac");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(page.getCartValue().contains("1")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
}

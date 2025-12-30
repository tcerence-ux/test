package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest {

	ShoppingCartPage page;
	@BeforeClass
	public void setupClass() throws InterruptedException {
		page = new ShoppingCartPage(driverThread.get());
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void waitsome() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public void testShoppingCartBtn() {
		page.clickShoppingCrtbtn();
		if(page.getTitle().equalsIgnoreCase("Shopping Cart")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	public void testCheckoutBtn() {
		page.clickCheckOutBtn();
		if(page.getCartMessage()=="Your shopping cart is empty!") {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	
}

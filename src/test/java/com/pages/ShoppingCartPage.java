package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class ShoppingCartPage extends Base {
	static WebDriver driver;
	public JavascriptExecutor exe;
	
	public ShoppingCartPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
		this.driver=driver;
		exe= (JavascriptExecutor)driver;
	}
	
	@FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement shoppincartbtn;
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement checkoutbtn;
	
	@FindBy(xpath="//div[@id='content']//p")
	WebElement cartmessage;
			
	
	
	public void clickShoppingCrtbtn() {
		logger.info("Clicking the shopping cart btn");
		shoppincartbtn.click();
	}
	
	public String getTitle() {
		logger.info("The page title is = "+ driver.getTitle());
		return driver.getTitle();
	}
	
	public void clickCheckOutBtn() {
		logger.info("Clicking checkout btn");
		checkoutbtn.click();
	}

	public String getCartMessage(){
		return cartmessage.getText();
	}
}

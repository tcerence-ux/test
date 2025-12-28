package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Base;

public class HomePage extends Base{

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	
	}
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchbox;
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-search']")
	WebElement searchbtn;
	@FindBy(xpath="//select[@name='category_id']")
	WebElement searchDropdown;
	@FindBy(id="button-search")
	WebElement criteriasearchbtn;
	@FindBy(xpath="//div[@class='product-thumb']")
	List<WebElement> productsthumb;
	@FindBy(id = "cart-total")
	WebElement cartid;
	
	public void setSearchbox(String data) {
		searchbox.sendKeys(data);
	}
	
	public void clickSearchbtn() {
		searchbtn.click();
	}
	public void selectSearchDrpDwn(String selectvalue) {
		Select select = new Select(searchDropdown);
		select.selectByContainsVisibleText(selectvalue);
		
	}
	
	public void clickCriteriaSrchBtn() {
		criteriasearchbtn.click();
	}
	
	public void addProductToCart(String productname ) {
		
		for(WebElement prod: productsthumb){
			WebElement ele=prod.findElement(By.xpath("//div[@class='caption']//a"));
			exe.executeScript("arguments[0].scrollIntoView()", ele);
			if(ele.getText().contains(productname)){
				System.out.println("Inside the if for selection");
				prod.findElement(By.xpath("//div[@class='button-group']//span[text()='Add to Cart']")).click();
			}
			
		}
	}
	
	public String getSearchvalue() {
	
		logger.info("Inside get getSearchvalue method");
		logger.info("The Value seacrched is = "+ searchbox.getAttribute("value")  );
		return searchbox.getAttribute("value");
		
	}
	
	public int getProductSize() {
		return productsthumb.size();
	}
	
	public String getCartValue() {

		logger.info("The cart value text is = "+ cartid.getText() );
		return cartid.getText();
	}
	
	

}

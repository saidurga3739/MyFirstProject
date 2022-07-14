package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class HomePage extends BaseClass {
	
	ActionsClass action= new ActionsClass();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishList() throws Throwable 
	{
		return action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable
	{
		return action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrentURL() throws Throwable
	{
		return driver.getCurrentUrl();
	}
	

}

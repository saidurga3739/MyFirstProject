package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class AddToCartPage extends BaseClass
{

	ActionsClass action= new ActionsClass();
	public AddToCartPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement quantityCount;
	
	@FindBy(name="group_1")
	WebElement size;
	
		
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessage;
	
	public void enterQuantity(String quantity)
	{
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys(quantity);
		// action.type(quantityCount, quantity);
	}
	
	public void enterSize(String dressSize)
	{
		action.selectByVisibleText(dressSize, size);
	}
	
	
	public OrderPage proceedToCheckOut() throws IOException, InterruptedException
	{
		
		action.JSClick(driver, proceedToCheckOut);
		Thread.sleep(5000);
		return new OrderPage();
		
	}
	
	public OrderPage clickOnCart() throws IOException
	{
		action.click(driver, addToCart);
		return new OrderPage();
	}
	
	public boolean addToCartMessage()
	{
		return action.isDisplayed(driver, addToCartMessage);
	}

	
	
	
	
	
	
	
}

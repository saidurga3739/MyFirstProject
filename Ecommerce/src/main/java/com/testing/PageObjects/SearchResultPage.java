package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class SearchResultPage extends BaseClass {
	
	ActionsClass action= new ActionsClass();
	
		
	public SearchResultPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='product-image-container']/a/img")
	WebElement productResult;
	
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")
	WebElement addToCartButton;
//	
	
	public boolean isProductAvailable()
	{
		return action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickProduct() throws IOException
	{
		action.moveToElement(driver, productResult);
		System.out.println("iam moved");
		action.click(driver, addToCartButton);
		System.out.println("iam clicked on add to cart");
		return new AddToCartPage();
	}
	


}

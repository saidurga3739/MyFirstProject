package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class IndexPage extends BaseClass{
	
	public IndexPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	

	ActionsClass action= new ActionsClass();


	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchIcon;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInButton;
	

	
	public SearchResultPage searchProduct(String ProductName) throws IOException
	{
		searchProductBox.sendKeys(ProductName);
		searchIcon.click();
		return new SearchResultPage();
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
		// return action.isDisplayed(driver, logo);
	}
	
	public LoginPage clickSigin() throws IOException
	{
		signInButton.click();
		//action.click(driver, signInButton);	
		return new LoginPage();
	}
	
	

}

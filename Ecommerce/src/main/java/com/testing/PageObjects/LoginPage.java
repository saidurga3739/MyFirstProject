package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.baseClass.BaseClass;

public class LoginPage extends BaseClass
{
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email_create")
	WebElement emailForNewAcc;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAcc;
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signin;
	
	
	public HomePage login(String username,String passwordKey) throws IOException
	{
		userName.sendKeys(username);
		password.sendKeys(passwordKey);
		signin.click();
		
		return new HomePage();	
	}
	
	public AddressPage login1(String username,String passwordKey) throws IOException
	{
		userName.sendKeys(username);
		password.sendKeys(passwordKey);
		signin.click();
		
		return new AddressPage();	
	}

	
	public AccountCreationPage createNewAccount(String username) throws IOException
	{
		emailForNewAcc.sendKeys(username);
		createNewAcc.click();
		return new AccountCreationPage();
	}
	
}

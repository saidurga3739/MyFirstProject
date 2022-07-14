package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class AddressPage extends BaseClass {

	ActionsClass action= new ActionsClass();
	public AddressPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public ShippingPage proceedToCheckOut() throws IOException
	{
		action.click(driver, proceedToCheckOut);
		return new ShippingPage();
	}
	
}

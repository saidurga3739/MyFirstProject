package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class ShippingPage extends BaseClass{

	ActionsClass action= new ActionsClass(); 
	
	public ShippingPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cgv")
	WebElement termsRadio;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public void checkTheTerms() throws Throwable {
		action.click(driver, termsRadio);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	}
}

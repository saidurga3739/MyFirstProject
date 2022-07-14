package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class PaymentPage extends BaseClass{
	
	ActionsClass action= new ActionsClass(); 
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement payByCheckMethod;
	
	public PaymentPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		action.click(driver, bankWireMethod);
		return new OrderSummary();
	}

}

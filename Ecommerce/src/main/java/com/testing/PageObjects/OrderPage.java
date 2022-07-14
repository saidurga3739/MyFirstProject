package com.testing.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.actiondriver.ActionsClass;
import com.testing.baseClass.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	@FindBy(xpath="//td[@class=\"cart_unit\"]/span/span")
	WebElement unitPrice;

	@FindBy(id="total_price")
	WebElement totalPrice;
	
	
	ActionsClass action= new ActionsClass();
	
	public OrderPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage proceedToCheckOut() throws IOException
	{
		action.JSClick(driver, proceedToCheckOut);
		return new LoginPage();
	}
	
	public double getUnitPrice()
	{
		String unitPrice1=unitPrice.getText();    // "$16.51"
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");   // "1651"
		double finalUnitPrice=Double.parseDouble(unit);    // 1651
		return finalUnitPrice/100;  // 16.51
	}
	
	public double getTotalPrice()
	{
		String totalPrice1=totalPrice.getText();    // "$16.51"
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]","");   // "1651"
		double finalTotalPrice=Double.parseDouble(total);    // 1651
		return finalTotalPrice/100;  // 16.51
		
	}
	
	


}

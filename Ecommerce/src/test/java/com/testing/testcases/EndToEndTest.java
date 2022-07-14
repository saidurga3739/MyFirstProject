package com.testing.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.PageObjects.AddToCartPage;
import com.testing.PageObjects.AddressPage;
import com.testing.PageObjects.IndexPage;
import com.testing.PageObjects.LoginPage;
import com.testing.PageObjects.OrderConfirmationPage;
import com.testing.PageObjects.OrderPage;
import com.testing.PageObjects.OrderSummary;
import com.testing.PageObjects.PaymentPage;
import com.testing.PageObjects.SearchResultPage;
import com.testing.PageObjects.ShippingPage;
import com.testing.baseClass.BaseClass;

public class EndToEndTest extends BaseClass{
	
	
	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmationPage;

	public EndToEndTest() throws IOException {
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws IOException, InterruptedException
	{
		initialization(browser);
		indexpage= new IndexPage();
	}
    
	@Test
	public void test() throws Throwable
	{
		searchResultPage=indexpage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.enterSize("M");
		addToCartPage.clickOnCart();
		orderpage=addToCartPage.clickOnCart();
		loginpage=orderpage.proceedToCheckOut();
		addressPage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.proceedToCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		
		
	}

}

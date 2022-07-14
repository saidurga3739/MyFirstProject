package com.testing.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.PageObjects.AddToCartPage;
import com.testing.PageObjects.IndexPage;
import com.testing.PageObjects.OrderPage;
import com.testing.PageObjects.SearchResultPage;
import com.testing.baseClass.BaseClass;

public class AddToCartPageTest extends BaseClass
{
	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderpage;

	public AddToCartPageTest() throws IOException {
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) throws IOException, InterruptedException
	{
		initialization(browser);
		indexpage= new IndexPage();
	}
    
	@Test(groups = {"Regression", "Smoke"})
	public void addToCart() throws IOException, InterruptedException
	{
		System.out.println("add to cart is started");
		searchResultPage=indexpage.searchProduct("t-shirt");
		
		System.out.println("search done");
		addToCartPage=searchResultPage.clickProduct();
		
		Thread.sleep(10000);
		System.out.println("iam waited");
		orderpage=addToCartPage.proceedToCheckOut();
		double totalPrice=orderpage.getTotalPrice();
		System.out.println(totalPrice+ "  totalPrice");
		double unitPrice=orderpage.getUnitPrice();
		System.out.println(unitPrice +"  unitPrice");
		double totalExpectedPrice=(unitPrice*1)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
}

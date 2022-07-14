package com.testing.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.PageObjects.HomePage;
import com.testing.PageObjects.IndexPage;
import com.testing.PageObjects.LoginPage;
import com.testing.PageObjects.SearchResultPage;
import com.testing.baseClass.BaseClass;

public class SearchResultPageTest extends BaseClass
{
    IndexPage indexpage;
    LoginPage loginpage;
    SearchResultPage searchResultPage;
    HomePage homepage;
    
    
	public SearchResultPageTest() throws IOException
	{
		super();
	}
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) throws IOException, InterruptedException
	{
		initialization(browser);
		indexpage= new IndexPage();
	}
	
	@Test(groups="Smoke")
	public void productAvailabilty() throws IOException
	{
		searchResultPage=indexpage.searchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}

}

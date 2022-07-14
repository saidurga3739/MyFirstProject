package com.testing.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.PageObjects.HomePage;
import com.testing.PageObjects.IndexPage;
import com.testing.PageObjects.LoginPage;
import com.testing.baseClass.BaseClass;



public class HomePageTest extends BaseClass
{

	public HomePageTest() throws IOException {
		super();
	}
	
	HomePage homepage;
	LoginPage loginpage;
	IndexPage indexpage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) throws IOException, InterruptedException
	{
		initialization(browser);
		homepage= new HomePage();
		loginpage= new LoginPage();
		indexpage= new IndexPage();
	}
	
	@Test(groups = "Smoke")
	public void validateWishList() throws Throwable
	{
		loginpage=indexpage.clickSigin();
		System.out.println("iam clicked on signin");
	    homepage=loginpage.login(prop.getProperty("userName"), prop.getProperty("password"));
	    System.out.println("uname is entered");
		boolean result=homepage.validateMyWishList();
		Assert.assertTrue(result);	
	}

	@Test(groups = "Smoke")
	public void validateOrderList() throws Throwable
	{
		loginpage=indexpage.clickSigin();
	    homepage=loginpage.login(prop.getProperty("userName"), prop.getProperty("password"));
		boolean result=homepage.validateOrderHistory();
		Assert.assertTrue(result);
		
		
		
	}
}

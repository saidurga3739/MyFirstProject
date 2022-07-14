package com.testing.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.PageObjects.AccountCreationPage;
import com.testing.PageObjects.IndexPage;
import com.testing.PageObjects.LoginPage;
import com.testing.baseClass.BaseClass;

public class AccountCreationTest extends BaseClass
{

	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountCreationPage;
	
	public AccountCreationTest() throws IOException 
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
	
	@Test(groups="Sanity")
	public void createAccount() throws IOException
	{
		loginpage=indexpage.clickSigin();
		accountCreationPage=loginpage.createNewAccount("sai2@gmail.com");	
		System.out.println("first half is passed");
	}
	
//	@Test(groups="Sanity")
//	public void validateTitle() throws IOException
//	{
//		boolean result=accountCreationPage.validateAccountCreateTitle();
//		System.out.println("result is "+ result);
//		Assert.assertTrue(result);
//	}

}

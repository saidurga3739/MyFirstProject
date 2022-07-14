package com.testing.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.PageObjects.IndexPage;
import com.testing.baseClass.BaseClass;

public class IndexPageTest extends BaseClass
{
	
	IndexPage indexpage;
	
	public IndexPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser)
	{
		initialization(browser);
	}
	
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws IOException
	{
		indexpage= new IndexPage();
		boolean image=indexpage.validateLogo();
		Assert.assertTrue(image, "image macthed");
		System.out.println("this is passed");
		
	}
	

}

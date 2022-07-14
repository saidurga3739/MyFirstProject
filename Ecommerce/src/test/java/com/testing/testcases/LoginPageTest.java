package com.testing.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.PageObjects.HomePage;
import com.testing.PageObjects.IndexPage;
import com.testing.PageObjects.LoginPage;
import com.testing.baseClass.BaseClass;
import com.testing.utility.NewExcelLibrary;


public class LoginPageTest extends BaseClass
{

	
	LoginPage loginpage;
	IndexPage indexpage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException 
	{
		super();
	}

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) throws IOException, InterruptedException
	{
		initialization(browser);
		indexpage= new IndexPage();
		loginpage =new LoginPage();
		Thread.sleep(10000);
		System.out.println("iam waited before sign in");
	}
	
	@DataProvider(name="loginTest")
	 
	 public String[][] getMyData() throws IOException 
	 {
//		 String loginData[][]=
//			   {
//				     
//					{"adminxyz@gmail.com", "admin@123" }, // 0
//                 
////                   {"sidama" ,   "World@03"},  // 1
////                   
////                   {"rissac" ,   "World@04" },  // 2
//				};
////	 
	     String path="C:\\Users\\003KT8744\\Desktop\\TestData.xlsx";
	     NewExcelLibrary rv1= new NewExcelLibrary(path);
	     int rows=rv1.getRowCount("Credentials");// 2
	     int cols=rv1.getCellCount("Credentials",rows); // 2
	     String loginData[][]=new String[rows][cols];
	     for(int i=1;i<=rows;i++)
	     {
	    	 for(int j=0;j<cols;j++)
	    	 {
	    		 loginData[i-1][j]=rv1.getCellData("Credentials", i, j);
	    	 }
	     }
	     
	    
	
				
	     return loginData;
		 
	 }
	
	@Test(dataProvider = "loginTest" , groups= {"Sanity","Smoke"})
	public void loginTest(String uname, String pwd) throws Throwable
	{
//		Log.startTestCase("loginTest");
//		Log.info("clicking on sign in");
		loginpage=indexpage.clickSigin();
		Thread.sleep(10000);
		System.out.println("iam waited");
		// Log.info("Entering username & password");
	    homepage=loginpage.login(uname,pwd);
	   // Log.info("getting the current url");
	    String currentURL=homepage.getCurrentURL();
	    Assert.assertEquals(currentURL, "http://automationpractice.com/index.php?controller=my-account");
	    System.out.println("this was passed");
	   // Log.endTestCase("loginTest");
	}

	

}

package com.testing.baseClass;

import java.io.File;
import com.testing.utility.ExtentManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;

	@BeforeSuite
	public void beforeSuite() throws IOException {
		ExtentManager.setExtent();
		// DOMConfigurator.configure("log4j.xml");
	}

	@AfterSuite
	public void AfterSuite() {
		ExtentManager.endReport();
	}

	public static Properties prop;

	public BaseClass() throws IOException {
		prop = new Properties();
		File f = new File(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
	}

	public static void initialization(String browser) {
		// String browser=prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\003KT8744\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("url") + " iam opened for the first time");

	}
	
	

}

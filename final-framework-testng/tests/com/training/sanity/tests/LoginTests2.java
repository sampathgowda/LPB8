package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.MediumLeveltestcases;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests2 {

	private WebDriver driver;
	private String baseUrl;
	private MediumLeveltestcases mediumLeveltestcases;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@BeforeMethod
	public void setUp() throws Exception {

		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		mediumLeveltestcases = new MediumLeveltestcases(driver);

		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	  @Test(priority=1)
	  public void RETC_043() throws InterruptedException {
	  mediumLeveltestcases.sendUserName("manipal");
	  mediumLeveltestcases.sendPassword("manipal@123");
	  mediumLeveltestcases.entertext("PRESTIGE","Home Town");
	  
	  screenShot.captureScreenShot("Screenshot");
	  
	  }
	  
	  @Test(priority=2) 
	  public void RETC_044() throws InterruptedException {
	  mediumLeveltestcases.sendUserName("manipal");
	  mediumLeveltestcases.sendPassword("manipal@123");
	  mediumLeveltestcases.AddNewfeature("Best","PRESTIGE","Home Town");
	  Thread.sleep(10000); screenShot.captureScreenShot("Screenshot");
	  
	  }
	 

	@Test(priority = 3)
	public void RETC_045() throws InterruptedException {
		mediumLeveltestcases.sendUserName("manipal");
		mediumLeveltestcases.sendPassword("manipal@123");
		mediumLeveltestcases.AddNewRegion("Electronic City", "Prestiage", "HomeTown");
		Thread.sleep(10000);
		screenShot.captureScreenShot("Screenshot");
	}

}

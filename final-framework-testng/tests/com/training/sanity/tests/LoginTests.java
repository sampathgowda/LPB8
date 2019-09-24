package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		loginPOM.clickhyperlinnk();
		loginPOM.sendUserName("sampath");
		loginPOM.sendPassword("sampath@12345");
		loginPOM.clickLoginBtn(); 
		loginPOM.logout();
		screenShot.captureScreenShot("Screenshot");
	}

	/*
	 * @Test(priority=2) public void Adminuserlogin() throws InterruptedException {
	 * loginPOM.clickhyperlinnk(); loginPOM.sendUserName("admin");
	 * loginPOM.sendPassword("adminuser@12345"); loginPOM.clickLoginBtn();
	 * loginPOM.clickuserlinnkadminpage(); loginPOM.Sendnewpwd("adminuser@12345");
	 * Thread.sleep(10000); loginPOM.updateprofile(); Thread.sleep(1000);
	 * screenShot.captureScreenShot("Screenshot"); }
	 * 
	 * @Test(priority = 3) public void RETC_013() throws InterruptedException {
	 * loginPOM.clickhyperlinnk(); loginPOM.sendUserName("admin");
	 * loginPOM.sendPassword("admin!@#$%"); loginPOM.clickLoginBtn();
	 * loginPOM.clickuserlinnkadminpage();
	 * loginPOM.Sendlastnameandphonenumber("Manzoor","9876543210");
	 * Thread.sleep(10000); loginPOM.updateprofile(); Thread.sleep(1000);
	 * loginPOM.updateprofile(); screenShot.captureScreenShot("Screenshot"); }
	 * 
	 * 
	 */
}



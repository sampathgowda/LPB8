package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	
	}
		
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement hyperlink; 
    @FindBy(xpath ="//button[contains(text(),'Generate Password')]")
    private WebElement generatepwd;
	@FindBy(xpath="//div[@class='my-account-nav-container']//ul[2]//li[2]//a[1]")
	private WebElement logout; 
	@FindBy(xpath ="//div[@class='wp-menu-image dashicons-before dashicons-admin-users']")
	private WebElement userlinkadminpage;
	@FindBy(xpath="//a[contains(text(),'admin')]")
	private WebElement yourprofileadminpage;
	@FindBy(id = "pass1-text")
	private WebElement passtext;
	@FindBy(id = "last_name")
	private WebElement Lastname;
	@FindBy(id = "phone")
	private WebElement phone;
	@FindBy(id="submit")
	private WebElement updateprofile;
	@FindBy(id="user_pass")
	private WebElement password;
	@FindBy(id="user_login")
	private WebElement username;
	@FindBy(name="login")
	private WebElement SignIn; 
	
	public void sendUserName(String userName) {
		this.username.clear();
		this.username.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.SignIn.click(); 
	}

	public void clickhyperlinnk() {
		this.hyperlink.click();	
	}
	public void logout() {
		this.logout.click();
		
	}

	public void clickuserlinnkadminpage()  {
		this.userlinkadminpage.click();
		this.yourprofileadminpage.click();
		this.generatepwd.click();
		
	}
	
	public void Sendnewpwd(String Newpassword)  {
		this.passtext.clear();
		this.passtext.sendKeys(Newpassword);
		
	}
	
	public void Sendlastnameandphonenumber(String lastname, String phone) throws InterruptedException  {
		this.Lastname.clear();
		this.Lastname.sendKeys(lastname);
		this.phone.clear();
		this.phone.sendKeys(phone);
		
	}
	
	public void updateprofile() {
		this.updateprofile.click();
	}
	
}



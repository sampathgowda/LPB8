package com.training.pom;

import org.apache.poi.hssf.record.FeatRecord;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;


public class MediumLeveltestcases {
	private WebDriver driver; 
	private JavascriptExecutor javascriptExecutor;
	
	public  MediumLeveltestcases(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);	
	}
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(id="user_login")
	private WebElement username;
	@FindBy(name="login")
	private WebElement SignIn; 
	@FindBy(xpath="//div[contains(text(),'Properties')]")	
	private WebElement Propertiestab;
	@FindBy(linkText="Add New" )
	private WebElement clickonAddNew;
	@FindBy(id = "title")
	private WebElement entertext;
	@FindBy(id = "_price")
	private WebElement enterdataintextbox;
	@FindBy (id ="in-property_feature-431")
	private WebElement selectedaddedfeature;
	@FindBy (id = "in-region-57")
	private WebElement selectregions;
	@FindBy(id="publish")
	private WebElement cliclpublishbutton;
	@FindBy(id = "property_feature-add-toggle")
	private WebElement clickonaddNewFeature;
	@FindBy (id = "newproperty_feature")
	private WebElement entertextinaddfeature;
	@FindBy (id = "newproperty_feature_parent")
	private WebElement selectvaluefromparentfeaturelist;
	@FindBy (id = "property_feature-add-submit")
	private WebElement AddNewFeature;
	@FindBy (id ="region-add-toggle")
	private WebElement AddNewRegion; 
	public void sendUserName(String userName) {
		this.username.clear();
		this.username.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		this.SignIn.click();
		this.Propertiestab.click();
		this.clickonAddNew.click();
		
	}

	public void entertext (String text, String textbox)
	{
		
		this.entertext.click();
		this.entertext.sendKeys(text);
		this.enterdataintextbox.click();
		this.enterdataintextbox.sendKeys(textbox);
		this.selectedaddedfeature.click();
		this.selectregions.click();
		this.cliclpublishbutton.click();
	}
	public void AddNewfeature(String text, String text1,String textbox) {
		this.clickonaddNewFeature.click();
		this.entertextinaddfeature.sendKeys(text);
		Select Feature_list  = new Select(selectvaluefromparentfeaturelist);
		Feature_list.selectByValue("435");
		this.AddNewFeature.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.F5).build().perform();
		this.entertext.sendKeys(text1);
		this.enterdataintextbox.sendKeys(textbox);
		this.cliclpublishbutton.click();
		
	}
	@FindBy (id ="newregion")
	private WebElement Enternewregion;
	@FindBy (id = "newregion_parent")
	private WebElement selectregionfromdropdown;
	@FindBy (id ="region-add-submit")
	private WebElement Addnewregionclick;
	public void AddNewRegion(String text,String text1,String textbox) {
		this.AddNewRegion.click();
		this.Enternewregion.sendKeys(text);
		Select region_list  = new Select(selectregionfromdropdown);
		region_list.selectByValue("49");
		this.Addnewregionclick.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.F5).build().perform();
		this.entertext.sendKeys(text1);
		this.enterdataintextbox.sendKeys(textbox);
		this.cliclpublishbutton.click();

		
	}
	

}

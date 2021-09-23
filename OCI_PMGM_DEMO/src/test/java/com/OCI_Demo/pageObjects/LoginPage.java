package com.OCI_Demo.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.OCI_Demo.testCases.BaseClass;


public class LoginPage {
	
	public WebDriver lDriver;
	
	public LoginPage(WebDriver lpDriver)
	{
		lDriver = lpDriver;
		PageFactory.initElements(lpDriver, this);
	}
	
	@FindBy(name = "uid" )
	@CacheLookup
	public WebElement txtUserName;
	
	
	@FindBy(name = "password")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	public WebElement btnLogin;
	
	
	public void enterUserName(String uname)//action methods
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(lDriver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(txtUserName));
		txtUserName.click();
		txtUserName.clear();
		txtUserName.sendKeys(uname);	
		Thread.sleep(100);
		BaseClass.logger.info("Entered user name as: "+ uname);
		}catch(Exception e)
		{
			Assert.assertTrue(false);
			BaseClass.logger.error(e.getMessage().toString());
		}
		
	}
	
	public void enterPwd(String pwd)
	{
		txtPassword.sendKeys(pwd);
		lDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
} 

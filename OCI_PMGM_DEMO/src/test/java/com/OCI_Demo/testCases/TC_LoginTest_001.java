package com.OCI_Demo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OCI_Demo.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest()
	{
		driver.get(baseURL);
		
		logger.info("URL launched");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(username);
		logger.info("Username entered");
		
		lp.enterPwd(password);
		logger.info("Password entered");
		
		lp.clickSubmit();
		logger.info("Submit buttonclicked");
		

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}

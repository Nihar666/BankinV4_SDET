package com.banking.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.testbase.BaseClass;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException{
		
		driver.get(baseUrl);
		
		logger.info("Url is open");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Enter username::");
		lp.setPassword(password);
		logger.info("password inserteddd");
		
		lp.clickSubmit();
		captureScreen(driver, "loginTest");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
		}else{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
		
		
		
		
		
		
		
	}

}

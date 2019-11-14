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
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		
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

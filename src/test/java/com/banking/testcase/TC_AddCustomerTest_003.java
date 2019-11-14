package com.banking.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;
import com.banking.testbase.BaseClass;

import net.bytebuddy.utility.RandomString;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();
        
        addcust.custName("nihar");
        addcust.custgender("male");
        addcust.custdob("10", "1", "1990");
		Thread.sleep(20000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("500074");
		addcust.custtelephoneno("9876543210");
		
		
	    String email = randomstring()+"@gmail.com";
	    addcust.custemailid(email);
	    Thread.sleep(5000);
	    
	    addcust.custpassword("abcdefff");
	    addcust.custsubmit();
	    
	    
	    
	   boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	   if(res==true){
		   Assert.assertTrue(true);
	   }else{
		   
		   captureScreen(driver, "addNewCustomer");
		   Assert.assertTrue(false);
	   }
	    
	    
		
		
		
		
	}

	public String randomstring() {
		String email = RandomString.make(8);
		return email;
	}
	
	public String randomNum(){
		
		String generatedString2 = RandomString.make(8);
		return generatedString2;
	}
	
}

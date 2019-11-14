package com.banking.testbase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utility.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseUrl=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br){
		
		if(br.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
	}
	
	/*@AfterClass
	public void tearDown(){
		driver.quit();
	}*/
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") +"/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
}
		

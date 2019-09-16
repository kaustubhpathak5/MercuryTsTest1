package com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTsTest 
{
	public WebDriver driver;
	@Test(priority=1,description="Verify that valid user1 able to login into Mercury tours application successfully using valid username @ password")
	public void loginWithValidds1()
	{
		System.out.println("login withValidds1 method under test");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Suvidyap1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		System.out.println("user1 has login into Mercury tours application successfully");
		boolean flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		System.out.println("Flight finder Image is displayed");
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	
	@Test(priority=2,description="Verify that valid user2 able to login into Mercury Tours Application by using valid username and password")
	  public void loginwithValidds2() 
		
	{
		 System.out.println("loginwithValidds2 method under Test");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap2");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword2");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  System.out.println("User1 has login into Mercury tours application successfully");
		  boolean flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		  System.out.println("Flight Finder image is displayed");
		  driver.findElement(By.linkText("SIGN-OFF")).click();	  
	  }
	  
	  @Test(priority=3,description="Verify that valid user2 able to login into Mercury Tours Application by using valid username and password")
	  public void loginwithInValidds() 
	  {
		  System.out.println("loginwithValidds2 method under Test");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  System.out.println("User1 has login into Mercury tours application successfully");
		  boolean flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		  System.out.println("Flight Finder image is displayed");
		  driver.findElement(By.linkText("SIGN-OFF")).click();	  
	  }
	  
	  @BeforeMethod
	  public void getAllCookies() 
	  {
		  System.out.println("In getAllCookies method under BeforeMethod");
		  Set<Cookie> cookies=driver.manage().getCookies();
		  for(Cookie cookie:cookies)
		  {
			  System.out.println(cookie.getName());
		  }
	  }

	  @AfterMethod
	  public void captureScreenshot(ITestResult result) throws IOException
	  {
		  if(result.getStatus()==result.FAILURE)
		  {
		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFileToDirectory(src, new File("E:\\Nilam Mam\\Listener\\Screenshotfailed"));
	      System.out.println("Screenshot has captured successfully");
		  }else
		  {
			  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFileToDirectory(src, new File("E:\\Nilam Mam\\Listener\\Screenshotpass\\")); 
		  }
	  }

	  @BeforeClass
	  public void maximizeBrowser() 
	  {
		  System.out.println("In maximizeBrowser method under BeforeClass");
		  driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void deleteAllCookies()
	  {
		  System.out.println("In deleteAllCookies method under AfterClass");
		  driver.manage().deleteAllCookies();
	  }

	  @BeforeTest
	  public void enterApplicationURL() 
	  {
		  System.out.println("enterApplicationURL method under BeforeTest");
		  driver.get("http://www.newtours.demoaut.com/mercurywelcome.php");
		  System.out.println("Application URL is entered successfully");
	  }

	  @AfterTest
	  public void dbConnectionClosed()
	  {
		  System.out.println("dbConnectionClosed method under AfterTest");
	  }

	  @BeforeSuite
	  public void openBrowser()
	  {
		  System.out.println("openBrowser method under BeforeSuite");
		  System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\29062019\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  System.out.println("Chrome browser is opened successfully");
	  }

	  @AfterSuite
	  public void closeBrowser()
	  {
		  System.out.println("In closeBrowser method under AfterSuite");
		  driver.close();
	  }

	}

	
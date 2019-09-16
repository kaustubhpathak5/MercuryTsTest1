package com.model;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestcaseListenerTest implements ITestListener
{
  @Override
  public void onFinish(ITestContext arg0)
  {
	  System.out.println("In onFinish method under TestcaseListenerTest ");
  }
  
  @Override
  public void onStart(ITestContext arg0)
  {
	  System.out.println("In onstart method under TestcaseListenerTest");
  }
  
  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result)
  {
	  System.out.println("In onTestFailedButWithinSuccessPercentage method under TestcaseListenerTest");
  }
  
  @Override
  public void onTestFailure(ITestResult result)
  {
	  System.out.println("onTestfailure method under Teat case listener test ");
	  String testfailednm=result.getName();
	  System.out.println("Failed test name:"+testfailednm);
  }
  
  @Override
  public void onTestSkipped(ITestResult result)
  {
	    System.out.println("In onTestSkipped method under TestcaseListenerTest");
		String testskippednm=result.getName();
		System.out.println("Skipped test name: "+testskippednm);
  }
  
  @Override
  public void onTestStart(ITestResult result)
  {
	  System.out.println("on start method under testcaselistener test");
  }
  
  @Override
  public void onTestSuccess(ITestResult result)
  {
	  System.out.println("In onTestSuccess method under testcaseListenerTest");
	  String testnmpass=result.getName();
	  System.out.println("Test pass is:"+testnmpass);		  
  }
}
 
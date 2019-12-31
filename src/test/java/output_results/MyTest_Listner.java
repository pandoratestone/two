package output_results;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;
import test_data.Data_Helper;

public class MyTest_Listner implements ITestListener{
	
	 public static WebDriver driver;
	 public static ExtentReports reports;
	 public static ExtentTest test;
	
	 public void onTestStart(ITestResult result) {
		
	  System.out.println("on test start====");
	  
	  test = reports.startTest(result.getMethod().getMethodName());
	  UDF_All_Methods.TC_PassCount=0;
	  UDF_All_Methods.TC_FailCount=0;
	  UDF_All_Methods.TC_TotalCount=0;
	  System.out.println("TC_PassCount: "+UDF_All_Methods.TC_PassCount);
//	  test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
	 }
	 
	 
	 
	 public void onTestSuccess(ITestResult result) {
	  System.out.println("on test success===> "+test.getEndedTime());
//	  test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	 }
	 
	 public void onTestFailure(ITestResult result) {
	  System.out.println("on test failure===="+test.getEndedTime());
//	  test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
//	  TakesScreenshot ts = (TakesScreenshot) driver;
//	  File src = ts.getScreenshotAs(OutputType.FILE);
//	  try {
//	   FileUtils.copyFile(src, new File("C:\\images\\" + result.getMethod().getMethodName() + ".png"));
//	   String file = test.addScreenCapture("C:\\images\\" + result.getMethod().getMethodName() + ".png");
//	   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
//	   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
//	  } catch (IOException e) {
//	   e.printStackTrace();
//	  }
	 }
	 public void onTestSkipped(ITestResult result) {
	  System.out.println("on test skipped");
	  test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	 }
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	  System.out.println("on test sucess within percentage");
	 }
	 
	 
	 public void onStart(ITestContext context) {
	  System.out.println("on start");
	  System.out.println("------------------------------------------------");
//	  String ss=new SimpleDateFormat("System.getProperty("user.dir")+"\\ExtentReportResults.html";

	  String sthtmlFile=Constants.strExtendReportpath+"Extendreports.html";
	  System.out.println("strImagePath="+sthtmlFile);
	  reports = new ExtentReports(sthtmlFile);
	  Data_Helper.CopyFileToOtherLocation(Constants.strTestcaseTargetPath);
	 }
	 
	 
	 
	 
	 public static void ExtendReportsResult(String Result,String strTestcasename,String strTCDesc) {
		  System.out.println("on test failure");
//		  test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
			  String strImagePath=Constants.strImagesPath+System.currentTimeMillis();
		   FileUtils.copyFile(src, new File(strImagePath+".png"));
		   String file = test.addScreenCapture(strImagePath+ ".png");
		   if(Result.equalsIgnoreCase("fail"))
		   {
		   test.log(LogStatus.FAIL, strTestcasename, strTCDesc+file);
		   UDF_All_Methods.TC_FailCount=UDF_All_Methods.TC_FailCount+1;
		   }
		   else if(Result.equalsIgnoreCase("pass"))
		   {
			   test.log(LogStatus.PASS, strTestcasename, strTCDesc+file);
			   UDF_All_Methods.TC_PassCount=UDF_All_Methods.TC_PassCount+1;
		   }
			Data_Helper.TestCaseRowNumber=0;   
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
	 
	 
	 
	 public void onFinish(ITestContext context) {
	  System.out.println("on finish--------->");
//	  driver.close();
	  reports.endTest(test);
	  reports.flush();
	 }

	 
	 
	 
	 
}

package output_results;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.error.MarkedYAMLException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;

public class Extend_Reports extends UDF_All_Methods{

	public Extend_Reports(WebDriver driver) {
		super(driver);
		
	}
	
	 static ExtentTest test;
	 static ExtentReports report;
	
	
/*	public  void StartReport()
	{
		String Filepath=Constants.strImagesPath;
		System.out.println("Filepath=="+Filepath);
//		report=new ExtentReports("E:\\ExtentReportResults.html");
		report = new ExtentReports("E:\\ExtentReportResults.html");
	}*/
	
	public  void StartTestCase(String strTestcaseName)
	{
		System.out.println("strTestcaseName==="+strTestcaseName);
		test=report.startTest(strTestcaseName);
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	
	public  void Success (String strTestcasename)
	{
		System.out.println("Success===="+strTestcasename);
		   String strIamgePath=strImagePath(strTestcasename);
		   String file = test.addScreenCapture(strIamgePath);
		   test.log(LogStatus.PASS, strTestcasename + "test is Passed", file);
		   UDF_All_Methods.TC_PassCount=UDF_All_Methods.TC_PassCount+1;
	}
	
	public static void Failure(String strTestcasename)
	{
		   String strIamgePath=strImagePath(strTestcasename);
		   String file = test.addScreenCapture(strIamgePath);
		   test.log(LogStatus.FAIL, strTestcasename + "test is failed", file);
//		   MyTest_Listner.test.log(LogStatus.FAIL,strTestcasename + "test is failed");
		   UDF_All_Methods.TC_FailCount=UDF_All_Methods.TC_FailCount+1;
	}
	
	
	public static void OnFinishResports()
	{
		report.flush();
		report.endTest(test);
		report.close();
	}
	
	public static String strImagePath(String strTestCasename)
	{
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 String strImagePath=Constants.strImagesPath+strTestCasename+UDF_All_Methods.milliseconds +".png";
		try {
			
			FileUtils.copyFile(src, new File(strImagePath));
			return strImagePath;
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		return strImagePath;
	}
	
	
	
	
	
}

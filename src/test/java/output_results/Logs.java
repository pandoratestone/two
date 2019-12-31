package output_results;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import streams_ucc_UDF.UDF_All_Methods;

public class Logs extends UDF_All_Methods{

	
	 public Logs(WebDriver driver) {
		super(driver);
	}
 
 public static ExtentReports reports;
 public static ExtentTest logger;
	 
	 private static Logger Log = Logger.getLogger(Logs.class.getName());
	public static final String log4jpath=System.getProperty("user.dir")+"\\src\\test\\java\\log4j.properties";
	 
	 public static void start_test_case(String testcasename)
	 {
	    PropertyConfigurator.configure(log4jpath);

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+testcasename+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		
		Log.info("****************************************************************************************");
//		Extend_Reports e=new Extend_Reports(driver);
//		e.StartTestCase(testcasename);
		//Log.info("****************************************************************************************");
	 }
	 
	 public static void endTestCase(String sTestCaseName){

			Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
			Log.info("XXXXXXXXXXXXXXXXXXXXXXX   "+sTestCaseName+"  "+"XXXXXXXXXX Ended Test case XXXXXXXXXXXXX");
			//Log.info("XXXXXXXXXXXXXXXXXXXXXXX    Testcase ended     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			
			}

			// Logs levels status methods

		 public static void info(String message) {

				Log.info(message+"\n");

				}

		 public static void warn(String message) {

		    Log.warn(message+"\n");

			}
		 
		 public static void error(String message) {

			    Log.error(message+"\n");

				}

			 public static void fatal(String message) {

			    Log.fatal(message);

				}

			 public static void debug(String message) {

			    Log.debug(message);

				}
			 
			 
			 
			 
			 
			 
			 
			 
			 
			/* public  void Pass(String passDescription) throws Exception 
			 {
			  
					  String screenshot_path =Smartbox_all_methods.captureScreenshot(driver, passDescription);	
					  String image=logger.addScreenCapture(screenshot_path);
					  logger.log(LogStatus.PASS,""+passDescription+"",image);
		     }
			 public  void fail(String FailDescription){
					 String screenshot_path =Smartbox_all_methods.captureScreenshot(driver, FailDescription);	
					  String image=logger.addScreenCapture(screenshot_path);
					  logger.log(LogStatus.FAIL,""+FailDescription+"",image);
			 }*/
}

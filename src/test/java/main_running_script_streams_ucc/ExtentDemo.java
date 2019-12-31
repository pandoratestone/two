package main_running_script_streams_ucc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ExtentDemo {
static ExtentTest test;
static ExtentReports report;
@BeforeClass
public static void startTest()
{
	System.out.println("E\\ExtentReportResults.html");
report = new ExtentReports("E:\\ExtentReportResults.html");

test = report.startTest("ExtentDemo");
}
@Test
public void extentReportsDemo()
{
	System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Softwares\\Jar_Drivers\\Chrome drive\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.google.co.in");
if(driver.getTitle().equals("Google"))
{
test.log(LogStatus.PASS, "Navigated to the specified URL");
}
else
{
test.log(LogStatus.FAIL, "Test Failed");
}
}
@AfterClass
public static void endTest()
{
report.endTest(test);
report.flush();
}
}
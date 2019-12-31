package main_running_script_streams_ucc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import output_results.Logs;

public class Status_Presence_Main {
	 public static HSSFSheet ExcelWSheet;
	 private static HSSFWorkbook ExcelWBook;
	 private static HSSFCell Cell;
     private static HSSFRow Row;
     public static WebDriver driver;

	public static void main(String[] args) throws Exception 
	{
		
	FileInputStream ExcelFile = new FileInputStream("E:\\Selenium\\Scripts\\Com.streama_UCC.com\\src\\test\\java\\test_data\\Streams_StatusBeta2.xls");
	ExcelWBook = new HSSFWorkbook(ExcelFile);
    ExcelWSheet = ExcelWBook.getSheet("testdata");
       
    int rowCount = ExcelWSheet.getLastRowNum();
	System.out.println("last Row Numb:"+rowCount);
    ExcelWBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
  	 
   
  	 
//  	 WebDriverWait elemetewait=new WebDriverWait(driver, 60);
  	 
       for (int i = 1; i <=24; i++) 
       {
    	   System.out.println("I value is=="+i);
    	   Cell = ExcelWSheet.getRow(i).getCell(0);
//      	   String CellData = Cell.getStringCellValue().trim();
    	   String CellData ="satyaone@accountvalidation";
      	   System.out.println("Cell data is :"+CellData);
      
      	 System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Softwares\\Jar_Drivers\\Chrome drive\\chromedriver.exe");
       	 driver=new ChromeDriver();
       	 driver.manage().window().maximize();
       	 driver.manage().deleteAllCookies();
            
      	 try {
      		 driver.get("https://streams.us/");
			//driver.get("https://streamsbeta2.beta-wspbx.com");
			WebDriverWait elemetewait=new WebDriverWait(driver, 60);
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("xusername")))).sendKeys(CellData);
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password")))).sendKeys("abc@1234",Keys.ENTER);
//			Thread.sleep(3000);
			/*elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='chatFilter']"))));
			driver.navigate().refresh();
			Thread.sleep(3000);
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='chatFilter']"))));
			System.out.println("Recents Locading Done");
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='spaneltabanc_1']")))).click();
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search_contacts")))).sendKeys(CellData);;
			String Status=elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+CellData+"']")))).getText();
				
			String StatusMessage=System.currentTimeMillis()+"_"+i;
			
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("status_msg")))).click();
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cstatus_new")))).clear();
			if (i>10) 
			{
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='statusicon_available' and @type='radio']")))).click();
				
			}
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cstatus_new")))).sendKeys(StatusMessage,Keys.ENTER);
			List <WebElement> Statuscount=driver.findElements(By.xpath("//span[@class='statusMessage']"));
			int count=Statuscount.size();
			System.out.println("count is :"+count);
			if (count>=5) 
			{
				Thread.sleep(2000);
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='button'][@value='OK']")))).click();
				System.out.println("Alert Accepted doneeeee");
			}
//				Thread.sleep(3000);
			
			elemetewait.until(ExpectedConditions.textToBe(By.id("status_msg"), StatusMessage));
			elemetewait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+CellData+"']"), StatusMessage));
			
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("streams_menu_icon_area")))).click();
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@onclick='SH.signOut();']")))).click();
			Thread.sleep(2000);
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("xusername"))));
			
			//driver.quit();
			*/
		} 
      	 catch (Exception e) 
      	 {
			System.out.println("Failed at user name is :"+CellData);
			System.out.println("Failed to Change usre status :"+e);
			/*String currenturl=driver.getCurrentUrl();
			if (currenturl.contains("dashboardid")) 
			{
			System.out.println("Login came inn Catch due to invalid crediantials");	
			} 
			else if(currenturl.contains("home.jsp")) 
			{
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("streams_menu_icon_area")))).click();
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@onclick='SH.signOut();']")))).click();
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("xusername"))));
			}
			*/
			//driver.quit();
		}
      	 
//      	try {
//			Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
//			Logs.info("[Task kill]... driver kill done");
//		} catch (Exception e) {
//			Logs.error("[Task kill]... Failed to kill driver");
//		}
       }
       
       
       try {
			Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
			Logs.info("[Task kill]... driver kill done");
		} catch (Exception e) {
			Logs.error("[Task kill]... Failed to kill driver");
		}
	}

}

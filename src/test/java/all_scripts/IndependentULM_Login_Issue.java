package all_scripts;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import output_results.Logs;

public class IndependentULM_Login_Issue {

	
	
	 public static HSSFSheet ExcelWSheet;
	 private static HSSFWorkbook ExcelWBook;
	 private static HSSFCell Cell;
     private static HSSFRow Row;
     public static WebDriver driver;

	public static void main(String[] args) throws Exception 
	{
		
	FileInputStream ExcelFile = new FileInputStream("E:\\Selenium\\Scripts\\Com.streama_UCC.com\\src\\test\\java\\test_data\\Streams_IndependentULM.xls");
	ExcelWBook = new HSSFWorkbook(ExcelFile);
    ExcelWSheet = ExcelWBook.getSheet("testdata");
       
    int rowCount = ExcelWSheet.getLastRowNum();
	System.out.println("last Row Numb:"+rowCount);
    ExcelWBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
    
    
    for (int i = 1; i <=rowCount; i++) 
    {
 	   System.out.println("I value is=="+i);
 	   Cell = ExcelWSheet.getRow(i).getCell(0);
   	   String CellData = Cell.getStringCellValue().trim();
   	   System.out.println("Cell data is :"+CellData);
   
   	   	 
//    	 driver.manage().deleteAllCookies();
         
   	 try {
   		 
   		if((CellData).equals(null) || (CellData).equals(""))
		{
   			CellData="revert@security";
		}
		
   	/*	System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Softwares\\Jar_Drivers\\Chrome drive\\chromedriver.exe");
       	 driver=new ChromeDriver();
       	 driver.manage().window().maximize();*/
   		  System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Softwares\\Jar_Drivers\\Chrome drive\\chromedriver.exe");
          ChromeOptions options = new ChromeOptions();
		  options.addArguments("user-data-dir=C:/Users/QA/AppData/Local/Google/Chrome/User Data/person 7");
		  options.addArguments("--start-maximized");
		  
		 
	     driver=new ChromeDriver(options);
   		 driver.get("https://gostreams.beta-wspbx.com/livemonitor.jsp");
   		 SessionId session = ((RemoteWebDriver) driver).getSessionId();
   		 System.out.println("session=="+session);
			
			WebDriverWait elemetewait=new WebDriverWait(driver, 100);
			

			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("xusername")))).sendKeys(CellData);
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password")))).sendKeys("abc@1234",Keys.ENTER);
			elemetewait.until(ExpectedConditions.attributeContains(By.id("pgload_indicator"), "style", "display: none"));
//			elemetewait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("pgload_indicator")), "style", Attributevalue));
//			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("streams_menu_icon_area")))).click();
//			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@onclick='SH.signOut();']")))).click();
//			driver.navigate().refresh();
//			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("xusername"))));
			
			}
   	 		catch(Exception LginEx)
   	 		{
   	 		System.out.println("Login failed @ "+CellData);	
   	 		System.out.println("Getting URl==="+driver.getCurrentUrl());
   	 		System.out.println("Login Exception Reason is=="+LginEx.getMessage()+"\n");
   	 		}
   	 		driver.quit();
			}
			}
}

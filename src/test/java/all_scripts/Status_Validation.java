package all_scripts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;

public class Status_Validation extends UDF_All_Methods{

	public Status_Validation(WebDriver driver) {
		super(driver);
		
	}

	public static String filepath="E:\\"+datesent()+"_output.txt";
	
	
	public void Status() throws Exception
	{
		this.second_login("pavanone@iosclient", "abc@1234");
		WebDriverWait st=new WebDriverWait(driver, 10);
		for(int i=1;i<=100;i++)
		{
			String Statuspass="IOSclient"+i;
			try {
				st.until(ExpectedConditions.visibilityOf(statusbar)).click();
				st.until(ExpectedConditions.visibilityOf(EnterStatus)).clear();
				this.EnterStatus.sendKeys(Statuspass,Keys.ENTER);
				List <WebElement> Statuscount=driver.findElements(By.xpath("//span[@class='statusMessage']"));
				int count=Statuscount.size();
				System.out.println("count is :"+count);
				if (count>=5) 
				{
					st.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='button'][@value='OK']")))).click();
				}
				
				st.until(ExpectedConditions.textToBe(By.id("status_msg"), Statuspass));
				st.until(ExpectedConditions.textToBe(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_pavanone@iosclient']"), Statuspass));
				this.Screenshort(Statuspass+"_", "pass_");
			} 
			catch (Exception e) 
			{
				/*LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
				 BufferedWriter writer = null;
		        for (LogEntry entry : logEntries) 
		        {
		            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage()+"\n");
		            writer = new BufferedWriter(new FileWriter(filepath,true));
		            writer.write(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		            writer.close();
		        }
		        this.Screenshort(Statuspass+"_", "FAIL_");
		        this.senmail(Statuspass, i, "balapavan@panterranetworks.com", filepath);*/
				Logs.error("[Status Update fail]..."+e.getMessage());
			}
			
		}
		
		
		
	  }
	
}

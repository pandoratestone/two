package main_running_script_streams_ucc;

import java.util.List;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import output_results.Logs;
import test_data.Constants;

public class PersistanceMonitoring_Setting {

	 public static WebDriver driver;
	 
	public static void main(String[] args) throws Exception {
		
	
		  System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Softwares\\Jar_Drivers\\Chrome drive\\chromedriver.exe");
          ChromeOptions options = new ChromeOptions();
		  options.addArguments("user-data-dir=C:/Users/QA/AppData/Local/Google/Chrome/User Data/person 8");
		  options.addArguments("--start-maximized");
		  
		 
	     driver=new ChromeDriver(options);
	    
   		 driver.get(Constants.IDPStreamsBETAURL);
   		 SessionId session = ((RemoteWebDriver) driver).getSessionId();
   		 System.out.println("session=="+session);
			
			WebDriverWait elemetewait=new WebDriverWait(driver, 100);
			

			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("xusername")))).sendKeys("ios@security");
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password")))).sendKeys("abc@1234",Keys.ENTER);
//			WebElement SigninButton=driver.findElement(By.id("login_button"));
//			boolean isEnabledSigninButton=elemetewait.until(ExpectedConditions.visibilityOf(SigninButton)).isEnabled();
//			if(isEnabledSigninButton==true)
//			{
//				String backColour=SigninButton.getCssValue("background-color");
//				String strFontSize=SigninButton.getCssValue("background-color");
//				
//			
////				Logs.info("backColour of SigninButton=="+backColour+"  allll--->"+allll);
//				
//				
//				
//			}
			
			
			
			
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("xusername")))).sendKeys("ios@security");
			elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password")))).sendKeys("abc@1234",Keys.ENTER);
			elemetewait.until(ExpectedConditions.attributeContains(By.id("pgload_indicator"), "style", "display: none"));
			
			List <WebElement> LogoutAgents=driver.findElements(By.className("userName_LoggedOut"));
			int SuccessCpount=0;
			int FailCount=0;
			for(int i=LogoutAgents.size()-1;i>=0;i--)
			{
				elemetewait.until(ExpectedConditions.visibilityOf(LogoutAgents.get(i))).click();
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("search_ULM_Main"))));
				List <WebElement> GroupsCount=driver.findElements(By.xpath("//div[contains(@id,'plogin_')]"));
				boolean issavebuttonClick=false;
				
				for(int j=0;j<GroupsCount.size();j++)
				{
					String strClass=GroupsCount.get(j).getAttribute("class");
					System.out.println("class==========="+strClass+" Count==="+GroupsCount.size());
//					String strColor = GroupsCount.get(j).getCssValue("color");
//					String[] hexValue = strColor.replace("rgba(", "").replace(")", "").split(",");
//
//					int hexValue1=Integer.parseInt(hexValue[0]);
//					hexValue[1] = hexValue[1].trim();
//					int hexValue2=Integer.parseInt(hexValue[1]);
//					hexValue[2] = hexValue[2].trim();
//					int hexValue3=Integer.parseInt(hexValue[2]);
//
//					String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
//					System.out.println("strColor======"+actualColor);
					if(strClass.contains("checkbox_unchecked"))
					{	
						GroupsCount.get(j).click();
						new WebDriverWait(driver, 7).until(ExpectedConditions.attributeToBe(GroupsCount.get(j), "class", "checkbox_checked"));
						issavebuttonClick=true;
						
					}
					else
					{
						
						System.out.println("AlreadyChecked==========="+strClass+"  GroupsCount.size()=="+GroupsCount.size());
						
					}
				}
				if(issavebuttonClick==true)
				{
				Thread.sleep(2000);
				new Actions(driver).moveToElement(driver.findElement(By.xpath("(//input[@value='Save'])[3]"))).click();
				driver.findElement(By.xpath("(//input[@value='Save'])[3]")).click();
				System.out.println("New Save @==="+LogoutAgents.get(i).getText());
				Thread.sleep(3000);
//				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("search_ULM_Main"))));
				elemetewait.until(ExpectedConditions.visibilityOf(LogoutAgents.get(i-1))).click();
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("search_ULM_Main"))));
				elemetewait.until(ExpectedConditions.visibilityOf(LogoutAgents.get(i))).click();
				elemetewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("search_ULM_Main"))));
				}
				try{
//					Thread.sleep(3000);
					List <WebElement> Recheck=driver.findElements(By.xpath("//div[contains(@id,'plogin_')]"));
					
					for(int k=0;k<Recheck.size();k++)
					{
						new WebDriverWait(driver, 7).until(ExpectedConditions.attributeToBe(Recheck.get(k), "class", "checkbox_checked"));
					
					}
					SuccessCpount=SuccessCpount+1;
					}
					catch(Exception e)
					{
					FailCount=FailCount+1;
					
					System.out.println("Failed at user LogoutAgents==="+LogoutAgents.get(i).getText());
					System.out.println("fail Reason=="+e);
					}
				
					System.out.println("Maxmium users ==="+LogoutAgents.size()+" Success Count=="+SuccessCpount+" Fail Count=="+FailCount);
			}
		
	}

}

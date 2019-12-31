package main_running_script_streams_ucc;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.seleniumhq.jetty9.util.log.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import all_scripts.All_Actionsat_Ownserend;
import all_scripts.Alll_Actions_Receiverend;
import all_scripts.Audio_file_middlechatpanel;
import all_scripts.Colleguge_photos;
import all_scripts.IndependentULMLogin;
import all_scripts.Login_Logout_Agents_Validations;
import all_scripts.Login_testcase;
import all_scripts.Messages_Load;
import all_scripts.Status_Validation;
import all_scripts.Streams_UCC_Attachments;
import all_scripts.Streams_Ucc_sentmessage;
import all_scripts.Team_Creations;
import all_scripts.TextFile_Middelchat;
import all_scripts.ULM_Login;
import all_scripts.ULM_More_Options;
import all_scripts.ULM_QueueFilters;
import all_scripts.ViewFilters;
import output_results.Extend_Reports;
import output_results.Logs;
import output_results.MyTest_Listner;
import streams_ucc_UDF.UDF_All_Methods;
import streams_ucc_page.Page;
import test_data.Constants;

public class StreamsUCC_Main_Script extends MyTest_Listner {

//	public static WebDriver driver;
	
	public static String testdatasheetpath;
//	public static String Enterpriseuserid;
//	public static String Shredoutuserforlock;
	private static double Scriptsstardingtime;
	private static double Scriptsendingtime;
	public  static ExtentTest logger;
	public static String strNetwork;
	
	 @Test(priority=0)
	  public void login_streams() throws Exception
	  {
		 
		  Login_testcase l=new Login_testcase(driver);
		
		  l.login();
	  }
	@Test(priority=1)
	public void Message_validations() throws Exception
	{
//		Streams_Ucc_sentmessage msg=new Streams_Ucc_sentmessage(driver);
//		msg.textvalidations_at_Owner();
//		msg.Textvalidation_Receiver();
		Messages_Load msg=new Messages_Load(driver);
		msg.Messages();
	}
	
	@Test(priority=2)
	public void Photo_Attachment_validation() throws Exception
	{
		Streams_UCC_Attachments photo=new Streams_UCC_Attachments(driver);
		photo.Singlephoto_Actions_Ownerend();
		photo.Singlephoto_Receiver_Actions();
	}
	@Test(priority=3)
	public void Textfile_Validations() throws Exception
	{
		TextFile_Middelchat txt=new TextFile_Middelchat(driver);
		txt.textfilevalidations_Owner_end();
		txt.Textfilevalidation_Receiverend();
	}

	@Test(priority=4)
	public void Audiofile_validations() throws Exception
	{
		Audio_file_middlechatpanel audio=new Audio_file_middlechatpanel(driver);
		audio.Audiofilevalidations_Owner_end();
		audio.Audiofilevalidation_Receiverend();
	}
	
	@Test(priority=5)
	public void Collegeof_photos_validatoions() throws Exception
	{
		Colleguge_photos co=new Colleguge_photos(driver);
		co.collegephoto_Actions_Ownerend();
		co.Singlephoto_Receiver_Actions();
	}
	
	@Test(priority=6)
	public void team_Creation() throws Exception
	{
		Team_Creations t=new Team_Creations(driver);
		t.Create_team();
	}
	
	
	@Test(priority=7)
	public void OwnerActions() throws Exception{
		
		All_Actionsat_Ownserend owner= new All_Actionsat_Ownserend(driver);
		owner.OwnerActions();
	}
	
	@Test(priority=8)
	public void ReceiverActions() throws Exception{
		
		Alll_Actions_Receiverend receiver= new Alll_Actions_Receiverend(driver);
		receiver.ReceiverActions();
	}
	
	@Test(priority=9)
	public void StatusValidation() throws Exception
	{
		Status_Validation st=new Status_Validation(driver);
		st.Status();
	}
	
	@Test(priority=9)
	public void IndepedentULM_StreamsBrandings()
	{
		Logs.start_test_case("IndepedentULM_StreamsBrandings");
		driver.manage().deleteAllCookies();
		IndependentULMLogin streams=new IndependentULMLogin(driver);
		streams.IndependentULM_LOGIN_Brnading(0, strNetwork);
		streams.IndependentULM_ForGotPage_Brnading(0, strNetwork);
		streams.IndependentULM_ForGotPageHomeLink_Brnading(0, strNetwork);
		streams.IndepenDenetULM_PrivacyPolicyPage_Branding(0, strNetwork);
		streams.Independent_ULM_HomePage_Branding(0, strNetwork);
		streams.IndependentULM_SignoutPage(0, strNetwork);
	
	}
	
	@Test(priority=10)
	public void IndepedentULM_InpacketBrandings()
	{
		Logs.start_test_case("IndepedentULM_InpacketBrandings");
		driver.manage().deleteAllCookies();
		IndependentULMLogin inpacket=new IndependentULMLogin(driver);
		inpacket.IndependentULM_LOGIN_Brnading(1, strNetwork);
		inpacket.IndependentULM_ForGotPage_Brnading(1, strNetwork);
		inpacket.IndependentULM_ForGotPageHomeLink_Brnading(1, strNetwork);
		inpacket.IndepenDenetULM_PrivacyPolicyPage_Branding(1, strNetwork);
		inpacket.Independent_ULM_HomePage_Branding(1, strNetwork);
		inpacket.IndependentULM_SignoutPage(1, strNetwork);
	
	}
	@Test(priority=11)
	public void IndependentULM_KonnectBranding()
	{
		Logs.start_test_case("IndependentULM_KonnectBranding");
		driver.manage().deleteAllCookies();
		IndependentULMLogin Konnect =new IndependentULMLogin(driver);
		Konnect.IndependentULM_LOGIN_Brnading(2, strNetwork);
		Konnect.IndependentULM_ForGotPage_Brnading(2, strNetwork);
		Konnect.IndependentULM_ForGotPageHomeLink_Brnading(2, strNetwork);
		Konnect.IndepenDenetULM_PrivacyPolicyPage_Branding(2, strNetwork);
		Konnect.Independent_ULM_HomePage_Branding(2, strNetwork);
		Konnect.IndependentULM_SignoutPage(2, strNetwork);
		
	}
	
	@Test(priority=12)
	public void IndependentULM_QuorumTechBranding()
	{
		Logs.start_test_case("IndependentULM_QuorumTechBranding");
//		driver.manage().deleteAllCookies();
		IndependentULMLogin Quorumtech =new IndependentULMLogin(driver);
		Quorumtech.IndependentULM_LOGIN_Brnading(3, strNetwork);
		Quorumtech.IndependentULM_ForGotPage_Brnading(3, strNetwork);
		Quorumtech.IndependentULM_ForGotPageHomeLink_Brnading(3, strNetwork);
		Quorumtech.IndepenDenetULM_PrivacyPolicyPage_Branding(3, strNetwork);
		Quorumtech.Independent_ULM_HomePage_Branding(3, strNetwork);
		Quorumtech.IndependentULM_SignoutPage(3, strNetwork);
	}
	
	
	
	@Test(priority=1)
	public  void ULmLogin() throws Exception
	{
		ULM_Login l=new ULM_Login(driver);
		l.ULMLogin();
	}
	@Test(priority=2)
	public static void ULM_Queues() throws Exception
	{
		ULM_QueueFilters queues=new ULM_QueueFilters(driver);
		queues.SelectACDQueue();
		queues.SelectHuntGroup();
		queues.SelectAllQueues();
	}
	
	@Test(priority=4)
	public static void ULM_Show_Filters() throws Exception
	{
		String strShow="1";
		ViewFilters filters=new ViewFilters(driver);
		filters.PerQueueViewType();
		filters.AllQueueViewType();	
		filters.LoginAgents_Section_AllQueues(strShow);
		filters.CallsInQueue_Section_AllQueues(strShow);
		filters.Activecalls_Section_AllQueues(strShow);
		filters.SLAKPI_Section_AllQueues(strShow);
		filters.Logout_Section_AllQueues(strShow);
		filters.LoginAgents_Section_PerQueues(strShow);
		filters.CallsInQueue_Section_PerQueues(strShow);
		filters.SLAKPI_Section_PerQueues(strShow);
		filters.Activecalls_Section_PerQueues(strShow);
		filters.Logout_Section_PerQueues(strShow);
	}
	
	@Test(priority=3)
	public static void ULM_Hide_Filters() throws Exception
	{
		String strShow="0";
		ViewFilters filters=new ViewFilters(driver);
		filters.PerQueueViewType();
		filters.AllQueueViewType();			
		filters.LoginAgents_Section_AllQueues(strShow);
		filters.CallsInQueue_Section_AllQueues(strShow);
		filters.Activecalls_Section_AllQueues(strShow);
		filters.SLAKPI_Section_AllQueues(strShow);
		filters.Logout_Section_AllQueues(strShow);
		filters.LoginAgents_Section_PerQueues(strShow);
		filters.CallsInQueue_Section_PerQueues(strShow);
		filters.SLAKPI_Section_PerQueues(strShow);
		filters.Activecalls_Section_PerQueues(strShow);
		filters.Logout_Section_PerQueues(strShow);
	}
	
	
	@Test(priority=5)
	public static void CallmonitoringForm() throws Exception
	{
		ULM_More_Options opt=new ULM_More_Options(driver);
		opt.SoftPhone_callMonitorForm_AllQueues();
		opt.IP1_callMonitorForm_AllQueues();
		opt.IP2_callMonitorForm_AllQueues();
		opt.RefreshULM_AllQueues();
		opt.SoftPhone_callMonitorForm_PerQueues();
		opt.IP1_callMonitorForm_PerQueues();
		opt.IP2_callMonitorForm_PerQueues();
		opt.RefreshULM_PerQueues();
	}
	
	@Test(priority=6)
	public void Loggedin_Logout_Agentes() throws Exception
	{
		
		Login_Logout_Agents_Validations lilo=new Login_Logout_Agents_Validations(driver);
		lilo.Logged_In_Agentes_Count_AllQueues();
		lilo.Logged_OUT_Agentes_Count_AllQueues();
		lilo.Logged_In_Agentes_Count_PerQueues();
		lilo.Logged_OUT_Agentes_Count_perQueues();
		lilo.AgentLoggedinStatus_AllQueues();
		lilo.AgentLoggedOUTStatus_AllQueues();
		lilo.LoginAgent_in_AllQueues();
	}
	
	
	
	 @Parameters({"Network","browser"})
	  @BeforeSuite
	  public void beforeSuite(String Network,String browser) 
	  {
		 
		      String AdressBarURL="Empty";  
		      strNetwork=Network;		      
	
		        if(browser.equalsIgnoreCase("gc"))
		        {
		          
		          System.setProperty("webdriver.chrome.driver",Constants.Chromedriverpath);
//		          ChromeOptions options = new ChromeOptions();
//				  options.addArguments("user-data-dir=C:/Users/QA/AppData/Local/Google/Chrome/User Data/person 10");
//		          options.addArguments("disable-infobars");	
//				  options.addArguments("--start-maximized");
//				  options.addArguments("--start-fullscreen");
			     driver=new ChromeDriver();
			     driver.manage().window().maximize();
		        }
		        else if(browser.equalsIgnoreCase("ff"))
		        {
		        	System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Softwares\\Jar_Drivers\\GekoDriver\\geckodriver.exe");
		        	driver = new FirefoxDriver();
		    		driver.manage().window().maximize();
		    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		        	
		        }
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				Logs.info("[Browser launch]: Deleted all the cookies & Launched Successfully");
			    String Starttime =UDF_All_Methods.datesent2();
			    String removespace=Starttime.replace(" ", "");
			    double d=Double.parseDouble(removespace);   //----Converting String to Double
			    Scriptsstardingtime=d;
			    System.out.println("Scripts are running with date and time is:"+UDF_All_Methods.datesent());
			   
				
			    if (Network.contains("dce")) 
			    {
//					driver.get(Constants.streamsproductionurldce);
			    	AdressBarURL=Constants.streamsproductionurldce;
					String dcesheetpath=Constants.sheetpathdce;
					
					testdatasheetpath=dcesheetpath;	
					 Logs.info("****** Scripts started **********"+testdatasheetpath);
				} 
				else if(Network.contains("dcw"))
				{
//					driver.get(Constants.streamsproductionurldcw);
					AdressBarURL=Constants.streamsproductionurldcw;
					 Logs.info("****** Scripts started **********"+testdatasheetpath);
					//String dcwsheetpath=Constants.she;	
				}
				else if(Network.contains("beta"))
				{
//					driver.get(Constants.streamsproductionurlbeta);
					AdressBarURL=Constants.streamsproductionurlbeta;
					String beta1sheetpath=Constants.sheetpathbeta1;
					testdatasheetpath=beta1sheetpath;
					Logs.info("[Login URL]:"+Constants.streamsproductionurlbeta);
				}
				else if(Network.contains("stg"))
				{
					driver.get(Constants.SteramsStagingURL);
					Logs.info("[Login URL]:"+Constants.SteramsStagingURL);
				}
//				else if(Network.equalsIgnoreCase("ulm"))
//				{
//					AdressBarURL=Constants.strIndependentULmBeta_URL;
//				}
//			    driver.get(AdressBarURL);
	  }
	  
	  @AfterMethod()
	  public void Endtestcase(ITestResult result) throws Exception
	  {
		    Logs.endTestCase(result.getName());
		    Logs.info("Tottal Number of Test cases =="+UDF_All_Methods.TC_TotalCount+
		    		" No.of Test cases Pass=="+UDF_All_Methods.TC_PassCount+
		    		" No.Of Test cases Faile Count=="+UDF_All_Methods.TC_FailCount);
//		    driver.quit();
	      /*try {
			Robot r = new Robot();        
			  r.keyPress(KeyEvent.VK_CONTROL);
			  r.keyPress(KeyEvent.VK_T);
			  r.keyRelease(KeyEvent.VK_CONTROL);
			  r.keyRelease(KeyEvent.VK_T);
			  
			  Set <String> t=driver.getWindowHandles();
				 System.out.println("No.of windows is:"+t.size());
				 String handle[]=new String[t.size()];
				 int i=0;
				 for(String s:t)
				 {
					 System.out.println(s);
					 handle[i]=s;
					 i++; 
				 }
				if(t.size()>1){
					driver.switchTo().window(handle[1]);
					 driver.get("E:\\Selenium\\Scripts\\com.streams.smartbox.com\\test-output\\Sanity\\Stresams Smartbox.html");
					 System.out.println("  Switched to second window ");
					 Thread.sleep(3000);
					 driver.close();
					 driver.switchTo().window(handle[0]); }
					 else{
						 System.out.println("Single window is opened");
					 }
		} catch (Exception e) {
			Logs.error("unable to open new window duye to unexpected exceprion :"+e);
		}
		  */
		  
	/*	  if (result.getStatus() == result.SUCCESS) 
			{
				//sc.Screenshot("pass "+result.getName());
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
				driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
			  Logs.endTestCase(result.getName()+"and result is PASSS"+"\n");
			} 
			 else if (result.getStatus() == result.FAILURE) 
			  {
		       //sc.Screenshot("Fail "+result.getName());
				 Logs.endTestCase(result.getName()+"and result is FAIL"+"\n");
			 }
			 else if(result.getStatus() == result.SKIP)
			 {
				 //System.out.println("----Test skipped---"+result.getName());
				 Logs.endTestCase(result.getName()+"and result is SKIP "+"\n");
			 }*/
	  }
	  
	  
	  @AfterSuite()
	  public void kil() throws Exception
	  {
		  try {
//			  UDF_All_Methods signout=new UDF_All_Methods(driver);
//			  Page.logout();
			  //Thread.sleep(3000);
			  System.out.println("Scripts are Ended with date and time is:"+UDF_All_Methods.datesent());
			  driver.quit();
			   String Endtime =UDF_All_Methods.datesent2();
			   String removespace=Endtime.replace(" ", "");
			    double end=Double.parseDouble(removespace);   //----Converting String to Double
			    Scriptsendingtime=end;
			    System.out.println("script ending time is :"+Scriptsendingtime);
			    double OveralScriptstiming=Scriptsendingtime-Scriptsstardingtime;
			  Logs.info("************************* Scripts Ended time is : "+OveralScriptstiming+"**********************************");
		} catch (Exception e) {
		//	driver.quit();	
		} 
		  try {
			Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
			Logs.info("[Task kill]... driver kill done");
		} catch (Exception e) {
			Logs.error("[Task kill]... Failed to kill driver");
		}
	  }

	  //$$$$$$$$$$$$$$$ BELOW CHROME OPTIONS ARE USER FOR DISABLING THE BAR "THIS CHROME IS CONTROLED BY AUROMATIONS BAR" $$$$$$$$$
      
//------------TO CAPTURE CONSOLE LOGS FROM CHROME BROWSER -----------------------------//		        
		        //   DesiredCapabilities caps = DesiredCapabilities.chrome();
		   /*     LoggingPreferences logPrefs = new LoggingPreferences();
		        logPrefs.enable(LogType.BROWSER, Level.ALL);
		        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		        driver = new ChromeDriver(caps);
		       // driver.manage().window().maximize();
*/		        
//*********************************************ENED FOR CAPTURE CONSOLE LOGS *********//		
	
}

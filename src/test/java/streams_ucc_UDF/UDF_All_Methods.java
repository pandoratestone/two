package streams_ucc_UDF;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;

import output_results.Extend_Reports;
import output_results.Logs;
import output_results.MyTest_Listner;
import streams_ucc_page.Page;
import test_data.Constants;
import test_data.Data_Helper;
import test_data.Excel_Data;

public class UDF_All_Methods extends Page {

	public UDF_All_Methods(WebDriver driver) {
		super(driver);
		
	}

	public static ExtentReports report;
	public  static ExtentTest logger;
	public static long milliseconds=System.currentTimeMillis();
	public static String Reportspath="E:\\Selenium\\Scripts\\Streams_Ucc_Reports.html";
	public static String Screenshortpath;
	public static String loggedin_suername;
	public static String sheetpath=StreamsUCC_Main_Script.testdatasheetpath;
	public static String messagesent="Automation-"+datesent()+"_"+milliseconds;
	public static String commentsent="Comments_"+datesent()+"_"+milliseconds+"";
	public static String CommemntReceiver=commentsent+"_Receiver";
//	public static String Ownername;
//	public static String Receivername;
//	public static String Reshareusername;
	public static int TC_PassCount;
	public static int TC_FailCount;
	public static int TC_TotalCount;
	public static final String strFail="fail";
	public static final String strPass="pass";
	
	public static HashSet <String> ACDGroups = new HashSet <String>();;
	public static HashSet <String> HuntGroups = new HashSet <String>();
	public static  HashMap<Integer, String> AllQueusList = new HashMap<Integer, String>();;
 	
	public void getowner_and_receiverdetails() throws Exception
	{
		Excel_Data.ExcelFile(sheetpath, "testdata");
		String fromuesrname=Excel_Data.getCellData(1, 2);
//		Ownername=fromuesrname;
		String sent_touser=Excel_Data.getCellData(2,2);
//		Receivername=sent_touser;
		String Resharetargetusrname=Excel_Data.getCellData(3, 2);
//		Reshareusername=Resharetargetusrname;
	}

	
	//----- Login and Logout method -----//
		public void login_all(String uname,String pass) throws Exception
		{
			Logs.info("[Login test Actions are Started] Started .... *"+Thread.currentThread().getStackTrace()[1].getMethodName());
			WebDriverWait login=new WebDriverWait(driver,30);
			Logs.info("[Streams Login started] here username :"+uname+" and password is :"+pass);
			this.username_password_Login(uname,pass);
//			Extend_Reports e=new Extend_Reports(driver);
			if (uname.isEmpty()) 
			{
	     	  //Thread.sleep(1000);
			    Alert al=driver.switchTo().alert();
			    String blankusername=al.getText();
			    Assert.assertEquals(blankusername, "Please enter User Name."); 
			    al.accept();
				Logs.info("[Login alerts]"+blankusername+": username :"+uname+" and password is:"+pass+"and accepted alert");
//				e.Success("Blank Username");
			}
			else if(pass.isEmpty())
			{
				Alert al=driver.switchTo().alert();
				String Emptypassword=al.getText();
				 Assert.assertEquals(Emptypassword, "Please enter Password."); 
				 al.accept();
				 Logs.info("[Login alerts]"+Emptypassword+": username :"+uname+" and password is:"+pass+"and accepted alert");
//				 e.Success("Blank password");
			}
			else if(uname.contains("gmail.com"))
            {
			  Logs.info("Invalid username or password entered alert is displayed frist time");
	          new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(invalidusername_or_password));
	          String incorrectcrediantials=invalidusername_or_password.getText();
//	          this.Screenshort(incorrectcrediantials, "Pass");
	          Logs.info("[Login alerts]"+incorrectcrediantials+": username :"+uname+" and password is:"+pass+"and invalid username and password");
//	          MyTest_Listner.ExtendReportsResult(strPass, "Login user Name="+uname+" and Password=="+pass);
//	          e.Success("Invalid username and Password");pass
             }
			else if(login.until(ExpectedConditions.visibilityOf(menubutton)).isDisplayed())
			{ 
//				Logs.info("logged in with proper usernmae is:"+uname);
				this.recents_loading(uname);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				
//				this.Screenshort("user logged in properly", "Pass");
			}
			Logs.info("[Login test Actions are Ended]: Ended "+getClass().getName());
		}
	
		private boolean isElementpresent(WebDriver driver, By by) {
		  	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  try {
		  		driver.findElement(by);
		  		return true;
		  	} catch (NoSuchElementException e) {
		  		return false;
		  	}
		  	
		  }

public void loggedinusername()	
{
	WebDriverWait loggedinusername=new WebDriverWait(driver, 7);
	loggedinusername.until(ExpectedConditions.visibilityOf(loginusername));
	String loggedinusernameis=driver.findElement(By.xpath("")).getText();
	loggedin_suername=loggedinusernameis;
}
		
	public void Logout() throws Exception
	{
		this.logout();
	}
		//--- complete recents loading method and get user status ---//
		public void recents_loading(String statusname) throws Exception
		{
			this.recentssearchbarwait();
			this.contacts_status(statusname);
			Logs.info("user logged in success fully with username:"+statusname);
		}	
	
		
		public static String setDirectry_Path()
		{
			SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
			Date dt=new Date();
			String sysdate= df.format(dt);
			return sysdate;	
		}
		
		
		
		public static  boolean MakeDirectory(String strDirectory)
		{
			File theDir = new File(strDirectory);

			if(theDir.exists())
			{
				return true;
			}
			else if(!theDir.exists()) 
			{
			    System.out.println("creating directory: " + theDir.getName());
			    return true;
			}
			return false;
			
		}
		
		public static String DirectoryPath(String strDirectoryPath)
		{
			boolean isCreated=MakeDirectory(strDirectoryPath);
			System.out.println("isCreated=="+isCreated+" and strDirectoryPath=="+strDirectoryPath);
			if(isCreated==true)
			{
				
			return strDirectoryPath;
			}
			else
			{
				for(int i=0;i<=2;i++)
				{
					boolean retry=MakeDirectory(strDirectoryPath);
							if(retry==true)
							{
								return strDirectoryPath;
							}
				}
			}
			return null;
		}
		
		public static String datesent()
		{
			SimpleDateFormat df=new SimpleDateFormat("YYYY MM DD HH MM SS");
			Date dt=new Date();
			String sysdate= df.format(dt);
			return sysdate;	
			//System.out.println("sent date is ---"+datesent);
		}
		public static String datesent2()
		{
			SimpleDateFormat df=new SimpleDateFormat("HH MM");
			Date dt=new Date();
			String sysdate= df.format(dt);
			return sysdate;	
			//System.out.println("sent date is ---"+datesent);
		}
		public void Sentmessage(String sentmessage) throws Exception
		{
			//this.buddyclick(selectusername);
			this.sentmessage(sentmessage);
		}

		public void perfrom_likeoperation(String UuiD,String username_likes_screen) throws Exception
		{
			String strTestCasename=Data_Helper.strTestCase_Name("TC_5");
			String name=getClass().getName();
			try {
				
				Logs.start_test_case(strTestCasename);
				this.like(UuiD, username_likes_screen);
				 Excel_Data.setCellData(strPass, Data_Helper.TestCaseRowNumber, 5);
				 MyTest_Listner.ExtendReportsResult(strPass, strTestCasename,Data_Helper.strTestCase_Description());
//				this.Screenshort(name, "pass");
			} catch (Exception e) {
				Excel_Data.setCellData(strFail, Data_Helper.TestCaseRowNumber, 5);
				 MyTest_Listner.ExtendReportsResult(strFail, strTestCasename,Data_Helper.strTestCase_Description());
//				this.Screenshort(name, "Fail");
			}
		}
		public void perfor_comment(String Commentsent,String Comments_object,String UuID) throws Exception
		{
			String strTestCasename=Data_Helper.strTestCase_Name("TC_6");
//			String name=getClass().getName();
			try {
				Logs.start_test_case(strTestCasename);
				this.comment(Commentsent, Comments_object, UuID);
				 Excel_Data.setCellData(strPass, Data_Helper.TestCaseRowNumber, 5);
				 MyTest_Listner.ExtendReportsResult(strPass, strTestCasename,Data_Helper.strTestCase_Description());
//				this.Screenshort(name, "pass");
			} catch (Exception e) {
				 Excel_Data.setCellData(strFail, Data_Helper.TestCaseRowNumber, 5);
				 MyTest_Listner.ExtendReportsResult(strFail, strTestCasename,Data_Helper.strTestCase_Description());
//				this.Screenshort(name, "fail");
			}
		}

		public void perfrom_pin(String UUIDD)
		{ 
			try {
				this.pin(UUIDD);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}


		  public void Reshare(String resharemessage,String Resharetargetuser)
		  {  
			  Logs.info("[Reshare Actions] Started..."+getClass().getName()+"{here reshared message is :"+resharemessage+" and reshared target user is :"+Resharetargetuser+" }");
			  this.Reshare(resharemessage);
			  this.usernamesent_reshare(Resharetargetuser);
			  this.Selectreshareuserbuddy(Resharetargetuser);
			  Logs.info("[Reshare Actions] Ended...");
		  }
	
		  
  public void like_comment_pin_Reshare(String UuiD,String username_likes_screen,String Commentsent,String Comments_object_resharemessage,String Resharetargetuser) throws Exception
  {
	  this.perfrom_likeoperation(UuiD,username_likes_screen);
	  this.perfor_comment(Commentsent,Comments_object_resharemessage,UuiD);
	  this.perfrom_pin(UuiD);
	  this.Reshare(Comments_object_resharemessage,Resharetargetuser);
	 // this.Resharemessahevalidation(resharemessage);
  }
		  
		 public void Sentimage_ucc(String imageautoitpath,String SentRenamefile,WebElement filetype) throws Exception
		 {
			 Logs.info("");
			 this.middlechatuploadbutton_wait();
			 this.middlechatpane_upload_select_requriedfiletype(filetype);
			 Thread.sleep(2000);
			 Runtime.getRuntime().exec(imageautoitpath);
			 this.Rename_uploadfilename_popup(SentRenamefile);
			 this.click_upload_ucc();
			 this.uploading_file_name_middelchat_window();
		 }
		 
	 public void Selecttextfile_ucc(String imageautoitpath,String SentRenamefile,WebElement filetype) throws Exception
	 {
		 this.middlechatuploadbutton_wait();
		 this.middlechatpane_upload_select_requriedfiletype(filetype);
		 Thread.sleep(2000);
		 Runtime.getRuntime().exec(imageautoitpath);
		 this.Rename_uploadfilename_popup(SentRenamefile);
		 this.click_upload_ucc();
		 this.uploading_file_name_middelchat_window();
	 }
	 public void Select_Audio_file_ucc(String imageautoitpath,String SentRenamefile,WebElement filetype) throws Exception
	 {
		 this.middlechatuploadbutton_wait();
		 this.middlechatpane_upload_select_requriedfiletype(filetype);
		 Thread.sleep(2000);
		 Runtime.getRuntime().exec(imageautoitpath);
		 this.Rename_uploadfilename_popup(SentRenamefile);
		 this.click_upload_ucc();
		 this.uploading_file_name_middelchat_window();
	 }

   public void Collegeofpictues_streams_ucc(WebElement filetype,String imageautoitpath1,String Secondimag_path,String fristimagenamerename,String Secondimagenamerename) throws Exception
   {
		 this.middlechatuploadbutton_wait();
		 this.middlechatpane_upload_select_requriedfiletype(filetype);
		 Thread.sleep(2000);
		 Runtime.getRuntime().exec(imageautoitpath1);
		 this.selectfile_uploadpopupwindow_for_rename(1);
		 this.Rename_uploadfilename_popup(fristimagenamerename);
		 new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(plus_button_uploadpopup)).click();
		 Thread.sleep(2000);
		 Runtime.getRuntime().exec(Secondimag_path);
		 this.selectfile_uploadpopupwindow_for_rename(2);
		 this.Rename_uploadfilename_popup(Secondimagenamerename);
		 this.click_upload_ucc();
		 this.uploading_file_name_middelchat_window();	 
   }	 
	 
  public void Createteam_validation(String Teamname,WebElement select_requriedteam)
  {
	  this.sent_team_name(Teamname);
	  this.Click_team_type_radio_button(select_requriedteam);
  }

  public void select_user_team(String username)
  {
	  this.addcontacts_search_teamcreationpage(username);
	  this.Addcontact_validation_createpage(username);
  }
 
  
  public void Teamcreation_page_Wait()
  {
	  this.Plusicon_Click_Recents();
	  this.Click_Createteam();
	  this.TeamCreation_page_loading_wait();
  }
  
   
 public void teamname_validations(String Teamname)
 {
	 WebDriverWait teamnamealert=new WebDriverWait(driver,20);
	 // this.sent_team_name(Teamname);
	// teamnamealert.until(ExpectedConditions.visibilityOf(createteam_click)).click();
	 if (Teamname.isEmpty() || Teamname==null) 
	 {
		 this.sent_team_name(Teamname);
		 System.out.println("tame name is :"+Teamname);
		 teamnamealert.until(ExpectedConditions.visibilityOf(empty_specialcharacters_teamname)).click();
		 teamnamealert.until(ExpectedConditions.visibilityOf(EnterTeamame));
		 Logs.info("Entered team name is Empty or null and accepted alert and team name taken from excel is :"+Teamname);
	} else if(Teamname.contains("*"))
	{    
		 this.sent_team_name(Teamname);
		 teamnamealert.until(ExpectedConditions.visibilityOf(empty_specialcharacters_teamname)).click();
		 teamnamealert.until(ExpectedConditions.visibilityOf(EnterTeamame));
		 Logs.info("Entered team name contains Special characters :"+Teamname);
	}
	else
	{
		this.sent_team_name(Teamname);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(menubutton));
		teamnamealert.until(ExpectedConditions.elementToBeClickable(contacts_tabbutton));
		teamnamealert.until(ExpectedConditions.visibilityOf(typemessagefield));
		Logs.info("team created properly with valid team name :"+Teamname);
		
	}
 }
  
  public void MakeTeamAdmin(String MakeAdminUesrName,String TEamName)
  {
	  this.MoreOptions_on_TeamMember(MakeAdminUesrName);
	  this.MakeTeam_Admin(MakeAdminUesrName,TEamName);
  }
 
 public void RemoveUserFromTeam(String RemoveUesrName,String TEamName) throws Exception
 {
	this.OpenTeamUserContactstab(TEamName); 
	this.TeamStreamDetailedpanel(TEamName);
//	this.properTeamOpenedOrNot(TEamName);
	this.TeamMembersvalidation_TeaminfoPage_andGetID(RemoveUesrName);
	Thread.sleep(3000);
	this.MoreOptions_on_TeamMember(RemoveUesrName);
	this.RemoveFromTeam(RemoveUesrName, TEamName);
 }
  
 
 
 
 
 
 
 /************ Branding Independent ULM ************************/
 
 
 
 public static String strCurrentYear()
	{
		SimpleDateFormat df=new SimpleDateFormat("YYYY");
		Date dt=new Date();
		String strYear= df.format(dt);
		return strYear;	
		//System.out.println("sent date is ---"+datesent);
	}
 
 
 public int IsIndependentULMLoginPageBrandingStatus(int Branding,String strNetwork)
 {
	 String strRightSide=null;
	 String strLeftSide=null;
	 driver.navigate().to(setIndependentULMURl(Branding, strNetwork));
	 this.setIndependentULMLoginPage();
	 
	 if(Branding==0)
	 {
		 strRightSide="https://accounts.beta-wspbx.com/auth/images/Streams_Logo.png";
		 strLeftSide="/auth/images/logo.gif";
	 }
	 else if(Branding>0)
	 	{
		 strRightSide=strSetDellearId(Branding, strNetwork);
		 strLeftSide=strRightSide;
	 	}
	 
	 
	 System.out.println("strRightSide==="+strRightSide+" strLeftSide=="+strLeftSide);
	 
//	 boolean IsCopyRights=IsLoginPageCopyRights(Branding, strNetwork);
	 boolean IsCopyRights=IndependentULM_CopyRights_validation("login",Branding, strNetwork);
	 boolean ISageTittle=IsIndependetULMPageTittle(Branding);
	 boolean IsLoginPage=ISLogos_validation(strRightSide, strLeftSide);
	 boolean IsULM_Logo=ISULMLogoDisplayed();
	 
	 
	 System.out.println("ISageTittle===="+ISageTittle+"    IsLoginPage=="+IsLoginPage+"  IsCopyRights=="+IsCopyRights+"  IsULM_Logo=="+IsULM_Logo);
	 return (ISageTittle==true && IsLoginPage==true && IsCopyRights==true && IsULM_Logo==true) ? 1:0;
			/* if (ISageTittle==true && IsLoginPage==true && IsCopyRights==true && IsULM_Logo==true) 
			 {
				 return 1;
			 }
			 else
			 {
				 return 0;
			 }	*/	 
 	}
 
 public boolean ISIndependentUMForgotPageBrandings(int Branding,String strNetwork)
 {
	 String strRightSide=null;
	 String strLeftSide=null;
	 driver.navigate().to(setIndependentULMURl(Branding, strNetwork));
	 this.setIndependentULMLoginPage();
	 this.setForgotpasswordPage();

	 if(Branding==0)
	 {
		 strRightSide="https://accounts.beta-wspbx.com/auth/images/Streams_Logo.png";
		 strLeftSide="/auth/images/logo.gif";
	 }
	 else if(Branding>0)
	 	{
		 strRightSide=strSetDellearId(Branding, strNetwork);
		 strLeftSide=strRightSide;
	 	}
	 
	 System.out.println("strRightSide==="+strRightSide+" strLeftSide=="+strLeftSide);
	 
	 boolean ISageTittle=IsIndependetULMPageTittle(Branding);
	 boolean IsLoginPageLogos=ISLogos_validation(strRightSide, strLeftSide);
//	 boolean isForgotPageCopyRights=IsFogotPasswordPageCopyRights(Branding, strNetwork);
	 boolean isForgotPageCopyRights=IndependentULM_CopyRights_validation("forgot",Branding, strNetwork);
	
	 System.out.println("ISageTittle===="+ISageTittle+"    IsLoginPageLogos=="+IsLoginPageLogos+"  isForgotPageCopyRights=="+isForgotPageCopyRights);
	 if (ISageTittle==true && IsLoginPageLogos==true && isForgotPageCopyRights==true) 
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }		
 }
 
 public boolean ISHomeLInkIndependetULMFogotpageStatus(int Branding ,String strNetwork)
 {
	 String strRightSide=null;
	 String strLeftSide=null;
	 driver.navigate().to(setIndependentULMURl(Branding, strNetwork));
	 this.setIndependentULMLoginPage();
	 this.setForgotpasswordPage();
	 this.setIndependentUMHoneLink();
	 if(Branding==0)
	 {
		 strRightSide="https://accounts.beta-wspbx.com/auth/images/Streams_Logo.png";
		 strLeftSide="/auth/images/logo.gif";
	 }
	 else if(Branding>0)
	 	{
		 strRightSide=strSetDellearId(Branding, strNetwork);
		 strLeftSide=strRightSide;
	 	}
	 
	 System.out.println("strRightSide==="+strRightSide+" strLeftSide=="+strLeftSide);
	 
	 boolean ISageTittle=IsIndependetULMPageTittle(Branding);
	 boolean IsLoginPageLogos=ISLogos_validation(strRightSide,strLeftSide);
//	 boolean isForgotPageCopyRights=IsLoginPageCopyRights(Branding, strNetwork);
	 boolean isForgotPageCopyRights=IndependentULM_CopyRights_validation("login",Branding, strNetwork);
	 boolean IsULM_Logo=ISULMLogoDisplayed();
	 
	 
	 System.out.println("ISageTittle===="+ISageTittle+"    IsLoginPageLogos=="+IsLoginPageLogos+"  isForgotPageCopyRights=="+isForgotPageCopyRights+"  IsULM_Logo=="+IsULM_Logo);
	 if (ISageTittle==true && IsLoginPageLogos==true && isForgotPageCopyRights==true && IsULM_Logo==true) 
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }		
 }
 
 
 
  public int PrivacyPolicyBranding(int Branding,String strNetwork)
  {
	  String strRightSide=null;
	  String strLeftSide=null;
	  this.setPrivacyPlocyLink(Branding, strNetwork);

		 if(Branding==0)
		 {
			 strRightSide="https://accounts.beta-wspbx.com/auth/images/Streams_Logo.png";
			 strLeftSide="/auth/images/logo.gif";
		 }
		 else if(Branding>0)
		 	{
			 strRightSide=strSetDellearId(Branding, strNetwork);
			 strLeftSide=strRightSide;
		 	}
	  boolean Logos=ISLogos_validation(strRightSide,strLeftSide);
//	  boolean CopyRights=IsFogotPasswordPageCopyRights(Branding, strNetwork);
	  boolean CopyRights=IndependentULM_CopyRights_validation("forgot",Branding, strNetwork);
	  if(Logos==true && CopyRights==true)
	  {
		  return 1;
	  }
	  else
	  {
		  System.out.println("Privacy policy failed Logos=="+Logos+"  CopyRights=="+CopyRights);
	  return 0;
	  }
  }
 
 
  	public int IndependentULM_Homepage_Branding(int Brandng,String strNetwork)
  	{
  		this.setLoginUserintoIndependentULM(Brandng, strNetwork);
  		this.setIndependentULMLodaingWait();
  		String strDellerID=this.strSetDellearId(Brandng, strNetwork);
  		boolean HomepageLogo=IndependentULM_HomePage_Logo_Branding(strDellerID);
//  		boolean Homepage_CopyRights=IndependentULM_HomePage_CopyRights(Brandng, strNetwork);
  		boolean Homepage_CopyRights=IndependentULM_CopyRights_validation("home",Brandng, strNetwork);
  		if(HomepageLogo==true && Homepage_CopyRights==true)
  		{
  			return 1;
  		}
  		else
  		{
  			System.out.println("Home page HomepageLogo=="+HomepageLogo+" and Homepage_CopyRights=="+Homepage_CopyRights);
  			return 0;
  		}
  	}
  	
  	
  	public int IndependentULM_SognoutPage_Status(int Branding,String strNetwork) throws Exception
  	{
  		
  		this.setIndependentUMSignout();
  		boolean Sigoutpagevaldiation=IDPSignoutPage_validation(Branding);
  		System.out.println("Sigoutpagevaldiation=="+Sigoutpagevaldiation);
  		if(Sigoutpagevaldiation==true)
  		{
  			return 1;
  		}
  		else
  		{
  			return 0;
  		}
  	}
  	
  
/***
 * ULM Starts Here
 */
 
  	public static final String strAllQueueViewType="All Queues";
  	public static final String strPerQueueViewType="Per Queue";
  	
  	
  	
  	public static void ULMCompleteLoading()
  	{
  		WebDriverWait elemetewait=new WebDriverWait(driver, 100);
		elemetewait.until(ExpectedConditions.attributeContains(By.id("pgload_indicator"), "style", "display: none"));
		ULMLoadingWait();
  	}
 
  	
  	public static  void StoreAllQueuesDetails()
  	{
  		setQueueFilterbutton();
  		int queusSize=QueueName_QueueFilterButton.size();
  		System.out.println("queusSize-->"+queusSize);
  		for(int i=0;i<queusSize;i++)
  		{
  			String strQueuename=QueueName_QueueFilterButton.get(i).getAttribute("title").trim();
  			System.out.println("strQueuename-->"+strQueuename);
  			AllQueusList.put(i+1, strQueuename);
  			
  			if(strQueuename.contains("[NONACD]"))
			{
				HuntGroups.add(strQueuename.replace("[NONACD]", "").trim());
				
			}
			else if(strQueuename.contains("[ACD]"))
			{
				ACDGroups.add(strQueuename.replace("[ACD]", "").trim());
				
			}
  		}
  		System.out.println("All Queus userhave: "+AllQueusList+"\n"+"ACD GRoups List: :"+ACDGroups+" \n"+" Hunt Groups: : "+HuntGroups);
  	}
  	
  	public static boolean ACDQueueEnable(String strQueueName) throws InterruptedException
  	{
  		System.out.println("[ACDQueueEnable] Started..: "+strQueueName);
  		setQueueFilterbutton();
  		setCheckQueue_Search(strQueueName.toLowerCase());
  		SetCheckQueue(strQueueName);
  		setQueueFilter_SaveButton();
  		SetQueueDivListLoading(true);
  		boolean isQueueCheck_QueueFilter=isQueueSelected_QueueFilter(strQueueName);
  		System.out.println("[ACDQueueEnable] Started..: "+isQueueCheck_QueueFilter);
  		boolean isQueueDisplayed_Rightside=isACDQueueDisplayed_RightSide(strQueueName);
  		if(isQueueCheck_QueueFilter==true && isQueueDisplayed_Rightside==true)
  		{
  			return true;
  		}
  		return false;
  	}
  	
  	public static boolean HuntEnable(String strQueueName) throws Exception
  	{
  		System.out.println("[HuntEnable] Started..: "+strQueueName);
  		setQueueFilterbutton();
  		setCheckQueue_Search(strQueueName.toLowerCase());
  		SetCheckQueue(strQueueName);
  		setQueueFilter_SaveButton();
  		SetQueueDivListLoading(false);
  		boolean isQueueDisplayed_Rightside=isACDQueueDisplayed_RightSide(strQueueName);
  		boolean isQueueCheck_QueueFilter=isQueueSelected_QueueFilter(strQueueName);
  		if(isQueueCheck_QueueFilter==true && isQueueDisplayed_Rightside==false)
  		{
  			return true;
  		}
  		return false;
  	}
  	
  	
  	public static void SelectAllQueues_CheckBox(boolean SelectAllorDeSelectAll) throws Exception
  	{
  		System.out.println("************************************");
  		setQueueFilterbutton();
  		if(SelectAllorDeSelectAll==true)
  		{
  			SetSelectAll_Queues();
  			System.out.println("Enabled Done ....");
  		}
  		else
  		{
  			setUnCheck_AllQueuesCheckBox();
  			setQueueFilter_SaveButton();
  		}
		SetQueueDivListLoading(SelectAllorDeSelectAll);
  	}
  	
  	public static boolean isAllQueueEnabled() throws Exception
  	{
  		SelectAllQueues_CheckBox(true);
  		Iterator<String> ACD = ACDGroups.iterator(); 
  		Iterator<String> Hunt = HuntGroups.iterator(); 
  		setQueueFilterbutton();
        while (ACD.hasNext()) 
        {
        	String strACDQueueName=ACD.next();
            System.out.println("strACDQueueName : :"+strACDQueueName); 
  			boolean isQueuechecked=isQueueSelected_QueueFilter(strACDQueueName);
  			boolean isRightside=isACDQueueDisplayed_RightSide(strACDQueueName);
  			System.out.println("ACD ACD: : "+strACDQueueName+" isQueuechecked=="+isQueuechecked+" isRightside=="+isRightside);
  			if(isQueuechecked==false || isRightside==false)
  			{
  				return false;
  			}
  		}
        
  		while (Hunt.hasNext()) {
  			boolean isQueuechecked=isQueueSelected_QueueFilter(Hunt.next());
  			boolean isRightside=isACDQueueDisplayed_RightSide(Hunt.next());
  			System.out.println("Hunt: : "+Hunt.next()+" isQueuechecked=="+isQueuechecked+" isRightside=="+isRightside);
  			if(isQueuechecked==false || isRightside==true)
  			{
  				return false;
  			}
  		}
        return false;
  	}
 
  	
  	public static int AllQueueFilter(String strRequriedText) throws Exception
  	{
  		System.out.println("[AllQueueFilter].. : "+strRequriedText);
  		SelectAllQueues_CheckBox(true);
  		setViewFilterButton();
  		SetRequriedViewType(strRequriedText);
  		setSaveButton_ViewFilter();
  		SetQueueDivListLoading(true);
  		boolean isSwitched=isRequriedQueueText(strRequriedText); //Don't Conver to lower case or upper case
  		String isQueueRadioButton=getSelected_Queue_viewType();
  		System.out.println("Received : isSwitched :"+isSwitched+" : isQueueRadioButton : "+isQueueRadioButton);
  		if(isSwitched==true && isQueueRadioButton.equals(strRequriedText))
  		{
  			return 1;
  		}
  		return 0;
  	}
  	
  	
  	public static void QueueViewType(String strViewtype) throws Exception
  	{
  		if(isRequriedQueueText(strViewtype)==false)
  		{
  		setViewFilterButton();
  		SetRequriedViewType(strViewtype);
  		setSaveButton_ViewFilter();
  		SetQueueDivListLoading(true);
  		}
  	}
  	
  	
  	public static int SHow_Hide_Filters(WebElement Element,String strViewtype,String optonShow,List<WebElement> MiddlepanelElement) throws Exception
  	{
  		System.out.println("[SHow_Hide_Filters] Received Headder info: : strViewtype=="+strViewtype+" optonShow=="+optonShow+" MiddlepanelElement==" +MiddlepanelElement);
  		setViewFilterButton();
  		SetRequriedViewType(strViewtype);
  		setView_Options(Element, optonShow);
  		setSaveButton_ViewFilter();
  		SetQueueDivListLoading(true);
  		setViewFilterButton();
  		boolean isExpected=isGetView_OptionsStatus(Element, optonShow);
  		
  		String strStyle=null;
  		if(optonShow.equals("1"))
  		{
  			strStyle=strShowAtt;	
  		}
  		else
  		{
  			strStyle=strHideatt;	
  		}
  		
  		boolean isHide=isOptionHide(MiddlepanelElement, strStyle);
  		if(isExpected==true && isHide==true)
  		{
  			return 1;
  		}
		return 0;	
  	}
  	
  	
  	public static int CallmonitorForm(WebElement PhonetypeElement)
  	{
  		SetMoreoptionsButton();
  		boolean isSupervisor=isSupervisor();
  		System.out.println("[CallmonitorForm- UDF] isSupervisor="+isSupervisor);
  		if(isSupervisor==false)
  		{
  			System.out.println("[CallmonitorForm] user is not Supervisor to validate this Case Please validate by login with Supervisor.");
  			return 0;
  		}
  		else if(isSupervisor==true)
  		{
  			SetPhoneType_CallMonitoringForm(PhonetypeElement);
  			return setPhonetypeValidation(PhonetypeElement);
  		}
  		return 0;	
  	}
  	
  	
  	public static int Refesh_Button()
  	{
  		try
  		{
  		SetMoreoptionsButton();
  		setRefreshButton();
  		SetQueueDivListLoading(true);
  		return 1;
  		}
  		catch (Exception e) {
		System.out.println("[Refesh_Button] Failed Exception: : "+e);
		return 0;
		}
  	}
  	
  	
  	/*** Logged in & Logged out Agnets Cout Comparision 
  	 * @throws Exception ****/
  	
  	public static int Logged_IN_AgentesCount_AllQueues() throws Exception
  	{
  		QueueViewType(strAllQueueViewType);
  		SelectAllQueues_CheckBox(true);
  		int MiddleViewCount=getLogged_IN_AgentsCount_AllQueues();
  		int detailedViewCount=GetLogged_In_AgentsCount_AllQueues_Detailedpanel();
  		System.out.println("[Logged_IN_AgentesCount_AllQueues] MiddleViewCount="+MiddleViewCount+" detailedViewCount="+detailedViewCount);
  		if(MiddleViewCount==detailedViewCount)
  			return 1;
  		else
  			return 0;
  	}
  	
  	public static int Logged_OUT_AgentesCount_AllQueues() throws Exception
  	{
  		QueueViewType(strAllQueueViewType);
  		SelectAllQueues_CheckBox(true);
  		int MiddleViewCount=getLogged_OUT_AgentsCount_AllQueues();
  		int detailedViewCount=GetLogged_OUT_AgentsCount_AllQueues_Detailedpanel();
  		System.out.println("[Logged_OUT_AgentesCount_AllQueues] MiddleViewCount="+MiddleViewCount+" detailedViewCount="+detailedViewCount);
  		if(MiddleViewCount==detailedViewCount)
  			return 1;
  		else
  			return 0;
  	}
  	
  	public static int Logged_IN_AgentesCount_PerQueues(String strQueueName) throws Exception
  	{
  		System.out.println("[Logged_IN_AgentesCount_PerQueues] QueueName="+strQueueName);
  		QueueViewType(strPerQueueViewType);
  		SelectAllQueues_CheckBox(true);
  		int MiddleViewCount=GetLogged_In_AgentsCount_PerQueue(strQueueName);
  		int detailedViewCount=GetLogged_In_AgentsCount_PerQueues_Detailedpanel(strQueueName);
  		System.out.println("[Logged_IN_AgentesCount_PerQueues] MiddleViewCount="+MiddleViewCount+" detailedViewCount="+detailedViewCount);
  		if(MiddleViewCount==detailedViewCount)
  			return 1;
  		else
  			return 0;
  	}
  	
  	
	public static int Logged_OUT_AgentesCount_PerQueues(String strQueueName) throws Exception
  	{
		System.out.println("[Logged_OUT_AgentesCount_PerQueues] QueueName="+strQueueName);
  		QueueViewType(strPerQueueViewType);
  		SelectAllQueues_CheckBox(true);
  		int MiddleViewCount=GetLogged_OUT_AgentsCount_PerQueue(strQueueName);
  		int detailedViewCount=GetLogged_OUT_AgentsCount_PerQueues_Detailedpanel(strQueueName);
  		System.out.println("[Logged_OUT_AgentesCount_PerQueues] MiddleViewCount="+MiddleViewCount+" detailedViewCount="+detailedViewCount);
  		if(MiddleViewCount==detailedViewCount)
  			return 1;
  		else
  			return 0;
  	}
  	
	public static int AgentLoggedinAllQueues(String strAgentname) throws Exception
	{
		QueueViewType(strAllQueueViewType);
		SelectAllQueues_CheckBox(true);
		boolean isLoggedin=GetAgentLoginStatus_AllQueues(strAgentname);
		System.out.println("****************"+isLoggedin);
		if(isLoggedin==false)
		{
			System.out.println("--------------");
			isLoggedin=LoginUser_AllQueues_fromAllQueues(strAgentname);
		}
		System.out.println("[AgentLoggedinAllQueues] isLoggedin " +isLoggedin);
		setLoggedAgent_Click(strAgentname);
		setSearchField_LoginDeatis("");
		boolean IsAgentLoggedin_Details=GetAgentLoggedinStatus_AllQueues_Detailedpanel(strAgentname, "1");
		System.out.println("[AgentLoggedinAllQueues] IsAgentLoggedin_Details " +IsAgentLoggedin_Details);
		if(IsAgentLoggedin_Details==true && isLoggedin==true)
				return 1;
		else
			return 0;
		
	}
  	
	
	public static int AgentLogedOutinAllQueues(String strAgentname) throws Exception
	{
		QueueViewType(strAllQueueViewType);
		SelectAllQueues_CheckBox(true);
		boolean isLoggedin=GetAgentLoginStatus_AllQueues(strAgentname);
		System.out.println("****************"+isLoggedin);
		if(isLoggedin==true)
		{
			System.out.println("--------------");
			isLoggedin=LogoutUser_AllQueues_fromAllQueues(strAgentname);
		}
		System.out.println("[AgentLoggedinAllQueues] isLoggedin " +isLoggedin);
		setLoggedOutAgent_Click(strAgentname); //Clicked on Logged out Agent 
		setSearchField_LoginDeatis(""); 
		boolean IsAgentLoggedin_Details=GetAgentLoggedinStatus_AllQueues_Detailedpanel(strAgentname, "0");
		System.out.println("[AgentLoggedinAllQueues] IsAgentLoggedin_Details " +IsAgentLoggedin_Details);
		if(IsAgentLoggedin_Details==false && isLoggedin==true)
				return 1;
		else
			return 0;
		
	}
	
	
	public static int LoginAgentin_AllQueues(String strAgentname) throws Exception
	{
		QueueViewType(strAllQueueViewType);
		SelectAllQueues_CheckBox(true);
		boolean isLoggedin=GetAgentLoginStatus_AllQueues(strAgentname);
		if(isLoggedin==false)
		{
			isLoggedin=LoginUser_AllQueues_fromAllQueues(strAgentname);
		}
		else
		{
			isLoggedin=LogoutUser_AllQueues_fromAllQueues(strAgentname);
			isLoggedin=LoginUser_AllQueues_fromAllQueues(strAgentname);
		}
		System.out.println("[AgentLoggedinAllQueues] isLoggedin " +isLoggedin);
		setLoggedAgent_Click(strAgentname);
		setSearchField_LoginDeatis("");
		boolean IsAgentLoggedin_Details=GetAgentLoggedinStatus_AllQueues_Detailedpanel(strAgentname, "1");
		System.out.println("[AgentLoggedinAllQueues] IsAgentLoggedin_Details " +IsAgentLoggedin_Details);
		if(IsAgentLoggedin_Details==true && isLoggedin==true)
				return 1;
		else
			return 0;
		
	}
  	
	
	
	public static boolean LoginUser_AllQueues_fromAllQueues(String strAgentID) throws Exception
	{
		System.out.println("[LoginUser_AllQueues_fromAllQueues]  Came here ");
		QueueViewType(strAllQueueViewType);
		setLoginButton_AllQueues(strAgentID);
		setLoginAll_AllQueues(strAgentID);
		Thread.sleep(1500);
		boolean isLoggedin=GetAgentLoginStatus_AllQueues(strAgentID);
		return isLoggedin==true ? true:false;
	}

	public static boolean LogoutUser_AllQueues_fromAllQueues(String strAgentID) throws Exception
	{
		System.out.println("[LoginUser_AllQueues_fromAllQueues]  Came here ");
		QueueViewType(strAllQueueViewType);
		setLogoutButton_AllQueues(strAgentID);
		SetLogutAll_AllQueues(strAgentID);
		Thread.sleep(1500);
		boolean isLoggedin=GetAgentLoginStatus_AllQueues(strAgentID);
		return isLoggedin==false ? true:false;
	}
	
	
  //-----------------------SCREEN SHORT METHOD -------------------------------------
	public static String captureScreenshot(WebDriver driver, String name,String Result) 
	{
		// TODO Auto-generated method stub
		try {
			TakesScreenshot s=(TakesScreenshot)driver;
			File src=s.getScreenshotAs(OutputType.FILE);
			String dest="E:\\Selenium\\Fail screenshots\\"+Result+""+name+".png";
			File d=new File(dest);
			FileUtils.copyFile(src,d);
			System.out.println("-- Screen short taken --");
			return dest;
		}
		catch(Exception e)
		{
			System.out.println("--Screeen short is not takeen--"+e.getMessage());
		 return e.getMessage();
		}
		
	} 
  
  public void Screenshort(String screenshortname,String Result)
  {
	  
	  if (screenshortname.contains("message load fail")) 
	  {
		  String filepath="E:\\Selenium\\Results\\Output\\"+Result+""+screenshortname+""+datesent()+".png";
		  Screenshortpath=filepath;
	  } 
	  else 
	  {
		  String filepath="E:\\Selenium\\Fail screenshots\\"+Result+""+screenshortname+""+datesent()+".png";
		  Screenshortpath=filepath;
	  }
	  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  System.out.println("------Screen short path is :"+Screenshortpath);	  
  try {
	  FileUtils.copyFile(src, new File(Screenshortpath));
  	  } 
  catch (Exception e) 
  {
	
	  System.out.println(e.getMessage());
  }
  
 }
  
  
  
  
  
  
  
  
//------------------SEND MAIL USING JAVA MAIL---------------------//
public void senmail(String Messagessendingusername,int count,String TOusernames,String SentMessage)
{
	Logs.info("[Mail]... Started");
	Properties props = new Properties();

	// this will set host of server- you can change based on your requirement 
	props.put("mail.smtp.host", "smtp.gmail.com");

	// set the port of socket factory 
	props.put("mail.smtp.socketFactory.port", "465");

	// set socket factory
	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

	// set the authentication to true
	props.put("mail.smtp.auth", "true");

	// set the port of SMTP server
	props.put("mail.smtp.port", "465");

	// This will handle the complete authentication
	Session session = Session.getDefaultInstance(props,

			new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("pandoratestone@gmail.com", "abc@1234");

				}

			});

	try {

		// Create object of MimeMessage class
		Message message = new MimeMessage(session);

		// Set the from address
		message.setFrom(new InternetAddress("pandoratestone@gmail.com"));

		// Set the recipient address
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(TOusernames));
		message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("prakash@panterranetworks.com"));
	//	message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("prashanth@panterranetworks.com"));
        
                    // Add the subject link
		message.setSubject("Messages sent Complete:"+Messagessendingusername+" Count is :"+count);

		// Create object to add multimedia type content
		BodyPart messageBodyPart1 = new MimeBodyPart();

		// Set the body of email
		messageBodyPart1.setText("Messages sent complete and last message is :"+SentMessage+"  "
				                     + "and Count is :"+count+"\n\n Thanks, \n Bala Pavan.");

		// Create another object to add another content
		MimeBodyPart messageBodyPart2 = new MimeBodyPart();

		// Mention the file which you want to send
	//	String filename = Screenshortpath;
		String filename = Screenshortpath;

		// Create data source and pass the filename
		DataSource source = new FileDataSource(filename);

		// set the handler
		messageBodyPart2.setDataHandler(new DataHandler(source));

		// set the file
		messageBodyPart2.setFileName(filename);

		// Create object of MimeMultipart class
		Multipart multipart = new MimeMultipart();

		// add body part 1
		multipart.addBodyPart(messageBodyPart2);

		// add body part 2
		multipart.addBodyPart(messageBodyPart1);

		// set the content
		message.setContent(multipart);

		// finally send the email
		Transport.send(message);

		System.out.println("=====Email Sent=====");

	} catch (MessagingException e) {

		throw new RuntimeException(e);

	}
}
  
   
	 
}

package streams_ucc_page;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import output_results.Logs;
import streams_ucc_OR.OR;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;

public class Page extends OR{
	
  
	
	protected  static WebDriver driver;
	  public Page(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);  
	  }

	    public static String messageuuid,
	    					 attachmentuuid,
	    					 TextFileUuid,
	    					 AudioFileUuid,
	    					 CollegeUuid;
	    public boolean CurrectBuddyOpen,openedBuddyStatus;
		public static String OpenTargetBuddyName;
		public static String LoggedinUsername,CurrrentLoggedinUser;
		
		
		/**
		 * 
		 * @param Element
		 * @param time
		 * @param waittype -> 0 visibility,
		  			   -> 1 Element to be Clickable
		  			   -> 2 Presence of Element	
		 */
		  public void CommonWaitofElement(WebElement Element,int time,int waittype)
		  {
//			  Logs.info("[CommonWaitofElement] Started.. Element :"+Element+".time is :"+time+" and Waittype :"+waittype);
			  WebDriverWait wait=new WebDriverWait(driver,15);
			  if (waittype==0) 
			  {
				wait.until(ExpectedConditions.visibilityOf(Element));
//				Logs.info("[CommonWaitofElement] done with 0 ");
			  } 
			  else if(waittype==1)
			  {
	           wait.until(ExpectedConditions.elementToBeClickable(Element));
//	           Logs.info("[CommonWaitofElement] done with 1");
			  }
			  else if(waittype==2)
			  {
				//  wait.until(ExpectedConditions.presenceOfElementLocated((By) Element));  
				  Logs.info("[CommonWaitofElement] done with 2");
			  }
		  }
		  
		  public String GetTextWait(WebElement element)
		  {	
			try {
				Logs.info("[GetTextWait]..Started & Element is :"+element);
				return element.getText();
				} 
				catch (Exception Gettextwait) 
				{
					Logs.error("[GetTextWait]..Exception is :"+Gettextwait);
					return "Getting Empty Text From Element";
				}  		
		  }
		  
		  public boolean GetTextToBeBool(By BYElement,int WaitTime,String ExpectedText)
		  {
			  WebDriverWait gettextwait=new WebDriverWait(driver, WaitTime);  
			  boolean bolGetText=gettextwait.until(ExpectedConditions.textToBe(BYElement, ExpectedText));
			  Logs.info("[GetTextToBe] returning bool value is :"+bolGetText);
			  return bolGetText; 
		  }
		  
		  public String GetAttributeFromLocator(WebElement Element,String Attribute)
		  {
			  Logs.info("[GetAttributeFromLocator].Element is:"+Element+" and Attribute is :"+Attribute);
			  return Element.getAttribute(Attribute);
		  }
		  
		  public boolean GetAttributeToBe(By Element,int Wait,String Attribute,String AttributeValueIs)
		  {
			  WebDriverWait attributewait=new WebDriverWait(driver, Wait);
			  boolean bolAttribute=attributewait.until(ExpectedConditions.attributeToBe(Element, Attribute, AttributeValueIs));
			  return bolAttribute;
		  }
		  
		  /**
		   * 
		   * @param Element
		   * @param EventType ->0 input filed Clear & Send Keys
		   * 				  ->1 Click Event	 
		   * @param InputFieldEnter
		   */
		  public void Action_ElemetS(WebElement Element,int EventType,String InputFieldEnter)
		  {
			  if (EventType==0) 
			  {
				  Element.clear();
				  Element.sendKeys(InputFieldEnter);
			  } 
			  else if(EventType==1)
			  {
				  Element.click();
			  }
		  }
		  
		  /*** WebElement Locating methods with return types
		   * 
		   * 
		   */
		  
		  public WebElement ElementIs(String Attributetype,String value)
		  {
			  if (Attributetype.toLowerCase().equals("id")) 
			  {
				WebElement  IDElement=driver.findElement(By.id(value));
				return IDElement;
			  } 
			  else if(Attributetype.toLowerCase().equals("xpath"))
			  {
				  WebElement xpathelement=driver.findElement(By.xpath(value));
				  return xpathelement;
			  }
			  else if(Attributetype.toLowerCase().equals("class"))
			  {
				  WebElement classElement=driver.findElement(By.className(value));
			     return classElement;
			  }
			  else if(Attributetype.toLowerCase().equals("name"))
			  {
				  WebElement nameElement=driver.findElement(By.name(value));
				     return nameElement;
			  }
			  else if(Attributetype.toLowerCase().equals(value))
			  {
				  WebElement linktextElement=driver.findElement(By.linkText(value));
				     return linktextElement;
			  }
			return null;
		  }
		  
		  /*** By Class Locating methods with return types
		   * 
		   * 
		   */
		  
		  public By ByElementIS(String Attributetype,String value)
		  {
			  if (Attributetype.toLowerCase().equals("id")) 
			  {
				By  IDElement=By.id(value);
				Logs.info("[ByElementIS]..id is :"+IDElement);
				return IDElement;
			  } 
			  else if(Attributetype.toLowerCase().equals("xpath"))
			  {
				  By xpathelement=By.xpath(value);
				  return xpathelement;
			  }
			  else if(Attributetype.toLowerCase().equals("class"))
			  {
				  By classElement=By.className(value);
			     return classElement;
			  }
			  else if(Attributetype.toLowerCase().equals("name"))
			  {
				  By nameElement=By.name(value);
				     return nameElement;
			  }
			  else if(Attributetype.toLowerCase().equals(value))
			  {
				   By linktextElement=By.linkText(value);
				     return linktextElement;
			  } 
			  return null;
		  }
		 /** 
		  Code Optiomization
		  
		  Ended **/
		
		
		// ******** Login user method *********
		  
		public void EnterUsreNamePassword(String Username,String Password)
		{
			Logs.info("[EnterUsreNamePassword].. Started Userid"+Username);
			this.CommonWaitofElement(username, 7, 0);
			this.username.clear();
			this.username.sendKeys(Username);
			this.CommonWaitofElement(password, 7, 0);
			this.password.clear();
			this.password.sendKeys(Password,Keys.ENTER);
			Logs.info("[EnterUsreNamePassword] Ended..");
		}
		  
	  
	  public void username_password_Login(String uname,String pass) throws Exception
	  {
	    Logs.info("[Login]... Started ........."+uname+"");
	    WebDriverWait l=new WebDriverWait(driver, 6);
	    String loginPageUrl=driver.getCurrentUrl();
	    Logs.info("[Login]... page url is .........:"+loginPageUrl);
	      
	    if (loginPageUrl.contains("/sloader/home.jsp")) 
	    {
	    	 Logs.info("[Login].. already one user logged in hence logouting user : ");
	    	 if (CurrentLoggedin_User().equals(uname)) 
	    	 {
			  Logs.info("[Login]...Proper user logged in.. no need to logout");
			  driver.navigate().refresh();
			  this.recentssearchbarwait();
			  this.contacts_status(uname);
	    	 } 
	    	 else 
	    	 {
	    		 this.logout();
	    		 this.EnterUsreNamePassword(uname, pass);
	 			 Logs.info("[Login].. Logout done login requried user:"+uname);
			}
		} 
	    else if(loginPageUrl.contains("dashboardid=302922967"))
		{
			Logs.info("[Login].. Login page is displayed hence login user :");
			if (username.isDisplayed()) 
			{
				Logs.info("[Login].. Login page displayed");
				 this.EnterUsreNamePassword(uname, pass);
				Logs.info("[Login]..Ended..  Clicked on sign in button..");
			} 
			else if(!loginPageUrl.contains("dashboardid=302922967"))
			{
				driver.navigate().to(Constants.streamsproductionurlbeta);
				if (username.isDisplayed()) 
				{
					Logs.info("[Login].. Login page displayed");
					 this.EnterUsreNamePassword(uname, pass);
					Logs.info("[Login]..Ended..  Clicked on sign in button..");
				}
			}
			else 
			{
				 Logs.info("[Login]... Session Propble came");
				 this.recentssearchbarwait();
				 this.logout();
				 this.EnterUsreNamePassword(uname, pass);
	 			 Logs.info("[Login].. Logout done due to session problemlogin requried user:"+uname);
			}
			Logs.info("[Login].. entered crediantilas username is :"+uname+" and password is :"+pass);
		}   
	  }

	  //-------- Login locators ended --------

   public void second_login(String usernae,String Password) throws Exception
   {
	    this.username_password_Login(usernae,Password);
		this.recentssearchbarwait();
		this.contacts_status(usernae);
   }
	  //--- Logout locators -----//
	  public  void logout() throws Exception
	  {
		  Logs.info("[Logout Actions]: Started *");
	  	try {
	  		if (menubutton.isDisplayed()) 
	  		{
	  			this.CommonWaitofElement(menubutton, 15, 1);
		  		this.menubutton.click();
		  		Logs.info("[Logout Actions]: Clicked on threebar menu");
		  		this.CommonWaitofElement(logoutbutton, 15, 1);
		  		this.logoutbutton.click();
		  		Logs.info("[Logout Actions]: Clicked Logout button");
		  		this.CommonWaitofElement(username, 10, 0);
		  		this.CommonWaitofElement(password, 10, 0);
		  		Logs.info("[Logout ENDED]: Logged out done identified Menubutton:"+driver.getCurrentUrl());
			} 
	  		else 
			{
	  			Logs.info("[Logout Actions]: Meu Action is not displaye ddoing refresh and Loggedout.");	
	  		 	driver.navigate().refresh();
             	this.recentssearchbarwait();
             	this.CommonWaitofElement(menubutton, 15, 1);
             	this.menubutton.click();
             	this.CommonWaitofElement(logoutbutton, 15, 1);
		  		this.logoutbutton.click();
		  		Logs.info("[Logout Actions]: Clicked Logout button");
		  		this.CommonWaitofElement(username, 10, 0);
		  		this.CommonWaitofElement(password, 10, 0);
		  		Logs.info("[Logout ENDED]: Logged out done with failure");
			}
	  //		userloggedStatus=false;
	  		Logs.info("[Logout]  Logot Ended in try block and sending login status as false :");
	  	} 
	  	catch (Exception e) 
	  	{
	  		driver.navigate().refresh();
         	this.recentssearchbarwait();
         	this.CommonWaitofElement(menubutton, 15, 1);
         	this.menubutton.click();
         	this.CommonWaitofElement(logoutbutton, 15, 1);
	  		this.logoutbutton.click();
	  		this.CommonWaitofElement(username, 10, 0);
	  		this.CommonWaitofElement(password, 10, 0);
	  	//	 userloggedStatus=true;
	  		 Logs.error("[Logout Actions]: User logged out Fail Due to :"+e.getMessage());
	  	}
	  	
	  }
	 
	    // *** Streams Recents wait ******
	    public void recentssearchbarwait() throws InterruptedException
	    {   
	       Logs.info("[Recents loading wait] Started.. *"+Thread.currentThread().getStackTrace()[1].getMethodName());	
	  //	   WebDriverWait rsearch=new WebDriverWait(driver,100);
	  	  try 
	  	  	{ 
	  		this.CommonWaitofElement(ChatFilter, 100, 1); 
	  		this.CommonWaitofElement(contacts_tabbutton, 100, 1); 
	  		this.contacts_tabbutton.click();
	  		this.CommonWaitofElement(searchbar_contcatstab, 60, 0); 
	  		this.searchbar_contcatstab.clear();
	  		/*rsearch.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='chatFilter']")));
	  		rsearch.until(ExpectedConditions.presenceOfElementLocated(By.id("search_recents")));
	  		rsearch.until(ExpectedConditions.visibilityOf(contacts_tabbutton)).click();
	  		rsearch.until(ExpectedConditions.visibilityOf(searchbar_contcatstab));
	  		*/
	  		Logs.info("[Recents loading wait] Search bar displayed in Contacts tab");
	  		Logs.info("[Recents loading wait] Ended....recentssearchbarwait() Portal url is :"+driver.getCurrentUrl());
	  		//userloggedStatus=true;
	  		Logs.info("[Recents loading wait] Ended and CurrentLoggedinUser:"+CurrentLoggedin_User()+" and user login Status is:");
	  	  	} 
	  	  catch (Exception e) 
	  	  	{   
	  		  	
	  		  	driver.navigate().refresh();
	  	  		this.CommonWaitofElement(ChatFilter, 100, 1); 
	  	  		this.CommonWaitofElement(contacts_tabbutton, 100, 1); 
	  	  		this.contacts_tabbutton.click();
	  	  		this.CommonWaitofElement(searchbar_contcatstab, 60, 0); 
	  	  		this.searchbar_contcatstab.clear();
	  			/*	 rsearch.until(ExpectedConditions.presenceOfElementLocated(By.id("search_recents")));
	  	  			 rsearch.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='chatFilter']")));
	  				 rsearch.until(ExpectedConditions.visibilityOf(contacts_tabbutton)).click();
	  				 rsearch.until(ExpectedConditions.visibilityOf(searchbar_contcatstab));
	  				 Thread.sleep(3000);	
	  				 Logs.error("[Recents loading wait]unable to locate Search bar in recents due to :"+e.getMessage());
	  			*///	 userloggedStatus=true;
	  	  	}	
	  	}  
   
	 //--- BELOW METHOS IS USED FOR GETTING LOGGEDIIN USER FROM PROFILE PIC---------//   
	    public String CurrentLoggedin_User()
	    {
	    	try {
	    		Logs.info("[CurrentLoginUser] Started....");
				this.CommonWaitofElement(UserProfilePic, 20, 0);
				String loggeduserNameAttribute=GetAttributeFromLocator(UserProfilePic, "name");
				Logs.info("[CurrentLoggedin_User].. Attribute is :"+loggeduserNameAttribute);
				String Replacing_unwantedString=loggeduserNameAttribute.replace("profilepic_", "");
				CurrrentLoggedinUser=Replacing_unwantedString;
				Logs.info("[CurrentLoginUser] ended ... user is :"+Replacing_unwantedString);
				return CurrrentLoggedinUser;	
			    } 
	    		catch (Exception e) 
	    		{
				Logs.error("[CurrentLoginUser]...Return null -->fail due to :"+e);
				return null;
				
	    		} 
	    }
	    
	    public void contacts_status(String sent_username) throws Exception
	    {
	      Logs.info("[User Status ] Started."+Thread.currentThread().getStackTrace()[1].getMethodName());
	  	//  WebDriverWait csearch=new WebDriverWait(driver,60); 
	      try 
	  	  {
	  		  
	  		if (sent_username.equals(CurrentLoggedin_User())) 
	  		 {
	  			Logs.info("[Currect Loggedin user Validation] Done Super..");	
			 } 
	  		 else 
	  		 {
	  			 Logs.error("[Currect Loggedin user Validation].. Fail ot mached Poperly.. expected is:"+sent_username+" but getting resut is :"+CurrentLoggedin_User());
	  			 Logs.info("[Currect Loggedin user Validation]..Hence logut & Login proper user");
	  			 this.logout();
	  			 this.username_password_Login(sent_username, Constants.commonpassword);
	  			 this.recentssearchbarwait();
	  			 Logs.info("[Currect Loggedin user Validation].. Proper usre login done :"+sent_username);
			 } 
	  		  this.CommonWaitofElement(searchbar_contcatstab, 60, 0);
	  		  this.searchbar_contcatstab.clear();
	  		  this.searchbar_contcatstab.sendKeys(sent_username);  
	  		  WebElement UserStatuReflect=driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+sent_username+"']"));
	  		  this.CommonWaitofElement(UserStatuReflect, 30, 0);
	  		  Logs.info("[Staus]...."+GetTextWait(UserStatuReflect));
	  		 
	  		 if(GetTextWait(UserStatuReflect).equals("On Desktop"))
	  		 {
	  			 Logs.info("[USER STATUS IS ] ==== Status :=== "+GetTextWait(UserStatuReflect)+" bool value is :"+this.GetTextToBeBool(ByElementIS("id", "status_b4fa6aa68ad111e6b48f001e58a7db4a_"+sent_username+""),20,"On Desktop"));
	  		 }
	  		 else 
	  			{
	  				this.statusbar.click();
	  				this.CommonWaitofElement(ondesktop, 5, 0);
	  				this.ondesktop.click();
	  				Logs.info("[User Status ]--- bool value is :"+this.GetTextToBeBool(ByElementIS("id", "status_b4fa6aa68ad111e6b48f001e58a7db4a_"+sent_username+""),30,"On Desktop"));
	  			}
	  			Logs.info("[User Status ] Ended.....");
	  	  } 
	      catch (Exception StatusException) 
	      {
	  		Logs.error("[User Status ]unable to get user Status to On Desktop :"+StatusException.getMessage());
	  	  }
	      
	    }  
    
	   public void Stream_detail_panel_open_middlechat(String username) throws Exception
	   {
		 Logs.info("[Stream detail panel and Right side panel] Started .");
	  	 
		 WebDriverWait detailpanel=new WebDriverWait(driver, 20);
	  	 
	  	if (openedBuddyStatus==true) 
	  	 {
		  Logs.info("[Stream detailpanel]..Prper Buddy Opened...:"+openedBuddyStatus);	
		 } 
	  	 else 
	  	 {   Logs.info("[Stream detailpanel]..Prper Buddy Opened...:"+openedBuddyStatus);	
	  		 if (contacts_tabbutton.isDisplayed()) 
	  		 {
	  		  Logs.info("[Stream detail panel]...: Contacts tab search displayed rety...");
			  this.searchbar_contcatstab.clear();
			  this.searchbar_contcatstab.sendKeys(OpenTargetBuddyName);
			  Thread.sleep(5000);
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+OpenTargetBuddyName+"']")))).click();
			  Logs.info("[Budddy Click operations] Clicked on selected user and username is : "+OpenTargetBuddyName);
			  detailpanel.until(ExpectedConditions.visibilityOf(typemessagefield));
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='middle_ucnt']//*[@id='status_middle_"+OpenTargetBuddyName+"']"))));
			  Logs.info("[Budddy Click operations] Retry success...");
	  		  } 
	  		  else 
	  		  {
	  		  Logs.info("[Stream detail panel].. Unexpected doing Reresh:"+openedBuddyStatus);
              driver.navigate().refresh();
              this.recentssearchbarwait();
              this.searchbar_contcatstab.clear();
			  this.searchbar_contcatstab.sendKeys(OpenTargetBuddyName);
			  Thread.sleep(5000);
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+OpenTargetBuddyName+"']")))).click();
			  Logs.info("[Budddy Click operations] Clicked on selected user and username is : "+OpenTargetBuddyName);
			  detailpanel.until(ExpectedConditions.visibilityOf(typemessagefield));
			  detailpanel.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='middle_ucnt']//*[@id='status_middle_"+OpenTargetBuddyName+"']"))));
	  		  }
		  }
	  	   		detailpanel.until(ExpectedConditions.visibilityOf(streamdetailedpanel_middlechat));
	  	   		String panelposition=this.streamdetailedpanel_middlechat.getAttribute("class");
	  	 
	  	 	if (panelposition.contains("streamDetails activeStatus"))
	  	 	{
	  	 		Logs.info("[Stream detail panel and Right side panel] stream detail panel is opened and class attribute is:"+panelposition);
	  	 	} 
	  	 	else if(panelposition.contains("streamDetails")) 
	  	 	{    
	  		Logs.info("[Stream detail panel and Right side panel] Stream detail panel is not opened hence opening and class attribute is:"+panelposition);
	        
	  		this.streamdetailedpanel_middlechat.click(); 
	        detailpanel.until(ExpectedConditions.attributeContains(streamdetailedpanel_middlechat, "class", "streamDetails activeStatus"));
	        detailpanel.until(ExpectedConditions.visibilityOf(Pinneditemsbar_rightsidepanel));
	        Logs.info("[Stream detail panel and Right side panel] Right side panel is opened and pinned items section is displayed");  
	  	 	}
	  	 	Logs.info("[Stream detail panel and Right side panel] Ended");
	  	 	this.OpenBuddyValidation(OpenTargetBuddyName);
	  	 	Logs.info("[Boolean value is]"+CurrectBuddyOpen);
	  		Logs.info("[Expanding pinned items] Started");	       
	   }
	   
	   
	  public void OpenBuddyValidation(String username) throws Exception
	  {
		//  WebDriverWait UseridWait=new WebDriverWait(driver, 20);
		  Logs.info("[Validating opened buddy].. Started.....");
		  
		  if ((username)!=null) 
		  {
			  WebElement name=driver.findElement(By.xpath("//span[@class='rightUserID']"));
			  this.CommonWaitofElement(name, 10, 0);
			    String OpenedUseris=GetTextWait(name);
			    Logs.info("[Validating opened buddy].. is:"+OpenedUseris);
			  	if (OpenedUseris.equals(username)) 
			  	{
			  		
					CurrectBuddyOpen=true;
					Logs.info("[Boolean opened properbuddy in if block]"+CurrectBuddyOpen);
				} 
			  	else 
				{
					CurrectBuddyOpen=false;
					this.buddyclick(OpenTargetBuddyName, LoggedinUsername);
					
				}
		   } 
		  else 
		  {
			CurrectBuddyOpen=false;
			this.buddyclick(OpenTargetBuddyName, LoggedinUsername);
			
		  }	  
	  }
	   
	  public void pinneditems_complete_loading_wait()
	  {
	  	try {
	  		if (CurrectBuddyOpen==true) 
	  		{
	  			Logs.info("[Counting pinned items] Started");
	  			
		  		 WebDriverWait pinneditemsloading=new WebDriverWait(driver, 10);
		  		 String pineditemsmode=pinneditemsloading.until(ExpectedConditions.visibilityOf(pinneditemsbar)).getAttribute("title");
			     System.out.println("attribute is :"+pineditemsmode);
			       
			   if (pineditemsmode.contains("Click here to expand")) 
			   {
			  		Logs.info("[Expanding pinned items] pinned items is in collapse mode then expanding");
			  		pinneditemsloading.until(ExpectedConditions.visibilityOf(pinneditemsbar)).click();
			  		pinneditemsloading.until(ExpectedConditions.attributeToBe(pinneditemsbar, "title", "Click here to collapse"));
			  		Logs.info("[Expanding pinned items] Expanding Pinned items");
			  	} 
			       else if(pineditemsmode.contains("Click here to collapse")) 
			    {
			       Logs.info("[Expanding pinned items] pinned items are is in expand mode");
			  	}
		  		List<WebElement> pinnesitems=driver.findElements(By.xpath("//div[@id='pin_items']/div"));
		  		int pinnedcount=pinnesitems.size();
		  		Logs.info("[Counting pinned items] Tottal pinned items are :"+pinnedcount);
		  		if (pinnedcount>0) 
		  		{
		  			
		  			for (int i = 1; i <=pinnedcount; i++) 
		  			{
		  				pinneditemsloading.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='pin_items']/div)["+i+"]"))));
		  				if(i==pinnedcount)
		  				{
		  				Logs.info("[Counting pinned items]Last pinned itmem is identified:"+i);
		  				}
		  			}
		  		} 
		  			else 
		  			{
		  				Logs.info("[Counting pinned items]No.of pinned items are empty");
		  			}
		  			Logs.info("[Counting pinned items] Ended....");
			} 
	  		else 
	  		{
				this.buddyclick(OpenTargetBuddyName, LoggedinUsername);
			}
	  			  	}
	  	catch (Exception e) {
	  		Logs.error("Unable to locate elemet xpath is :"+e);
	  	}
	  	
	  }
	   
	   
	  public void buddyclick(String buddyclick_username,String loggedinuserstatus) throws Exception
	  {
		  Logs.info("[Budddy Click operations] Started.");
		  
		  OpenTargetBuddyName=buddyclick_username;
		  LoggedinUsername=loggedinuserstatus;
	   try
	   {
		   this.CommonWaitofElement(searchbar_contcatstab, 30, 0);
		   this.searchbar_contcatstab.clear();
		   this.searchbar_contcatstab.sendKeys(buddyclick_username);
		   WebElement StatusClickElement=driver.findElement(By.xpath("//div[@id='status_b4fa6aa68ad111e6b48f001e58a7db4a_"+buddyclick_username+"']"));
		   this.CommonWaitofElement(StatusClickElement, 30, 1);
		   StatusClickElement.click();
		   this.CommonWaitofElement(typemessagefield, 20, 1);
		   Logs.info("[Budddy Click operations] Clicked on selected user and username is : "+buddyclick_username);
		   Logs.info("[Buddy Click]..typemessagefield ");
		   WebElement MiddleChatUserStatus=driver.findElement(By.xpath("//div[@id='middle_ucnt']//*[@id='status_middle_"+buddyclick_username+"']"));
		   this.CommonWaitofElement(MiddleChatUserStatus, 20, 1);
		   this.CommonWaitofElement(driver.findElement(By.xpath("//a[@class='customMessage']")), 10, 1);
		   Logs.info("[Buddy Click]..Status middle chat ");
		   openedBuddyStatus=true;
		   Logs.info("[Buddy Click]... Proper buddy opened..:"+openedBuddyStatus);
	   } 
	   catch(Exception e) 
	   {
		   openedBuddyStatus=false;
		   Logs.error("[buddy].... Fails :"+openedBuddyStatus);
	   }
		
	    this.Stream_detail_panel_open_middlechat(buddyclick_username);
	    this.pinneditems_complete_loading_wait();
	    this.CommonWaitofElement(typemessagefield, 20, 1);
	    Logs.info("[Budddy Click operations] Ended..and Write a messsage field is displayed :"+buddyclick_username+"*Done*");
	    
	  }
	    
	  private boolean isElementpresent(WebDriver driver, By by) {
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  try {
	  		driver.findElement(by);
	  		return true;
	  	} catch (NoSuchElementException e) {
	  		return false;
	  	}
	  	
	  }

	  public void sentmessage(String sentmessage) throws Exception
	  {  
		  
		 Logs.info("[Message sent] Started.."+sentmessage);
	  	 try {
	  		 this.CommonWaitofElement(typemessagefield, 10, 1);
	  		 this.typemessagefield.clear();
	  		 this.typemessagefield.sendKeys(sentmessage);
	  		 this.CommonWaitofElement(messagesentclickbuton, 10, 1);
	  		 this.messagesentclickbuton.click();
			 Logs.info("[Message sent] Ended.. and message is :"+sentmessage);
	  	 	} 
	  	 catch (Exception e) 
	  	 {
	  		 Logs.error("[Message sent]  Failed trying in Chatch with refresh.."+e.getMessage());
			 driver.navigate().refresh();
			 this.recentssearchbarwait();
			 this.contacts_status(CurrrentLoggedinUser);
			 this.buddyclick(OpenTargetBuddyName, CurrrentLoggedinUser);
			 this.CommonWaitofElement(typemessagefield, 10, 1);
	  		 this.typemessagefield.clear();
	  		 this.typemessagefield.sendKeys(sentmessage);
	  		 this.CommonWaitofElement(messagesentclickbuton, 10, 1);
	  		 this.messagesentclickbuton.click();
			/*sentmessagefield.until(ExpectedConditions.visibilityOf(typemessagefield));
			this.typemessagefield.sendKeys(sentmessage);
			sentmessagefield.until(ExpectedConditions.visibilityOf(messagesentclickbuton)).click();*/
			Logs.info("[Message sent]   Success in Catch.....");
		}
	  	 
	  }

	  public String messageuuid(String message)
	  {
		 Logs.info("[Message UUID] Started..");
	  	 WebDriverWait messagebar=new WebDriverWait(driver, 30);
	  	 WebElement message_bar=driver.findElement(By.xpath("//div[@msg='"+message+"']"));
	  	 messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@msg='"+message+"']"))));
	  	 messagebar.until(ExpectedConditions.visibilityOf(message_bar));
	  	 String getuid=message_bar.getAttribute("uuid");
	  	 messageuuid=getuid;
		 Logs.info("[Message UUID] Ended and UUID is..: "+messageuuid);
		 return getuid;  	
	  }

	  public void like(String UUID,String likedusername_you)
	  {
		  	Logs.info("[Like Actions] Started.. and UUID is:"+UUID);
		  	WebDriverWait messagebar=new WebDriverWait(driver, 30);
		  	
			Actions like=new Actions(driver);
			WebElement likaction=driver.findElement(By.id("likemsg_"+UUID+""));
			this.CommonWaitofElement(likaction, 30, 1);
			//messagebar.until(ExpectedConditions.visibilityOf(likaction));
			String text=likaction.getText();
			Logs.info("[Like Actions] Item displayed for like Action");
			if (text.equals("Like")) {
				like.moveToElement(likaction).click().build().perform();
			//	String afterliketesxt=likaction.getText();
				Logs.info("[Like Actions] Clicked on Like");
				messagebar.until(ExpectedConditions.textToBe(By.id("likemsg_"+UUID+""), "Unlike"));
				Logs.info("[Like Actions] unlike text is displayed");
				String likecount=messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lcnt_"+UUID+"")))).getText();
			    Logs.info("[Like Actions] Likes Count is :"+likecount);
				messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lcnt_"+UUID+"")))).click();
			    Logs.info("[Like Actions] Clicked on Likes Count");
				messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id,'"+likedusername_you+"')][@class='MemberSection ExplicitBuddyWidth MemberSectionLike']"))));
			}
			Logs.info("[Like Actions]like action done at user properly at :"+likedusername_you+"Verified in likes screen ");
			Logs.info("[Like Actions] Ended.....");
      	// messagebar.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("likemsg_"+UUID+"")))).click();	   
	  }
	    
	  public void comment(String commnetsent,String commentobject,String commentUUID)
	  {
		Logs.info("[comment Actions] Started..and sent commet is:");  
	  	WebDriverWait comentwait=new WebDriverWait(driver, 10);
	  	System.out.println("taken uid from sent message for Comment is :"+commentUUID);
	  	comentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("comment_"+commentUUID+"")))).click();
	  	//WebElement commenttextarea=driver.findElement(By.xpath("//textarea[@msg='"+commentobject+"']"));////textarea[contains(@msg,'17')]
	  	WebElement commenttextarea=driver.findElement(By.xpath("//textarea[contains(@msg,'"+commentobject+"')]"));
	  	comentwait.until(ExpectedConditions.visibilityOf(commenttextarea)).clear();
	  	comentwait.until(ExpectedConditions.visibilityOf(commenttextarea)).sendKeys(commnetsent);
	  	comentwait.until(ExpectedConditions.visibilityOf(commentsentclick)).click();
	  	comentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ccnt_"+commentUUID+"")))).click();
	  	Logs.info("[comment Actions] Comment done properly and comment count is displayed and clicked on comments"+commnetsent);
	  /*	List <WebElement> allcomments=driver.findElements(By.xpath("//div[@class='recentMessageComment']/div[@class='chatContent preWrappedText']"));
	  	for (int i = 1; i <=allcomments.size(); i++) {
			String sentcommenttext=comentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='recentMessageComment']/div[@class='chatContent preWrappedText'])["+i+"]")))).getText();
			System.out.println("----------------"+sentcommenttext+"and i value is :"+i);
			if (sentcommenttext==commnetsent) 
			{
			  Logs.info("Comment sent properly and validated in connetms screen also and comments is :"+sentcommenttext);	
			} else if(sentcommenttext!=commnetsent) {
               System.out.println("While iterating comment sent comments is not displayed in comments screen and Actual sent comments is :"+commnetsent);    
			}
		}*/
	  	String commentscount=comentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ccnt_"+commentUUID+"")))).getText();
	  	Logs.info("[comment Actions]Ended...... Comments Count is :"+commentscount);
	  }

	  public void pin(String UUID)
	  {
	  	Logs.info("[Pinned Action] Stared... and item uuid is:"+UUID+"");
	  	new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pinmsg_"+UUID+"")))).click();
	  	Logs.info("[Pinned Action] Ended...");
	  }

	  public void Reshare(String sentmessage)
	  { 
	  	WebDriverWait reshareclick=new WebDriverWait(driver, 20);
	  	reshareclick.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@msg,'"+sentmessage+"')]/div[3]/a[2]")))).click();
	  	Logs.info("[Reshare Actions] Clicked on Rehsre button");
	  }

	  public void usernamesent_reshare(String resahedto_username)
	  {
	  	WebDriverWait usernamesent=new WebDriverWait(driver, 20);
	  	usernamesent.until(ExpectedConditions.visibilityOf(Reshareusernaemsentfield)).clear();
	  	this.Reshareusernaemsentfield.sendKeys(resahedto_username);
	  	Logs.info("[Reshare Actions] Send user name in field:"+resahedto_username);
	  }

	  public void Selectreshareuserbuddy(String reshareusername)
	  {
	  	WebDriverWait re=new WebDriverWait(driver, 20);
	  	re.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@buddyid='"+reshareusername+"']/div[2]")))).click();
	  	re.until(ExpectedConditions.visibilityOf(rehare_click)).click();
	  	Logs.info("[Reshare Actions] Checked user:"+reshareusername+" and Clicked on Reshare button");
	  }
	    
	  public void Resharemessahevalidation(String message)
	  { 
		  Logs.info("[Reshare validation] Started...");
	  	  WebDriverWait messagebar=new WebDriverWait(driver, 30);
	  	  WebElement message_bar=driver.findElement(By.xpath("//div[contains(@msg,'"+message+"')]"));
	  	  new Actions(driver).moveToElement(messagebar.until(ExpectedConditions.visibilityOf(message_bar))).build().perform();
	  	  Logs.info("[Reshare  validation] Item displayed Ended...");
	  }
	    
	    
	  public void middlechatuploadbutton_wait()
	  {
	  	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(uploadbutton_chatwindow)).click();
	  	new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(Pictures_uploadbutton));
	  }
	    
	 public void middlechatpane_upload_select_requriedfiletype(WebElement Typeoffile)
	 {
		
		 new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Typeoffile)).click();
	 }
	
	 public void selectfile_uploadpopupwindow_for_rename(int i)
	 {
		 new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//p[@id='upimg_container']/div/img[@class='orientation-2'])["+i+"]")))).click();
	 }
	 
	  public void Rename_uploadfilename_popup(String sentrename_whileuploadingfile)
	  {  
	  	 WebDriverWait uploadwindowrename_startupload=new WebDriverWait(driver, 10);
	  	 uploadwindowrename_startupload.until(ExpectedConditions.visibilityOf(Renamefile_Whileuploading)).clear();
	  	 uploadwindowrename_startupload.until(ExpectedConditions.visibilityOf(Renamefile_Whileuploading)).sendKeys(sentrename_whileuploadingfile);
	     Logs.info("Renamed perfrom successfully and filename sent is:"+sentrename_whileuploadingfile);
	  }
	 public void click_upload_ucc()
	 {
		 new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(uploadbutton_uploadpopup_window)).click();
		 Logs.info("Uploading started clicked on upload button");
	 }
	  
	  public static String middlechatuploadingfilename;
	  public  void  uploading_file_name_middelchat_window()
	  {   Logs.info("file name taken started");
	  
	    WebDriverWait file=new WebDriverWait(driver, 20);
	    file.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='uploadBarMain']"), "style", ""));
	    file.until(ExpectedConditions.visibilityOf(uploadingfilename));
	    System.out.println("file name is taken");
	  	String filename=uploadingfilename.getText();
	  	String trimminguploadingtext=filename.replace("Uploading.. ","");
	  	System.out.println("inial value is :"+filename);
	  	middlechatuploadingfilename=trimminguploadingtext;
	  	System.out.println("uploading file name is "+middlechatuploadingfilename);
	  	new WebDriverWait(driver, 100).until(ExpectedConditions.attributeContains(By.xpath("//div[@class='uploadBarMain']"), "style", "display: none;"));
	  	Logs.info("attachment uploaded successfully in middle chat window");
	  }
	  public void upload_imagesucess(String uploadingfilename){
	  	new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='filenameInfo']/span[@title='"+uploadingfilename+"']"))));
	  }

	  public  void select_curect_image(String imagename,String filetype)
	  {
	  	WebDriverWait attachment=new WebDriverWait(driver, 30);
	  	 String takeuid=attachment.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@msg,'"+imagename+"')]")))).getAttribute("uuid");
	  	attachmentuuid=takeuid;
	  	 
	  	 /* *if (filetype.contains("photo")) {
	  		attachmentuuid=takeuid;
	  		Logs.info("[UUId for attachemnt is]"+attachmentuuid);
		} else if(filetype.contains("textfile")) 
		{
           TextFileUuid=takeuid;
           Logs.info("[UUId for text is]"+TextFileUuid);
		}
		else if (filetype.contains("Audiofile"))
		{
		  AudioFileUuid=takeuid;
		  Logs.info("[UUId for audio is]"+AudioFileUuid);
		}
		else if(filetype.contains("College") || filetype.contains("second"))
		{
			CollegeUuid=takeuid;
			Logs.info("[UUId for college is]"+CollegeUuid);
		}*/
	  	 
	  	Logs.info("!!!!!!!!!!!!!!!!!!!!!!!!!! Attachment UUID id :"+attachmentuuid+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	  }
	    
	public void Plusicon_Click_Recents()
	{
		Logs.info("[Plusicon_Click_Recents]  Started...");
		WebDriverWait plus=new WebDriverWait(driver, 15);
		plus.until(ExpectedConditions.elementToBeClickable(plussbutton_recents)).click();
		plus.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='plusIconpp']/ul/li"))));
		Logs.info("[Plusicon_Click_Recents]  Done... and List Came");
	}
	public void Click_Createteam()
	{
       List <WebElement> PlusButtonActions=driver.findElements(By.xpath("//div[@id='plusIconpp']/ul/li"));
       int SizeofPlusActions=PlusButtonActions.size();
       System.out.println("Size is :"+SizeofPlusActions);
       for (int i = 0; i <SizeofPlusActions; i++) 
       {
		WebDriverWait pwait=new WebDriverWait(driver,10);
		String PlusList=pwait.until(ExpectedConditions.visibilityOfAllElements(PlusButtonActions)).get(i).getText();
		System.out.println("Test in Plus is:"+PlusList);
		if (PlusList.equals("Create Team")) 
		{
			pwait.until(ExpectedConditions.visibilityOfAllElements(PlusButtonActions)).get(i).click();
			Logs.info("[Click_Createteam].. Clicked");
			break;
		} 
		else 
		{
			System.out.println("Not came trying other");
		}
       }
	//	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(Createteam_Click)).click();
	}
	
	public void TeamCreation_page_loading_wait()
	{
		WebDriverWait creationpage_completeloading_wait=new WebDriverWait(driver, 30);
		creationpage_completeloading_wait.until(ExpectedConditions.visibilityOf(EnterTeamame));
		creationpage_completeloading_wait.until(ExpectedConditions.visibilityOf(Findbutton_Teamcreationpage));
		//creationpage_completeloading_wait.until(ExpectedConditions.visibilityOf(createteam_click));
	}
	
	
	public void OpenTeamUserContactstab(String TeamName)
	{
		Logs.info("[OpenTeamUserContactstab]... Started...");
		WebDriverWait TeamdisplayWait=new WebDriverWait(driver, 10);
		TeamdisplayWait.until(ExpectedConditions.visibilityOf(RecentsButton)).click();
		TeamdisplayWait.until(ExpectedConditions.visibilityOf(recents_searchbar));
		TeamdisplayWait.until(ExpectedConditions.visibilityOf(contacts_tabbutton)).click();
		//this.contacts_tabbutton.click();
		TeamdisplayWait.until(ExpectedConditions.visibilityOf(searchbar_contcatstab)).clear();
		this.searchbar_contcatstab.sendKeys(TeamName);
		TeamdisplayWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@fname='"+TeamName+"' and @style='']")))).click();
		Logs.info("[OpenTeamUserContactstab]... Ended...");
	}
	
	public void TeamStreamDetailedpanel(String TeamName)
	{
		WebDriverWait TeamDeatil=new WebDriverWait(driver, 10);
		
		TeamDeatil.until(ExpectedConditions.visibilityOf(streamdetailedpanel_middlechat));
	   	String panelposition=this.streamdetailedpanel_middlechat.getAttribute("class");
	 
	 	if (panelposition.contains("streamDetails activeStatus"))
	 	{
	 		Logs.info("[TeamStreamDetailedpanel] stream detail panel is opened and class attribute is:"+panelposition);
	 	} 
	 	else if(panelposition.contains("streamDetails")) 
	 	{    
		Logs.info("[TeamStreamDetailedpanel] Stream detail panel is not opened hence opening and class attribute is:"+panelposition);
    
		this.streamdetailedpanel_middlechat.click(); 
		TeamDeatil.until(ExpectedConditions.attributeContains(streamdetailedpanel_middlechat, "class", "streamDetails activeStatus"));
		TeamDeatil.until(ExpectedConditions.visibilityOf(Pinneditemsbar_rightsidepanel));
		Logs.info("[TeamStreamDetailedpanel] Right side panel is opened and pinned items section is displayed");  
	 	}
	 	TeamDeatil.until(ExpectedConditions.textToBe(By.id("middle_chatwin_container_chattername"), TeamName));
	 	Logs.info("[TeamStreamDetailedpanel] Ended");
	}
	public static String TeamMembersvalidation_TeaminfoPage_andGetID(String TeamMemberName)
	{
		WebDriverWait MemberWait=new WebDriverWait(driver, 10);
		Actions act=new Actions(driver);
		act.moveToElement(MemberWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='team_members_info']//*[@class='ShowArea']//div[@uid='"+TeamMemberName+"' and @style='']")))));
		String GetteamMemberID=driver.findElement(By.xpath("//div[@id='team_members_info']//*[@class='ShowArea']//div[@uid='"+TeamMemberName+"' and @style='']")).getAttribute("id");
		Logs.info("[TeamMembersvalidation_TeaminfoPage] identified user is:"+TeamMemberName+" and id is :"+GetteamMemberID);
		return GetteamMemberID;

	}
	
	public void properTeamOpenedOrNot(String Teamname)
	{
		WebDriverWait middlechatteamname=new WebDriverWait(driver, 10);
		middlechatteamname.until(ExpectedConditions.textToBe(By.xpath("//div[@class='teamName']/div/span"), Teamname));
		
	}
	public void AdminorNot(String TeamMember)
	{
		
	}
	public void MoreOptions_on_TeamMember(String TeamMember)
	{
		if (TeamMember.equals(CurrentLoggedin_User())) 
		{
		Logs.info("[MoreOptions_on_TeamMember].. Moreaction notwork on admin");		
		}
		else
		{
			Actions act=new Actions(driver);
			WebDriverWait more=new WebDriverWait(driver, 10);
			WebElement Moreoptions=driver.findElement(By.xpath("//*[@id='"+TeamMembersvalidation_TeaminfoPage_andGetID(TeamMember)+"']//*[@class='MoreOptions']"));
			Logs.info("[MoreOptions_on_TeamMember]  id of user is :"+TeamMembersvalidation_TeaminfoPage_andGetID(TeamMember));
		//	WebElement Moreoptions=driver.findElement(By.xpath("//a[contains(@onclick,'"+TeamMember+"')]"));
		//	act.moveToElement(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@onclick,'"+TeamMember+"')]"))))).click().build().perform();
		//	this.typemessagefield.click();
			/*act.moveToElement(more.until(ExpectedConditions.visibilityOf(Moreoptions)));
			act.moveToElement(Moreoptions).click().build().perform();
			more.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(@id,'make_admin_') and contains(@onclick,'"+TeamMember+"')]"))));*/
			act.moveToElement(more.until(ExpectedConditions.elementToBeClickable(Moreoptions))).click().build().perform();
			String mkaetadminIDtrim=TeamMembersvalidation_TeaminfoPage_andGetID(TeamMember).substring(0,TeamMembersvalidation_TeaminfoPage_andGetID(TeamMember).indexOf("_"));
			Logs.info("[[MoreOptions_on_TeamMember].. Whole id is :"+TeamMembersvalidation_TeaminfoPage_andGetID(TeamMember)+" after trim is :"+mkaetadminIDtrim);
			
			//more.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='make_admin_"+mkaetadminIDtrim+"_"+TeamMember+"'][@name='make_team_admin_option']")));
		//	more.until(ExpectedConditions.elementToBeClickable(By.id("'make_admin_"+mkaetadminIDtrim+"_"+TeamMember+"'")));
		//	more.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='make_admin_"+mkaetadminIDtrim+"_"+TeamMember+"']")));
			
			//more.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#make_admin_"+mkaetadminIDtrim+"_"+TeamMember+"")));
			Logs.info("[MoreOptions_on_TeamMember] done :"+TeamMember);
		}	
	}
	public void MakeTeam_Admin(String OtherAdminUsername,String teamName)
	{
		Logs.info("[MakeTeamAdmin]...Started ..");
		WebDriverWait admin=new WebDriverWait(driver, 20);
		if (OtherAdminUsername.equals(CurrentLoggedin_User())) 
		{
			Logs.info("[MakeTeamAdmin] can't make team admin as again team admin");
		} 
		else 
		{
			Logs.info("[MakeTeamAdmin]Making Started:"+OtherAdminUsername);
		//	this.MoreOptions_on_TeamMember(OtherAdminUsername);
			/*Actions act=new Actions(driver);
			act.moveToElement(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@onclick,'"+OtherAdminUsername+"')]"))))).click().build().perform();*/
		//	admin.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(@id,'make_admin_') and contains(@onclick,'"+OtherAdminUsername+"')]")))).click();
			String mkaetadminIDtrim=TeamMembersvalidation_TeaminfoPage_andGetID(OtherAdminUsername).substring(0,TeamMembersvalidation_TeaminfoPage_andGetID(OtherAdminUsername).indexOf("_"));
			Logs.info("[[MoreOptions_on_TeamMember].. Whole id is :"+TeamMembersvalidation_TeaminfoPage_andGetID(OtherAdminUsername)+" after trin is :"+mkaetadminIDtrim);
			admin.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='make_admin_"+mkaetadminIDtrim+"_"+OtherAdminUsername+"'][@name='make_team_admin_option']"))).click();
			//admin.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='OK']")))).click();
			admin.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='make_admin_"+mkaetadminIDtrim+"_"+OtherAdminUsername+"']"))).click();
			admin.until(ExpectedConditions.visibilityOf(typemessagefield));
			this.OpenTeamUserContactstab(teamName);
			this.TeamStreamDetailedpanel(teamName);
			admin.until(ExpectedConditions.visibilityOf(typemessagefield));
			admin.until(ExpectedConditions.textToBe(By.xpath("//*[@id='"+TeamMembersvalidation_TeaminfoPage_andGetID(OtherAdminUsername)+"']//*[@class='userType']"), "Team Admin"));
			/*this.contacts_tabbutton.click();
			this.searchbar_contcatstab.clear();
			this.searchbar_contcatstab.sendKeys(teamName);
			admin.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@fname='"+teamName+"' and @style='']")))).click();*/	
		//	admin.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//div[@id='team_members_info']//*[@class='ShowArea']//div[@uid='"+OtherAdminUsername+"' and @style='']")), "admin", "1"));
		//	admin.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//a[contains(@onclick,'"+OtherAdminUsername+"')]"))));
			admin.until(ExpectedConditions.attributeContains(driver.findElement(By.id(""+TeamMembersvalidation_TeaminfoPage_andGetID(OtherAdminUsername)+"")), "admin", "1"));
			admin.until(ExpectedConditions.visibilityOf(typemessagefield));
			Logs.info("[MakeTeamAdmin]... Ended ");
		}
		
	}

	public void RemoveFromTeam(String UsreaName,String teamName)
	{
		Logs.info("[RemoveFromTeam]..Started..");
		WebDriverWait Remove=new WebDriverWait(driver, 20);
	try {
		//	this.TeamStreamDetailedpanel(teamName);
			String id=TeamMembersvalidation_TeaminfoPage_andGetID(UsreaName);
		//	this.MoreOptions_on_TeamMember(UsreaName);
			Remove.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='menu_"+id+"_"+UsreaName+"']//*[@name='remove_frm_stream_option']"))).click();

			//	Remove.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(@onclick,'"+UsreaName+"') and @name='remove_frm_stream_option']")))).click();
			
			Remove.until(ExpectedConditions.textToBe(By.xpath("//div[@class='alertPopupMain']//*[@class='alertInfo']"), "Are you sure you want to remove the Team member?"));
			Remove.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='Yes']")))).click();
			Remove.until(ExpectedConditions.visibilityOf(typemessagefield));
			Logs.info("[RemoveFromTeam]..Ented Success..");
	} catch (Exception e) 
	{
		Logs.error("[RemoveFromTeam] fail due to detting this exception:"+e);
		e.printStackTrace();
	}
	}
	
  public void TeamTypeSelect(String Teamtype,String TeamAttribute,String HideMembersStatus)
  {
	  WebDriverWait TeamSelectWait=new WebDriverWait(driver, 15);
	  
	  if (Teamtype.toLowerCase()=="display") 
	  {
		  TeamSelectWait.until(ExpectedConditions.visibilityOf(Displayteam_radiobutton)).click();
		  this.Displayteam_radiobutton.isSelected();
	  } 
	  else if(Teamtype.toLowerCase()=="private")
	  {
		  TeamSelectWait.until(ExpectedConditions.visibilityOf(privatetamradio_button)).click();
		  this.privatetamradio_button.isSelected();
//		  switch(TeamAttribute)
//		  {  
//		  case "AnyUserCan":
//			  TeamSelectWait.until(ExpectedConditions.visibilityOf(privatetam_invitetype_dropdown));
//			  Select Attribute=new Select(privatetam_invitetype_dropdown);
//			  Attribute.selectByVisibleText("Any User Can Invite");
//		     break;
//		  case "Admin":
//			  TeamSelectWait.until(ExpectedConditions.visibilityOf(privatetam_invitetype_dropdown));
//			  Select Admin=new Select(privatetam_invitetype_dropdown);
//			  Admin.selectByVisibleText("Admin Only Invite");  
//			  break;
//		  }
////		  
	  }
	  else if(Teamtype.toLowerCase()=="company")
	  {
		  
	  }
	  else if(Teamtype.toLowerCase()=="public")
	  {
		  
	  }
  }
	
	
	
  public void sent_team_name(String Teamname)
  {
	  System.out.println("Team name in page is :"+Teamname);
	  WebDriverWait teamneamewait=new WebDriverWait(driver, 7);
	  teamneamewait.until(ExpectedConditions.visibilityOf(EnterTeamame));
	  this.EnterTeamame.clear();
	  this.EnterTeamame.sendKeys(Teamname);
	  teamneamewait.until(ExpectedConditions.visibilityOf(Createteam_Click)).click();
  }
  
  public void Click_team_type_radio_button(WebElement teamtyperadiobutton)
  {
	  WebDriverWait radiobutton=new WebDriverWait(driver, 7);
	  radiobutton.until(ExpectedConditions.visibilityOf(teamtyperadiobutton));
	  if (teamtyperadiobutton.isSelected()) 
	  {
        Logs.info("Team  type radio button is selected properly");		
	} else 
	{
		teamtyperadiobutton.click();  
		Logs.info("Requried team type is not selected hence click on radio button");
	}
  }
  
  public void addcontacts_search_teamcreationpage(String addusername)
  {
	  WebDriverWait adduser=new WebDriverWait(driver, 7);
	  adduser.until(ExpectedConditions.visibilityOf(Sentsuername_Teamcreation_page)).clear();
	  this.Sentsuername_Teamcreation_page.sendKeys(addusername);
	  WebElement selectusername=driver.findElement(By.id("contpp_chkbox_"+addusername+""));
	 // adduser.until(ExpectedConditions.visibilityOf(selectusername)).click();
	  if (selectusername.isSelected()) 
	  {
		 Logs.info("Requried added usr to team is checked ");
	 } 
	  else 
	  {
		selectusername.click();
		Logs.info("requried added user is not selected hence secting");
	}
  }
	public void Addcontact_validation_createpage(String addusername)
	{
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("conppbuddy_"+addusername+""))));
	}
	
	
	
	
	/**** Independet ULM Methods Starts Here **************/
	
	
	public String setIndependentULMURl(int Branding,String strNetwork)
	{
		
		if(strNetwork.equalsIgnoreCase("beta"))
		{
			String[] strBETAURLS={Constants.IDPStreamsBETAURL,Constants.IDPMcgrawBETAURL
					,Constants.IDpKonnectBETAdURL,Constants.IDPQuorumtechBETAURL} ;	
			
			return strBETAURLS[Branding];
		}
		else if(strNetwork.equalsIgnoreCase("dce") || strNetwork.equalsIgnoreCase("dcw"))
		{
			String[] strProductonURLS={Constants.IDPStreamsProdURL,Constants.IDPMcgrawProdURL
										,Constants.IDpKonnectProdURL,Constants.IDPQuorumtechProdURL} ;
			
			return strProductonURLS[Branding];
			
		}

		return null;
		
	}
	
	public String strSetDellearId(int Brandng ,String strNetwork)
	{
		if (strNetwork.equalsIgnoreCase("beta")) 
		{
			String[]  strbetnDellerids={"","/wholesale/5785","/wholesale/5783","/wholesale/2875"};	
			return strbetnDellerids[Brandng];
			
		} 
		else  
		{
			
		String[]  strProductionDellerids={"","/wholesale/3682","/wholesale/3817","/wholesale/2875"};
		return strProductionDellerids[Brandng];
			
		}
		
		
	}
	
	
	public boolean ISULMLogoDisplayed()
	{
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.attributeContains(ULMLOGO_LoginPage, "src", "/auth/images/ulm-heading.png"));
			return true;
		} catch (Exception e) {
			System.out.println(" ULLM logo is not Displaying getting src attribute from Locator Src=="+ULMLOGO_LoginPage.getAttribute("src"));
			return false;
		}
		
		
	}
	
	public boolean ISLogos_validation(String strRightsside,String strLeftSide)
	{
		String LeftSideAttributeSrc=LeftSideLogo.getAttribute("src").trim();
		String RightSideAttributeSrc=RightSideLogo.getAttribute("src").trim();
		System.out.println("LeftSideAttributeSrc=="+LeftSideAttributeSrc+" and RightSideAttributeSrc=="+RightSideAttributeSrc);
		if(RightSideAttributeSrc.contains(strRightsside) &&LeftSideAttributeSrc.contains(strLeftSide))
		{
		
			return true; 
		}
		else 
		{
			return false;
		}
	}
	
	
	public boolean IndependentULM_CopyRights_validation(String strLocation,int Branding,String strNetwork)
	{
		String strExpectedCopyRights=null;
		String strActualCopyRights = null;
		
//		switch (strLocation.toLowerCase()) {
//		case "login":
//			strActualCopyRights=LoginPageCopyRIghts.getText().trim();
//			break;
//		case "forgot":
//			strActualCopyRights=ForgotPasswordCopyRight.getText().trim();
//			break;
//		case "home":
//			
//			strActualCopyRights=IDPHomePage_CopyRights.getText().trim();
//			
//			break;
//		default:
//			strActualCopyRights="Default";
//			break;
//		}
		
		if(strNetwork.equalsIgnoreCase("beta"))
		{
			String[] strExpectedCopyRightsBeta={Constants.strCopyRight_Sterams_Beta,Constants.strCopyRight_Mcgraw_Beta,
					Constants.strCopyRight_Konnect_Beta,Constants.strCopyRight_Quorumtech_Beta};
			strExpectedCopyRights=strExpectedCopyRightsBeta[Branding];
			if(Branding==0 && strLocation.equalsIgnoreCase("home"))
			{
				strExpectedCopyRights=strExpectedCopyRights.replace(UDF_All_Methods.strCurrentYear(), "2007-"+UDF_All_Methods.strCurrentYear());
			}
			else if(Branding==2 && strNetwork.equalsIgnoreCase("beta"))
			{
				strExpectedCopyRights=strExpectedCopyRights.replace(UDF_All_Methods.strCurrentYear(), "2002-"+UDF_All_Methods.strCurrentYear());
			}
		}
		else
		{
		String[] strExpectedCopyRightsBeta={Constants.strCopyRight_Sterams_Productioon,Constants.strCopyRight_Mcgraw_Productioon,
								Constants.strCopyRight_Konnect_Productioon,Constants.strCopyRight_Quorumtech_Productioon};
		strExpectedCopyRights=strExpectedCopyRightsBeta[Branding];
		}
		
		System.out.println("strExpectedCopyRights "+strLocation+"=="+strExpectedCopyRights);
		//--- Copy Rights Compare Code----//
		if(strActualCopyRights.contains(strExpectedCopyRights))
		{
			return true;
		}
		else
		{
			System.out.println("Copy Rights not matched  Actual=="+strActualCopyRights+". Expected=="+strExpectedCopyRights);
			return false;
		}
		
		
		
	}
	
	
	
	
	public boolean IsIndependetULMPageTittle(int Branding)
	{
		System.out.println("Getting Page Tittle======"+driver.getTitle());
		String[] strpageTittle={"Streams","InPacket","Konnect","WorldSmart"};
		String strKeyFeaturesText=ULMKeyFeaturesHeading.getText().trim();
		System.out.println("strKeyFeaturesText=="+strKeyFeaturesText);
		if(driver.getTitle().equals(strpageTittle[Branding]) && strKeyFeaturesText.equals(""+strpageTittle[Branding]+" key features include:"))
		{
			return true;
		}
		else
		{
			System.out.println("Failed Page tittle validation Obtained=="+driver.getTitle()+" Expected=="+strpageTittle[Branding]);
			return false;
		}
	}
	
	public void setPrivacyPlocyLink(int Branding,String strNetwork)
	{
		
		driver.navigate().to(setIndependentULMURl(Branding, strNetwork));
		CommonWaitofElement(PrivacyPolicy_Link, 15, 0);
		String strGethref=PrivacyPolicy_Link.getAttribute("href");
		driver.navigate().to(strGethref);
	}
	
	
	public void setForgotpasswordPage()
	{
		CommonWaitofElement(ForgotPasswordPage, 15, 2);
		this.ForgotPasswordPage.click();
		CommonWaitofElement(Forgotpasswrodpage_UsernameField, 20, 1);
	}
	
	public void setIndependentUMHoneLink()
	{
	
		CommonWaitofElement(HomeLink_ForgotpasswordPage, 15, 1);
		this.HomeLink_ForgotpasswordPage.click();
		CommonWaitofElement(LeftSideLogo, 15, 0);
		CommonWaitofElement(RightSideLogo, 15, 0);
	}
	
	
	public void setIndependentULMLoginPage()
	{
		CommonWaitofElement(LeftSideLogo, 10, 0);
		CommonWaitofElement(RightSideLogo, 15, 0);
		CommonWaitofElement(LoginPageCopyRIghts, 10, 0);
		System.out.println("----------- Success Login page Loaded-----------");
	}
	
	
	public void setLoginUserintoIndependentULM(int Branding,String strNetwork)
	{
		driver.navigate().to(setIndependentULMURl(Branding, strNetwork));
		this.CommonWaitofElement(username, 15, 1);
		this.CommonWaitofElement(password, 15, 1);
		this.CommonWaitofElement(Loginbuton_IDPULM, 15, 1);
		
		String strUsername=null;
		String strPassword="abc@1234";
		if(strNetwork.equalsIgnoreCase("beta"))
		{
			String[] strusername={"balasms@security","bala@mcgraw.test","bala@kumo.test","bala@quorumtech.test"};
			strUsername=strusername[Branding];	
		}
		else 
		{
			if(strNetwork.toLowerCase().equalsIgnoreCase("dce"))
			{
				strUsername="bala@add.mlb";
			}
			else if(strNetwork.equalsIgnoreCase("dcw"))
			{
				strUsername="pavan@accountvalidation";
			}
			String[] strusername={strUsername,"bala@mcgraw.test","bala@kumo.test","bala@quorumtech.test"};
			strUsername=strusername[Branding];
		}
		
		username.clear();
		username.sendKeys(strUsername);
		password.click();
		password.sendKeys(strPassword);
		Loginbuton_IDPULM.click();
	}
	
	public void setIndependentULMLodaingWait()
	{
		new WebDriverWait(driver, 100).until(ExpectedConditions.attributeContains(By.id("pgload_indicator"), "style", "display: none"));
		CommonWaitofElement(QueueFilter, 15, 0);
	}
	
	public boolean IndependentULM_HomePage_Logo_Branding(String strDellerid)
	{
		String strSrc=IDPHomePage_Logs.getAttribute("src");
		
		return strSrc.contains(strDellerid) && driver.getCurrentUrl().contains("/sloader/home.jsp") ? true:false;
		/*if(strSrc.contains(strDellerid) && driver.getCurrentUrl().contains("/sloader/home.jsp"))
		{
			return true;
		}
		else
		{
			System.out.println("IndependentULM_HomePage_Logo_Branding  Not mactched Actual=="+strSrc+" Expected ID="+strDellerid);
			return false;
		}*/
	}
	
	
	
	public  String IndependentUM_HomePage_PolicyLink()
	{
		
		CommonWaitofElement(PrivacyPolicy_Link,15,0);
		return PrivacyPolicy_Link.getAttribute("href");
		
	}
	
	public void setIndependentUMSignout() throws Exception
	{
		CommonWaitofElement(menubutton, 15, 0);
		this.menubutton.click();
		CommonWaitofElement(logoutbutton, 15, 0);
		logoutbutton.click();
//		SessionId session = ((RemoteWebDriver) driver).getSessionId();
//  		System.out.println("session Signoutpage=="+session);
  		 Thread.sleep(5000);
  		

	}
	
	
	public boolean IDPSignoutPage_validation(int Branding) throws Exception
	{
		System.out.println("page Tittle==="+driver.getTitle());
		System.out.println("Current URL=="+driver.getCurrentUrl());
		boolean ElementDisplayStatus=false;
		WebElement[] Element={ULMLOGO_LoginPage,BCMLogo_LogoutPage,KumoLogo_LogoutPage,username,};
		String[] strpageTittle={"Streams","Home - BCM One",
							"Cloud Services, IT Managed Services, VoIP Solutions "
							+ "- Irvine, Lake Forest, Santa Ana | Kumo","WorldSmart"};
		
		System.out.println("page Tittle==="+driver.getTitle());
		System.out.println("Current URL=="+driver.getCurrentUrl());
		/*SessionId session = ((RemoteWebDriver) driver).getSessionId();
 		 System.out.println("session =="+session);
		try 
		{
			System.out.println("ElementDisplayStatus=== cameee");
//			driver.navigate().to(driver.getCurrentUrl());
//			System.out.println("navigate Success");
			Thread.sleep(3000);
			ElementDisplayStatus=Element[Branding].isDisplayed();
			System.out.println("ElementDisplayStatus==="+ElementDisplayStatus);
		} 
		catch (Exception e) {
			Logs.error("LogoutPgae validation fail Due to :"+e+"\n");
			return false;
		}
		*/
		if(driver.getTitle().equals(strpageTittle[Branding]) && Element[Branding].isDisplayed()==true)
		{
			return true;
		}
		return false;
	}
	
	/****
	 * @author Bala Pavan
	 * ULM PO Begins from Here
	 */
	
	public static final String attrStyle="style";
	public static final String strHideatt="display: none;";
	public static final String strShowAtt="";
	public static final String AllQueuesText="All Queues";
	public static final String PerQueueText="Per Queue";
	
	
	public static void ULMLoadingWait()
	{
		WebDriverWait ULM=new WebDriverWait(driver, 60);
		ULM.until(ExpectedConditions.attributeContains(By.id("pgload_indicator"), attrStyle, strHideatt));
		ULM.until(ExpectedConditions.visibilityOf(QueueFilter));
		System.out.println("ULM Loaded Properly.");
		
	}
	

	public static void setQueueFilterbutton()
	{
		WebDriverWait queue=new WebDriverWait(driver, 15);
		queue.until(ExpectedConditions.elementToBeClickable(QueueFilter));
		if(QueueFilter_POPUp.getAttribute(attrStyle).contains(strHideatt))
		{
			QueueFilter.click();
			queue.until(ExpectedConditions.attributeToBe(QueueFilter_POPUp, attrStyle, strShowAtt));		
			queue.until(ExpectedConditions.elementToBeClickable(QueueFilter_SearchField));
			queue.until(ExpectedConditions.elementToBeClickable(QueueFilter_SaveButton));
			queue.until(ExpectedConditions.elementToBeClickable(QueueFilter_SelectALlCheckBox));
		}
		System.out.println("[setQueueFilterbutton] Completed.");
	}
	
	public static void setCheckQueue_Search(String strQueueName)
	{
		WebDriverWait check=new WebDriverWait(driver, 30);
		check.until(ExpectedConditions.elementToBeClickable(QueueFilter_SearchField)).clear();
		QueueFilter_SearchField.sendKeys(strQueueName);	
	}
	
	public static void SetCheckQueue(String strQueueName)
	{
		WebElement QueueCheckbox=driver.findElement(By.xpath("//li[@id='li_qfilter_"+strQueueName+"']/span[@id='"+strQueueName+"']"));
		WebDriverWait check=new WebDriverWait(driver, 10);
		check.until(ExpectedConditions.elementToBeClickable(QueueCheckbox));
		String strClass=QueueCheckbox.getAttribute("class");
		if(strClass.contains("checkbox_unchecked"))
		{
			QueueCheckbox.click();
			check.until(ExpectedConditions.attributeContains(QueueCheckbox, "class", "checkbox_checked"));
		}
	}
	
	public static void setQueueFilter_SaveButton() throws InterruptedException
	{
		WebDriverWait savebt=new WebDriverWait(driver, 10);
		savebt.until(ExpectedConditions.elementToBeClickable(QueueFilter_SaveButton)).click();
		savebt.until(ExpectedConditions.attributeToBe(QueueFilter_POPUp, attrStyle, strHideatt));
	}
	
	public static void SetQueueDivListLoading(boolean isACDEnabled)
	{
		WebDriverWait queueDiv=new WebDriverWait(driver, 60);
		if(isACDEnabled==true)
		{
		queueDiv.until(ExpectedConditions.attributeToBe(ULM_groups_Enabled, attrStyle, strShowAtt));
		queueDiv.until(ExpectedConditions.attributeToBe(ViewFilterButton, attrStyle, "cursor: pointer;"));
		queueDiv.until(ExpectedConditions.elementToBeClickable(ViewFilterButton));
		queueDiv.until(ExpectedConditions.visibilityOf(individualQueuesCollapseButton));
		queueDiv.until(ExpectedConditions.visibilityOf(QueueViewText_Middle1));
		setShowULM_Detailedpanel_Button();
		System.out.println("[SetQueueDivListLoading] All are loaded Properly");
		}
		else
		{
			queueDiv.until(ExpectedConditions.attributeToBe(ULM_groups_Enabled, attrStyle, strHideatt));
			queueDiv.until(ExpectedConditions.visibilityOf(NOACDorHuntEnabledMessage));
			queueDiv.until(ExpectedConditions.attributeToBe(ViewFilterButton, attrStyle, "cursor: pointer; display: none;"));
			System.out.println("[SetQueueDivListLoading ]All ACD Groups are Hide Done Properly..");
		}
		
	}
	
	public static void setShowULM_Detailedpanel_Button()
	{
		WebDriverWait detailed=new WebDriverWait(driver, 40);
		detailed.until(ExpectedConditions.visibilityOf(ULM_DetailedPanelButton));
		String strAttribute=ULM_DetailedPanelButton.getAttribute("class");
		if(strAttribute.equals("streamDetails"))
		{
			ULM_DetailedPanelButton.click();
			detailed.until(ExpectedConditions.attributeToBe(ULM_DetailedPanelButton, "class", "streamDetails activeStatus"));
		}
	}
	
	public static void SetSelectAll_Queues() throws Exception
	{
		WebDriverWait selectall=new WebDriverWait(driver, 10);
		selectall.until(ExpectedConditions.visibilityOf(QueueFilter_SelectALlCheckBox));
		String strisselected=QueueFilter_SelectALlCheckBox.getAttribute("class");
		if (!(strisselected).contains("checkbox_checked")) {
			QueueFilter_SelectALlCheckBox.click();
			selectall.until(ExpectedConditions.attributeContains(QueueFilter_SelectALlCheckBox, "class", "checkbox_checked"));
			setQueueFilter_SaveButton();
			System.out.println("[SetSelectAll_Queues].. Now selected All ..");
		}
		else if((strisselected).contains("checkbox_checked"))
		{
			System.out.println("[SetSelectAll_Queues] Already Selected..");
		}
	}
	
	public static void setUnCheck_AllQueuesCheckBox() throws Exception
	{
		WebDriverWait selectall=new WebDriverWait(driver, 10);
		selectall.until(ExpectedConditions.visibilityOf(QueueFilter_SelectALlCheckBox));
		String strisselected=QueueFilter_SelectALlCheckBox.getAttribute("class");
			
		if (strisselected.contains("checkbox_checked")) 
			{
				QueueFilter_SelectALlCheckBox.click();
				selectall.until(ExpectedConditions.attributeContains(QueueFilter_SelectALlCheckBox, "class", "checkbox_unchecked"));
				System.out.println("[SetSelectAll_QueueFilter_Checkbox] Un Check done ");
			}
			else 
			{
				QueueFilter_SelectALlCheckBox.click();
				Thread.sleep(1000);
				QueueFilter_SelectALlCheckBox.click();
				selectall.until(ExpectedConditions.attributeContains(QueueFilter_SelectALlCheckBox, "class", "checkbox_unchecked"));
				System.out.println("[SetSelectAll_QueueFilter_Checkbox] Selected and De Selected done ");
			}
		
	}
	
	/*** TO validate Selected ACD Group Visible in RIght Side or not **/
	public static boolean isACDQueueDisplayed_RightSide(String strQueueNmae)
	{
		try
		{
		WebDriverWait savebt=new WebDriverWait(driver, 10);
		savebt.until(ExpectedConditions.visibilityOfAllElements(rightSideQueuename));
		int size=rightSideQueuename.size();
		for(int i=0;i<size;i++)
		{
			String strgroupName=rightSideQueuename.get(i).getText();
			if(strgroupName.toLowerCase().equals(strgroupName))
			{
				return true;
			}
		}
		return false;
		}
		catch (Exception e) 
		{
			System.out.println("[isACDQueueDisplayed_RightSide] Failed. "+strQueueNmae);
			return false;
		}
	}
	
	public static String getQueueType(String strQueuename)
	{
		WebDriverWait queuetype=new WebDriverWait(driver, 20);
		WebElement queueelement=driver.findElement(By.xpath("//span[contains(@title,'"+strQueuename+"')]"));
		String strQueuetype=queuetype.until(ExpectedConditions.visibilityOf(queueelement)).getText();
			if(strQueuetype.contains("[NONACD]"))
			{
				return "hunt";
			}
			else if(strQueuetype.contains("[ACD]"))
			{
				return "acd";
			}
		return null;
	}
	
	public static boolean isQueueSelected_QueueFilter(String strQueueName)
	{
		setQueueFilterbutton();
		WebDriverWait queue=new WebDriverWait(driver, 15);
		String QueueCheck=queue.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@id='li_qfilter_"+strQueueName+"']/span[@id='"+strQueueName+"']")))).getAttribute("class");
		if(QueueCheck.contains("checkbox_checked"))
		{
			return true;
		}
		return false;
	}
	
	public static void setViewFilterButton()
	{
		WebDriverWait view=new WebDriverWait(driver, 10);
		view.until(ExpectedConditions.elementToBeClickable(ViewFilterButton));
		if(ViewFilterPOPupDiv.getAttribute(attrStyle).contains(strHideatt))
		{
			ViewFilterButton.click();
			view.until(ExpectedConditions.attributeToBe(ViewFilterPOPupDiv, attrStyle, strShowAtt));
			view.until(ExpectedConditions.elementToBeClickable(ViewFilter_AllQueueRadioButton));
//			view.until(ExpectedConditions.elementToBeClickable(ViewFilter_PerQueueRadioButton));
//			view.until(ExpectedConditions.elementToBeClickable(ViewFilter_Loggedin_Checkbox));
//			view.until(ExpectedConditions.elementToBeClickable(ViewFilter_CallsinQueue_CheckBox));
//			view.until(ExpectedConditions.elementToBeClickable(ViewFilter_ActiveCalls_CheckBox));
//			view.until(ExpectedConditions.elementToBeClickable(ViewFilter_LogoutAgents_CheckBox));
		}
		System.out.println("[setViewFilterButton] Completed");
	}
	
	/** Viewfilter Icon Dynamci Change ***/
	public static String IsAllFiltersSelected_Filteriocnchange()
	{
		setViewFilterButton();
		WebDriverWait view=new WebDriverWait(driver, 10);
		List<WebElement> Filters=driver.findElements(By.xpath("//div[@id='filterPopup_ULM']//span[contains(@id,'_filter')]"));
		view.until(ExpectedConditions.visibilityOfAllElements(Filters));
		for(int i=0;i<Filters.size();i++)
		{
			String strisShow=Filters.get(i).getAttribute("value");
			if(strisShow.equals("0"))
			{
				view.until(ExpectedConditions.attributeToBe(ViewFilterButton, "class", "filteroptionFilter"));
				return "0";
			}
		}
		view.until(ExpectedConditions.attributeToBe(ViewFilterButton, "class", "filteroption"));
		return "1";
	}
	
	
	public static void setSaveButton_ViewFilter() throws Exception
	{
		WebDriverWait view=new WebDriverWait(driver, 10);
		view.until(ExpectedConditions.elementToBeClickable(ViewFilter_SaveButton)).click();
		view.until(ExpectedConditions.attributeToBe(ViewFilterPOPupDiv, attrStyle, strHideatt));
		Thread.sleep(1500);
		System.out.println("[setSaveButton_ViewFilter] Completed");
	}
	
	public static void setAllQueueView_Filter()
	{
		WebDriverWait view=new WebDriverWait(driver, 10);
		view.until(ExpectedConditions.elementToBeClickable(ViewFilter_AllQueueRadioButton)).click();
	}
	public static void setPERQueueView_Filter()
	{
		System.out.println("[setPERQueueView_Filter].. Started..");
		WebDriverWait view=new WebDriverWait(driver, 10);
		view.until(ExpectedConditions.elementToBeClickable(ViewFilter_PerQueueRadioButton)).click();
	}
	public static boolean isRequriedQueueText(String strExpectedText)
	{
		WebDriverWait view=new WebDriverWait(driver, 15);
		String RightSideView=view.until(ExpectedConditions.visibilityOf(QueueViewText_RightSide)).getText();
		boolean middle1=view.until(ExpectedConditions.textToBePresentInElement(QueueViewText_Middle1, "ACD Activity - "));
		String MiddlePanelView=view.until(ExpectedConditions.visibilityOf(QueueViewText_Middle2)).getText();
		if(RightSideView==strExpectedText && middle1==true && MiddlePanelView==strExpectedText)
		{
			return true;
		}
		return false;
	}
	
	
	public static void SetRequriedViewType(String strViewType)
	{
		if(strViewType.toLowerCase().contains("all"))
			setAllQueueView_Filter();
  		else
  			setPERQueueView_Filter();
	}
	
	
	public static String getSelected_Queue_viewType()
	{
		setViewFilterButton();
		String strAll=ViewFilter_AllQueueRadioButton.getAttribute("value");
		System.out.println("[getSelected_Queue_viewType]--->"+strAll);
		if (strAll.equals("1")) 
		{
			return "All Queues";
		} 
		else
		{
			return "Per Queue";
		}
	}
	
	
	public static void setView_Options(WebElement OptionElement,String Value)
	{
		WebDriverWait liSc=new WebDriverWait(driver, 10);
		liSc.until(ExpectedConditions.visibilityOf(OptionElement));
		String getValue=OptionElement.getAttribute("value");
		if(!(getValue).equals(Value))
		{
			OptionElement.click();
			liSc.until(ExpectedConditions.attributeToBe(OptionElement, "value", Value));
		}
	}

	public static boolean isGetView_OptionsStatus(WebElement OptionElement,String Value)
	{
		WebDriverWait liSc=new WebDriverWait(driver, 10);
		liSc.until(ExpectedConditions.visibilityOf(OptionElement));
		String getValue=OptionElement.getAttribute("value");
		if(getValue.equals(Value))
		{
			return true;
		}
		return false;
	}
	
	public static boolean isOptionHide(List <WebElement> WebElement, String strHide_Show)
	{
		WebDriverWait liSc=new WebDriverWait(driver, 10);
		int Size=WebElement.size();
		for(int i=0;i<Size;i++)
		{
			boolean getValue=liSc.until(ExpectedConditions.attributeToBe(WebElement.get(i), attrStyle, strHide_Show));
			System.out.println("[isOptionHide]-------->"+getValue);
			if(getValue==false)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void setLoggedinAgentsSections(String strShowORhide)
	{
		WebDriverWait liSc=new WebDriverWait(driver, 10);
		liSc.until(ExpectedConditions.visibilityOfAllElements(LoggedinAgents_Label));
			for(int i=0;i<LoggedinAgents_Label.size();i++)
			{
				liSc.until(ExpectedConditions.attributeToBe(LoggedinAgents_Label.get(i), attrStyle, strShowORhide));
			}
	}
	
	
	/****
	 * Call Monitoring PO Starts From here
	 */

	public static void SetMoreoptionsButton()
	{
		WebDriverWait more=new WebDriverWait(driver, 10);
		if(More_Option_Div.getAttribute(attrStyle).equals(strHideatt))
		{
		more.until(ExpectedConditions.attributeToBe(More_Options_Button, "title", "More Options")); //Tool Tip validation
		more.until(ExpectedConditions.visibilityOf(More_Options_Button)).click();
	    more.until(ExpectedConditions.attributeToBe(More_Option_Div, attrStyle, strShowAtt));
	    more.until(ExpectedConditions.visibilityOf(ManageGroups_More_Option));
	    more.until(ExpectedConditions.visibilityOf(Refresh_More_Option));
		}
		 System.out.println("[SetMoreoptionsButton] More options DIv Loaded .");
	}
	
	public static boolean isSupervisor()
	{
		String isSupervisor=CallMonitoringForm_MoreOption_Button.getAttribute(attrStyle);
		if(isSupervisor.equals(strHideatt))
			return false;
		else if(isSupervisor.equals(strShowAtt))	
			return true;
		return false;	
	}
	
	public static void SetPhoneType_CallMonitoringForm(WebElement PhoneType)
	{
		System.out.println("[SetPhoneType_CallMonitoringForm] Received: :"+PhoneType);
		
		String strRadioButtonchecked="createTeam_Icons radio_checked";
		String strRadioButtonUNchecked="createTeam_Icons radio_unchecked";
		WebDriverWait setPhone=new WebDriverWait(driver, 15);
		setPhone.until(ExpectedConditions.visibilityOf(CallMonitoringForm_MoreOption_Button));
		Actions actPhone=new Actions(driver);
		actPhone.moveToElement(CallMonitoringForm_MoreOption_Button).perform();
		setPhone.until(ExpectedConditions.attributeToBe(phoneTypesDiv_CallMonitorOptions, attrStyle, strShowAtt));
		setPhone.until(ExpectedConditions.visibilityOf(SofTphoe_CallMonitoringForm));
		actPhone.moveToElement(PhoneType).click().build().perform();
		setPhone.until(ExpectedConditions.attributeToBe(PhoneType, "class", strRadioButtonchecked));
		WebElement[] phonetypes={SofTphoe_CallMonitoringForm,IP1_CallMonitoringForm,IP2_CallMonitoringForm};
		for(int i=0;i<phonetypes.length;i++)
		{
			if(phonetypes[i]!=PhoneType)
			{
//				System.out.println("[SetPhoneType_CallMonitoringForm] Element: : "+phonetypes[i]);
				setPhone.until(ExpectedConditions.attributeToBe(phonetypes[i], "class", strRadioButtonUNchecked));
			}
		}
	}
	
	public static int setPhonetypeValidation(WebElement phonetype)
	{
		String strClass=phonetype.getAttribute("class");
		if(strClass.equals("createTeam_Icons radio_checked"))
		{
			return 1;
		}
		return 0;
	}
	
	public static void setRefreshButton()
	{
		WebDriverWait refresh=new WebDriverWait(driver, 10);
		refresh.until(ExpectedConditions.visibilityOf(Refresh_More_Option)).click();
		System.out.println("[setRefreshButton] Refresh Button Click Done");
	}
	
	// ----ULM More options and call Monitoring form PO Ended---- //
	
	/**** Agents Login and logout PO Starts Here *****/
	public static int getLogged_IN_AgentsCount_AllQueues()
	{
		try
		{
		WebDriverWait loginwait=new WebDriverWait(driver, 10);
		loginwait.until(ExpectedConditions.visibilityOfAllElements(Logged_IN_AgentsDivs_AllQueues));
		return Logged_IN_AgentsDivs_AllQueues.size();
		}
		catch (Exception e) {
			System.out.println("[getLogged_IN_AgentsCount_AllQueues] Locator is not found hence Returing 0");
			return 0;
		}
	}
	
	public static int getLogged_OUT_AgentsCount_AllQueues()
	{
		try
		{
		WebDriverWait loginwait=new WebDriverWait(driver, 10);
		loginwait.until(ExpectedConditions.visibilityOfAllElements(Logged_OUT_AgentsDivs_AllQueues));
		return Logged_OUT_AgentsDivs_AllQueues.size();
		}
		catch (Exception e) {
			System.out.println("[getLogged_OUT_AgentsCount_AllQueues] Locator is not found hence Returing 0");
			return 0;
		}
	}
	
	public static int GetLogged_In_AgentsCount_AllQueues_Detailedpanel()
	{
		String strCoutText=Logged_IN_AgentesCount_DetailedPanel.getText().replaceAll("[^0-9]", "").trim();
		return Integer.parseInt(strCoutText);
	}
	
	public static int GetLogged_OUT_AgentsCount_AllQueues_Detailedpanel()
	{
		String strCoutText=Logged_OUT_AgentesCount_DetailedPanel.getText().replaceAll("[^0-9]", "").trim();
		return Integer.parseInt(strCoutText);
	}
	
	public static int GetLogged_In_AgentsCount_PerQueue(String strQueueName)
	{
		try
		{
		List<WebElement> LoggedinAgentesElement=driver.findElements(By.xpath("//div[@groupname='"+strQueueName+"']"));
		WebDriverWait loginwait=new WebDriverWait(driver, 10);
		loginwait.until(ExpectedConditions.visibilityOfAllElements(LoggedinAgentesElement));
		return LoggedinAgentesElement.size();
		}
		catch (Exception e) {
			System.out.println("[GetLogged_In_AgentsCount_PerQueue] Element not visible hence no agents hence returing 0");
			return 0;
		}
	}
	
	
	public static int GetLogged_OUT_AgentsCount_PerQueue(String strQueueName)
	{
		try{
		List<WebElement> LoggedOutAgentesElement=driver.findElements(By.xpath("//div[@name='"+strQueueName+"_ulm_buddies_lo'] "));
		WebDriverWait logOutwait=new WebDriverWait(driver, 10);
		logOutwait.until(ExpectedConditions.visibilityOfAllElements(LoggedOutAgentesElement));
		return LoggedOutAgentesElement.size();
		}
		catch (Exception e) {
			System.out.println("[GetLogged_OUT_AgentsCount_PerQueue] Element not visible hence no agents hence returing 0");
			return 0;
		}
	}
	
	public static int GetLogged_In_AgentsCount_PerQueues_Detailedpanel(String strQueuename)
	{
		WebElement LoggedinAgents=driver.findElement(By.id("ulm_li_cnt_span_"+strQueuename+""));
		String strCoutText=LoggedinAgents.getText().replaceAll("[^0-9]", "").trim();
		return Integer.parseInt(strCoutText);
	}
	
	public static int GetLogged_OUT_AgentsCount_PerQueues_Detailedpanel(String strQueuename)
	{
		WebElement LoggedinAgents=driver.findElement(By.id("ulm_lo_cnt_span_"+strQueuename+""));
		String strCoutText=LoggedinAgents.getText().replaceAll("[^0-9]", "").trim();
		return Integer.parseInt(strCoutText);
	}
	
	public static void setLoggedAgent_Click(String LoggedinAgentName)
	{
		WebElement LoggedinAgnetLocator=driver.findElement(By.xpath("//span[contains(@id,'"+LoggedinAgentName+"')][@class='ulmTimer']"));
		WebDriverWait LoggedinWait=new WebDriverWait(driver, 10);
		LoggedinWait.until(ExpectedConditions.visibilityOf(LoggedinAgnetLocator));
		LoggedinAgnetLocator.click();
	}
	
	public static void setLoggedOutAgent_Click(String LoggedOutAgentName)
	{
		WebElement LoggedOutAgent=driver.findElement(By.id("loggedOut_ULM_A_"+LoggedOutAgentName+"_username"));
		WebDriverWait LoggedinWait=new WebDriverWait(driver, 10);
		LoggedinWait.until(ExpectedConditions.visibilityOf(LoggedOutAgent));
		LoggedOutAgent.click();
	}
	
	public static String getLoggedAgent_IdelTimmer_AllQueues(String LoggedinAgentName)
	{
		WebElement LoggedinAgnetLocator=driver.findElement(By.id("showtimer_"+LoggedinAgentName+""));
		return LoggedinAgnetLocator.getText();
	}
	public static String getLoggedAgent_IdelTimmer_RespectiveQueues(String LoggedinAgentName,String Queuename)
	{
		WebElement LoggedinAgnetLocator=driver.findElement(By.id("showtimer_"+Queuename+"_"+LoggedinAgentName+""));
		return LoggedinAgnetLocator.getText();
	}
	
	public static boolean GetAgentLoginStatus_AllQueues(String strAgentName)
	{
		try
		{
		List<WebElement> User=driver.findElements(By.id("loggedIn_ULM_A_"+strAgentName+"_username"));
		WebDriverWait AgnetWait=new WebDriverWait(driver, 15);
		AgnetWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("loggedIn_ULM_A_"+strAgentName+"_username")));
		if(User.size()==1 && User.get(0).getAttribute("id").equals("loggedIn_ULM_A_"+strAgentName+"_username"))
		{
			System.out.println("[GetAgentLoginStatus_AllQueues] "+driver.findElement(By.id("showtimer_"+strAgentName+"")).getText());
			return true;
		}
		}
		catch(Exception e)
		{
			System.out.println("[GetAgentLoginStatus_AllQueues] unbale to Find agent in Logged Section Reson: "+e);
			return false;
		}
		return false;
	}
	
	/*** Below methods is for ALl Queues Click on Logout button Logged Agents section ****/
	public static void setLoginButton_AllQueues(String strAgentName)
	{
		WebDriverWait LogoutWait=new WebDriverWait(driver, 10);
		WebElement AgentLoginButton=driver.findElement(By.id("lo_acd_options_"+strAgentName+"_All Queues"));
		WebElement AgentLoginDiv=driver.findElement(By.id("showmenu_"+strAgentName+""));
		LogoutWait.until(ExpectedConditions.visibilityOf(AgentLoginButton));
		AgentLoginButton.click();
		LogoutWait.until(ExpectedConditions.elementToBeClickable(AgentLoginDiv));
		System.out.println("[setLoignButton_AllQueues] Succ!");
	}
	
	/*** Below method for ALl Queues Click on Login all from Loggedout section ****/
	public static void setLoginAll_AllQueues(String strAgentID)
	{
		WebDriverWait LogoutWait=new WebDriverWait(driver, 15);
		WebElement LoginAllButton=driver.findElement(By.xpath("//li[@id='menu_sub_login_this_"+strAgentID+"']/a[text()='Log In All']"));
		LogoutWait.until(ExpectedConditions.visibilityOf(LoginAllButton));
		LoginAllButton.click();
		LogoutWait.until(ExpectedConditions.presenceOfElementLocated(By.id("loggedIn_ULM_A_"+strAgentID+"_username")));
		System.out.println("[setLoginAll_AllQueues] Succ!");
	}
	
	/*** Below method for ALl Queues Click on PersistanceLogin_All from Loggedout section ****/
	public static void setPersistanceLogin_All_AllQueues(String strAgentID)
	{
		WebDriverWait LogoutWait=new WebDriverWait(driver, 10);
		WebElement perLoginButton=driver.findElement(By.xpath("//li[@id='menu_sub_login_this_"+strAgentID+"']/a[text()='Persistent Login']"));
		LogoutWait.until(ExpectedConditions.visibilityOf(perLoginButton));
		perLoginButton.click();
//		LogoutWait.until(ExpectedConditions.invisibilityOf(perLoginButton));
		System.out.println("[setPersistanceLogin_All_AllQueues] Succ!");
	}
	
	/*** Set Logout All button in All Queues Filter ****/
	public static void setLogoutButton_AllQueues(String strAgentName)
	{
		WebDriverWait LogoutWait=new WebDriverWait(driver, 10);
		WebElement AgentLoginButton=driver.findElement(By.xpath("//div[@id='li_acd_options_"+strAgentName+"_All Queues']//span[@title='Log Out']"));
		WebElement AgentLoginDiv=driver.findElement(By.id("showmenu_exit_"+strAgentName+""));
		LogoutWait.until(ExpectedConditions.visibilityOf(AgentLoginButton));
		AgentLoginButton.click();
		LogoutWait.until(ExpectedConditions.elementToBeClickable(AgentLoginDiv));
		System.out.println("[setLogoutButton_AllQueues] Succ!");
	}
	
	/*** Click logout all froom All Queues ****/
	public static void SetLogutAll_AllQueues(String strAgentID)
	{
		WebElement AgentLoginDiv=driver.findElement(By.id("showmenu_exit_"+strAgentID+""));
		AgentLoginDiv.click();
		WebDriverWait LogoutWait=new WebDriverWait(driver, 15);
		LogoutWait.until(ExpectedConditions.presenceOfElementLocated(By.id("loggedOut_ULM_A_"+strAgentID+"_username")));
		System.out.println("[SetLogutAll_AllQueues] Succ!");
	}
	
	public static void setSearchField_LoginDeatis(String strvalue)
	{
		WebDriverWait searchfield=new WebDriverWait(driver, 10);
		searchfield.until(ExpectedConditions.visibilityOf(SearchField_LoginDetails));
		SearchField_LoginDetails.clear();
		SearchField_LoginDetails.sendKeys(strvalue);
		searchfield.until(ExpectedConditions.attributeToBe(SearchField_LoginDetails, "value", strvalue));
	}
	
	public static boolean GetQueueLoginStatus_Details(String steAgenteName,String strQueueName)
	{
		WebElement LoginCheckBox=driver.findElement(By.xpath("//div[@queuename='"+strQueueName+"']//div[contains(@id,'slogin_"+steAgenteName+"')]"));
		WebDriverWait agentwait=new WebDriverWait(driver, 7);
		agentwait.until(ExpectedConditions.visibilityOf(LoginCheckBox));
		if(LoginCheckBox.getAttribute("value").trim().equals("1"))
			return true;
		return false;
	}
	
	/**** 
	 * ExpectedLoginStatus 0 Logout, 1 Lgoin 
	 * This method will provide Agent logged status from Right side detailed panel after clicking on Agent ***/
	public static boolean GetAgentLoggedinStatus_AllQueues_Detailedpanel(String strAgentId, String ExpectedLoginStatus)
	{
		List<WebElement> AgnetLoggedinButton=driver.findElements(By.xpath("//div[contains(@id,'slogin_"+strAgentId+"')]"));
		WebDriverWait agentwait=new WebDriverWait(driver, 7);
		agentwait.until(ExpectedConditions.visibilityOfAllElements(AgnetLoggedinButton));
		System.out.println("[GetAgentLoggedinStatus_AllQueues_Detailedpanel] Queues Count : "+AgnetLoggedinButton.size());
		for(int i=0;i<AgnetLoggedinButton.size();i++)
		{
			String strvalue=AgnetLoggedinButton.get(i).getAttribute("value").trim();
			if(!(strvalue).equals(ExpectedLoginStatus) || strvalue==null || strvalue.isEmpty())
			{
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean GetAgentLoginStatus_PerQueues(String strAgentName,String strQueueName)
	{
		WebElement AgnetElement=driver.findElement(By.id(""+strAgentName+"_loggedIn_ULM_A_"+strQueueName+"_username"));
		try
		{
			WebDriverWait agentwait=new WebDriverWait(driver, 7);
			agentwait.until(ExpectedConditions.visibilityOf(AgnetElement)).click();
			setSearchField_LoginDeatis(strQueueName);
			boolean isLoggedin=GetQueueLoginStatus_Details(strAgentName, strQueueName);
			return isLoggedin;
		}
		catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	/****
	 * Agent Available and UNAvailable PO Starts Here 
	 */
		
	public static void setAgentStatus_AllQueues(String strAgnetid) throws Exception
	{
		WebDriverWait AgnetWait=new WebDriverWait(driver, 10);
		WebElement AgentAvalivaleButton=driver.findElement(By.xpath("//span[@class='supervisoryPrivilages']//span[contains(@id,'"+strAgnetid+"_All')][@style=''][contains(@class,'vailableIcon_ULM')]"));
		AgnetWait.until(ExpectedConditions.visibilityOf(AgentAvalivaleButton));
		System.out.println("[setAgentStatus_AllQueues] Before cick Color ="+strAgentStatusColor_AllQueues(strAgnetid));
		AgentAvalivaleButton.click();
		Thread.sleep(6000);
		System.out.println("[setAgentStatus_AllQueues] Color After Click="+strAgentStatusColor_AllQueues(strAgnetid));
	}
	
	public static String strAgentStatusColor_AllQueues(String strAgentId)
	{
		WebDriverWait AgnetWait=new WebDriverWait(driver, 10);
		WebElement AgentAvalivaleButton=driver.findElement(By.xpath("//div[@id='ulm_presence_statid_"+strAgentId+"']//span[contains(@style,'color')]"));
		System.out.println("[Presence].. "+AgentAvalivaleButton.getText());
		// rgb(255, 0, 0); --> Unavailable Red
		// rgb(0, 128, 0); --> Available green
		System.out.println("[Presence]..asd "+AgentAvalivaleButton.getAttribute(attrStyle));
		return AgentAvalivaleButton.getAttribute(attrStyle).replace("color:", "");
	}
	
	
}

package streams_ucc_OR;

import java.util.List;

import org.apache.poi.util.SuppressForbidden;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OR
{
   WebDriver driver;
  
 //***** Login and Logout locators ****//
    @FindBy(xpath="//div[@class='productLogo']/img") public WebElement streamslogo;
    @FindBy(id="xusername") protected static WebElement username;
	@FindBy(id="password") public static WebElement password;
	@FindBy(className="normal-button") public WebElement loginbutton;
	@FindBy(id="streams_menu_icon_area") public WebElement menubutton; 
	@FindBy(xpath="(//li[@class='actionBarMenuList'])[1]") public WebElement settingspage;
	@FindBy(xpath="//li[@onclick='SH.signOut();']") public WebElement logoutbutton;
	@FindBy(xpath="//div[@class='errorMessageLogin']") public WebElement invalidusername_or_password;
	@FindBy(id="header_userName") public static WebElement loginusername;
	@FindBy(id="status_msg") public WebElement statusbar;
	@FindBy(id="cstatus_new") public WebElement EnterStatus;
    @FindBy(xpath="//div[@id='status_msg' and @statmsgid='1']") public WebElement statusbardesktop;
    @FindBy(xpath="//li[1]/span[2]") public WebElement ondesktop;
	
//**** Streams Recents locators ****//
   // @FindBy(id="spaneltab_2") public WebElement RecentsButton;
    @FindBy(xpath="//a[@class='chatFilter']") public WebElement ChatFilter;
    @FindBy(xpath="//a[@id='spaneltabanc_2']") public WebElement RecentsButton;
	@FindBy(id="search_recents") public WebElement  recents_searchbar;
	@FindBy(xpath="//a[@id='spaneltabanc_1']") public WebElement contacts_tabbutton; 
	@FindBy(id="search_contacts") public WebElement searchbar_contcatstab;
	@FindBy(xpath="//span[@id='main_user_img']/img") public WebElement UserProfilePic;
	
//********* Middel chat panel locators ******************************************
	@FindBy(id="middle_rpopt") protected WebElement streamdetailedpanel_middlechat;
	@FindBy(id="pin_panel") protected WebElement Pinneditemsbar_rightsidepanel;
	@FindBy(id="pin_cnt") protected WebElement pincount_rightsidepanel;
	@FindBy(xpath="//div[@id='pin_panel']/div[@class='rightHeadBar']") protected WebElement pinneditemsbar;
	@FindBy(xpath="//textarea[@rows='1']") protected WebElement typemessagefield;
	@FindBy(id="middle_sendicon") protected WebElement messagesentclickbuton;
	@FindBy(id="send_icon") protected WebElement commentsentclick;
	@FindBy(id="tb_rshare_pp") protected WebElement Reshareusernaemsentfield;
	@FindBy(xpath="//div[@id='rsharpp_but']/input[@value='Re-Share'][1]") protected WebElement rehare_click;
	
	//------------------Upload locators --------------------------------------------
	
	@FindBy(xpath="//a[@class='chatUpload']") protected WebElement uploadbutton_chatwindow;
	@FindBy(xpath="//div[@class='uploadMenu']/ul/li[1]") protected WebElement Pictures_uploadbutton;
	@FindBy(xpath="//div[@class='uploadMenu']/ul/li[2]")protected WebElement Audio_uploadbutton;
	@FindBy(xpath="//div[@class='uploadMenu']/ul/li[3]") protected WebElement Attachfile_uploadbutton;
	@FindBy(xpath="//input[@value='Upload']") protected WebElement uploadbutton_uploadpopup_window;
	@FindBy(xpath="//div[@class='uploadBarMain']/span[@class='uploadFilename']") protected  static WebElement uploadingfilename;
	@FindBy(id="upimg_fname") protected WebElement Renamefile_Whileuploading;
	@FindBy(id="fs_addmore") protected WebElement plus_button_uploadpopup;

	
//-------------- TEAM CREATIOON LOCATORS---------------------------------------	
	@FindBy(xpath="//a[@class='addUser']") protected WebElement plussbutton_recents;
	@FindBy(xpath="//div[@id='plusIconpp']/ul/li[1]") protected WebElement Createtam_Button;
	//@FindBy(id="contpp_tname'") protected WebElement enterteamame;
	@FindBy(xpath="//input[@id='contpp_tname']") protected WebElement EnterTeamame;
	@FindBy(id="tb_contpp") protected WebElement Sentsuername_Teamcreation_page;
	//@FindBy(id="contpp_findbtn") protected WebElement findbutton_teamcreationpage;
	@FindBy(xpath="//input[@id='tb_contpp']") protected WebElement Findbutton_Teamcreationpage;
	@FindBy(xpath="//input[@id='contpp_crteam']") protected WebElement Createteam_Click;
	//----------- TEAM ATTRIBUTES -------------------------------//
	@FindBy(id="team_type_1") protected WebElement Displayteam_radiobutton;
	@FindBy(id="team_type_2") protected WebElement privatetamradio_button;
	@FindBy(id="options_2") protected WebElement privatetam_invitetype_dropdown;
	@FindBy(xpath="//input[@value='OK']") protected WebElement empty_specialcharacters_teamname;
	
	
	/*** ULM Branding Logos Locators **********/
	@FindBy(xpath="//input[@value='Login']") public WebElement Loginbuton_IDPULM;
	@FindBy(xpath="//img[contains(@class,'logoAuth')][@align='left']") public WebElement LeftSideLogo;
	@FindBy(xpath="//img[contains(@class,'logoAuthRight')][@align='right']") public WebElement RightSideLogo;
	@FindBy(xpath="//div[@class='introText']/img") public WebElement ULMLOGO_LoginPage;
	@FindBy(xpath="(//div[@class='introText'])[2]") public WebElement ULMKeyFeaturesHeading;
	@FindBy(xpath="//div[@class='login_footer']") public WebElement LoginPageCopyRIghts;
	@FindBy(xpath="//div[@class='footer' and @align='center']") public WebElement ForgotPasswordCopyRight;
	@FindBy(linkText="Forgot Password?") public WebElement ForgotPasswordPage;
	@FindBy(id="username") public WebElement Forgotpasswrodpage_UsernameField;
	@FindBy(linkText="HOME") public WebElement HomeLink_ForgotpasswordPage;
	@FindBy(linkText="Privacy Policy") public WebElement PrivacyPolicy_Link;
	@FindBy(xpath="//img[@alt='Logo' and @class='mobile']") public WebElement BCMLogo_LogoutPage;
	@FindBy(xpath="//img[@alt='Kumo Cloud Solutions, Inc.']") public WebElement KumoLogo_LogoutPage;
	
	
	@FindBy(xpath="//div[@class='productLogo']/img") public WebElement IDPHomePage_Logs;
	@FindBy(xpath="//div[@class='copyrights_footer']") public WebElement IDPHomePage_CopyRights;
	
	
	
	/**
	 * @author Bala Pavan
	 * Date 10-07-19
	 * ULM Locators
	 */

	@FindBy(xpath="//div[@id='stream_right']//*[@class='di_loader']") public static WebElement Loading_Div;
	/**** Queue Filter Locators *****/
	@FindBy(xpath="//span[@title='Queue Filter']") public static WebElement QueueFilter;
	@FindBy(id="ulm_queues_list") public static WebElement QueueFilter_POPUp;
	@FindBy(id="searchfield_queuefilter") public static WebElement QueueFilter_SearchField;
	@FindBy(xpath="//span[@id='chkall_filter']") public static WebElement QueueFilter_SelectALlCheckBox;	
	@FindBy(id="queuefilter_saveDiv") public static WebElement QueueFilter_SaveButton;
	@FindBy(id="ULM_groups") public static  WebElement  ULM_groups_Enabled;
	@FindBy(name="queue_filter_chk") public static List<WebElement> QueueFilter_Checkbox;
	
	/*** View Filter Options ******/
	@FindBy(id="ulm_filter_option") public static WebElement ViewFilterButton; 
	@FindBy(id="filterPopup_ULM") public static WebElement ViewFilterPOPupDiv;
	@FindBy(id="ulm_allqueue_view") public static WebElement ViewFilter_AllQueueRadioButton;
	@FindBy(id="ulm_perqueue_view") public static WebElement ViewFilter_PerQueueRadioButton;
	@FindBy(id="loggedin_filter") public static WebElement ViewFilter_Loggedin_Checkbox;
	@FindBy(id="ciq_filter") public static WebElement ViewFilter_CallsinQueue_CheckBox;
	@FindBy(id="ac_filter") public static WebElement ViewFilter_ActiveCalls_CheckBox;
	@FindBy(id="slakpi_filter") public static WebElement ViewFilter_SLAKPI_CheckBox;
	@FindBy(id="logoff_filter") public static WebElement ViewFilter_LogoutAgents_CheckBox;
	@FindBy(id="mc_filter") public WebElement ViewFilter_Missedcalls_CheckBox;
	@FindBy(xpath="//div[@id='filter_menu']//input[@value='Save']") public static WebElement ViewFilter_SaveButton;
	
	/**** Call monitoring form ****/
	@FindBy(className="callMonitorPosition") public static WebElement More_Options_Button;
	@FindBy(id="ulm_callmonitor_id") public static WebElement More_Option_Div;
	@FindBy(id="ulm_manage_groups") public static WebElement ManageGroups_More_Option;
	@FindBy(id="ulm_manage_refresh") public static WebElement Refresh_More_Option;
	@FindBy(id="ulm_callmonitor_option") public static WebElement CallMonitoringForm_MoreOption_Button;
	@FindBy(id="ulm_call_monitoring_options") public static WebElement phoneTypesDiv_CallMonitorOptions;
	@FindBy(id="calmonitor_softphone_0") public static WebElement SofTphoe_CallMonitoringForm;
	@FindBy(id="calmonitor_ipphone_1") public static WebElement IP1_CallMonitoringForm;
	@FindBy(id="calmonitor_ipphone_2") public static WebElement IP2_CallMonitoringForm;
	
	/*** Logged in Agents Counts ****/
	
	@FindBy(xpath="//div[@groupname='All Queues']") public static List<WebElement> Logged_IN_AgentsDivs_AllQueues;
	@FindBy(xpath="//div[@name='ulm_buddies_lo']") public static List<WebElement> Logged_OUT_AgentsDivs_AllQueues;
	@FindBy(id="ulm_li_cnt_span") public static WebElement Logged_IN_AgentesCount_DetailedPanel;
	@FindBy(id="ulm_lo_cnt_span") public static WebElement Logged_OUT_AgentesCount_DetailedPanel;
	
	/*** User Selective Queue Login & Details ****/
	@FindBy(className="cross_select_user_search") public static WebElement SearchField_LoginDetails;

	
	@FindBy(xpath="//span[@class=' queueName']") public static List<WebElement> QueueName_QueueFilterButton;
	@FindBy(id="ULM_indiv_groups") public static WebElement IndiviQueueList;
	@FindBy(xpath="//p[@class='ULMPoppedOutText ULMMiddleText']") public static WebElement NOACDorHuntEnabledMessage;
	@FindBy(xpath="//div[@class='contentLeft_ULM']/span[@class='queueNameLeft']") public static List<WebElement> rightSideQueuename;
	@FindBy(xpath="//div[@class='contentLeft_ULM']/span[@name='qname']") public static List<WebElement> rightSideQueuename_CheckBox;
	@FindBy(id="ulm_acdactivity") public static WebElement individualQueuesCollapseButton;
	@FindBy(id="All_Queues") public static WebElement QueueViewText_RightSide;
	@FindBy(xpath="//div[@class='chatUserID']") public static WebElement QueueViewText_Middle1;
	@FindBy(xpath="//div[@class='chatUserID']/span") public static WebElement QueueViewText_Middle2;
	
	/**ULm Detailed panel ***/
	@FindBy(id="middle_rpopt") public static WebElement ULM_DetailedPanelButton;
	@FindBy(className="right-panel") public static WebElement ULM_DetailedPanelShow;
	
	
	
	/*** ULm Middle Lcoators *****/
	
	/*@FindBy(xpath="//div[contains(@id,'li_buddies')][@class='heading']") public static List<WebElement> LoggedinAgents_Label;
	@FindBy(xpath="//div[contains(@id,'wc_buddies')][@class='heading']") public static List<WebElement> CallsinQueue_Label;
	@FindBy(xpath="//div[contains(@id,'ac_buddies')][@class='heading']") public static List<WebElement> Activecalls_Label;
	@FindBy(xpath="//div[contains(@id,'slakpi_buddies')][@class='heading']") public static List<WebElement> SLAKPI_Label;
	@FindBy(xpath="//div[contains(@id,'lo_buddies')][@class='heading']") public static List<WebElement> Logout_Label;*/
	
	@FindBy(xpath="//div[contains(@id,'li_buddies')]") public static List<WebElement> LoggedinAgents_Label;
	@FindBy(xpath="//div[contains(@id,'wc_buddies')]") public static List<WebElement> CallsinQueue_Label;
	@FindBy(xpath="//div[@id='ulm_main_content']//div[contains(@id,'ac_buddies')]") public static List<WebElement> Activecalls_Label;
	@FindBy(xpath="//div[contains(@id,'slakpi_buddies')]") public static List<WebElement> SLAKPI_Label;
	@FindBy(xpath="//div[contains(@id,'lo_buddies')]") public static List<WebElement> Logout_Label;
	
	/*** lables ****/
	@FindBy(id="ulm_acd_activity") public static WebElement AcdActivity;
	@FindBy(className="contentLeft_ULM_active") public static WebElement SelectedQueueViewType;
	@FindBy(xpath="//span[contains(text(),'Individual Queues')]") public static WebElement RightSide_IndividualQueue;
	@FindBy(id="ulm_main_content") public static WebElement ULMMiddleChatElement;
	@FindBy(className="chatUserID") public static WebElement MiddleSectionACDActivity;
}

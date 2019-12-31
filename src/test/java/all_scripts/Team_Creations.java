package all_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Excel_Data;

public class Team_Creations extends UDF_All_Methods{

	public Team_Creations(WebDriver driver) {
		super(driver);
	} 	
  private static  long Date=System.currentTimeMillis(); 
  public static String propertamname;
	public void Create_team() throws Exception
	{
		Excel_Data.ExcelFile(StreamsUCC_Main_Script.testdatasheetpath, "testdata");
		Excel_Data.ExcelFile(StreamsUCC_Main_Script.testdatasheetpath, "testdata");
		String Username=Excel_Data.getCellData(1, 2);
		this.second_login(Username, "abc@1234");
		this.Teamcreation_page_Wait();
		this.Click_team_type_radio_button(privatetamradio_button);
		for (int i = 2; i <=4; i++) 
		{
		    String addedusername=Excel_Data.getCellData(i, 2);
		    Logs.info("added user name is :"+addedusername);
			this.select_user_team(addedusername);
		}
		
		for (int i = 1; i <=3; i++) 
		{
		  String Teamname=Excel_Data.getCellData(i, 3);
		  if (Teamname.isEmpty()|| Teamname.contains("*") || Teamname==null) {
			  this.teamname_validations(Teamname);
		} else {
			String teamnamesent=Teamname+"_"+Date;
			propertamname=teamnamesent;
			this.teamname_validations(propertamname);
		}
		}
		System.out.println("proper team name is :"+propertamname);
		WebDriverWait contactstab=new WebDriverWait(driver, 20);
		contactstab.until(ExpectedConditions.visibilityOf(RecentsButton)).click();
		contactstab.until(ExpectedConditions.visibilityOf(recents_searchbar));
		this.OpenTeamUserContactstab(propertamname);
		/*this.contacts_tabbutton.click();
		contactstab.until(ExpectedConditions.visibilityOf(searchbar_contcatstab)).clear();
		this.searchbar_contcatstab.sendKeys(propertamname);
		//contactstab.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='profilePicture']/span[@title='"+propertamname+"']")))).click();
		contactstab.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@fname='"+propertamname+"' and @style='']")))).click();*/
		this.TeamStreamDetailedpanel(propertamname);
		
		for (int i = 1; i <=4; i++) 
		{
		    String addedusername=Excel_Data.getCellData(i, 2);
		    this.TeamMembersvalidation_TeaminfoPage_andGetID(addedusername);
		   // this.MoreOptions_on_TeamMember(addedusername);
		}
		String TeamAdmin=Excel_Data.getCellData(2, 2);
		this.MakeTeamAdmin(TeamAdmin, propertamname);
		String RemoveteamMember=Excel_Data.getCellData(3, 2);
		this.RemoveUserFromTeam(RemoveteamMember,propertamname);
	}
	
	
}

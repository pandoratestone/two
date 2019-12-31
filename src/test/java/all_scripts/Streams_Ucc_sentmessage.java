package all_scripts;

import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;
import test_data.Excel_Data;

public class Streams_Ucc_sentmessage extends UDF_All_Methods {

	public Streams_Ucc_sentmessage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static String sheetpath=StreamsUCC_Main_Script.testdatasheetpath;
	private String Fromusername;
	private static String Tousername;
	private static String Reshareusername;
    public static int a,b,c;
    private boolean boolSentMessageAtReceiver;
	
	public void textvalidations_at_Owner() throws Exception
	{
		try {
			Logs.start_test_case("Text validatipons started at owner end and milli seconds is:"+milliseconds);
			Excel_Data.ExcelFile(sheetpath, "testdata");
			
			String fromuesrname=Excel_Data.getCellData(1, 2);	
			String Receiverusername=Excel_Data.getCellData(2, 2);
			String Reshareusername=Excel_Data.getCellData(3, 2);
			this.buddyclick(Receiverusername, fromuesrname);
			this.Sentmessage(messagesent);
			boolSentMessageAtReceiver=true;
			Logs.info("[textvalidations_at_Owner] ..sent message bool is:"+boolSentMessageAtReceiver);
	   		//this.messageuuid(messagesent);
			this.like_comment_pin_Reshare(messageuuid(messagesent), fromuesrname, commentsent, messagesent, Reshareusername);
			this.buddyclick(Reshareusername, fromuesrname);
			this.Resharemessahevalidation(messagesent);
			this.Logout();
		} catch (Exception e) {
			Logs.error("text validation failed at owner end due to :"+e);
			//this.Logout();
		}
	}
		
	public void Textvalidation_Receiver() throws Exception
	{
		try {
			Logs.info("[Textvalidation_Receiver]... Started.."+boolSentMessageAtReceiver);
			if (boolSentMessageAtReceiver==true) 
			{
				Excel_Data.ExcelFile(sheetpath, "testdata");
				String fromuesrname=Excel_Data.getCellData(1, 2);
				Fromusername=fromuesrname;
				String Receiverusername=Excel_Data.getCellData(2,2);
				String password=Excel_Data.getCellData(6, 1).trim();
				this.second_login(Receiverusername, password);
				this.buddyclick(fromuesrname, Receiverusername);
				this.messageuuid(messagesent);
				this.like(messageuuid(messagesent), Receiverusername);
				this.perfor_comment(CommemntReceiver, messagesent, messageuuid(messagesent));
				this.pin(messageuuid(messagesent));
				String Resharetargetusrname=Excel_Data.getCellData(4, 2);
				this.Reshare(messagesent, Resharetargetusrname);
				this.buddyclick(Resharetargetusrname, Receiverusername);
				this.Resharemessahevalidation(messagesent);
				this.Logout();
			} 
			else 
			{
				Logs.error("[Textvalidation_Receiver] .Skiped due to failed at Sender end");
			}
			
		} catch (Exception e) {
			Logs.error("[Textvalidation_Receiver] failed due to :"+e);
		//	this.Logout();
		}
	}
}

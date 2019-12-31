package all_scripts;

import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;
import test_data.Excel_Data;

public class Alll_Actions_Receiverend extends UDF_All_Methods{

	public Alll_Actions_Receiverend(WebDriver driver) {
		super(driver);
	}
	
	private static String sheetpathis=StreamsUCC_Main_Script.testdatasheetpath;
	
	public void ReceiverActions() throws Exception
	{
		Logs.start_test_case("[ReceiverActions] Started....");
		//------------- Message validations ----------------//
		Excel_Data.ExcelFile(sheetpathis, "testdata");
		String Ownername=Excel_Data.getCellData(1, 2);
		String Receivername=Excel_Data.getCellData(2,2);
		String password=Excel_Data.getCellData(6, 1).trim();
		String Reshareusername=Excel_Data.getCellData(4, 2);
		this.second_login(Receivername, Constants.commonpassword);
	
		//----- Message sent and validations ------//
		
		try {
			Logs.info("[Meessage-Receiver Actions]..STARTED");
			this.buddyclick(Ownername, Receivername);
			this.messageuuid(All_Actionsat_Ownserend.messagesent);
			/*this.like(messageuuid, Receivername);
			this.perfor_comment(commentsent+"_Receiver", messagesent, messageuuid);
			this.pin(messageuuid);
			this.Reshare(messagesent, Reshareusername);*/
			this.like_comment_pin_Reshare(messageuuid, Receivername, commentsent, All_Actionsat_Ownserend.messagesent, Reshareusername);
			this.buddyclick(Reshareusername, Receivername);
			this.Resharemessahevalidation(All_Actionsat_Ownserend.messagesent);
			this.buddyclick(Ownername, Receivername);
			Logs.info("[Meessage-Receiver Actions]..ENDED");
			} 
		   catch (Exception e) 
		  {
			Logs.error("[Meessage-Receiver Actions Fail]..."+e.getStackTrace());
	      }
		
		//------------------ Image Validations ------------------//
		try {
			Logs.info("[IMAGE-Receiver Actions]..STARTED");
			this.buddyclick(Ownername, Receivername);
			this.select_curect_image(All_Actionsat_Ownserend.Photonamesent,All_Actionsat_Ownserend.Photonamesent);
			this.like_comment_pin_Reshare(attachmentuuid, Receivername, commentsent+"_Receiver", 
											All_Actionsat_Ownserend.Photonamesent, 
											 Reshareusername);
			this.buddyclick(Reshareusername, Receivername);
			this.Resharemessahevalidation(All_Actionsat_Ownserend.Photonamesent);
			this.buddyclick(Ownername, Receivername);
			Logs.info("[IMAGE-Receiver Actions]..ENDED DONE..");
			} 
			catch (Exception e) {
			
				Logs.error("[IMAGE-Receiver FAIL..].."+e.getMessage());
			}
		
		//----------- Audio file validations at Receiver end ------------//
		
		try {
			Logs.info("[AudioFile-Receiver].. Started..");
			this.buddyclick(Ownername, Receivername);
			this.select_curect_image(All_Actionsat_Ownserend.Audiofilename,All_Actionsat_Ownserend.Audiofilename);
			this.like_comment_pin_Reshare(AudioFileUuid, Receivername, commentsent+"_Receiver", 
										All_Actionsat_Ownserend.Audiofilename, 
										 Reshareusername);
			Logs.info("[AudioFile-Receiver].. Ended Done..");
			} 
			catch (Exception Audiofilefail) 
			{
			  Logs.error("[AudioFile-Receiver-> Fail].."+Audiofilefail.getMessage());
			}
		
		
	}
	
	
	
}

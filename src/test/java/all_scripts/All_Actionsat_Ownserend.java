package all_scripts;

import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;
import test_data.Excel_Data;

public class All_Actionsat_Ownserend  extends UDF_All_Methods{

	public All_Actionsat_Ownserend(WebDriver driver) {
		super(driver);
	}

	private static String sheetpathis=StreamsUCC_Main_Script.testdatasheetpath;
	public static String Photonamesent="photo_"+messagesent+"";
	public static String Audiofilename="Audiofile"+messagesent+"";
	public static String Textfilename="textfile"+messagesent+"";
	public static String FirstPhotoname="College_"+messagesent+"";
	public static String secondphotoname="second_"+messagesent+"";
	
	public void OwnerActions() throws Exception
	
	{  //----- Message sent and validations ------//
		Excel_Data.ExcelFile(sheetpathis, "testdata");
		String Ownername=Excel_Data.getCellData(1, 2);
		String Receivername=Excel_Data.getCellData(2,2);
		String password=Excel_Data.getCellData(6, 1).trim();
		String Reshareusername=Excel_Data.getCellData(3, 2);
		try {
			this.second_login(Ownername, Constants.commonpassword);
			this.buddyclick(Receivername, Ownername);
			this.Sentmessage(messagesent);
			this.messageuuid(messagesent);
			/*this.perfrom_likeoperation(messageuuid, Ownername);// like on message 
			this.perfor_comment(commentsent, messagesent, messageuuid); // Commet on messagesent
			this.perfrom_pin(messageuuid);//               pin on message
			this.Reshare(messagesent, Reshareusername); *///Reshare on message	
			this.like_comment_pin_Reshare(messageuuid, Ownername, commentsent, messagesent, Reshareusername);
			this.buddyclick(Reshareusername, Ownername);
			this.Resharemessahevalidation(messagesent);
			this.buddyclick(Receivername, Ownername);
			} 
			catch (Exception e) 
			{
			this.buddyclick(Receivername, Ownername);
			Logs.error("unable to perfrom message actions at owner end due to :"+e.getMessage());
			}
		
		//---- Image sent and validations ----//
		
		try {
			this.Sentimage_ucc(Constants.Singleimage, Photonamesent, Pictures_uploadbutton);
			this.upload_imagesucess(middlechatuploadingfilename);
			this.select_curect_image(middlechatuploadingfilename,Photonamesent);
			/*this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, Ownername);//Attachment like
			this.comment(commentsent, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			this.Reshare(Photonamesent, Reshareusername);*/
		    this.like_comment_pin_Reshare(attachmentuuid, Ownername, commentsent, Photonamesent, Reshareusername);
			this.buddyclick(Reshareusername, Ownername);
			this.Resharemessahevalidation(Photonamesent);
			this.buddyclick(Receivername, Ownername);
			} 
			catch (Exception e) 
			{
			Logs.info("unable to perform onwer actions for Image"+e.getMessage());
			this.buddyclick(Receivername, Ownername);
			}
		
		
//------------------ Audio file validations at Owner end -----------------------------------//
		try {
			this.Select_Audio_file_ucc(Constants.audio_file, Audiofilename, Audio_uploadbutton);
			//this.uploading_file_name_middelchat_window();
			//this.upload_sucess(middlechatuploadingfilename);
			this.select_curect_image(middlechatuploadingfilename,Audiofilename);
			this.like_comment_pin_Reshare(AudioFileUuid, Ownername, commentsent, Audiofilename, Reshareusername);
			/*this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, Ownername);//Attachment like
			this.perfor_comment(commentsent, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			this.Reshare(Audiofilename, Reshareusername);*/
			this.buddyclick(Reshareusername, Ownername);
			this.Resharemessahevalidation(Audiofilename);
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.buddyclick(Receivername, Ownername);
			} 
			catch (Exception e) 
			{
			Logs.error("[Error at Audio file at Owner end]..Audio file owner acions are failed due to :"+e.getMessage());
			this.buddyclick(Receivername, Ownername);
			e.printStackTrace();
			}
		

//---------------- Text File validations at Owner end ------------------------------//
		try {
			
			this.Selecttextfile_ucc(Constants.textfile, Textfilename, Attachfile_uploadbutton);
			this.select_curect_image(middlechatuploadingfilename,Textfilename);
			this.like_comment_pin_Reshare(TextFileUuid, Ownername, commentsent, Textfilename, Reshareusername);
			this.buddyclick(Reshareusername, Ownername);
			this.Resharemessahevalidation(Textfilename);
			this.buddyclick(Receivername, Ownername);
			} 
			catch (Exception e) 
			{
			this.buddyclick(Receivername, Ownername);
			e.printStackTrace();
			Logs.error("[Text file validation at Owner end Failed due to]... "+e);
			}
		
		
//----------- College Photo Actions at Owner end -------------------------------//
		try {
			
			this.Collegeofpictues_streams_ucc(Pictures_uploadbutton, Constants.Singleimage,Constants.image2_jpg, Photonamesent, secondphotoname);
			this.select_curect_image(middlechatuploadingfilename,FirstPhotoname);
			this.like_comment_pin_Reshare(CollegeUuid, Ownername, commentsent, FirstPhotoname, Reshareusername);
			this.buddyclick(Receivername, Ownername);
			} 
			catch (Exception e) 
		    {
			 Logs.error("[College fail at Owner end].. Due to .."+e.getMessage());
			}
		
		
	}
}

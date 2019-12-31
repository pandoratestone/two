package all_scripts;

import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;
import streams_ucc_page.Page;
import test_data.Constants;
import test_data.Excel_Data;

public class Streams_UCC_Attachments extends UDF_All_Methods{

	public Streams_UCC_Attachments(WebDriver driver) {
		super(driver);
	}

//	public static String Date=datesent();
	public static String sheetpath=StreamsUCC_Main_Script.testdatasheetpath;
	public static String Photonamesent="photo_"+messagesent+"";
	/*public static String commentsentowner="Comments_"+Date+"";
	public static String Commentssent_receiver="Comment_receiver_"+Date+"";*/
	//public static String uploadingfilename=uploading_file_name_middelchat_window();

	
	public void Singlephoto_Actions_Ownerend() throws Exception
	{
		try {
			Logs.start_test_case("Singlephoto_Actions_Ownerend Started ");
			Excel_Data.ExcelFile(sheetpath, "testdata");
			String fromuesrname=Excel_Data.getCellData(1, 2);
			String Sentusrename=Excel_Data.getCellData(2,2);
			String password=Excel_Data.getCellData(6, 1).trim();
			String Resharetargetusrname=Excel_Data.getCellData(3, 2);
			System.out.println("Singlephoto_Actions_Ownerend");
			this.second_login(fromuesrname, password);
			this.buddyclick(Sentusrename, fromuesrname);
			this.Sentimage_ucc(Constants.Singleimage, Photonamesent, Pictures_uploadbutton);
			//this.uploading_file_name_middelchat_window();
			this.upload_imagesucess(middlechatuploadingfilename);
			this.select_curect_image(middlechatuploadingfilename,Photonamesent);
			this.perfrom_pin(attachmentuuid);
			this.like_comment_pin_Reshare(attachmentuuid, fromuesrname, commentsent, Photonamesent, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, fromuesrname);
			this.Resharemessahevalidation(Photonamesent);
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Logout();
		} catch (Exception e) 
		{
			Logs.error("[Singlephoto_Actions_Ownerend]..failed due to :"+e.getMessage());
		}
	}
	
	public void Singlephoto_Receiver_Actions() throws Exception
	{
		try {
			Logs.info("___________Singlephoto_Receiver_Actions Started_________________");
			Excel_Data.ExcelFile(sheetpath, "testdata");
			String fromuesrname=Excel_Data.getCellData(1, 2);
			String Receiverusrename=Excel_Data.getCellData(2,2);
			String password=Excel_Data.getCellData(6, 1).trim();
			String Resharetargetusrname=Excel_Data.getCellData(4, 2);
			this.second_login(Receiverusrename, password);
			this.buddyclick(fromuesrname, Receiverusrename);
			select_curect_image(middlechatuploadingfilename,Photonamesent);
			this.like_comment_pin_Reshare(attachmentuuid, fromuesrname, commentsent, Photonamesent, Resharetargetusrname);
			/*this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, Receiverusrename);//Attachment like
			this.comment(CommemntReceiver, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
*/			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Reshare(Photonamesent, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, Receiverusrename);
			this.Resharemessahevalidation(Photonamesent);
			this.Logout();
		} catch (Exception e) 
		{
			Logs.error("[Singlephoto_Receiver_Actions]..failed due to :"+e.getMessage());
		
		}
	}
	
}

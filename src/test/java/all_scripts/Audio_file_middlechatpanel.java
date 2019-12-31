package all_scripts;

import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;
import test_data.Excel_Data;

public class Audio_file_middlechatpanel extends UDF_All_Methods{

	public Audio_file_middlechatpanel(WebDriver driver) {
		super(driver);
	}

	
//	public static String Date=datesent();
	public static String sheetpath=StreamsUCC_Main_Script.testdatasheetpath;
	public static String Audiofilename="Audiofile"+messagesent+"";
//	public static String commentsent="Comments_"+Date+"";	
	
	
	public void Audiofilevalidations_Owner_end() throws Exception
	{
		try {
			Excel_Data.ExcelFile(sheetpath, "testdata");
			String fromuesrname=Excel_Data.getCellData(1, 2);
			String Sentusrename=Excel_Data.getCellData(2,2);
			String password=Excel_Data.getCellData(6, 1).trim();
			String Resharetargetusrname=Excel_Data.getCellData(3, 2);
			System.out.println("Single Audio_Actions_Ownerend");
			this.second_login(fromuesrname, password);
// this.current_user_login_logout_status(fromuesrname, password);
			/*if (this.menubutton.isDisplayed()) {
				this.Logout();
				this.login_all(fromuesrname, password);
			} else if (this.loginbutton.isDisplayed()) {
				this.login_all(fromuesrname, password);
			}*/
			this.buddyclick(Sentusrename, fromuesrname);
			this.Select_Audio_file_ucc(Constants.audio_file, Audiofilename, Audio_uploadbutton);
			//this.uploading_file_name_middelchat_window();
			//this.upload_sucess(middlechatuploadingfilename);
			this.select_curect_image(middlechatuploadingfilename,Audiofilename);
			this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, fromuesrname);//Attachment like
			this.perfor_comment(commentsent, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			this.Reshare(Audiofilename, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, fromuesrname);
			this.Resharemessahevalidation(Audiofilename);
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Logout();
		} catch (Exception e) {
			this.Logout();
		}
	}

	public void Audiofilevalidation_Receiverend() throws Exception
	{
		try {
			Excel_Data.ExcelFile(sheetpath, "testdata");
			String fromuesrname=Excel_Data.getCellData(1, 2);
			String Receiverusrename=Excel_Data.getCellData(2,2);
			String password=Excel_Data.getCellData(6, 1).trim();
			String Resharetargetusrname=Excel_Data.getCellData(4, 2);
			this.second_login(Receiverusrename, password);
			this.buddyclick(fromuesrname, Receiverusrename);
			this.select_curect_image(middlechatuploadingfilename,Audiofilename);
			this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, Receiverusrename);//Attachment like
			this.perfor_comment(CommemntReceiver, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Reshare(Audiofilename, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, Receiverusrename);
			this.Resharemessahevalidation(Audiofilename);
			this.Logout();
		} catch (Exception e) {
			this.Logout();
		}
	}
	
}

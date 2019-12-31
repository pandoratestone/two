package all_scripts;

import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;
import test_data.Excel_Data;

public class TextFile_Middelchat extends UDF_All_Methods{

	public TextFile_Middelchat(WebDriver driver) {
		super(driver);
	}
	
	public static String sheetpath=StreamsUCC_Main_Script.testdatasheetpath;
	public static String Textfilename="textfile"+messagesent+"";

	public void textfilevalidations_Owner_end() throws Exception
	{
		try {
			Logs.start_test_case("-------------- Text file  validation started at Owner end-----------------");
			Excel_Data.ExcelFile(sheetpath, "testdata");
			String fromuesrname=Excel_Data.getCellData(1, 2);
			String Sentusrename=Excel_Data.getCellData(2,2);
			String password=Excel_Data.getCellData(6, 1).trim();
			String Resharetargetusrname=Excel_Data.getCellData(3, 2);
			System.out.println("Single Text file_Actions_Ownerend");
			this.second_login(fromuesrname, password);
		//	this.current_user_login_logout_status(fromuesrname, password);
			/*if (this.menubutton.isDisplayed()) {
				this.Logout();
				this.login_all(fromuesrname, password);
			} else if (this.loginbutton.isDisplayed()) {
				this.login_all(fromuesrname, password);
			}*/
			this.buddyclick(Sentusrename, fromuesrname);
			this.Selecttextfile_ucc(Constants.excelfile, Textfilename, Attachfile_uploadbutton);
			//this.uploading_file_name_middelchat_window();
			//this.upload_sucess(middlechatuploadingfilename);
			this.select_curect_image(middlechatuploadingfilename,Textfilename);
			this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, fromuesrname);//Attachment like
			this.perfor_comment(commentsent, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			this.Reshare(Textfilename, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, fromuesrname);
			this.Resharemessahevalidation(Textfilename);
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Logout();
		} 
		catch (Exception e) 
		{
			Logs.error("[Text file  validation started at Owner end].. failed Due to :"+e.getMessage());
		}
	}

	public void Textfilevalidation_Receiverend() throws Exception
	{
		try {
			Excel_Data.ExcelFile(sheetpath, "testdata");
			String fromuesrname=Excel_Data.getCellData(1, 2);
			String Receiverusrename=Excel_Data.getCellData(2,2);
			String password=Excel_Data.getCellData(6, 1).trim();
			String Resharetargetusrname=Excel_Data.getCellData(4, 2);
			this.second_login(Receiverusrename, password);
			this.buddyclick(fromuesrname, Receiverusrename);
			select_curect_image(middlechatuploadingfilename,Textfilename);
			this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, Receiverusrename);//Attachment like
			this.perfor_comment(CommemntReceiver, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Reshare(Textfilename, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, Receiverusrename);
			this.Resharemessahevalidation(Textfilename);
			this.Logout();
		} catch (Exception e) 
		{
			Logs.error("[Textfilevalidation_Receiverend].. failed Due to :"+e.getMessage());
		}
	}
	
	
}

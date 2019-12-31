package all_scripts;

import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;
import test_data.Excel_Data;

public class Colleguge_photos extends UDF_All_Methods {

	public Colleguge_photos(WebDriver driver) {
		super(driver);
	
	}
	
	
//	public static String Date=datesent();
	public static String sheetpath=StreamsUCC_Main_Script.testdatasheetpath;
	public static String Photonamesent="College_"+messagesent+"";
	public static String secondphotoname="second_"+messagesent+"";
//	public static String commentsent="Comments_"+Date+"";

	public void collegephoto_Actions_Ownerend() throws Exception
	{
		try {
			Logs.start_test_case("Singlephoto_Actions_Ownerend Started ");
			Excel_Data.ExcelFile(sheetpath, "testdata");
			String fromuesrname=Excel_Data.getCellData(1, 2);
			String Sentusrename=Excel_Data.getCellData(2,2);
			String password=Excel_Data.getCellData(6, 1).trim();
			String Resharetargetusrname=Excel_Data.getCellData(3, 2);
			System.out.println("Singlephoto_Actions_Ownerend");
			//this.current_user_login_logout_status(fromuesrname, password);
/*	try {
				if (this.menubutton.isDisplayed()) {
					this.Logout();
					this.login_all(fromuesrname, password);
				} else if (this.loginbutton.isDisplayed()) {
					this.login_all(fromuesrname, password);
				}
			} catch (Exception e) {
				this.login_all(fromuesrname, password);
			}*/
			this.second_login(fromuesrname, password);
			this.buddyclick(Sentusrename, fromuesrname);
			this.Collegeofpictues_streams_ucc(Pictures_uploadbutton, Constants.Singleimage,Constants.image2_jpg, Photonamesent, secondphotoname);
			//this.upload_imagesucess(middlechatuploadingfilename);
			this.select_curect_image(middlechatuploadingfilename,Photonamesent);
			this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, fromuesrname);//Attachment like
			this.comment(commentsent, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			this.Reshare(Photonamesent, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, fromuesrname);
			this.Resharemessahevalidation(Photonamesent);
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Logout();
		} catch (Exception e) {
			this.Logout();
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
			this.perfrom_pin(attachmentuuid);
			this.perfrom_likeoperation(attachmentuuid, Receiverusrename);//Attachment like
			this.comment(commentsent, middlechatuploadingfilename, attachmentuuid);//Attachment commnet
			System.out.println("Attachment UUID id from main script is:"+attachmentuuid);
			this.Reshare(Photonamesent, Resharetargetusrname);
			this.buddyclick(Resharetargetusrname, Receiverusrename);
			this.Resharemessahevalidation(Photonamesent);
			this.Logout();
		} catch (Exception e) {
			this.Logout();
		}
	}
	
	
	
}

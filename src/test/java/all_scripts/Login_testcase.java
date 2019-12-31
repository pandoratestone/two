package all_scripts;
import org.openqa.selenium.WebDriver;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;
import output_results.Logs;
import output_results.MyTest_Listner;
import streams_ucc_UDF.UDF_All_Methods;
import test_data.Data_Helper;
import test_data.Excel_Data;

public class Login_testcase extends UDF_All_Methods {

	public Login_testcase(WebDriver driver) {
		super(driver);
	}
	//private String sheetpath="E:\\Selenium\\Scripts\\com.streams.smartbox.com\\src\\test\\java\\test_data\\Data.xls";
	private String Sheetname="testdata";
	//public  String username=Constants.dceuname; 
	//public String password=Constants.pass;
  // public static  String password;
   public static String username;
   
	public void login() throws Exception
	{
//		Excel_Data.ExcelFile(StreamsUCC_Main_Script.testdatasheetpath, Sheetname);
		Logs.start_test_case("Login_testcase started and test sheet path is :"+StreamsUCC_Main_Script.testdatasheetpath);
		try {
			 
//			 Logs.info("[OverallCelldata]"+Excel_Data.ExcelWSheet.getLastRowNum());
			for (int i = 1; i <=4; i++) 
			{
				try {
					String strTestCasename=Data_Helper.strTestCase_Name("TC_"+i);
					Logs.start_test_case(strTestCasename);
					UDF_All_Methods.TC_TotalCount=i;
					Logs.info("[Current Cell Count]--"+i);
					String UserName=Data_Helper.strCellData(StreamsUCC_Main_Script.testdatasheetpath, Sheetname, i,0);
					String userpassword=Data_Helper.strCellData(StreamsUCC_Main_Script.testdatasheetpath, Sheetname, i,1);
//					String  UserName =  Excel_Data.getCellData(i, 0).trim();
//					username=UserName;
//	 System.out.println("UserName is "+UserName);
//					 String userpassword= Excel_Data.getCellData(i, 1).trim();
//					 System.out.println("User password is  "+userpassword);
					
					
					 login_all(UserName, userpassword);
					 Excel_Data.setCellData(strPass, Data_Helper.TestCaseRowNumber, 5);
					 MyTest_Listner.ExtendReportsResult(strPass, strTestCasename,Data_Helper.strTestCase_Description());
//					 Logout();
//					 if (UserName.isEmpty() || userpassword.isEmpty()) 
//					 {
//						System.out.println("blank usrename or password");
////						 MyTest_Listner.ExtendReportsResult(strPass, );
//					} 
				} catch (Exception e) 
				{
					MyTest_Listner.ExtendReportsResult(strFail, "login Failed",Data_Helper.strTestCase_Description());
					Logs.error("Failed--->i=="+i+" UserName=="+username);
				}
				 
			}
			} catch (Exception e) {
			Logs.debug("Unable to get user crediantials from excel sheet due to :"+e.getMessage());
		}
		
	}

}

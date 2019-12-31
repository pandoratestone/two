package test_data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;

public class Data_Helper 
{
	
	public static int TestCaseRowNumber;

	
	public static String strCellData(String strSheetpath,String strSheetname,int coloum,int Row) throws Exception
	{
		Excel_Data.ExcelFile(StreamsUCC_Main_Script.testdatasheetpath, strSheetname);
		String CellData=Excel_Data.getCellData(coloum, Row).trim();
		System.out.println("Cell Data =="+CellData);
		return CellData;
	}
	
	
	public static String strTestCase_Name(String strTestCaseId) throws Exception
	{
//		System.out.println("Came------------>");
		Excel_Data.ExcelFile(Constants.strTestcaseTargetPath, "TestCases");
		for(int i=0;i<=Excel_Data.ExcelWSheet.getLastRowNum();i++)
		{
//			System.out.println("Came--------<<<<<---->");
			String strCaseID=Excel_Data.getCellData(i, 1).trim();
//			System.out.println("strCaseID--------<<<<<---->"+strCaseID);
			if(strCaseID.equalsIgnoreCase(strTestCaseId))
			{
				TestCaseRowNumber=i;
				String strTestCasename=Excel_Data.getCellData(i, 3).trim();
				System.out.println("Test Case name==="+strTestCasename+"  TestCaseRowNumber=="+TestCaseRowNumber);
				return strTestCasename;
			}
		}
		return null;
	}
	
	
	public static String strTestCase_Description() throws Exception
	{
		Excel_Data.ExcelFile(Constants.strTestcaseTargetPath, "TestCases");
		String strTC_Desc=Excel_Data.getCellData(TestCaseRowNumber, 6).trim();
		return strTC_Desc;
	}
	
	
	
	public static void CopyFileToOtherLocation(String strTargetLocation)
	{
		File source = new File(Constants.strTestcaseSourcePath);
		File dest = new File(strTargetLocation);
		try {
			Files.copy(source, dest);
//		    FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	
	
	
	
}

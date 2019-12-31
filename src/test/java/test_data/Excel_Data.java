package test_data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import main_running_script_streams_ucc.StreamsUCC_Main_Script;



public class Excel_Data {
	  
	   public static HSSFSheet ExcelWSheet;
	   private static HSSFWorkbook ExcelWBook;
 	   private static HSSFCell Cell;
       private static HSSFRow Row;
	
     public static void ExcelFile(String Path,String SheetName) throws Exception 
     {

   	  try {

   		FileInputStream ExcelFile = new FileInputStream(Path);
			   ExcelWBook = new HSSFWorkbook(ExcelFile);
              ExcelWSheet = ExcelWBook.getSheet(SheetName);
			 } 
   	  	catch (Exception e)
   	  			{
                   throw (e); 
                   }
          }
     public static String getCellData(int RowNum, int ColNum) throws Exception
     {
    try{
 
  	   ExcelWBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
  	   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
  	   String CellData = Cell.getStringCellValue().trim();
		   return CellData;
        } 
    	catch (Exception e)
         		{
               return" "; 
         		 }
      }
   
     
     
     public static void setCellData(String Result, int RowNum, int ColNum) throws Exception	
     {
	  try{
		  ExcelFile(Constants.strTestcaseTargetPath, "TestCases");
		  ExcelWBook.getSheet("TestCases");
		  Row  = ExcelWSheet.getRow(RowNum);
			   Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			   if (Cell == null) 
               {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
               } else {
                	Cell.setCellValue(Result);
                      }
			   
			  FileOutputStream fileOut = new FileOutputStream(Constants.strTestcaseTargetPath);
		//	  ExcelWBook.getSheet(StrSheetName);
	  	  ExcelWBook.write(fileOut);
		  fileOut.flush();
		  fileOut.close();
		  System.out.println("Excel...Write done......");
	  	  } catch(Exception e)
	   	   		{
	  		  System.out.println("Write failll  due to :"+e);
	   		      throw (e); 
	   		     }
	   }
	
     
     
     
     
//Constant variables Test Data path and Test Data file name	   
   public static void setOutputFile(String strOutFilePath) throws IOException
   	  {
	   	  FileOutputStream fileOut = new FileOutputStream(strOutFilePath);
	  	  ExcelWBook.write(fileOut);
		  fileOut.flush();
		  fileOut.close();
      }
   public static int rowCount() throws IOException
   	  {
	   int rowCount = ExcelWSheet.getLastRowNum();
	   return rowCount;
      }
   
   public static int coloumsCount() throws IOException
   	  {
	   int rowcount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
	    Row = ExcelWSheet.getRow(rowcount+1);
	   int coloumsCount  = Row.getLastCellNum();
	   return coloumsCount;
	  }
 
}

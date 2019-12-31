package output_results;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Update_Result_Status_Excel {
	
	
	 public static HSSFSheet ExcelWSheet;
	   private static HSSFWorkbook ExcelWBook;
	   private static HSSFCell Cell;
   private static HSSFRow Row;
  public  static FileInputStream fis=null;
	
   public static void ExcelFile(String Path,String SheetName) throws Exception 
   {

 	  try {

 		 fis = new FileInputStream(Path);
			   ExcelWBook = new HSSFWorkbook(fis);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
			  } catch (Exception e){
                 throw (e); }
        }
   public static String getCellData(int RowNum, int ColNum) throws Exception
   {
  try{
	   ExcelWBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	   String CellData = Cell.getStringCellValue().trim();
		   return CellData;
      } catch (Exception e)
       		{
             return" "; 
       		 }
    }
   
   
}

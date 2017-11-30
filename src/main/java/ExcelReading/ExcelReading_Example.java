package ExcelReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading_Example {
    
	    
	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		 XSSFWorkbook wb ;
		 XSSFSheet sh;
		 int rowcnt;
	   File ipFile = new File("E:\\Testdata\\expedia.xlsx");
	   FileInputStream src = new FileInputStream(ipFile);
	   wb = new XSSFWorkbook(src);
	   sh = wb.getSheetAt(0);
	   sh.getLastRowNum();
	   rowcnt = sh.getLastRowNum()+1;
	   System.out.println(rowcnt);
	   for(int i=0;i<rowcnt;i++)
	   {
		  int cellcnt = sh.getRow(i).getLastCellNum();
		  for(int col = 0 ; col < cellcnt ; col++)
		  {
			  XSSFCell cell = sh.getRow(i).getCell(col);
			  if(cell.getCellType()== Cell.CELL_TYPE_STRING)
			  {
				  System.out.println(cell.getStringCellValue());
			  }
			 else if(cell.getCellType()== Cell.CELL_TYPE_NUMERIC)
			  {
				  String num = String.valueOf(cell.getNumericCellValue());
			        if(HSSFDateUtil.isCellDateFormatted(cell))
			        {
				   DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				   Date d = cell.getDateCellValue();
				   num = df.format(d);
				   System.out.println("date is" + num);
			        }
			  }
		  }
		  }
		  wb.close();
		  }
	
	}
	   
	




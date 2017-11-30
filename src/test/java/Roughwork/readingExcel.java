package Roughwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingExcel {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
        File inputFile  = new File("E:\\Testdata\\expedia.xlsx");
        FileInputStream fis = new FileInputStream(inputFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
        List<HashMap<String , String>> arraySearchList = new ArrayList<HashMap<String , String>>();
        XSSFSheet searchSheet = wb.getSheet("SearchFlight");
        int searchsheetRowcnt = searchSheet.getPhysicalNumberOfRows();
        System.out.println(" The total number of rows" + searchsheetRowcnt);
        Row headerRow = searchSheet.getRow(0);
        for(int rowindx = 1 ; rowindx <  searchsheetRowcnt ; rowindx++ ){
        	 Row currentRow = searchSheet.getRow(rowindx);
        	 HashMap<String , String> searchRowdata = new HashMap<String , String>();
        	 for(int colinx = 0 ; colinx < currentRow.getPhysicalNumberOfCells(); colinx++ ){
        		 Cell celldata = currentRow.getCell(colinx);
        		 switch(celldata.getCellType()){
        			 case Cell.CELL_TYPE_STRING:
        				 searchRowdata.put(headerRow.getCell(colinx).getStringCellValue(), celldata.getStringCellValue() );
        				 break;
        			 case Cell.CELL_TYPE_NUMERIC:
        				 searchRowdata.put(headerRow.getCell(colinx).getStringCellValue(), String.valueOf(celldata.getNumericCellValue()));
        				 break;
        		 }
        	 }
        	 arraySearchList.add(searchRowdata);	
        }
        // Printing the content of the hash table
        for(HashMap<String ,String> keyelement : arraySearchList){
        	for(String key : keyelement.keySet()){
        		System.out.println(key + "\t" + keyelement.get(key) );
        	}
        }
       
        System.out.println("\n");
	
	}	

}

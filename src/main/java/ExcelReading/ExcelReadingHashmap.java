package ExcelReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingHashmap {
	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		 XSSFWorkbook wb ;
		 XSSFSheet sh;
		 int rowcnt;
		 ArrayList<String> headerlist;
		 ArrayList<String> rowdata;
	   File ipFile = new File("E:\\Testdata\\expedia.xlsx");
	   FileInputStream src = new FileInputStream(ipFile);
	   wb = new XSSFWorkbook(src);
	   sh = wb.getSheetAt(0);
	   sh.getLastRowNum();
	   rowcnt = sh.getLastRowNum();
	   System.out.println(rowcnt);
	   headerlist = new ArrayList<String>();
	   int headercnt = sh.getRow(0).getPhysicalNumberOfCells();
	   for(int header = 0; header<headercnt;header++)
	   {
		   XSSFCell headercell = sh.getRow(0).getCell(header);
		   String headerdata = headercell.getStringCellValue();
		    headerlist.add(headerdata);
		    
	   }
	   getheaderdata(headerlist);
	   rowdata = new ArrayList<String>();
	   for(int i=0;i<rowcnt;i++)
	   {
		  int cellcnt = sh.getRow(i).getLastCellNum();
		  for(int col = 0 ; col < cellcnt ; col++)
		  {
			  XSSFCell cell = sh.getRow(i+1).getCell(col);
			  if(cell.getCellType()== Cell.CELL_TYPE_STRING)
			  {
				rowdata.add(cell.getStringCellValue());
			  }
			 else if(cell.getCellType()== Cell.CELL_TYPE_NUMERIC)
			  {
				  String num = String.valueOf(cell.getNumericCellValue());
			        if(HSSFDateUtil.isCellDateFormatted(cell))
			        {
				   DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				   Date d = cell.getDateCellValue();
				   num = df.format(d);
				   rowdata.add(num);
			        }
			  }
		  }
		 
		  }
	       getrowdata(rowdata);
	      setHeaderkey(headerlist,sh ,rowdata);
	      //setHashmapdata(headerlist , rowdata);
	      
		  wb.close();
		  }

	private static void setHeaderkey(ArrayList<String> headerlist, XSSFSheet sh,ArrayList<String> rowdata ) {
		ArrayList<String> keyslist = new ArrayList<String>();
		System.out.println("rowsize" + rowdata.size());
		int rowscnt = sh.getLastRowNum()+1;
		int k = 1;
	    do{
	    	keyslist.addAll(headerlist);
	    	k++;
	    }while (k<rowscnt);
	   System.out.println("The size of keyslist"+ keyslist.size());
	   for(int i = 0 ; i<keyslist.size();i++){
		   System.out.println(keyslist.get(i));
		   //setHashmapdata( keyslist, rowdata);
	   }
	setHashmapdata( headerlist, rowdata);
	}

	private static void setHashmapdata(ArrayList<String> headerlist, ArrayList<String> rowdata) 
	{
	   HashMap<String , String> mp = new HashMap<String , String>();
	   ArrayList<HashMap<String , String>> al = new ArrayList<HashMap<String , String>>();
	   int keyscnt = headerlist.size();
	   int rowdatacnt = rowdata.size();
	   int k = 0, t = 0;
	   while(k < keyscnt && t< rowdatacnt)
	   {
				   mp.put(headerlist.get(k), rowdata.get(t)); 
				   k++;
	               t++;
			   }
	               
			   getHashmap(mp);
			   al.add(mp);
			   for(int i = 0; i<al.size();i++){
				   System.out.println("arraylist : " + al.get(i));
			   }
			   }
		   
	private static void getHashmap(HashMap<String, String> mp)
	{
		Iterator entries = mp.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		     String key =  (String) entry.getKey();
		     String value = (String)entry.getValue();
		    System.out.println("Key = " + key + ", Value = " + value);
		}
	
	}
	
	private static void getrowdata(ArrayList<String> rowdata) {
		for(int rwid = 0; rwid<rowdata.size();rwid++){
			System.out.println(rowdata.get(rwid));
		}
		
	}

	private static void getheaderdata(ArrayList<String> headerlist) {
		for(int i=0;i<headerlist.size();i++){
			System.out.println(headerlist.get(i));
		}
		
	}
	
	}
	   
	




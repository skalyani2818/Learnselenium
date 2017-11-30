package Roughwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtil {

	public static void main(String[] args) throws IOException {
		
		String path = "E:\\Selenium Tutorials\\Selenium practice files\\Loginsheet.xlsx";
		String SheetName = "Login";
		Object[][] tab = getData( path,SheetName) ;
		showtab(tab,SheetName,path);
	}



	public static void showtab(Object[][] tab , String sheetname , String path) throws IOException {
		
		File f = new File(path);
		FileInputStream readFile = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(readFile);
		XSSFSheet sh = wb.getSheet(sheetname);
		int row = tab.length;
		int col = tab[0].length;
		Object[][] exceldata = new Object[row][col];
		for(int i = 1 ; i < row ; i++){
			for(int j = 0; j <= col ; j++){
				exceldata[i][j]    = getCell(sh,i,j);
				System.out.println(exceldata[i][j] + "");
			}
		}
	}



	public static Object[][] getData(String path, String sheetName) throws IOException {
		String passingPath = path;
		String sheet = sheetName;
		Object[][] tab1 = null;
		File f = new File(passingPath);
		FileInputStream readFile = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(readFile);
		XSSFSheet sh = wb.getSheet(sheet);
		int rwCnt = sh.getPhysicalNumberOfRows();
		System.out.println("Row count " + rwCnt);
		int colunm = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println("column count" + colunm);
		tab1 = new Object[rwCnt][colunm];
		for(int r = 1 ; r < rwCnt ; r++){
			for(int c = 0 ; c < colunm ; c++){
				tab1[r][c] = getCell(sh,r,c);
			}
		}
		return tab1;
	}

	
    public static String getCell(XSSFSheet sheet, int r, int c) {
		   XSSFSheet s = sheet;
		   XSSFCell cell = s.getRow(r).getCell(c);
		    String celldata = null;
		if(cell.getCellType() == Cell.CELL_TYPE_STRING){
			  celldata =  cell.getStringCellValue();
		}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
		    	  celldata = String.valueOf(cell.getNumericCellValue());
		}else if(cell.getCellType()== Cell.CELL_TYPE_BLANK){
			  celldata = "";
		}else  {
				 celldata =  String.valueOf(cell.getBooleanCellValue());
				}
		
		return celldata;
    }
    }
		
		   
		
	


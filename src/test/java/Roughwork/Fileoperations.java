package Roughwork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import com.google.common.io.Files;

public class Fileoperations {

	public static void main(String[] args) throws IOException  {
		
		 String folderName = "SeleniumScreenShots";
		 String path = "E:\\";
		 String subdirectory = "siva";
		 String filename = "siva.txt";
		 String path1 = fileCreation(path , folderName);
		 System.out.println("After main folder created the path" + path1);
		 subfileCreation(path1,subdirectory,filename);
		/* boolean s = absolutePath(path1);
		 if(s == true){
			 System.out.println("The directory is exist");
			 
		 }else {
			 System.out.println("The directory not exist");
			
		 }**/
	}

/*	private static void writingdata(String subpath,String filename,String folder) 
	{
		String fileName = filename;
		String subpathname = subpath;
		String mainFolder = folder;
		File f = new File(mainFolder);
		if(f.isDirectory())
		{
			System.out.println("it is directory");
		}else
		{
			System.out.println("not a directory");
		}
	}**/

	private static String fileCreation(String path, String folderName) throws IOException  
	{
		String filePath = path;
		String folder = folderName;
		File folderCreate = new File(filePath ,folder);
		String path1 = null;
		if(!folderCreate.exists())
		{
			if(folderCreate.mkdir())
			{
				System.out.println("The main folder was created");
				
			}else {
					System.out.println(" The folder was not created due to exception");
					}
	}else{
		System.out.println("The main folder already exist");
		System.out.println(folderCreate.getName());
		
	}
		path1 = folderCreate.getAbsolutePath();
		return path1;	
	}
	
	
	
	 private static void subfileCreation(String path1, String subdirectory ,String filename) throws IOException {
	   String subpath = path1;
	   String subdir = subdirectory;
	    boolean dir = absolutePath(subpath);
	    if(dir == true){
	    	File sub = new File(subpath,subdir);
	    	if(!sub.exists()){
	    		if(sub.mkdir()){
	    			System.out.println("The sub folder created");
	    			String subpath1 = sub.getAbsolutePath();
	    			System.out.println(" The subpath is" + subpath1);
	    			textFileCreation(sub ,filename );
	    			
	    					
	    		}else{
	    			System.out.println("The sub folder not created");
	    		}
	    	}
	    }
	   
	
}

	private static void textFileCreation(File subdir,String filename) throws IOException {
		String fileName = filename;
		 if(subdir.isDirectory()){
			String s =  subdir.getName();
			System.out.println("The sub directory" + s);
			String path2 = subdir.getAbsolutePath() ;
			String pathurl = path2 +  "\\" + fileName ;
			 File f = new File(pathurl);
			 if(!f.exists()){
				 System.out.println("Create new file" +f.createNewFile()); 
			 }else{
				 System.out.println("The file already exist");
			 }
		 }
		
		 
	}

	public static boolean absolutePath(String fpath){
		 String pathVari = fpath;
		 File f = new File(pathVari);
		 boolean directoryfound = false;
		 if(f.isDirectory()){
					directoryfound = true;
		 }else{
			        directoryfound = false;
		 }
		 return directoryfound;
		 
}
	
};
		




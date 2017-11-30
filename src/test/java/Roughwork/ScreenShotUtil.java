package Roughwork;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {

	public static String screenshots(WebDriver driver, String filename){
		 String destinationPath;
		 filename = filename + ".jpeg";
		 String screenshotpath = "E:\\SeleniumScreenShots\\Images";
		 File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(srcfile, new File(screenshotpath + filename));
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		 destinationPath = screenshotpath + filename;
		return destinationPath;
		
		 
	}
}

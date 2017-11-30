package Roughwork;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ExtentReportsName {
 
	  String url = "https://www.gmail.com";
	  WebDriver driver;
	  ExtentReports rep;
	  ExtentTest testEx;
	  ScreenShotUtil su;
	  
  @BeforeClass
  public void Setup() 
  {
	    
	   rep = new ExtentReports("E:\\SeleniumScreenShots\\siva\\defaultcaptureScreenShot.html");
	   testEx = rep.startTest("Verify the gmail login", "This test is used for verifing for gmail login functionality");
	   
	   
	   //Initializing  the chromedriver
	   System.setProperty("webdriver.chrome.driver", "E:\\Selenium Tutorials\\Selenium software 281116\\chromedriver.exe");
	   driver = new ChromeDriver();
	   testEx.log(LogStatus.INFO, "The chrome browser was intialized");
	   
	   //Maximize the browser and pass the base url
	   testEx.log(LogStatus.INFO, "Maximize the browser");
	   testEx.setDescription("Maximize the browser");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   testEx.log(LogStatus.INFO, "Maximize the window");
	   driver.get(url);
	   testEx.log(LogStatus.INFO, "Navigate to the Url");
  }
  
  @Test(testName = "gmail")
  public void gmailLogin() {
	  Reporter.log("Checking the Gmail functionality");
	  testEx.getStartedTime();
	  testEx.log(LogStatus.INFO, "Entered to the gmail test");
	  testEx.log(LogStatus.INFO, "entering the user name and password");
	  
	  WebElement usrName = driver.findElement(By.xpath("//input[@name= 'Email']"));
	  usrName.sendKeys("siva.k28181");
	  testEx.log(LogStatus.INFO, "Entered the Username", "Username was entered");
	  
	  WebElement nxtBtn = driver.findElement(By.id("next"));
	  nxtBtn.click();
	  testEx.log(LogStatus.INFO, "Click the Next buttom", "clicking the next button");
	  
	  WebElement psw = driver.findElement(By.xpath("//input[@name = 'Passwd']"));
	  psw.sendKeys("kalyani2818");
	  testEx.log(LogStatus.INFO, "Entered the Password", "Password was entered");
	  
	  WebElement sign = driver.findElement(By.xpath(".//*[@id='signIn']"));
	  sign.click();
	  testEx.log(LogStatus.INFO, "Click the sign buttom", "clicking the signin button");
	  
	  testEx.log(LogStatus.INFO, "Checking whether the inbox page is displayed or not");
	  
	  try{
		 WebElement compose = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
		 Assert.assertTrue(compose.isDisplayed());
		 testEx.log(LogStatus.PASS,"The inbox page is displayed");
		 Reporter.log("The inbix is displayed", 1);
		   
	  }catch(ElementNotVisibleException ex){
		  String message = ex.getMessage();
		   testEx.log(LogStatus.INFO, message);    
	  }
	    
	  //click on the photo image in the inbox page after login
	  testEx.log(LogStatus.INFO, "Click on the photo image" ,"Clicking on the photo image");
	  WebElement photoimg = driver.findElement(By.xpath("//a[@class = 'gb_b gb_eb gb_R']"));
	  photoimg.click();
	   //Click on the logout button
	  testEx.log(LogStatus.INFO, "click on the logout link", "clicked on the logout link");
	  WebElement logoutLink = driver.findElement(By.xpath(".//*[@id='gb_71']"));
	  logoutLink.click();
	  
	  testEx.log(LogStatus.INFO, "End of the test case in test method");
	  testEx.getEndedTime();
	  
	    
  }

  @AfterMethod
  public void ClosingResult(ITestResult res) {
	   System.out.println("The test status name is :" + res.getStatus());
	   String filename =  res.getName();
	   if(res.getStatus()== ITestResult.FAILURE){
		 String path =  ScreenShotUtil.screenshots(driver, filename);
		 String imagesPath = testEx.addScreenCapture(path);
		 testEx.log(LogStatus.FAIL, "Verifying gmail functionality fail", imagesPath);
	   }
	  
	  testEx.log(LogStatus.INFO, "shut down the browser");
	  driver.quit();
	  rep.endTest(testEx);
	  rep.flush();
  }

}

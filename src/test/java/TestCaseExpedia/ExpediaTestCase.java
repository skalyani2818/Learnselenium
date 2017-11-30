package TestCaseExpedia;

import org.testng.annotations.Test;

import PagesPackage.FlightPage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class ExpediaTestCase {
 
	 WebDriver driver;
	 String url = "https://www.expedia.co.in/";
	 String date = "30";
	
  @BeforeTest
  public void beforeTest() {
	 System.setProperty("webdriver.chrome.driver", "E:\\Selenium Tutorials\\Selenium software 281116\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 
  }

  @Test
  public void flightreserve() throws Exception 
  {
	  System.out.println("I am in the test class");
	  FlightPage fp = PageFactory.initElements(driver, FlightPage.class);
	  fp.flights_tabclick(url);
	  fp.departingSelection();
	  //getting the dates from the first position calendar
	  List <WebElement> dates = driver.findElements(By.xpath("//div[@class = 'datepicker-cal-month'][position() = 1]//tbody[@class = 'datepicker-cal-dates']//td"));
	  for(WebElement getdate : dates)
	  {
		  String datevalue = getdate.getText();
		  System.out.println(datevalue);
		  if(datevalue.equalsIgnoreCase(date)){
			  System.out.println("I am in if block");
			  fp.calenderclick(date);
			  break;  
		  } 
	  } 
  }
  
  @Test(dependsOnMethods = {"flightreserve"} )
  public void advanceflightreserver()
  {
	  System.out.println("I am in the advance reservastion method");
  }
    
  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }

}

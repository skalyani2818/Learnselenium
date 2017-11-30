package PagesPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FlightPage {
	
	 WebDriver driver;
	 
	 //Initiation of the driver
	 public FlightPage(WebDriver driver){
		 this.driver = driver;
		
	 }
	 
	 //Finding the elements in the page
	 @FindBy(how = How.XPATH , using = "//a[@id = 'primary-header-flight']" )
	 WebElement flights_tab;
	 
	 @FindBy(how = How.XPATH , using = "//label[@id = 'flight-type-one-way-label']" )
	 WebElement One_way;
	 
	 @FindBy(how = How.XPATH , using = "//input[@id = 'flight-origin']" )
	 WebElement Flying_from;
	 
	 @FindBy(how = How.XPATH , using = "//input[@id = 'flight-destination']" )
	 WebElement Flying_to;
	 
	 @FindBy(how = How.XPATH , using = "//input[@id ='flight-departing']" )
	 WebElement departing;

	 @FindBy(how = How.XPATH , using = "//div[@class = 'datepicker-cal-month'][position() = 1]" )
	 WebElement calender;
	 
	 @FindBy(how = How.XPATH , using = "//button[@class = 'datepicker-paging datepicker-prev btn-paging btn-secondary prev']" )
	 WebElement button_arrow_prev;
	 
	 @FindBy(how = How.XPATH , using = "//button[@class = 'datepicker-paging datepicker-next btn-paging btn-secondary next']" )
	 WebElement button_arrow_next;
	 
	 @FindBy(how = How.XPATH , using = "//caption[@class = 'datepicker-cal-month-header']" )
	 WebElement caption_text;
	 
	 @FindBy(how = How.XPATH , using = "//select [@id = 'flight-adults']" )
	 WebElement adulit_dropdown;
	 
	 
	 @FindBy(how = How.XPATH , using = "//select[@id = 'flight-children']" )
	 WebElement childeren_dropdown;
	 
	 @FindBy(how = How.XPATH , using = "//select[@id = 'flight-age-select-1']" )
	 WebElement children_age_dropdown;
	 
	 @FindBy(how = How.XPATH , using = "//button[@id = 'search-button']" )
	 WebElement searchbutton;
	 
	 
	 //Methods for each element
	 
	 public void flights_tabclick(String url) throws Exception{
		 driver.get(url);
		 Thread.sleep(4000);
		 flights_tab.click();
	 }
	 
	 public void departingSelection() throws Exception{
		 departing.click();
		 Thread.sleep(2000);
	 }
	 
	 public void searchbuttonclick() throws Exception{
		 searchbutton.click();
		 Thread.sleep(2000);
	 }
	 
	 public void calenderclick(String date) throws Exception{
		 calender.click();
		 Thread.sleep(2000);
	 }
	 
	 
	 
	 
	 
	 
}

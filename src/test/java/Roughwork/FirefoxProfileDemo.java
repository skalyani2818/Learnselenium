
package Roughwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxProfileDemo {

	

	public static void main(String[] args) {
		
		String url = "www.gmail.com";
		WebDriver driver;
		
		//Creating the profile
		
		
		 
		//intializing the profile
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		ProfilesIni firefoxprofile = new ProfilesIni();
		FirefoxProfile fp = firefoxprofile.getProfile("sivaprasadselenium");
		driver = new FirefoxDriver(fp);
		driver.manage().window().maximize();
		driver.get(url);

	}

}

package Roughwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class safaridriver {

	public static void main(String[] args) {
		
		String url = "https:\\www.gmail.com";
		WebDriver driver;
		
	    @SuppressWarnings("static-access")
		DesiredCapabilities cp = new DesiredCapabilities().safari();
	    cp.setCapability(CapabilityType.PLATFORM, "Windows");
		 driver = new SafariDriver(cp);
		 driver.manage().window().maximize();
		 driver.get(url);
		

	}

}

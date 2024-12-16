package pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasePage {
	protected AndroidDriver driver;

	public BasePage(AppiumDriver driver2) {
		
	}

	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5555");
		caps.setCapability(MobileCapabilityType.APP,
				"C:\\\\Users\\\\ramyaram\\\\Downloads\\\\com.ulsumobile.calculator-1.1.apk");
		caps.setCapability(MobileCapabilityType.NO_RESET, "false");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}
	
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	

}

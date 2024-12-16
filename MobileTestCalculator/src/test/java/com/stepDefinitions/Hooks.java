package com.stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static AppiumDriver driver;

    @Before
    public void setUp_app() {
        System.out.println("Setting up Appium driver...");
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                
                caps.setCapability(MobileCapabilityType.APP,
        				"C:\\Users\\ramyaram\\Downloads\\com.ulsumobile.calculator-1.1.apk");
        		caps.setCapability(MobileCapabilityType.NO_RESET, "false");

               
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                System.out.println("Appium driver initialized successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize Appium driver.");
            }
        }
    }
    
    @Before
    public void setUp() {
        System.out.println("Setting up Appium driver...");
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                
                
        		caps.setCapability(MobileCapabilityType.NO_RESET, "false");

                driver = new AndroidDriver(new URL("https://www.globalsqa.com/demo-site/select-dropdown-menu/"), caps);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                System.out.println("Appium driver initialized successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize Appium driver.");
            }
        }
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down Appium driver...");
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure driver is reset between tests
            System.out.println("Appium driver quit successfully.");
        }
    }

    public static AppiumDriver getDriver() {
        System.out.println("Returning Appium driver instance...");
        return driver;
    }
}

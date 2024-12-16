package com.stepDefinitions;

import java.net.MalformedURLException;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.timeout.TimeoutException;
import io.qameta.allure.Allure;
import pageObjects.BasePage;


import pageObjects.dropdownObjects;

import com.stepDefinitions.Hooks;

public class Dropdown extends Hooks {
	 private AppiumDriver driver;
	 private dropdownObjects Obj;
	 
	public Dropdown() {
       
        this.driver = Hooks.getDriver();
        if (driver == null) {
            System.out.println("Driver is null in LoginSteps constructor!");
            throw new RuntimeException("Driver is not initialized.");
        }
        this.Obj = new dropdownObjects(driver);
    }

	@Given("User is on Dropdown page")
	public void user_is_on_DropdownPage() throws MalformedURLException {
		setUp();
	}	
	// Interact with dropdown
    @When("^I select India from the dropdown$")
    public void i_select_from_the_dropdown() {
        
        WebElement dropdownOption = driver.findElement(Obj.India);
        dropdownOption.click();
        Allure.addAttachment("Dropdown Option Selected","India");
    }

    @Then("^India should be selected$")
    public void should_be_selected(String option) {
    	WebElement selectedOption = driver.findElement(By.xpath("//select[@text='" + option + "']"));
        Assert.assertTrue(selectedOption.isDisplayed()); 
    }

       // Perform drag-and-drop
    @When("^I drag the item from Source Image to Trash$")
    public void i_drag_the_item_from_to() {
    	WebElement dragandDrop = driver.findElement(Obj.dragandDrop);
        dragandDrop.click(); 
    	WebElement source = driver.findElement(Obj.source);
    	WebElement target = driver.findElement(Obj.target);
    	  TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
          
          // Perform long press and move to target element, then release
          touchAction.longPress(ElementOption.element((WebElement) source))
                  .moveTo(ElementOption.element((WebElement) target))
                  .release()
                  .perform();
          Allure.addAttachment("Source Element", "source");
          Allure.addAttachment("Target Element", "target");
    }

    @Then("^the item should be dropped successfully$")
    public void the_item_should_be_dropped_successfully() {
        // Verification logic (e.g., check the position of the item after drop)
        System.out.println("Item dropped successfully.");
    }

    
    
   
	public void wait(By byValue) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(byValue));
		} catch (TimeoutException e) 
		{
			System.out.println("Timed out");
		}
	}
}

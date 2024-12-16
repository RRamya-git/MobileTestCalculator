package pageObjects;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class dropdownObjects extends BasePage {

	
	public dropdownObjects(AppiumDriver driver) {
        super(driver);
    }
	
	public By India = By.xpath("//select/option[@value='IND']");
	public By dragandDrop = By.xpath("(//a[contains(.,'Drag And Drop')])[3]");
	public By source = By.xpath("//li[@class='ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle'][1]");
	public By target = By.xpath("//div[@class='ui-widget-content ui-state-default ui-droppable'][1]");
	
    
    
    
}

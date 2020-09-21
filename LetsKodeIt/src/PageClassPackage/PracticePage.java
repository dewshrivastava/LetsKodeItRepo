package PageClassPackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {
	//Finding Locators
	By practicePage = By.xpath("//h1[contains(text(),'Practice Page')]");
	By benzCar = By.id("benzradio");
	By selectDropDown = By.id("carselect");
	By selectCheckBoxes = By.xpath("//input[@type='checkbox']");
	By openWindowButton = By.id("openwindow");
	By openTabButton = By.id("opentab");
	By frameTitle = By.className("course-listing-title");
	By alertTextBox = By.id("name");
	By alertButton = By.id("alertbtn");
	By confirmButton = By.id("confirmbtn");
	By hideButton = By.id("hide-textbox");
	By showButton = By.id("show-textbox");
	By hideShowTextBox = By.id("displayed-text");
	By iframeSection = By.id("courses-iframe");
	By searchBox = By.id("search-courses");
	By searchButton = By.cssSelector("button[class='btn search btn-default btn-lg']");
	By iframeOption = By.xpath("(//div[@class='course-listing-subtitle'])[1]");
	By courseTitle = By.className("course-title");
	By webTable = By.id("product");
	By priceList = By.xpath("//table[@id='product']/tbody/tr/td[3]");
	By mouseHoverButton = By.id("mousehover");
	By top = By.xpath("//div[@class='mouse-hover-content']/a");
	
	
	//Constructor created to access driver
	
	WebDriver driver;
	public PracticePage(WebDriver webDriver) {
		
		driver = webDriver;
		
	}
	
		
	//Method To Select RadioButton
	public Boolean selectRadioButton() {
		driver.findElement(benzCar).click();
		return true;
	}
	
	//Method To Select Value from Static Drop Down
	public Boolean selctFromDropDown() {
		Select select = new Select(driver.findElement(selectDropDown));
		select.selectByValue("benz");
		return true;
		
	}
	
	//Method to wait till element visible
	public Boolean waitTillVisible() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(practicePage));
	return true;
	}
	
	//Method To select multiple value from drop down
	public Boolean selectMultipleValue() {
		WebElement options = driver.findElement(By.id("multiple-select-example"));
		Select select = new Select(options);
		select.selectByValue("apple");
		select.selectByValue("orange");
		select.selectByValue("peach");
	    return true;
		}
	
	//Method to select multiple check boxes
	public Boolean selectCheckBox() {
		int count = driver.findElements(selectCheckBoxes).size();				
		for (int i=0; i<count;i++) 
		{
			driver.findElements(selectCheckBoxes).get(i).click();
		}
		return true;
	}
	
	//Method to switch window
	public int validateSwitchWindowFunctionality() {		
		  driver.findElement(openWindowButton).click();
		  int count = driver.getWindowHandles().size();
		  return count;
		  		 
		}  
 

	public int checkForOpenTab() {
		driver.findElement(openTabButton).click();;
		int count = driver.getWindowHandles().size();
		return count;
	}
	
		
	//Method to Handle Alert window
	public String alertAccept () {
		driver.findElement(alertTextBox).sendKeys("TestUser");
		driver.findElement(alertButton).click();
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();;
		return text;
		
	}
	
	//Method to handle Alert Window- Dismiss
	public Boolean alertDismiss () {
		driver.findElement(alertTextBox).sendKeys("TestUser");
		driver.findElement(confirmButton).click();
		driver.switchTo().alert().dismiss();
		return true;
	}

	//Method to check Hide feature
	public Boolean hideTextBox() {
		driver.findElement(hideButton).click();
		if(driver.findElement(hideShowTextBox).getAttribute("style").contains("none"))
		{
			return true;
		} else {
			return false;
		}
		
	}
	
	//Method to check Show feature
	public Boolean displayTextBox() {
		driver.findElement(hideButton).click();
		driver.findElement(hideShowTextBox).isDisplayed();
		return true;
	}
    
	//Method to handle iframe
	public String handleiFrame () {
		driver.switchTo().frame(0);
		driver.findElement(searchBox).sendKeys("Selenium");
		driver.findElement(searchButton);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(iframeOption));
		driver.findElement(iframeOption).click();
		wait.until(ExpectedConditions.elementToBeClickable(courseTitle));
		String text = driver.findElement(courseTitle).getText();
		driver.switchTo().defaultContent();
		driver.findElement(benzCar).click();
		return text;
		
	}
	
	//Method to select value from Web Table
	public Boolean selectFromTable () {
		int sum = 0;
		WebElement table = driver.findElement(webTable);
		int count = table.findElements(priceList).size();
		
		for(int i=0; i<count; i++) {
			String value = table.findElements(priceList).get(i).getText();
			int valueInteger = Integer.parseInt(value);
			System.out.println(valueInteger);
			sum = sum + valueInteger;
			}
		    System.out.println("The sum of prices is"  + sum);
			return true;
		}
	
	//Method of MouseHover
	public Boolean mouseHover () {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(mouseHoverButton)).perform();
		action.moveToElement(driver.findElement(top)).click();
		return true;
	}
		
}
	






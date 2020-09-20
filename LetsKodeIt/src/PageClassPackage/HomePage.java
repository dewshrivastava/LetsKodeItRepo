package PageClassPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	// Locators
	By practiceButton = By.xpath("//a[contains(text(),'Practice')]");
	
	//Constructor Created to access Driver 
	WebDriver driver;
	
	public HomePage (WebDriver webDriver) {
		driver = webDriver;
	}
	
	//Method Created to click on Practice button
	public PracticePage clickOnPractice () {
		driver.findElement(practiceButton).click();
		PracticePage practicePage = new PracticePage(driver);
		return practicePage;
	}

	public void waitTillClickable() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(practiceButton));		
	}
}

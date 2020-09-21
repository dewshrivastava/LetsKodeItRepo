package TestCasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageClassPackage.HomePage;
import PageClassPackage.PracticePage;

public class TestClass {
	
	@Test
	public void navigatetionOfPracticePage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/");
		//Creating a object of HomePage class and passing Driver
		HomePage homePageObj = new HomePage(driver);
		homePageObj.waitTillClickable();
		PracticePage practicePage = homePageObj.clickOnPractice();
		Boolean bool = practicePage.waitTillVisible();
		Assert.assertTrue(bool);
		driver.quit();
	} 
	
	@Test
	public void selectRadioButton() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/");
		HomePage homePage = new HomePage(driver);
		homePage.waitTillClickable();
		homePage.clickOnPractice();
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.selectRadioButton();
		Assert.assertTrue(bool);
		driver.quit();
		
	}

	@Test
	//Select Multiple Value from Select Drop Down
	public void selectMultipleValueFromDropDown() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.selectMultipleValue();
		Assert.assertTrue(bool);
		driver.quit();
	}  
	
	@Test
	//Select Multiple Check Boxes
	public void selectValueFromCheckBox() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.selectCheckBox();
		Assert.assertTrue(bool);
		driver.quit();
		
	}  
	
	@Test
	public void varifySwitchWindowFunctionality() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		int count = practicePageObj.validateSwitchWindowFunctionality();
		Assert.assertEquals(count, 3);
		driver.quit();
		
	}  
	  
	
	@Test
	//Test to switch to new tab
	public void verifyNewTabOpened() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		int count = practicePageObj.checkForOpenTab();
		Assert.assertEquals(count, 3);
		driver.quit();
	}  
	
	
	@Test
	//Test to Handle Alert-Accept
	public void switchToalertAccept() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		String text = practicePageObj.alertAccept(); 
		Assert.assertEquals(text, "Hello TestUser, share this practice page and share your knowledge");
		driver.quit();
	} 
	
	
	@Test
	//Test to Handle Alert-Dismiss 
	public void switchToalertDismiss() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.alertDismiss(); 
		Assert.assertTrue(bool);
		driver.quit();
    }  
	
	@Test
	//Test to check text field is hidden
	public void checkFieldIsHidden() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.hideTextBox();
		Assert.assertTrue(bool);
		driver.quit();
	}  
	  
	@Test
	//Test to check field is displayed
	public void checkFieldDisplayed() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.displayTextBox();
		Assert.assertTrue(bool);
		driver.quit();
		
	}
	
	
	@Test
	//Test to handle iframe
	public void searchInIFrame() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		String text = practicePageObj.handleiFrame();
		Assert.assertEquals(text,"Selenium WebDriver With Java");
		driver.quit();
		
	} 
	
	@Test
	//Test to select values from webTable
	public void selectFromWebTable() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.selectFromTable();
		Assert.assertTrue(true);
		driver.quit();	
		
	} 
	
	@Test
	//Test mouse Hover feature
	public void checkElementVisibleOnMouseHover() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ketanpc\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");
		PracticePage practicePageObj = new PracticePage(driver);
		practicePageObj.waitTillVisible();
		Boolean bool = practicePageObj.mouseHover();
		Assert.assertTrue(bool);	
		driver.quit();
		
	}
	
}
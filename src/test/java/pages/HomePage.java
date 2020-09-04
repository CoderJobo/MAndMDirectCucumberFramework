package pages;

import core.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	private String title = "MandM Direct Ireland | Cheap Mens, Womens & Kids Clothing";
	
	@FindBy(xpath=".//div[@id='myAccount']")
	private WebElement myAccount;

	@FindBy(xpath=".//a[@id='womens']")
	private WebElement womensTab;

	By signInButton = By.xpath(".//span[text()='Sign In']");
	By signOutButton = By.xpath(".//span/a[text()='Sign Out'][1]");
	By homePagePanel = By.xpath(".//div[@id='homepagePanelContainer']");
	By womensShoes = By.xpath(".//a[@id='womens']/following-sibling::div//a[text()='Shoes']");
	By searchInput = By.xpath(".//input[@id='mainSearchText']");
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) throws Exception {
		this.driver = driver;
	}

	public void launchApp(){
		driver.get(TestConfig.getProperty("appBaseURL"));
	}

	public boolean ifNavigatedToMAndMDirect(){
		return driver.findElement(homePagePanel).isDisplayed();
	}

	public void performSearch(String product) {
		driver.findElement(searchInput).sendKeys(product, Keys.ENTER);

	}

	public void chooseWomensShoes(){
		moveToElement(driver, womensTab);
		driver.findElement(womensShoes).click();
	}
	
//	public void navigateToLoginPage() {
//		driver.findElement(signInButton).click();
//	}
//
//	public boolean verifyLoginError(String errorMessage) {
//		return waitElement(driver, By.xpath(".//li[contains(text(), \"" + errorMessage + "\")]"), 20).isDisplayed();
//	}


}

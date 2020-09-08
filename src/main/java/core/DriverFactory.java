package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private WebDriver driver = null;
	
	public WebDriver getDriver(String browser) {
		switch(browser.toLowerCase()) {
		case "chrome" : 
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox" :
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			default : 
				System.out.println("Incorrect browser name provided: " + browser);
				System.out.println("Defaulting to run in Chrome...");
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
		}
		System.out.println("Getting page load timeout...");
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(TestConfig.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		System.out.println("Getting implicit wait timeout...");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
		return driver;
	}
	
	public void quitDriver() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	

}

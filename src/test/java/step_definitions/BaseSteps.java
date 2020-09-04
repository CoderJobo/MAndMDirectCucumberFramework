package step_definitions;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import core.JSONDataProvider;
import core.TestConfig;
import pages.HomePage;
import pages.SearchResultPage;

public class BaseSteps {
	
	private static WebDriver driver = null;
	
	public BaseSteps() throws Exception {}
	
	public Map<String, String> data(String dataSet) throws Exception {
		File testDataLocation = new File("src/main/resources/testdata");
		String env = TestConfig.getProperty("env");
		JSONDataProvider dataProvider = new JSONDataProvider(testDataLocation + "/data." + env + ".json");
		return dataProvider.getAllData(dataSet);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		BaseSteps.driver = driver;
	}
	
	public HomePage getHomePage() throws Exception {
		return new HomePage(driver);
	}
	
	public SearchResultPage getSearchResultPage() throws Exception {
		return new SearchResultPage(driver);
	}

}

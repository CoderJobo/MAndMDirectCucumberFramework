package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    public HomeSteps() throws Exception {}
	
    @Given("^I am navigated to M And M Direct$")
    public void navigateToMAndMDirect() throws Exception {
        System.out.println("Navigating to M And M Direct...");
        getHomePage().launchApp();
        Assert.assertEquals(true, getHomePage().ifNavigatedToMAndMDirect());
    }

    @When("^I perform a search for a (.*?) product$")
    public void searchForProduct(String productName) throws Exception {
        System.out.println("Searching for " + productName + "...");
        getHomePage().performSearch(productName);
    }

}

package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;


public class SearchResultSteps extends BaseSteps {

    public SearchResultSteps() throws Exception {}

    @Then("I should see search results for that product")
    public void iShouldSeeSearchResultsForThatProduct() throws Exception {
        System.out.println("Verifying if search results are displayed...");
        Assert.assertEquals(true, getSearchResultPage().verifyIfSearchResultDisplayed()); ;
    }
}

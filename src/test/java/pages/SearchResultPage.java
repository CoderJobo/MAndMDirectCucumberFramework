package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    By searchResults = By.xpath(".//div[@class='row-fluid items']");

    private WebDriver driver;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean verifyIfSearchResultDisplayed(){
        return driver.findElement(searchResults).isDisplayed();
    }
}

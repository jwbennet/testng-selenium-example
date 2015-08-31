package edu.iu.es.esi.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page("/")
public class GoogleSearchPage extends PageBase {

    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(name = "btnK")
    private WebElement searchButton;

    public String getSearchButtonValue() {
        return searchButton.getAttribute("value");
    }

    public GoogleSearchPage setSearchQuery(String query) {
        searchInput.sendKeys(query);
        return new GoogleSearchPage();
    }

    public boolean containsGoogle() {
        return driver.getPageSource().contains("Google");
    }
}

package entities.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@class = 'login']")
    private WebElement signUpButton;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class = 'btn btn-default button-search']")
    private WebElement searchButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openSite(String url) {
        super.driver.get(url);
    }

    public void openCreateAccountPage() {
        signUpButton.click();
    }

    public void fillSearchField(String request) {
        searchField.sendKeys(request);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }
}
package entities.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public static String userSearchRequest;

    public void setUserSearchRequest(String userSearchRequest) {
        SearchResultPage.userSearchRequest = userSearchRequest;
    }

    @FindBy(xpath = "//span[@class = 'lighter']")
    private WebElement searchResult;

    @FindBy(xpath = "//a[@class = 'product-name']")
    private WebElement productName;

    @FindBy(xpath = "//*[@class = 'alert alert-warning']")
    private WebElement warningMessage;

    public boolean checkSearchResultContainsUserRequest() {
        String getResult = searchResult.getText();
        String resultWithoutQuotes = getResult.substring(1, getResult.length() - 1);
        return resultWithoutQuotes.equalsIgnoreCase(userSearchRequest);
    }

    public boolean checkProductCardContainsUserRequest() {
        String result = productName.getText();
        return result.contains(userSearchRequest);
    }

    public boolean checkWarningMessageIsDisplayed(String message) {
        String actualMessage = warningMessage.getText();
        return message.equalsIgnoreCase(actualMessage);
    }

}

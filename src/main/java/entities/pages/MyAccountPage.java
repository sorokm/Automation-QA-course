package entities.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(className = "info-account")
    private WebElement messageInPage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean currentMyAccountPageUrlIsRight(String url) {
        return super.driver.getCurrentUrl().contains(url);
    }

    public boolean messageTextIsDisplayed(String message) {
        return messageInPage.getText().contains(message);
    }
}

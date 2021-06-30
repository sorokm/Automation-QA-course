package entities.pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkMyAccountPageUrl() {
        return super.driver.getCurrentUrl()
                           .contains("http://automationpractice.com/index.php?controller=my-account");
    }
}

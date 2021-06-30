package entities.pages;

import java.util.Random;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "email_create")
    private WebElement fieldEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    public void fillEmailField(String email) {
        Random random = new Random();
        int randomNumbers = random.nextInt(1000);
        String randomLogin = email + randomNumbers + "@gmail.com";
        fieldEmail.sendKeys(randomLogin);
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }
}

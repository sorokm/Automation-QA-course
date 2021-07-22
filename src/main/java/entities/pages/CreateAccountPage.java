package entities.pages;

import java.text.MessageFormat;
import java.util.Random;
import java.util.regex.Pattern;
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
        int randomNumbers = random.nextInt(1000000);
        while(email.contains("{}")) {
            email = email.replaceFirst(Pattern.quote("{}"), String.valueOf(randomNumbers));
        }
        String randomLogin = email + "@gmail.com";
        fieldEmail.sendKeys(randomLogin);
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }
}

package entities.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class PersonalInformationPage extends BasePage {

    public PersonalInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "customer_firstname")
    private WebElement fieldFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement fieldLastName;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "address1")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id='id_state']")
    private WebElement stateDropdown;

    @FindBy(id = "postcode")
    private WebElement postcodeField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    public void fillPersonalInformationForm(String firstName, String lastName, String pass, String address,
                                            String city, String state, String postcode, String mobilePhone) {
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        passwordField.sendKeys(pass);
        addressField.sendKeys(address);
        cityField.sendKeys(city);

        Select dropdownMenu = new Select(stateDropdown);
        dropdownMenu.selectByVisibleText(state);

        postcodeField.sendKeys(postcode);
        mobilePhoneField.sendKeys(mobilePhone);
    }

}

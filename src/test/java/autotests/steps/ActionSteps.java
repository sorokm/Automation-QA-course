package autotests.steps;

import autotests.context.TestContext;
import autotests.utils.PropertiesFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ActionSteps {

    TestContext testContext;

    public ActionSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        PropertiesFile propertiesFile = new PropertiesFile();
        WebDriver webDriver = propertiesFile.getBrowser();
        testContext.setWebDriver(webDriver);
        testContext.initializePageObject(testContext.getWebDriver());
    }

    @Given("I navigate to {string}")
    public void openSite(String url) {
        testContext.getHomePage().openSite(url);
    }

    @When("I open registration form")
    public void openRegistrationForm() {
        testContext.getHomePage().openCreateAccountPage();
    }

    @When("I fill all fields in the form with the valid data:")
    public void fillCreateFormFields(DataTable table) {
        testContext.initializePageObject(testContext.getWebDriver());
        List<List<String>> values = table.asLists();

        String login = values.get(1).get(0);
        String pass = values.get(1).get(1);
        String firstName = values.get(1).get(2);
        String lastName = values.get(1).get(3);
        String address = values.get(1).get(4);
        String city = values.get(1).get(5);
        String state = values.get(1).get(6);
        String postcode = values.get(1).get(7);
        String mobilePhone = values.get(1).get(8);

        testContext.getCreateAccountPage().fillEmailField(login);
        testContext.getCreateAccountPage().clickOnCreateAccountButton();

        testContext.getPersonalInformationPage().fillPersonalInformationForm(firstName,
            lastName, pass, address, city, state, postcode, mobilePhone);
    }

    @When("I click Register button")
    public void clickOnRegisterButton() {
        testContext.getPersonalInformationPage().getSubmitButton().click();
    }

    @When("I fill search field with {string} request")
    public void fillSearchField(String request) {
        testContext.getSearchResultPage().setUserSearchRequest(request);
        testContext.getHomePage().fillSearchField(request);
    }

    @When("I click on Search button")
    @When("I does not fill search field and click on Search button")
    public void clickOnSearchButton() {
        testContext.getHomePage().clickOnSearchButton();
    }

}


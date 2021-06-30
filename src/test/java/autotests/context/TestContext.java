package autotests.context;

import entities.pages.CreateAccountPage;
import entities.pages.HomePage;
import entities.pages.MyAccountPage;
import entities.pages.PersonalInformationPage;
import entities.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;

public class TestContext {

    WebDriver webDriver;

    CreateAccountPage createAccountPage;
    HomePage homePage;
    PersonalInformationPage personalInformationPage;
    MyAccountPage myAccountPage;
    SearchResultPage searchResultPage;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public CreateAccountPage getCreateAccountPage() {
        return createAccountPage;
    }

    public PersonalInformationPage getPersonalInformationPage() {
        return personalInformationPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public MyAccountPage getMyAccountPage() {
        return myAccountPage;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }

    public void initializePageObject(WebDriver webDriver) {
        createAccountPage = new CreateAccountPage(webDriver);
        homePage = new HomePage(webDriver);
        personalInformationPage = new PersonalInformationPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        searchResultPage = new SearchResultPage(webDriver);
    }

}

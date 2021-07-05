package autotests.steps;

import autotests.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AssertionSteps {
    TestContext testContext;

    public AssertionSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Account is created: the message {string} is displayed in the page")
    public void checkAccountWasCreated(String message) {
        Assert.assertTrue(testContext.getMyAccountPage().messageTextIsDisplayed(message));
    }

    @Then("Correct items are displayed in search result page")
    public void checkCorrectItemsAreDisplayed() {
        Assert.assertTrue(testContext.getSearchResultPage().isSearchResultContainUserRequest());
        Assert.assertTrue(testContext.getSearchResultPage().isProductCardContainUserRequest());
    }

    @Then("Warning message {string} is displayed in Search result page")
    public void checkWarningMessageIsDisplayed(String message) {
        Assert.assertTrue(testContext.getSearchResultPage().isWarningMessageDisplayed(message));
    }

    @After
    public void tearDown() {
        testContext.getWebDriver().quit();
    }
}

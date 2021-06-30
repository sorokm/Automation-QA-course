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

    @Then("New account is successfully created")
    public void checkAccountWasCreated() {
        Assert.assertTrue(testContext.getMyAccountPage().checkMyAccountPageUrl());
    }

    @Then("Correct items are displayed in search result page")
    public void checkCorrectItemsAreDisplayed() {

        Assert.assertTrue(testContext.getSearchResultPage().checkSearchResultContainsUserRequest());
        Assert.assertTrue(testContext.getSearchResultPage().checkProductCardContainsUserRequest());
    }

    @Then("Warning message {string} is displayed in Search result page")
    public void checkWarningMessageIsDisplayed(String message) {
        Assert.assertTrue(testContext.getSearchResultPage().checkWarningMessageIsDisplayed(message));
    }

    @After
    public void tearDown() {
        testContext.getWebDriver().quit();
    }
}

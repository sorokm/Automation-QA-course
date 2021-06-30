Feature: Online shop tests

  Background:
    Given I navigate to 'http://www.automationpractice.com'

  Scenario: Create new account
    When I open registration form
    And I fill all fields in the form with the valid data:
      | login     | pass  | first name | last name | address | city | state   | postcode | mobile phone |
      | testlogin | 12345 | Testname   | Testname  | address | City | Alabama | 11111    | 89111111111  |
    And I click Register button
    Then New account is successfully created

  Scenario: Check search work without sign in
    When I fill search field with 'Dress' request
    And I click on Search button
    Then Correct items are displayed in search result page

  Scenario: Check search work with empty user request
    When I does not fill search field and click on Search button
    Then Warning message 'Please enter a search keyword' is displayed in Search result page
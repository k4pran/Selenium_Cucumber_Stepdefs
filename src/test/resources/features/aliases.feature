Feature: Aliases to allow multiple ways of expressing the same thing

  Scenario: Go to url aliases
    Given I open the browser
      And I go to the website "https://www.google.com/"
      And I go to website "https://www.google.com/"
      And I visit the website "https://www.google.com/"
      And I visit website "https://www.google.com/"
      And I visit url "https://www.google.com/"

  Scenario: Open and close browser aliases
    Given I open the browser
      Then I close the browser
    Given I launch the browser
      Then quit
    Given I launch browser
      Then quit browser
    Given the browser has been launched
      And close browser
    Given the browser is opened
      And quit the browser

  Scenario: Selecting a browser alias
    Given I select driver "driver"
    Given I choose the driver "driver"
    Given I am using the driver "driver"
    Given I am using driver "driver"

    Given I refresh the page
      And I refresh page
      And select refresh
      And I press refresh page
      And refresh page
      And I click on refresh

  Scenario: Entering text
    Given I enter the text "text"
      And enter text "text"
      And type the text "text"
      And I input the text "text"
      And I input text "text"

  Scenario: Back and forward
    Given I go back a page
    Then I go forward a page
    Then I select back
    Then I go forward
    Then I click on forward
    Then I click back

  Scenario: Misc aliases
    Given the window is maximized
    Given window is maximized
    Given I maximize the window
    Given I maximize window

    Given I set implicit wait to 10 milliseconds
    Given implicit wait is set to 10 nanoseconds
      And set implicit wait to 10 seconds
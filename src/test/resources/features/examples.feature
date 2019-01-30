Feature: Basic examples

  Scenario: Open the browser
    Given I open the browser
    Then I close the browser

  Scenario: Open browser and go to url
    Given I open the browser
    # The 'I' is optional to make the grammar more readable for chained keywords
      And go to url "https://www.google.com/"
    Then I close the browser

  Scenario: Select element by id
    # Currently selected element will be stored in selectedElement
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by id using value "tophf"
    Then I close the browser

  Scenario: Select multiple elements by class name
    # Currently selected elements will be stored in selectedElements
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select elements by class name using value "SDkEP"
    Then I close the browser

  # You can also select using seleniums other selection methods such as xpath, css selector,
  # link text and partial link text

  Scenario: Clear selected elements
        # Currently selected elements will be stored in selectedElements
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select elements by class name using value "SDkEP"
      And select element by id using value "tophf"
    Then I clear selected elements
      And close the browser

  Scenario: Click on an element
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by xpath using value "/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[2]"
      And click selected element
    Then I close the browser

  Scenario: Hover over an element
    Given I open the browser
    And go to url "https://www.google.com/"
    When I select element by xpath using value "/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[2]"
      And hover over selected element
    Then I close the browser

  Scenario: Check current url is expected url
    Given I open the browser
      And go to url "https://www.google.com/"
    Then I check current url is "https://www.google.com/"
      And close the browser

  Scenario: Check current url contains part of the url
    Given I open the browser
      And go to url "https://www.google.com/"
    Then I check current url contains "google"
      And close the browser

  Scenario: Check current page title
    Given I open the browser
      And go to url "https://www.google.com/"
    Then I check the page title is "Google"
      And close the browser

  Scenario: Check current page title contains
    Given I open the browser
      And go to url "https://www.google.com/"
    Then I check the page title contains "Goog"
      And close the browser

  Scenario: Check an element's inner text
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by xpath using value "/html/body/div/div[7]/div[1]/div/div/div/div/div[2]/div/div/div[2]/div[1]"
    Then I check the element's inner text is equal to "A privacy reminder from Google"
      And close the browser

  Scenario: Check an element's inner text contains
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by xpath using value "/html/body/div/div[7]/div[1]/div/div/div/div/div[2]/div/div/div[2]/div[1]"
    Then I check the element's inner text contains "reminder"
      And close the browser

  Scenario: Entering text into an input field
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by xpath using value "/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input"
      And enter the text "Hello"
    Then I close the browser

  Scenario: Refresh page
    Given I open the browser
      And go to url "https://www.google.com/"
    When I refresh the page
    Then I close the browser

  Scenario: Go back a page
    Given I open the browser
      And go to url "https://www.google.com/"
      And go to url "http://www.bing.com/"
    When I go back a page
    Then I check current url is "https://www.google.com/"
      And I close the browser

  Scenario: Go forward a page
    Given I open the browser
      And go to url "http://www.bing.com/"
      And go to url "https://www.google.com/"
    When I go back a page
      And I go forward a page
    Then I check current url is "https://www.google.com/"
      And I close the browser

  Scenario: Clear elements
    # Clears both selectedElement and selectedElements
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by xpath using value "/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input"
      And I clear the selected elements
    Then I close the browser

  Scenario: Naming elements then selecting them
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by xpath using value "/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input"
      And I name the selected element as "myElement"
      And I select the named element "myElement"
      And enter the text "Hello"
    Then I close the browser

  Scenario: Checking an attribute exists and contains a value
    Given I open the browser
      And go to url "https://www.google.com/"
    When I select element by id using value "hplogo"
    Then I check the attribute "src" exists
      And I check the element's attribute "src" contains "/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
      And I close the browser
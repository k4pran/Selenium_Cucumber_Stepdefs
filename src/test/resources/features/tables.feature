Feature: Working with Grid Structures

  Scenario:
    Given I open the browser
    Given I go to the url "https://accessibility.umn.edu/web-designers/tables-web-pages"
    When I select element by xpath using value "//div[@class='field-item even']//table[2]//tbody[1]"
    Then I get the children of selected element
    Then I select element from elements by contained text "Season"
    Then I get the children of selected element
    Then I get index for element amongst selected elements containing "Season"
    Then I clear the selected elements
    Then I select elements by tag using value "tr"
    Then I select element from elements by contained text "Sweet Sixteen"
    Then I get the children of selected element
    Then I select element at current index from selected elements
    Then I check the selected element's inner text contains "Mid"

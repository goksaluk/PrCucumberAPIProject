
@Google
Feature: Search Car in London
  Scenario: Search Cars in London from Google
    Given the user is on the Google
    When the user search "Cars in London"
    Then displayed the result
    And verify the available "gumtree" Links number
    Then navigate to each Gumtree Link
    Then verify the title is displayed
    Then verify the number of cars grater then 0
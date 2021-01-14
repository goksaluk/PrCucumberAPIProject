@daviesgroup
Feature: Social Media Links

  Background:
    Given I open the DaviesGroup webpage


  @homepage
  Scenario: verify social media links
    When I click the social media links
    Then I should be navigate to respective social media webpages
      |Twitter|
      |LinkedIn|

@2ndSolution
Scenario: Gksl
  When I scroll down
  Then I click the buttons of social medias
  |twitter|
  |linkedin|
  And I verify social media page titles
    |Twitter|
    |LinkedIn|


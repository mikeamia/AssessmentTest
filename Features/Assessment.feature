Feature: Automation UI

  Scenario Outline: Scenario 2
    Given I open "http://www.saucedemo.com" with "chrome"
    When I input username with "<username>"
    And I input password with "<password>"
    And I click Login Button
    Then I see Homepage Screen
    When I Sort to see the highest price
    And I click first product
    Then I see detail of Product Name with the Highest Price
    When I checkout the product
    And input firstname with "<firstname>"
    And input lastname with "<lastname>"
    And input postal code with "<postalcode>"
    And click Continue Button
    And verify order status
    Then capture the screen



  Examples:
  | username | password | firstname | lastname | postalcode |
  | standard_user | secret_sauce | first | last | 12321     |

Feature: Amazon test

  @smoke
  Scenario: Adding an item to the cart
    Given I Open the Browser
    And I Navigate to the URL
    When I search for a product
    Then Search result is displayed
    When I Open the item
    And Add the item to cart
    Then Cart page is displayed



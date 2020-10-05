Feature: Amazon Search and Add to Cart

  @MobileTest
  Scenario: 18881_Searching a product and add to cart for Guest User
    Given open the Amazon app
    And click on skip sign in
    When select for an item by category
    And add the item to cart
    Then verify item is added to cart

  @MobileTest
  Scenario: 18882_Login with invalid credentials
    Given open the Amazon app	
    And login to the app with username "wrong username"
    When select for an item by category
    And add the item to cart
    Then verify item is added to cart
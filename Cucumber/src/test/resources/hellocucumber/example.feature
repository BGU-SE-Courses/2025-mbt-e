Feature: Managing product quantities

  Scenario Outline: Customer checks out item with quantity of 2
    Given The customer is connected to prestashop
    And The customer added "<product>" with quantity of 2 to cart
    When the customer proceeds to checkout
    Then the checkout process should succeed

    Examples:
      | product|
      | Mountain fox cushion |

  Scenario: Admin restricts maximum product quantity to 1
    Given Admin is on PrestaShop admin panel
    And Admin is logged in with valid credentials
    When Admin navigates to the product Hummingbird notebook in the Products catalog page
    And Admin sets maximum quantity to 1 in the Stocks tab
    Then Product maximum quantity should be set to 1

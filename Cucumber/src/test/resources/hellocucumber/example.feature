Feature: Managing product quantities

  Scenario Outline: Customer checks out item with quantity of 2
    Given The customer is connected to prestashop
    And The customer added "<product>" with quantity of 2 to cart
    When the customer proceeds to checkout
    Then the checkout process should succeed

    Examples:
      | product|
      | Mountain fox cushion |

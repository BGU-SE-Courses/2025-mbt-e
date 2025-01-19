Feature: Managing product quantities

  Scenario: Customer checks out item with quantity of 2
    Given the product "Mug The best is yet to come" is available with a stock of more than 2
    And a customer adds 2 "Mug The best is yet to come" items to the cart
    When the customer proceeds to checkout
    Then the checkout process should succeed
    And the customer should see a confirmation message "Order placed successfully "

    #TODO: לראות אם צריך לפצל ל2 פיטצרים

  Scenario: Admin sets the maximum allowable quantity for a product to 1
    Given the product "Widget" is available with a stock of 5
    When the admin sets the maximum allowable quantity for "Widget" to 1
    Then the maximum quantity for "Widget" should be updated successfully

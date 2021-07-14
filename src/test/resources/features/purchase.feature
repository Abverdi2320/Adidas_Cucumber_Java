Feature: Adidas Order Placement Functionalities
  Agile Story: As a user, I should be able to place order from the Website

  Scenario: Placing a successful order
    Given User is on the home page
    When User adds "Sony vaio i5" from "Laptops"
    And User adds "Dell i7 8gb" from "Laptops"
    And User removes "Dell i7 8g" from cart
    When User places order and captures and logs purchase ID and Amount
    When User verifies purchase amount equals expected
@Home
Feature: As a potential user i want to interact with the Home functionalities

  @SmokeTest
  Scenario Outline: The user put a article in the shopping-cart	
    Given The user is located in swaglabs Login page and logs in with '<username>' and '<password>'
    When The Home view is displayed and add an article in the cart
    Then The Shopping Cart is not empty

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |

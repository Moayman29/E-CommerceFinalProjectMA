@smoke

Feature: currency change

  Scenario: user could select euro currency
    Given user select Euro currency
    Then Euro symbol is displayed on all products

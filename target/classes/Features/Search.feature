@smoke

Feature: user could use search field

  Scenario Outline: 1 user could search using product name
    When user clicks on search field
    And user search with product"<productName>"
    Then user could find "<productName>" relative results
    Examples:
    |productName|
    |book|
    |laptop|
    |nike|

  Scenario Outline: 2 user could search for product using sku
    When user clicks on search field
    And user search with sku"<sku>"
    Then user could find "<sku>" inside product details page
    Examples:
    |sku|
    |SCI_FAITH|
    |APPLE_CAM|
    |SF_PRO_11|
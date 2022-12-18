@smoke

  Feature: wishlist button and page

    Scenario: user add a product to wishlist

      Given user clicks on add to wishlist button of a product
      Then a wishlist success message is displayed

    Scenario: user go to wishlist page

      Given user clicks on add to wishlist button of a product
      And user clicks on wishlist button
      Then user check the quantity of the selected product
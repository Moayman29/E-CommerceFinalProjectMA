@smoke

Feature: hover on main categories

  Scenario: user hover on one of main categories then click on sub category

    Given user hover on a random category
    And user select a subcategory
    Then a page relative to the chosen subcategory appears
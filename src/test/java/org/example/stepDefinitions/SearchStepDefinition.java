package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Locale;


public class SearchStepDefinition {

    HomePage home = new HomePage();
    SoftAssert soft = new SoftAssert();

    @When("user clicks on search field")
    public void user_clicks_on_search_field()
    {
        home.searchField().click();
    }

    //Scenario 1
    @And("user search with product{string}")
    public void user_Search_With_Product(String productName)
    {
        home.searchWord(productName);
        home.searchButton().click();
    }

    @Then("user could find {string} relative results")
    public void user_Could_Find_Relative_Results(String productName) {

        String expectedAddress = "https://demo.nopcommerce.com/search?q=";
        String actualAddress = Hooks.driver.getCurrentUrl();

        soft.assertTrue(actualAddress.contains(expectedAddress), "Error Message : wrong Url");

        String expectedResult = productName;
        String actualResult = home.getName().toLowerCase();

        soft.assertTrue(actualResult.contains(expectedResult),"Error Message : wrong name");

        soft.assertAll();
    }

    //Scenario 2
    @And("user search with sku{string}")
    public void user_Search_With_Sku(String codeSKU)
    {
        home.searchSKU(codeSKU);
        home.searchButton().click();
    }

    @Then("user could find {string} inside product details page")
    public void user_Could_Find_Inside_Product_Details_Page(String codeSKU)
    {
        home.findProduct().click();

        String expectedSKU = codeSKU;
        String actualSKU = home.getSKU();

        Assert.assertTrue(actualSKU.contains(expectedSKU),"Error Message : wrong sku");
    }
}

package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class CurrencyStepDefinition {

    HomePage home = new HomePage();

    @When("user select Euro currency")
    public void euro_option()
    {
        Select select = new Select(home.currencyList());
        select.selectByVisibleText("Euro");
    }

    @Then("Euro symbol is displayed on all products")
    public void euro_Symbol_Is_Displayed()
    {
        String expectedResult = "€";
        String actualResult = home.currencyValue();

        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message : wrong currency");
    }
}

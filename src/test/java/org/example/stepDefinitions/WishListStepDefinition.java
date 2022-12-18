package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.WishListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WishListStepDefinition {

    WishListPage wish = new WishListPage();
    SoftAssert soft = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));


    @Given("user clicks on add to wishlist button of a product")
    public void user_Clicks_On_Add_To_Wishlist_Button()
    {
        wish.addToWishlist().click();
    }

    @Then("a wishlist success message is displayed")
    public void a_Wishlist_SuccessMessage_IsDisplayed()
    {
        String expectedResult = "The product has been added to your";
        String actualResult = wish.checkMessage().getText();

        soft.assertTrue(actualResult.contains(expectedResult), "Error Message : wrong message");

        String expectedColor = Color.fromString("rgba(75,176,122,1)").asHex();
        String actualColor = Color.fromString(wish.checkMessage().getCssValue("background-color")).asHex();

        soft.assertTrue(actualColor.contains(expectedColor),"Error Message : wrong background color");

        soft.assertAll();
    }

    @And("user clicks on wishlist button")
    public void user_Clicks_On_Wishlist_Button()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-wishlist")));
    }

    @Then("user check the quantity of the selected product")
    public void userCheckTheQuantityOfTheSelectedProduct()
    {
        wish.wishlistMainButton().click();

        String actualResult = wish.getQuantity().getAttribute("value");
        int actualCount = Integer.parseInt(actualResult);

        Assert.assertTrue(actualCount>0,"Error Message : wrong quantity");
    }
}

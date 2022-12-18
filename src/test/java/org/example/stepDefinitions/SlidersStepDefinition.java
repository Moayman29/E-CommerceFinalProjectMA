package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.testng.Assert;

public class SlidersStepDefinition {

    HomePage home = new HomePage();

    @Given("user clicks on first slider")
    public void user_Clicks_On_First_Slider()
    {
        home.firstSliderButton().click();
        home.sliderImg().click();
    }

    @Then("a new page appears relative to nokia lumia")
    public void a_New_Page_Appears_Relative_To_Nokia_Lumia()
    {
        String expectedResult = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualResult = Hooks.driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message : wrong 1st slider url");
    }


    @Given("user clicks on second slider")
    public void userClicksOnSecondSlider()
    {
        home.secondSliderButton().click();
        home.sliderImg().click();
    }

    @Then("a new page appears relative to iphone")
    public void aNewPageAppearsRelativeToIphone()
    {
        String expectedResult = "https://demo.nopcommerce.com/iphone-6";
        String actualResult = Hooks.driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message : wrong 2nd slider url");
    }
}

package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.testng.Assert;

import java.util.Random;

public class HoverStepDefinition {

    HomePage home = new HomePage();
    int randomNumber = new Random().nextInt(2);
    String result= "";

    @Given("user hover on a random category")
    public void user_Hover_On_A_Random_Category()
    {
        home.categories(randomNumber);
    }

    @And("user select a subcategory")
    public void user_Select_A_Subcategory()
    {
       result = home.subCategories(randomNumber);
    }

    @Then("a page relative to the chosen subcategory appears")
    public void a_Page_Relative_To_The_Chosen_Subcategory_Appears()
    {
        String expectedResult = result.toLowerCase().trim();
        System.out.println(expectedResult);

        String actualResult = home.getPageTitle().getText().toLowerCase().trim();
        System.out.println(actualResult);

        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message : wrong title");
    }
}

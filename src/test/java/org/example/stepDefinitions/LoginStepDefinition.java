package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;

public class LoginStepDefinition {

    LoginPage log= new LoginPage();
    SoftAssert soft=new SoftAssert();

    @Given("user go to login page")
    public void user_go_to_login_page()
    {
        log.loginMainButton().click();
    }


    @When("user login with valid {string} and {string}")
    public void user_Login_With_Valid(String emailLog, String passwordLog)
    {
        log.getLoginEmailAndPassword(emailLog,passwordLog);
    }


    @And("user press on login button")
    public void user_Press_On_LoginButton()
    {
        log.loginFinal().click();
    }

    @Then("user login to the system successfully")
    public void user_Login_To_The_System_Successfully()
    {
        String expectedResult = "https://demo.nopcommerce.com/";
        String actualResult = Hooks.driver.getCurrentUrl();

        soft.assertTrue(actualResult.contains(expectedResult),"Error Message : Wrong Url");

        soft.assertTrue(Hooks.driver.findElement(By.className("ico-account")).isDisplayed(),"Error Message : Tab not found");

        soft.assertAll();
    }

    @When("user login with invalid {string} and {string}")
    public void user_Login_With_Invalid(String wrongEmailLog, String wrongPasswordLog)
    {
        log.getInvalidEmailAndPassword(wrongEmailLog,wrongPasswordLog);
    }


    @Then("user could not login to the system")
    public void user_Could_Not_Login_To_The_System()
    {
        String expectedResult = "Login was unsuccessful.";
        String actualResult = Hooks.driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();

        soft.assertTrue(actualResult.contains(expectedResult),"Error Message : text is wrong");

        String expectedColor = Color.fromString("rgba(228, 67, 75, 1)").asHex();
        String actualColor = Color.fromString(Hooks.driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getCssValue("color")).asHex();


        soft.assertTrue(actualColor.contains(expectedColor), "Error Message : color is wrong");

        soft.assertAll();
    }
}

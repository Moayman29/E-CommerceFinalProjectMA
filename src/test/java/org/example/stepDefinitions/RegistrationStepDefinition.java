package org.example.stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.RegisterPage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class RegistrationStepDefinition {
    RegisterPage reg = new RegisterPage();

    SoftAssert soft=new SoftAssert();

 @Given("user go to register page")
    public void go_to_register_page(){
     reg.registerMainButton().click();
 }

    @And("user select gender type")
    public void user_Select_Gender_Type() {
     reg.chooseGender().click();
    }

    @When("user enter first name {string} and last name {string}")
    public void user_Enter_FirstName_And_LastName(String firstName, String lastName)
    {
        reg.signupName(firstName,lastName);
    }

    @And("user enter date of birth")
    public void user_Enter_DateOfBirth()
    {
        //day
        Select select = new Select(reg.chooseDay());
        select.selectByIndex(29);
        //month
        select = new Select(reg.chooseMonth());
        select.selectByValue("1");
        //year
        select = new Select(reg.chooseYear());
        select.selectByVisibleText("1995");
    }


    @And("user enter email {string} field")
    public void user_Enter_Email_Field(String email)
    {
        reg.emailAddress(email);
    }

    @And("user fills Password fields {string} {string}")
    public void user_Fills_Password_Fields(String password, String confirmedPassword)
    {
        reg.getPassword(password,confirmedPassword);
    }

    @And("user clicks on register button")
    public void user_Clicks_On_RegisterButton()
    {
        reg.registerFinal().click();
    }


    @Then("success message is displayed")
    public void success_Message_Is_Displayed()
    {
       String expectedResult = "Your registration completed";
       String actualResult = reg.checkSuccess().getText();

        soft.assertTrue(actualResult.contains(expectedResult),"Error Message : text is wrong");

        String expectedColor = Color.fromString("rgba(76, 177, 124, 1)").asHex();
        String actualColor = Color.fromString(reg.checkSuccess().getCssValue("color")).asHex();


        soft.assertTrue(actualColor.contains(expectedColor), "Error Message : color is wrong");

        soft.assertAll();
    }
}

package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    public WebElement registerMainButton() {
        WebElement registerMainButton = Hooks.driver.findElement(By.className("ico-register"));
        return registerMainButton;
    }

    public WebElement chooseGender()
    {
        WebElement chooseGender = Hooks.driver.findElement(By.id("gender-male"));
        return chooseGender;
    }

    public WebElement writeFirstName()
    {
        WebElement writeFirstName = Hooks.driver.findElement(By.id("FirstName"));
        return writeFirstName;
    }

    public WebElement writeLastName()
    {
        WebElement writeLastName = Hooks.driver.findElement(By.id("LastName"));
        return writeLastName;
    }

    public void signupName(String firstName, String lastName)
    {
        writeFirstName().clear();
        writeFirstName().sendKeys(firstName);

        writeLastName().clear();
        writeLastName().sendKeys(lastName);
    }

    public WebElement chooseDay()
    {
        WebElement chooseDay = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        return chooseDay;
    }

    public WebElement chooseMonth()
    {
        WebElement chooseMonth = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        return chooseMonth;
    }

    public WebElement chooseYear()
    {
        WebElement chooseYear = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        return chooseYear;
    }

    public WebElement enterEmail()
    {
        WebElement enterEmail = Hooks.driver.findElement(By.id("Email"));
        return enterEmail;
    }

    public void emailAddress(String email)
    {
        enterEmail().clear();
        enterEmail().sendKeys(email);
    }

    public WebElement enterPassword()
    {
        WebElement enterPassword = Hooks.driver.findElement(By.id("Password"));
        return enterPassword;
    }
    public WebElement enterSamePassword()
    {
        WebElement enterSamePassword = Hooks.driver.findElement(By.id("ConfirmPassword"));
        return enterSamePassword;
    }

    public void getPassword(String password,String confirmedPassword)
    {
        enterPassword().clear();
        enterPassword().sendKeys(password);

        enterSamePassword().clear();
        enterSamePassword().sendKeys(confirmedPassword);
    }

    public WebElement registerFinal()
    {
        WebElement registerFinal = Hooks.driver.findElement(By.id("register-button"));
        return registerFinal;
    }

    public WebElement checkSuccess()
    {
        WebElement checkSuccess = Hooks.driver.findElement(By.className("result"));
        return checkSuccess;
    }


}

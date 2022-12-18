package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement loginMainButton()
    {
        WebElement loginMainButton = Hooks.driver.findElement(By.cssSelector(".ico-login"));
        return loginMainButton;
    }

    public WebElement loginEmail()
    {
        WebElement loginEmail = Hooks.driver.findElement(By.className("email"));
        return loginEmail;
    }

    public WebElement loginPassword()
    {
        WebElement loginPassword = Hooks.driver.findElement(By.className("password"));
        return loginPassword;
    }

    public void getLoginEmailAndPassword(String emailLog,String passwordLog)
    {
        loginEmail().clear();
        loginEmail().sendKeys(emailLog);

        loginPassword().clear();
        loginPassword().sendKeys(passwordLog);
    }

    public WebElement loginFinal()
    {
        WebElement loginFinal = Hooks.driver.findElement(By.cssSelector("button[class='button-1 login-button']"));
        return loginFinal;
    }

    public WebElement invalidEmail()
    {
        WebElement invalidEmail = Hooks.driver.findElement(By.className("email"));
        return invalidEmail;
    }
    public WebElement invalidPassword()
    {
        WebElement invalidPassword = Hooks.driver.findElement(By.className("password"));
        return invalidPassword;
    }

    public void getInvalidEmailAndPassword(String wrongEmailLog,String wrongPasswordLog)
    {
        invalidEmail().clear();
        invalidEmail().sendKeys(wrongEmailLog);

        invalidPassword().clear();
        invalidPassword().sendKeys(wrongPasswordLog);
    }

}

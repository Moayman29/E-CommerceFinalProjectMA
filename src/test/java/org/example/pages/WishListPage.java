package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WishListPage {

    public WebElement addToWishlist()
    {
        WebElement addToWishlist = Hooks.driver.findElement(By.xpath("//div[@class='master-wrapper-content']//div[3]//div[1]//div[2]//div[3]//div[2]//button[3]"));
        return addToWishlist;
    }

    public WebElement checkMessage()
    {
        WebElement checkMessage = Hooks.driver.findElement(By.xpath("//div[@class='bar-notification success']"));
        return checkMessage;
    }

    public WebElement wishlistMainButton()
    {
        WebElement wishlistMainButton = Hooks.driver.findElement(By.className("ico-wishlist"));
        return wishlistMainButton;
    }

    public WebElement getQuantity()
    {
        WebElement getQuantity = Hooks.driver.findElement(By.className("qty-input"));
        return getQuantity;
    }
}

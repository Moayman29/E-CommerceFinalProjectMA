package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class FollowUsPage {

    public WebElement openFacebook()
    {
        WebElement openFacebook = Hooks.driver.findElement(By.xpath("//a[normalize-space()='Facebook']"));
        return openFacebook;
    }

    public WebElement openTwitter()
    {
        WebElement openTwitter = Hooks.driver.findElement(By.xpath("//a[normalize-space()='Twitter']"));
        return openTwitter;
    }

    public WebElement openRSS()
    {
        WebElement openRSS = Hooks.driver.findElement(By.xpath("//a[normalize-space()='RSS']"));
        return openRSS;
    }

    public WebElement openYouTube()
    {
        WebElement openYouTube = Hooks.driver.findElement(By.xpath("//a[normalize-space()='YouTube']"));
        return openYouTube;
    }

    public ArrayList<String> tabs()
    {
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        return tabs;
    }

    public String newTab() throws InterruptedException
    {
        String newTab= Hooks.driver.switchTo().window(tabs().get(1)).getCurrentUrl();
        Thread.sleep(2000);
        return newTab;
    }
}

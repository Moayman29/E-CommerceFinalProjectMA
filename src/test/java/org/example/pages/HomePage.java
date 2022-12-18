package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class HomePage {
    //Search Feature
    public WebElement searchField()
    {
        WebElement searchField = Hooks.driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        return searchField;
    }

    public void searchWord(String productName)
    {
       searchField().clear();
       searchField().sendKeys(productName);
    }

    public WebElement searchButton()
    {
        WebElement searchButton = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        return searchButton;
    }

    public List<WebElement> nameConfirm()
    {
        List<WebElement> nameConfirm = Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
        return nameConfirm;
    }

    public String getName()
    {
        String getName = "";
        for (int i=0; i<nameConfirm().size(); i++) {
            getName = nameConfirm().get(i).getText();
            System.out.println(getName);
        }
        return getName;
    }
    //sku
    public void searchSKU(String codeSKU)
    {
        searchField().clear();
        searchField().sendKeys(codeSKU);
    }

    public WebElement findProduct()
    {
        WebElement findProduct = Hooks.driver.findElement(By.cssSelector("h2[class='product-title'] a"));
        return findProduct;
    }

    public List<WebElement> labelSKU()
    {
        List<WebElement> labelSKU= Hooks.driver.findElements(By.xpath("//div[@class='sku']"));
        return labelSKU;
    }

    public String getSKU()
    {
        String getSKU = "";
        for (int i=0; i<labelSKU().size(); i++) {
            getSKU = labelSKU().get(i).getText();
            System.out.println(getSKU);
        }
        return getSKU;
    }


    //Currency Feature

    public WebElement currencyList()
    {
        WebElement currencyList = Hooks.driver.findElement(By.id("customerCurrency"));
        return currencyList;
    }

    public List<WebElement> productsPrice()
    {
        List<WebElement> productsPrice = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return productsPrice;
    }

    public String currencyValue()
    {
        String currencyValue = "";
        for (int i=0; i<4; i++){
            currencyValue = productsPrice().get(i).getText();
            System.out.println(currencyValue);
        }
        return currencyValue;
    }

    //Hover Feature
    public List<WebElement> categories(int randomNumber)
    {
        List<WebElement> categories = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
        Actions hover = new Actions(Hooks.driver);
        hover.moveToElement(categories.get(randomNumber)).perform();
        return categories;
    }

    public String subCategories(int randomNumber)
    {
        randomNumber = randomNumber+1;
        List<WebElement> subCategories =  Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+randomNumber+"]/ul[@class=\"sublist first-level\"]/li"));
        int randomSubCategory = new Random().nextInt(2);

        String SCText = subCategories.get(randomSubCategory).getText();
        System.out.println(SCText);

        subCategories.get(randomSubCategory).click();

        return SCText;
    }


    public WebElement getPageTitle()
    {
        WebElement getPageTitle = Hooks.driver.findElement(By.cssSelector("div[class='page-title'] h1"));
        return getPageTitle;
    }

    //SlidersFeature
    public WebElement firstSliderButton()
    {
        WebElement firstSliderButton = Hooks.driver.findElement(By.xpath("//a[normalize-space()='1']"));
        return firstSliderButton;
    }

    public WebElement secondSliderButton()
    {
        WebElement secondSliderButton = Hooks.driver.findElement(By.xpath("//a[normalize-space()='2']"));
        return secondSliderButton;
    }

    public WebElement sliderImg()
    {
        WebElement sliderImg = Hooks.driver.findElement(By.xpath("//div[@id='nivo-slider']/a[1]"));
        return sliderImg;
    }

}

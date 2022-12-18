package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.FollowUsPage;
import org.testng.Assert;

public class FollowUsStepDefinition {

    FollowUsPage follow = new FollowUsPage();
    
    @Given("user opens facebook link")
    public void user_Opens_Facebook_Link()
    {
        follow.openFacebook().click();
    }

    @Then("{string} facebook is opened in new tab")
    public void facebook_Is_Opened_In_New_Tab(String fbUrl) throws InterruptedException
    {
        Thread.sleep(2000);

        String expectedResult = fbUrl;
        String actualResult = follow.newTab();

        Assert.assertTrue(actualResult.contains(expectedResult), "Error Message : wrong facebook url");
    }


    @Given("user opens twitter link")
    public void user_Opens_Twitter_Link()
    {
        follow.openTwitter().click();
    }

    @Then("{string} twitter is opened in new tab")
    public void twitter_Is_Opened_In_New_Tab(String twitterUrl) throws InterruptedException
    {
        Thread.sleep(2000);

        String expectedResult = twitterUrl;
        String actualResult = follow.newTab();

        Assert.assertTrue(actualResult.contains(expectedResult), "Error Message : wrong twitter url");
    }


    @Given("user opens rss link")
    public void user_Opens_Rss_Link()
    {
        follow.openRSS().click();
    }


    @Then("{string} rss is opened in new tab")
    public void rss_Is_Opened_In_New_Tab(String rssUrl) throws InterruptedException
    {
        Thread.sleep(2000);

        String expectedResult = rssUrl;
        String actualResult = follow.newTab();

        Assert.assertTrue(actualResult.contains(expectedResult), "Error Message : wrong rss url");
    }

    @Given("user opens youtube link")
    public void user_Opens_Youtube_Link()
    {
        follow.openYouTube().click();
    }

    @Then("{string} youtube is opened in new tab")
    public void youtubeIsOpenedInNewTab(String youtubeUrl) throws InterruptedException
    {
        Thread.sleep(2000);

        String expectedResult = youtubeUrl;
        String actualResult = follow.newTab();

        Assert.assertTrue(actualResult.contains(expectedResult), "Error Message : wrong youtube url");
    }
}

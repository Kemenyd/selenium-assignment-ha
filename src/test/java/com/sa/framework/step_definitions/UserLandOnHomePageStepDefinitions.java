package com.sa.framework.step_definitions;

import com.sa.framework.pages.HomePage;
import com.sa.framework.utilities.ConfigReader;
import com.sa.framework.utilities.DriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserLandOnHomePageStepDefinitions {

    HomePage homePage = new HomePage();

    @Given("user is on the homepage")
    public void userIsOnTheHomepage(){
        DriverUtil.getDriver().get(ConfigReader.getProperty("pageSut"));
        Assert.assertTrue(homePage.cookiePopupIsDisplayed());
        Assert.assertTrue(DriverUtil.getDriver().getTitle().contains("Használtautó.hu"));
    }

    @When("user clicks on accept cookies")
    public void userClicksOnAcceptCookies(){
        homePage.acceptWebCookies();
    }

    @Then("car search section is displayed")
    public void carSearchSectionIsDisplayed(){
        homePage.carSearchSectionIsDisplayed();
    }

}

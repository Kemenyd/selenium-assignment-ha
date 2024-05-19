package com.sa.framework.step_definitions;

import com.sa.framework.pages.HomePage;
import com.sa.framework.utilities.ConfigReader;
import com.sa.framework.utilities.DriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserLogsOutStepDefinitions {

    HomePage homePage = new HomePage();

    @Given("logged in user is on the home page")
    public void loggedInUserIsOnTheHomePage(){
        DriverUtil.getDriver().get(ConfigReader.getProperty("pageSut"));
        homePage.acceptWebCookies();
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");
        homePage.login(email, password);
    }

    @When("user clicks on log out button")
    public void userClicksOnLogOutButton(){
        homePage.userClicksOnLogoutButton();
    }

    @Then("user logged out successfully")
    public void userLoggedOutSuccessfully(){
        Assert.assertTrue(homePage.navbarLoginButtonIsDisplayed());
    }
}

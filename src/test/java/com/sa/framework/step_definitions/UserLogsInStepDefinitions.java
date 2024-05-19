package com.sa.framework.step_definitions;

import com.sa.framework.pages.HomePage;
import com.sa.framework.utilities.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserLogsInStepDefinitions {

    HomePage homePage = new HomePage();

    @When("user tries to log in with invalid credentials")
    public void userTriesToLogInWithInvalidCredentials(){
        homePage.acceptWebCookies();
        homePage.login("email@qwe.com", "password");
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed(){
        Assert.assertTrue(homePage.errorMessageIsDisplayed());
    }

    @When("user tries to log in with valid credentials")
    public void userTriesToLogInWithValidCredentials(){
        homePage.acceptWebCookies();
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");
        homePage.login(email, password);
    }

    @Then("user logged in successfully")
    public void userLoggedInSuccessfully(){
        Assert.assertTrue(homePage.accountButtonIsDisplayed());
    }
}

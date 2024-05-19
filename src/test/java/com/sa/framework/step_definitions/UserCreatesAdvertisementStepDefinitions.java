package com.sa.framework.step_definitions;

import com.sa.framework.pages.ChooseAdvertisedCarTypePage;
import com.sa.framework.pages.FillAttributesOfAdvertisedCarPage;
import com.sa.framework.pages.HomePage;
import com.sa.framework.utilities.ConfigReader;
import com.sa.framework.utilities.DriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserCreatesAdvertisementStepDefinitions {

    HomePage homePage = new HomePage();
    ChooseAdvertisedCarTypePage chooseAdvertisedCarTypePage = new ChooseAdvertisedCarTypePage();
    FillAttributesOfAdvertisedCarPage fillAttributesOfAdvertisedCarPage = new FillAttributesOfAdvertisedCarPage();

    @Given("user is on add Advertisement page")
    public void userIsOnAddAdvertisementPage(){
        DriverUtil.getDriver().get(ConfigReader.getProperty("pageSut"));
        Assert.assertTrue(homePage.cookiePopupIsDisplayed());
        Assert.assertTrue(DriverUtil.getDriver().getTitle().contains("Használtautó.hu"));
        homePage.acceptWebCookies();
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");
        homePage.login(email, password);
        homePage.userClicksOnAdvertisementAddButton();
    }

    @When("user selects vehicles type")
    public void userSelectsVehiclesType(){
        chooseAdvertisedCarTypePage.selectAdvertisedCarsType();
    }

    @And("user fills out the form")
    public void userFillsOutTheForm(){
        fillAttributesOfAdvertisedCarPage.fillOutAddAdvertisementForm();
        fillAttributesOfAdvertisedCarPage.userClicksOnSendFormButton();
    }

    @Then("user sends the form successfully")
    public void userSendsTheFormSuccessfully(){
        Assert.assertTrue(fillAttributesOfAdvertisedCarPage.fileuploadTitleIsDisplayed());
    }
}

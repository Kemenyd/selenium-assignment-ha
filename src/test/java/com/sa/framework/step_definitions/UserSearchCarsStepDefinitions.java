package com.sa.framework.step_definitions;

import com.sa.framework.pages.HomePage;
import com.sa.framework.pages.SearchPage;
import com.sa.framework.utilities.ConfigReader;
import com.sa.framework.utilities.DriverUtil;
import com.sa.framework.utilities.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserSearchCarsStepDefinitions {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    @Given("user is on the homepage and already logged in")
    public void userIsOnTheHomePageAndAlreadyLoggedIn(){
        DriverUtil.getDriver().get(ConfigReader.getProperty("pageSut"));
        homePage.acceptWebCookies();
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");
        homePage.login(email, password);
    }

    @When("user clicks on search button")
    public void userClicksOnSearchButton(){
        homePage.userClicksOnSearchButton();
    }

    @Then("user is on search page")
    public void userIsOnSearchPage(){
        WaitHelper.waitForUrlContains("https://www.hasznaltauto.hu/talalatilista");
        Assert.assertTrue(DriverUtil.getDriver().getCurrentUrl().contains("talalatilista"));
        Assert.assertTrue(searchPage.filteredSearchButtonIsDisplayed());
    }

    @When("user adds some specification to the search section")
    public void userAddsSomeSpecificationToTheSearchSection(){
        homePage.userClicksOnSearchButton();
        searchPage.userFillsOutSearchOptions();
    }

    @And("user clicks on filtered search button")
    public void userClicksOnFilteredSearchButton(){
        searchPage.userClicksOnSearchButton();
    }

    @Then("user is on filtered search page")
    public void userIsOnFilteredSearchPage(){
        WaitHelper.waitForUrlContains("https://www.hasznaltauto.hu/talalatilista");
        Assert.assertTrue(DriverUtil.getDriver().getCurrentUrl().contains("talalatilista"));
        Assert.assertTrue(searchPage.filteredSearchButtonIsDisplayed());
        Assert.assertTrue(searchPage.filteredSearchResultsIsDisplayed());
        Assert.assertTrue(searchPage.filteredSearchShowsDesiredCarAsResult());
    }
}

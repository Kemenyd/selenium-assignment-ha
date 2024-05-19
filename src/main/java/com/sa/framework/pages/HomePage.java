package com.sa.framework.pages;

import com.sa.framework.utilities.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//li[@class=\"navbar-hza-link\"]//a)[2]")
    private WebElement navbarLoginButton;

    @FindBy(xpath = "(//div//div[@class=\"modal-content\"])[1]")
    private WebElement loginSection;

    @FindBy(xpath = "//div//input[@id=\"username\"]")
    private WebElement emailField;

    @FindBy(xpath = "//div//input[@id=\"mui-1\"]")
    private WebElement passwordField;

    @FindBy(id = "mui-1-helper-text")
    private WebElement errorMessage;

    @FindBy(xpath = "//div//button[@data-testid=\"loginform-submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "(//li//a[@class=\"dropdown-toggle\"])[3]")
    private WebElement accountButton;

    @FindBy(xpath = "//li//a[@class=\"main-navigation-logout-button\"]")
    private WebElement logoutListElement;

    @FindBy(xpath = "//div//div[@class=\"tab-content\"]")
    private WebElement searchSection;

    @FindBy(xpath = "//div//button[@data-testid=\"submit-button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//li//button[@class=\"btn btn-success navbar-btn-hza adminlink publish-new-ad\"]")
    private WebElement advertisementAddButton;

    public void login(String email, String password){
        WaitHelper.waitForElementToAppearAndClick(navbarLoginButton);
        WaitHelper.waitForElementToAppear(loginSection);
        WaitHelper.waitForElementToAppearAndType(emailField, email);
        WaitHelper.waitForElementToAppearAndType(passwordField, password);
        WaitHelper.waitForElementToAppearAndClick(loginButton);
    }

    public boolean carSearchSectionIsDisplayed(){
        WaitHelper.waitForElementToAppear(searchSection);
        WaitHelper.waitForElementToBeClickable(searchButton);
        return searchSection.isDisplayed();
    }

    public boolean errorMessageIsDisplayed(){
        WaitHelper.waitForElementToAppear(errorMessage);
        return errorMessage.isDisplayed();
    }

    public boolean accountButtonIsDisplayed(){
        WaitHelper.waitForElementToAppear(accountButton);
        return accountButton.isDisplayed();
    }

    public void userClicksOnLogoutButton(){
        WaitHelper.waitForElementToAppearAndClick(accountButton);
        WaitHelper.waitForElementToAppearAndClick(logoutListElement);
    }

    public boolean navbarLoginButtonIsDisplayed(){
        WaitHelper.waitForElementToAppear(navbarLoginButton);
        return navbarLoginButton.isDisplayed();
    }

    public void userClicksOnSearchButton(){
        WaitHelper.waitForElementToDisappear(loginSection);
        WaitHelper.waitForElementToAppearAndClick(searchButton);
    }

    public void userClicksOnAdvertisementAddButton(){
        WaitHelper.waitForElementToAppearAndClick(advertisementAddButton);
    }
}

package com.sa.framework.pages;

import com.sa.framework.utilities.DriverUtil;
import com.sa.framework.utilities.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(xpath = "//div//div[@class=\"didomi-popup-view\"]")
    private WebElement cookiePopUp;

    @FindBy(xpath = "//div//button[@id=\"didomi-notice-agree-button\"]")
    private WebElement cookieAcceptButton;

    public BasePage() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    public boolean cookiePopupIsDisplayed(){
        WaitHelper.waitForElementToAppear(cookiePopUp);
        return cookiePopUp.isDisplayed();
    }
    public void acceptWebCookies(){
        WaitHelper.waitForElementToAppearAndClick(cookieAcceptButton);
    }
}

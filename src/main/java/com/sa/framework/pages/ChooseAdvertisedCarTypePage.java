package com.sa.framework.pages;

import com.sa.framework.utilities.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseAdvertisedCarTypePage extends BasePage {

    @FindBy(xpath = "//div//a[@class=\"kep szemelyauto\"]")
    private WebElement passengerCarAdAdvertisementButton;

    public void selectAdvertisedCarsType(){
        WaitHelper.waitForElementToAppearAndClick(passengerCarAdAdvertisementButton);
    }
}

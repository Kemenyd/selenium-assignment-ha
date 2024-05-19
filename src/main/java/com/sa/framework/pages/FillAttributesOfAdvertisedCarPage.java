package com.sa.framework.pages;

import com.sa.framework.utilities.CommonUtils;
import com.sa.framework.utilities.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FillAttributesOfAdvertisedCarPage extends BasePage {

    @FindBy(xpath = "//select[@name=\"evjarat1\"]")
    private WebElement carsAge;

    @FindBy(xpath = "//div[@data-brand=\"Audi\"]")
    private WebElement carsBrand;

    @FindBy(xpath = "//select[@id=\"modell\"]")
    private WebElement carsModel;

    @FindBy(xpath = "//option[@value=\"41\"]")
    private WebElement selectedModel;

    @FindBy(xpath = "id=\"tipus\"")
    private WebElement carsType;

    @FindBy(xpath = "//option[@value=\"2208129\"]")
    private WebElement selectedType;

    @FindBy(xpath = "//select[@id=\"allapot\"]")
    private WebElement carsPhysicalCondition;

    @FindBy(xpath = "(//option[@value=\"1\"])[4]")
    private WebElement selectedCondition;

    @FindBy(xpath = "//select[@id=\"okmany_jelleg\"]")
    private WebElement carsPapers;

    @FindBy(xpath = "(//option[@value=\"1\"])[5]")
    private WebElement selectedPapers;

    @FindBy(xpath = "//select[@id=\"okmany_ervenyes\"]")
    private WebElement papersValidity;

    @FindBy(xpath = "(//option[@value=\"1\"])[6]")
    private WebElement selectedValidity;

    @FindBy(xpath = "//input[@id=\"futottkm\"]")
    private WebElement kmStandsOn;

    @FindBy(xpath = "//select[@id=\"megye\"]")
    private WebElement carsLocation;

    @FindBy(xpath = "(//option[@value=\"20\"])[11]")
    private WebElement selectedLocation;

    @FindBy(xpath = "//select[@id=\"telepules\"]")
    private WebElement locationsPostCode;

    @FindBy(xpath = "//option[@value=\"1848\"]")
    private WebElement selectedPostCode;

    @FindBy(xpath = "//input[@class=\"oa strong\"]")
    private WebElement sendFormButton;

    @FindBy(xpath = "//h1[@class=\"kephozzaad\"]")
    private WebElement nextStepTitle;

    public void fillOutAddAdvertisementForm(){
        WaitHelper.waitForElementToAppearAndClick(carsAge);
        WaitHelper.waitForElementToAppearAndClick(carsBrand);
        WaitHelper.waitForElementToAppearAndClick(carsModel);
        WaitHelper.waitForElementToAppearAndClick(selectedModel);
        WaitHelper.waitForElementToAppearAndClick(carsType);
        WaitHelper.waitForElementToAppearAndClick(selectedType);
        WaitHelper.waitForElementToAppearAndClick(carsPhysicalCondition);
        WaitHelper.waitForElementToAppearAndClick(selectedCondition);
        WaitHelper.waitForElementToAppearAndClick(carsPapers);
        WaitHelper.waitForElementToAppearAndClick(selectedPapers);
        WaitHelper.waitForElementToAppearAndClick(papersValidity);
        WaitHelper.waitForElementToAppearAndClick(selectedValidity);
        WaitHelper.waitForElementToAppearAndType(kmStandsOn, "20000");
        CommonUtils.scrollToElement(sendFormButton);
        WaitHelper.waitForElementToAppearAndClick(carsLocation);
        WaitHelper.waitForElementToAppearAndClick(selectedLocation);
        WaitHelper.waitForElementToAppearAndClick(locationsPostCode);
        CommonUtils.scrollToElement(selectedPostCode);
        WaitHelper.waitForElementToAppearAndClick(selectedPostCode);
    }

    public void userClicksOnSendFormButton(){
        WaitHelper.waitForElementToAppearAndClick(sendFormButton);
    }

    public boolean fileuploadTitleIsDisplayed(){
        WaitHelper.waitForElementToAppear(nextStepTitle);
        return nextStepTitle.isDisplayed();
    }
}

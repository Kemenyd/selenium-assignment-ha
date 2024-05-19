package com.sa.framework.pages;

import com.sa.framework.utilities.CommonUtils;
import com.sa.framework.utilities.DriverUtil;
import com.sa.framework.utilities.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class SearchPage extends BasePage{

    @FindBy(xpath = "(//div//a[@class=\"accordion\"])[1]")
    private WebElement modelFilterSection;

    @FindBy(xpath = "(//div//select)[1]")
    private WebElement brandFilterInputField;

    @FindBy(xpath = "//select[@id='hirdetesszemelyautosearch-marka_id']//option[@value='12' and text()='AUDI (6016)']")
    private WebElement specificBrandFilterAudi;

    @FindBy(xpath = "(//div//select)[2]")
    private WebElement modelTypeFilterInputField;

    @FindBy(xpath = "//div//select//option[@value=\"2064\"]")
    private WebElement specificModelTypeFilterA7;

    @FindBy(xpath = "(//div[@class=\"panel-block\"])[2]")
    private WebElement technicalAttributes;

    @FindBy(xpath = "(//div//button[@class=\"multiselect dropdown-toggle form-control simaselect\"])[5]")
    private WebElement fuelTypeInputField;

    @FindBy(xpath = "(//ul//li[@class=\"multiselect-item multiselect-group\"])[6]")
    private WebElement specificFuelTypeDiesel;

    @FindBy(xpath = "//div//button[@name=\"submitSzukites\"]")
    private WebElement filteredSearchButton;

    @FindBy(xpath = "(//div[@class=\"row talalati-sor kiemelt\"])[1]")
    private WebElement filteredSearchResultCar;

    @FindBy(xpath = "(//div[@class=\"row talalati-sor kiemelt\"])[1]")
    private WebElement titleFilteredSearchResultCar;

    public boolean filteredSearchButtonIsDisplayed(){
        WaitHelper.waitForElementToAppear(filteredSearchButton);
        return filteredSearchButton.isDisplayed();
    }

    public void userFillsOutSearchOptions(){
        WaitHelper.waitForElementToAppearAndClick(modelFilterSection);
        WaitHelper.waitForElementToAppearAndClick(brandFilterInputField);
        Actions actions = new Actions(DriverUtil.getDriver());
        for(int i = 0; i < 12; i++){
            actions.sendKeys(Keys.DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        WaitHelper.waitForElementToAppearAndClick(modelTypeFilterInputField);
        WaitHelper.waitForElementToAppearAndClick(specificModelTypeFilterA7);
        WaitHelper.waitForElementToAppearAndClick(technicalAttributes);
        CommonUtils.scrollToElement(filteredSearchButton);
        WaitHelper.waitForElementToAppearAndClick(fuelTypeInputField);
        WaitHelper.waitForElementToAppearAndClick(specificFuelTypeDiesel);
        WaitHelper.waitForElementToAppearAndClick(fuelTypeInputField);
    }

    public void userClicksOnSearchButton(){
        CommonUtils.scrollToElement(filteredSearchButton);
        WaitHelper.waitForElementToAppearAndClick(filteredSearchButton);
    }

    public boolean filteredSearchResultsIsDisplayed(){
        WaitHelper.waitForElementToAppear(filteredSearchResultCar);
        return filteredSearchResultCar.isDisplayed();
    }

    public boolean filteredSearchShowsDesiredCarAsResult(){
        CommonUtils.scrollToElement(titleFilteredSearchResultCar);
        WaitHelper.waitForElementToAppear(titleFilteredSearchResultCar);
        return titleFilteredSearchResultCar.getText().contains("AUDI A7");
    }

}

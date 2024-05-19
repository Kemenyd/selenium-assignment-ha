package com.sa.framework.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    public static void waitForPageToLoad() {
        new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(30))
                .until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(30));
        wait.ignoring(WebDriverException.class).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(30));
        wait.ignoring(WebDriverException.class).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementToAppearAndClick(WebElement element) {
        waitForElementToAppear(element);
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(30));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public static void waitForElementToBeClickable(WebElement element) {
        waitForElementToAppear(element);
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForUrlContains(String url) {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains(url));
    }

    public static void waitForElementToAppearAndType(WebElement element, String text) {
        waitForElementToAppear(element);
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(30));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        visibleElement.sendKeys(text);
    }
}

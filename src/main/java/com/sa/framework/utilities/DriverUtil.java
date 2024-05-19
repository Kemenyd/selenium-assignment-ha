package com.sa.framework.utilities;

import lombok.SneakyThrows;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverUtil {

    private static WebDriver driver;

    private DriverUtil() {
    }

    @SneakyThrows
    public static WebDriver initDriver() {
        String browserType = ConfigReader.getProperty("browserType");
        switch (browserType) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-ssl-errors=yes");
                options.addArguments("--ignore-certificate-errors");
                driver = new ChromeDriver(options);
                Dimension dimension = new Dimension(1920, 1080);
                driver.manage().window().setSize(dimension);
            }
            case "headless-chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--ignore-certificate-errors");
                driver = new ChromeDriver(options);
                Dimension dimension = new Dimension(1920, 1080);
                driver.manage().window().setSize(dimension);
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--ignore-ssl-errors=yes");
                options.addArguments("--ignore-certificate-errors");
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize();
            }
            case "headless-firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("--ignore-certificate-errors");
                driver = new FirefoxDriver(options);
                Dimension dimension = new Dimension(1920, 1080);
                driver.manage().window().setSize(dimension);
            }
        }
//        String url = ConfigReader.getProperty("pageSut");
//        driver.get(url);
//        Cookie consentCookie = new Cookie.Builder("PHPSESSID", "0466f32ec7561c7b2a6a4fcac5c42613")
//                .domain(url)
//                .path("/")
//                .isHttpOnly(true)
//                .build();
//        driver.manage().addCookie(consentCookie);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

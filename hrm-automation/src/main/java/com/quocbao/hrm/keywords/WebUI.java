package com.quocbao.hrm.keywords;

import com.quocbao.hrm.drivers.DriverManager;
import com.quocbao.hrm.helpers.PropertiesHelper;
import com.quocbao.hrm.utils.LogUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebUI {
    private static int TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("TIMEOUT"));
    private static int PAGE_LOAD_TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));
    private static int SLEEP_TIME = Integer.parseInt(PropertiesHelper.getValue("SLEEP_TIME"));

    public static void sleep(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LogUtils.error(e.getMessage());
        }
    }

    public static String getCurrentURL() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static String getWebTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(TIMEOUT),
                    Duration.ofMillis(500)
            );
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(TIMEOUT),
                    Duration.ofMillis(500)
            );
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
    }

    public static boolean isElementDisplayed(By by) {
        try {
            WebElement element = DriverManager.getDriver().findElement(by);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static void watiForPageLoad() {
        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(PAGE_LOAD_TIMEOUT)
        );
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        try {
            wait.until(webDriver ->
                    js.executeScript("return document.readyState").toString().equals("complete")
            );
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }

    }

    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
        LogUtils.info("\uD83C\uDF10 Open URL: " + url);
    }

    public static void clearText(By by) {
        waitForElementVisible(by);
        getWebElement(by).clear();
    }

    public static void setText(By by, String value) {
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value);
        LogUtils.info(String.format(">>> INPUT: '%s' --> Element: %s", value, by));

    }

    public static String getText(By by) {
        waitForElementVisible(by);
        String text = getWebElement(by).getText();
        LogUtils.info(String.format(
                "[GET TEXT] Locator: %s | Value: '%s'",
                by.toString(),
                text));
        return text;
    }

    public static void scrollElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));

    }

    public static void hoverElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
    }

    public static void assertContains(String actual, String expected, String mess) {
        watiForPageLoad();
        LogUtils.info(String.format(
                "[ASSERT] Verify actual contain '%s'. Actual: '%s'"
                , expected, actual));
        Assert.assertTrue(actual.contains(expected), mess);

    }

    public static void assertNotContains(String actual, String expected, String mess) {
        watiForPageLoad();
        LogUtils.info(String.format(
                "[ASSERT] Verify actual DOES NOT contain '%s'. Actual: '%s'"
                , expected, actual));
        Assert.assertFalse(actual.contains(expected), mess);

    }

    public static void assertEquals(String actual, String expected, String mess) {
        watiForPageLoad();
        LogUtils.info(String.format(
                "[ASSERT] Verify actual DOES NOT contain '%s'. Actual: '%s'"
                , expected, actual));
        Assert.assertEquals(actual, expected, mess);
    }


}

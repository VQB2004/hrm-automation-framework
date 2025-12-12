package com.quocbao.hrm.common;

import com.quocbao.hrm.drivers.DriverManager;
import com.quocbao.hrm.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = setupDriver(browser);
        DriverManager.setDriver(driver);
    }

    private WebDriver setupDriver(String browser) {

        return switch (browser.strip().toLowerCase()) {
            case "chrome" -> initChromeDriver();
            case "edge" -> initEdgeDriver();
            default -> initChromeDriver();
        };
    }

    private WebDriver initChromeDriver() {
        WebDriver driver = new ChromeDriver();
        LogUtils.info("Launching Chrome browser...");
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        WebDriver driver = new EdgeDriver();
        LogUtils.info("Launching Edge browser...");
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
        }
        else {
            System.out.println("BUG");
        }
    }
}

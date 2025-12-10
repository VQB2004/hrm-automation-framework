package com.quocbao.tests.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final  ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }

    public static void quitDriver(){
        DriverManager.driver.get().quit();
        driver.remove();
    }
}

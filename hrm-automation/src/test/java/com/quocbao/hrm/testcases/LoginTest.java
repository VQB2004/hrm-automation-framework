package com.quocbao.hrm.testcases;

import com.quocbao.hrm.common.BaseTest;
import com.quocbao.hrm.dataproviders.DataProviderFactory;
import com.quocbao.hrm.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

@Listeners(com.quocbao.hrm.listeners.TestListener.class)
public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1, dataProvider = "data_login_success", dataProviderClass = DataProviderFactory.class)
    public void loginSuccess(Map<String, String> data) {
        loginPage = new LoginPage();
        loginPage.loginHRM(data.get("USERNAME"), data.get("PASSWORD"));
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2, dataProvider = "data_login_invalid_username", dataProviderClass = DataProviderFactory.class)
    public void loginInvalidUserName(Map<String, String> data) {
        loginPage = new LoginPage();
        loginPage.loginHRM(data.get("USERNAME"), data.get("PASSWORD"));
        loginPage.verifyLoginFail();
    }

    @Test(priority = 3, dataProvider = "data_login_invalid_password", dataProviderClass = DataProviderFactory.class)
    public void loginInvalidPassword(Map<String, String> data) {
        loginPage = new LoginPage();
        loginPage.loginHRM(data.get("USERNAME"), data.get("PASSWORD"));
        loginPage.verifyLoginFail();
    }
}

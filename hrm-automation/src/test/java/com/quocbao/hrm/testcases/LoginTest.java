package com.quocbao.hrm.testcases;

import com.quocbao.hrm.common.BaseTest;
import com.quocbao.hrm.dataproviders.DataProviderFactory;
import com.quocbao.hrm.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

@Epic("HRM System")
@Feature("Login Feature")
@Listeners(com.quocbao.hrm.listeners.TestListener.class)
public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1, dataProvider = "data_login_success", dataProviderClass = DataProviderFactory.class)
    @Story("Login success with valid account")
    @Description("Verify user can login successfully with valid username and password")
    public void loginSuccess(Map<String, String> data) {
        loginPage = new LoginPage();
        loginPage.loginHRM(data.get("USERNAME"), data.get("PASSWORD"));
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2, dataProvider = "data_login_invalid_username", dataProviderClass = DataProviderFactory.class)
    @Story("Login failed with invalid username")
    @Description("Verify login fails when username is invalid")
    public void loginInvalidUserName(Map<String, String> data) {
        loginPage = new LoginPage();
        loginPage.loginHRM(data.get("USERNAME"), data.get("PASSWORD"));
        loginPage.verifyLoginFail();
    }

    @Test(priority = 3, dataProvider = "data_login_invalid_password", dataProviderClass = DataProviderFactory.class)
    @Story("Login failed with invalid password")
    @Description("Verify login fails when password is invalid")
    public void loginInvalidPassword(Map<String, String> data) {
        loginPage = new LoginPage();
        loginPage.loginHRM(data.get("USERNAME"), data.get("PASSWORD"));
        loginPage.verifyLoginFail();
    }
}

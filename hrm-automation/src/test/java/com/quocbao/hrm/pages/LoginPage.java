package com.quocbao.hrm.pages;

import com.quocbao.hrm.helpers.PropertiesHelper;
import com.quocbao.hrm.keywords.WebUI;
import org.openqa.selenium.By;

public class LoginPage {
    private By inputUserName = By.id("iusername");
    private By inputPassword = By.id("ipassword");
    private By btnLogin = By.xpath("//button[@type='submit']");
    private By errorMessage=By.xpath("//div[@class='toast-message' and contains(text(),'Invalid')]");

    private void setUserName(String userName) {
        WebUI.setText(inputUserName, userName);
    }

    private void setPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickButtonLogin() {
        WebUI.clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        WebUI.waitForUrlContains("desk");
        WebUI.assertContains(WebUI.getCurrentURL(), "desk", "FAIL");
    }

    public void verifyLoginFail(){
        WebUI.assertContains(WebUI.getCurrentURL(),"login","FAIL");
        WebUI.assertEquals(WebUI.getText(errorMessage),"Invalid Login Credentials.","FAIL");
    }

    public void loginHRM(String userName, String password) {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoad();

        WebUI.clearText(inputUserName);
        setUserName(userName);

        WebUI.clearText(inputPassword);
        setPassword(password);

        clickButtonLogin();
        WebUI.waitForPageLoad();

    }

    public HomePage loginHRM() {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoad();

        WebUI.clearText(inputUserName);
        setUserName("admin_example");

        WebUI.clearText(inputPassword);
        setPassword("123456");

        clickButtonLogin();
        WebUI.waitForPageLoad();

        return new HomePage();

    }
}

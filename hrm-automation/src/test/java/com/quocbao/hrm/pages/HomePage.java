package com.quocbao.hrm.pages;

import com.quocbao.hrm.keywords.WebUI;
import org.openqa.selenium.By;

public class HomePage {
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");

    public ProjectPage clickMenuProject(){
        WebUI.waitForElementVisible(menuProject);
        WebUI.clickElement(menuProject);
        WebUI.waitForPageLoad();
        return new ProjectPage();
    }

}

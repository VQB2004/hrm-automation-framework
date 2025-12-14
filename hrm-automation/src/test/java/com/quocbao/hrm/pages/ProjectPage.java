package com.quocbao.hrm.pages;

import com.quocbao.hrm.drivers.DriverManager;
import com.quocbao.hrm.keywords.WebUI;
import com.quocbao.hrm.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Map;

public class ProjectPage {
    private By btnAddProject = By.xpath("//a[normalize-space()='Add New']");
    private By inputTitle = By.xpath("//input[@placeholder='Title']");
    private By inputClient = By.xpath("//select[@id='client_id']/following-sibling::span");
    private By searchClient = By.xpath("//input[@role='searchbox' and not(@placeholder='Team')]");
    private By inputEstimatedHour = By.xpath("//input[@placeholder='Estimated Hour']");
    private By inputSummary = By.xpath("//textarea[@id='summary']");
    private By btnSave = By.xpath("//button[@type='submit']//span[normalize-space()='Save']");

    private By inputStartDate = By.xpath("//input[@placeholder='Start Date']");
    private By inputEndDate = By.xpath("//input[@placeholder='End Date']");
    private By btnStartDateOk = By.xpath("(//button[normalize-space()='OK'])[1]");
    private By btnEndDateOk = By.xpath("(//button[normalize-space()='OK'])[2]");

    private By successAddMess = By.xpath("//div[normalize-space()='Project added.']");
    private By successDelMess = By.xpath("//div[normalize-space()='Project deleted.']");

    private By inputSearchProject = By.xpath("//label[normalize-space()='Search']//input[@type='search']");
    private By firstItem = By.xpath("//table[@id='xin_table']/tbody/tr[1]/td[1]");
    private By btnDelFirstItem = By.xpath("//table[@id='xin_table']/tbody/tr[1]/td[1]//span[@data-original-title='Delete']");
    private By btnConfirmDelete = By.xpath("//span[normalize-space()='Confirm']");

    private By btnDetailFirstItem = By.xpath("//table[@id='xin_table']/tbody/tr[1]/td[1]//span[@data-original-title='View Details']");


    private void clickButtonAddProject() {
        WebUI.clickElement(btnAddProject);
    }

    private void setInputTitle(String title) {
        WebUI.setText(inputTitle, title);
    }

    private void setInputClient(String client) {
        WebUI.clickElement(inputClient);
        WebUI.setTextAndKey(searchClient, client, Keys.ENTER);
    }

    private void setInputEstimatedHour(String estimatedHour) {
        WebUI.setText(inputEstimatedHour, estimatedHour);
    }

    private void setInputStartDate() {
        WebUI.clickElement(inputStartDate);
        WebUI.clickElement(btnStartDateOk);
    }

    private void setInputEndDate() {
        WebUI.clickElement(inputEndDate);
        WebUI.clickElement(btnEndDateOk);
    }

    private void setInputSummary(String summary) {
        WebUI.setText(inputSummary, summary);
    }

    private void clickButtonSave() {
        WebUI.clickElement(btnSave);
    }

    public void verifyAddProjectSuccess() {
        WebUI.assertContains(WebUI.getText(successAddMess), "Project added", "FAIL");

    }

    public void addProject(Map<String, String> data) {
        WebUI.waitForPageLoad();
        clickButtonAddProject();
        setInputTitle(data.get("TITLE"));
        setInputClient(data.get("CLIENT"));
        setInputEstimatedHour(data.get("HOUR"));
        setInputStartDate();
        setInputEndDate();
        setInputSummary(data.get("SUMMARY"));
        clickButtonSave();

    }

    public void searchProject(String title) {
        WebUI.setText(inputSearchProject, title);
        WebUI.scrollToBottom();
        WebUI.sleep();
        WebUI.waitForElementVisible(firstItem);
    }

    public void verifySearchProjectSuccess(String title) {
        WebUI.assertContains(WebUI.getText(firstItem), title, "FAIL");
    }

    public ProjectDetailPage clickButtonViewDetail() {
        WebUI.hoverElement(firstItem);
        WebUI.clickElement(btnDetailFirstItem);
        return new ProjectDetailPage();
    }


    public void deleteProject(String title) {
        searchProject(title);
        WebUI.hoverElement(firstItem);
        WebUI.clickElement(btnDelFirstItem);
        WebUI.clickElement(btnConfirmDelete);
        WebUI.waitForPageLoad();
    }

    public void verifyDeleteSuccess() {
        WebUI.assertContains(WebUI.getText(successDelMess), "Project deleted.", "FAIL");
    }
}

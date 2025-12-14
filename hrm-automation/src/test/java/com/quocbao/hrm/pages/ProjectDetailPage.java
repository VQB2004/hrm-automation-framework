package com.quocbao.hrm.pages;

import com.quocbao.hrm.keywords.WebUI;
import org.openqa.selenium.By;

public class ProjectDetailPage {
    private By btnUpdateStatus = By.xpath("//span[normalize-space()='Update Status']");
    private By successUpdateMess = By.xpath("//div[normalize-space()='Project status updated.']");
    private By successUploadFileMess = By.xpath("//div[normalize-space()='Project file added.']");
    private By labelAttachFile = By.xpath("//a[normalize-space()='Attach files']");
    private By fileName = By.xpath("//input[@name='file_name']");
    private By inputChooseFile=By.xpath("//input[@id='attachment_file']");
    private By btnAddFile = By.xpath("//button[@type='submit' and normalize-space(.)='Add File']");

    public static By ratingByText(String status) {
        return By.xpath(
                String.format("//a[normalize-space(@data-rating-text)='%s']", status)
        );
    }

    private void clickButtonUpdate() {
        WebUI.clickElement(btnUpdateStatus);
    }

    private void clickRatingStatus(String status) {
        WebUI.clickElement(ratingByText(status));
    }

    public void updateStatus(String status) {
        clickRatingStatus(status);
        clickButtonUpdate();
    }

    public void verifyUpdateSuccess() {
        WebUI.assertContains(WebUI.getText(successUpdateMess), "Project status updated.", "FAIL");
    }

    public void clickAttachFile() {
        WebUI.clickElement(labelAttachFile);
        WebUI.waitForPageLoad();
    }

    public void setFileName(String title) {
        WebUI.setText(fileName, title);
    }

    public void clickButtonAddFile() {
        WebUI.clickElement(btnAddFile);
    }

    public void setInputChooseFile(String filPath){
        WebUI.setText(inputChooseFile,filPath);
    }
    public void uploadFile(String fileName, String filePath) {
        clickAttachFile();
        setFileName(fileName);
        setInputChooseFile(filePath);
        clickButtonAddFile();
        WebUI.waitForPageLoad();

    }

    public void verifyUploadFile(){
        WebUI.assertContains(WebUI.getText(successUploadFileMess),"Project file added.","FAIL");
    }


}

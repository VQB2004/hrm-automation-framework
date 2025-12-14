package com.quocbao.hrm.pages;

import com.quocbao.hrm.keywords.WebUI;
import org.openqa.selenium.By;

public class ProjectDetailPage {
    private By btnUpdateStatus=By.xpath("//span[normalize-space()='Update Status']");
    private By successUpdateMess=By.xpath("//div[normalize-space()='Project status updated.']");
    public static By ratingByText(String status) {
        return By.xpath(
                String.format("//a[normalize-space(@data-rating-text)='%s']", status)
        );
    }

    private void clickButtonUpdate(){
        WebUI.clickElement(btnUpdateStatus);
    }

    private void clickRatingStatus(String status){
        WebUI.clickElement(ratingByText(status));
    }

    public void updateStatus(String status){
        clickRatingStatus(status);
        clickButtonUpdate();
    }

    public void verifyUpdateSuccess(){
        WebUI.assertContains(WebUI.getText(successUpdateMess),"Project status updated.","FAIL");
    }



}

package com.quocbao.hrm.testcases;

import com.quocbao.hrm.common.BaseTest;
import com.quocbao.hrm.dataproviders.DataProviderFactory;
import com.quocbao.hrm.pages.HomePage;
import com.quocbao.hrm.pages.LoginPage;
import com.quocbao.hrm.pages.ProjectDetailPage;
import com.quocbao.hrm.pages.ProjectPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

@Epic("HRM System")
@Feature("Project Management")
@Listeners(com.quocbao.hrm.listeners.TestListener.class)
public class ProjectTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;
    ProjectDetailPage projectDetailPage;


    @Test(priority = 1,dataProvider = "data_add_project", dataProviderClass = DataProviderFactory.class)
    @Story("Add new project")
    @Description("Verify user can add a new project successfully")
    public void addProject(Map<String,String> data){
        loginPage = new LoginPage();
        homePage= loginPage.loginHRM();

        projectPage= homePage.clickMenuProject();
        projectPage.addProject(data);
        projectPage.verifyAddProjectSuccess();
    }

    @Test(priority = 2,dataProvider = "data_search_project", dataProviderClass = DataProviderFactory.class)
    @Story("Search project by title")
    @Description("Verify user can search project by title")
    public void searchProject(Map<String,String> data){
        loginPage = new LoginPage();
        homePage= loginPage.loginHRM();

        projectPage= homePage.clickMenuProject();
        projectPage.searchProject(data.get("TITLE"));
        projectPage.verifySearchProjectSuccess(data.get("TITLE"));
    }

    @Test(priority = 3,dataProvider = "data_update_project", dataProviderClass = DataProviderFactory.class)
    @Story("Update project status")
    @Description("Verify user can update project")
    public void updateProject(Map<String,String> data){
        loginPage = new LoginPage();
        homePage= loginPage.loginHRM();

        projectPage= homePage.clickMenuProject();
        projectPage.searchProject(data.get("TITLE"));
        projectDetailPage= projectPage.clickButtonViewDetail();
        projectDetailPage.updateStatus(data.get("STATUS"));
        projectDetailPage.verifyUpdateSuccess();
    }

    @Test(priority = 4,dataProvider = "data_uploadFile", dataProviderClass = DataProviderFactory.class)
    @Story("Upload file to project")
    @Description("Verify user can upload file to project successfully")
    public void uploadFile(Map<String,String> data){
        loginPage = new LoginPage();
        homePage= loginPage.loginHRM();

        projectPage= homePage.clickMenuProject();
        projectPage.searchProject(data.get("TITLE"));
        projectDetailPage= projectPage.clickButtonViewDetail();
        projectDetailPage.uploadFile(data.get("FILENAME"),data.get("FILEPATH"));
        projectDetailPage.verifyUploadFile();
    }


    @Test(priority = 5,dataProvider = "data_delete_project", dataProviderClass = DataProviderFactory.class)
    @Story("Delete project")
    @Description("Verify user can delete project successfully")
    public void deleteProject(Map<String,String> data){
        loginPage = new LoginPage();
        homePage= loginPage.loginHRM();

        projectPage= homePage.clickMenuProject();
        projectPage.deleteProject(data.get("TITLE"));
        projectPage.verifyDeleteSuccess();
    }
}

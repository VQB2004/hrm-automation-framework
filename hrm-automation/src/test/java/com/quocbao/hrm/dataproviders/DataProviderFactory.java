package com.quocbao.hrm.dataproviders;

import com.quocbao.hrm.helpers.ExcelHelper;
import com.quocbao.hrm.helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "data_login_success")
    public Object[][] DataProviderLoginSuccess(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataLogin.xlsx",
                "LoginSuccess"
        );
        return  excelHelper.getDataAsMap();
    }

    @DataProvider(name = "data_login_invalid_username")
    public Object[][] DataProviderLoginInvalidUserName(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataLogin.xlsx",
                "LoginInvalidUsername"
        );
        return  excelHelper.getDataAsMap();
    }

    @DataProvider(name = "data_login_invalid_password")
    public Object[][] DataProviderLoginInvalidPassword(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataLogin.xlsx",
                "LoginInvalidPassword"
        );
        return  excelHelper.getDataAsMap();
    }

    @DataProvider(name = "data_add_project")
    public Object[][] DataProviderAddProject(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataProject.xlsx",
                "AddProject"
        );
        return  excelHelper.getDataAsMap();
    }

    @DataProvider(name = "data_search_project")
    public Object[][] DataProviderSearchProject(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataProject.xlsx",
                "SearchProject"
        );
        return  excelHelper.getDataAsMap();
    }

    @DataProvider(name = "data_update_project")
    public Object[][] DataProviderUpdateProject(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataProject.xlsx",
                "UpdateProject"
        );
        return  excelHelper.getDataAsMap();
    }

    @DataProvider(name = "data_uploadFile")
    public Object[][] DataProviderUploadFile(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataProject.xlsx",
                "UploadFile"
        );
        return  excelHelper.getDataAsMap();
    }

    @DataProvider(name = "data_delete_project")
    public Object[][] DataProviderDeleteProject(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"src/test/resources/data/DataProject.xlsx",
                "DeleteProject"
        );
        return  excelHelper.getDataAsMap();
    }

}

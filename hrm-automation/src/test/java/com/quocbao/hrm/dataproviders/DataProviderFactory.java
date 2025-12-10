package com.quocbao.hrm_tests.dataproviders;

import com.quocbao.hrm.helpers.ExcelHelper;
import com.quocbao.hrm.helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "data_login")
    public Object[][] DataProviderLogin(){
        ExcelHelper excelHelper = new ExcelHelper(
                SystemHelper.getCurrentDir()+"hrm-automation/src/test/resources/data/DataCRM.xlsx",
                "Login"
        );
        return  excelHelper.getDataAsMap();
    }


}

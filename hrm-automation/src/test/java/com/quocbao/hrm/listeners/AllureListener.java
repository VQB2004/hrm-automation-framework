package com.quocbao.hrm.listeners;

import com.quocbao.hrm.drivers.DriverManager;
import com.quocbao.hrm.reports.AllureManager;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;

public class AllureListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus().equals(Status.PASSED)) {
            if (DriverManager.getDriver() != null) {
               AllureManager.saveScreenshotPNG();
            }
        }
        if (result.getStatus().equals(Status.FAILED)) {
            if (DriverManager.getDriver() != null) {
                AllureManager.saveScreenshotPNG();
            }
        }
    }
}

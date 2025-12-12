package com.quocbao.hrm.listeners;

import com.quocbao.hrm.reports.AllureManager;
import com.quocbao.hrm.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private int total = 0;
    private int passed = 0;
    private int failed = 0;
    private int skipped = 0;

    private String getName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

    @Override
    public void onStart(ITestContext context) {
        LogUtils.info("Start suite:" + context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        LogUtils.info(("End suite: ") + context.getStartDate());
        LogUtils.info("Total: "+total);
        LogUtils.info("✅ Passed: " + passed);
        LogUtils.info("❌ Failed: " + failed);
        LogUtils.info("🔥 Skipped: " + skipped);
    }

    @Override
    public void onTestStart(ITestResult result){
        total++;
        LogUtils.info("Start test: "+getName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passed++;
        LogUtils.info("✅ PASSED: " + getName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failed++;
        LogUtils.error("❌ FAILED: " + getName(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skipped++;
        LogUtils.warn("🔥 SKIPPED: " + getName(result));

    }
}

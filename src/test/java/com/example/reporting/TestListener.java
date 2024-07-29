package com.example.reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {



    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.setUp();
    }
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentReportManager.extent.createTest(result.getMethod().getMethodName());
        ExtentReportManager.setTest(test);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().fail(result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip(result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }

}
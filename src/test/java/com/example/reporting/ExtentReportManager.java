package com.example.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {
    static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    // Initialize the ExtentReports instance
    public static void setUp() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }
    // Flush the report to save changes
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
    // Get the current thread's ExtentTest
    public static ExtentTest getTest() {
        return test.get();
    }
    // Set the ExtentTest for the current thread
    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    // Add a screenshot to the report
    public static void addScreenshot(WebDriver driver, String screenshotName) {
        // Capture screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

        // Define the path to save the screenshot
        String screenshotPath = "screenshots/" + screenshotName + ".png"; // Customize path and extension as needed

        try {
            // Create directories if they do not exist
            new File("screenshots").mkdirs();

            // Copy the screenshot to the desired location
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally handle the exception or log an error
        }

        // Add screenshot to the Extent Report
        getTest().info("Screenshot: " + screenshotName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}
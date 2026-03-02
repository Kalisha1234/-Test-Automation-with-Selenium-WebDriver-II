
package com.xyzbank.listeners;

import com.xyzbank.utils.DriverManager;
import com.xyzbank.utils.Log;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class TestListener implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        Log.info("TEST PASSED: " + context.getDisplayName());
        DriverManager.quitDriver();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Log.error("TEST FAILED: " + context.getDisplayName() + " - " + cause.getMessage());
        takeScreenshot();
        DriverManager.quitDriver();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        Log.warn("TEST ABORTED: " + context.getDisplayName());
        DriverManager.quitDriver();
    }

    private void takeScreenshot() {
        try {
            Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(
                    ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)
            ));
        } catch (Exception e) {
            Log.error("Failed to capture screenshot: " + e.getMessage());
        }
    }
}

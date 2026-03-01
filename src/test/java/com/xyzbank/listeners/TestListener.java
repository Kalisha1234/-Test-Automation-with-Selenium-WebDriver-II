package com.xyzbank.listeners;

import com.xyzbank.utils.DriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class TestListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(
            ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)
        ));
    }
}

package com.xyzbank.base;

import com.xyzbank.listeners.TestListener;
import com.xyzbank.pages.HomePage;
import com.xyzbank.utils.DriverManager;
import com.xyzbank.utils.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        Log.info("Setting up test - launching browser and navigating to app");
        driver = DriverManager.getDriver();
        DriverManager.navigateToApp();
        homePage = new HomePage(driver);
        Log.info("Browser launched and app loaded successfully");
    }
}

package com.xyzbank.tests;

import com.xyzbank.listeners.TestListener;
import com.xyzbank.pages.HomePage;
import com.xyzbank.utils.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();
        DriverManager.navigateToApp();
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

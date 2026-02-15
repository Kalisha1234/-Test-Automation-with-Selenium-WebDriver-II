package com.xyzbank.tests;

import com.xyzbank.pages.HomePage;
import com.xyzbank.utils.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

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

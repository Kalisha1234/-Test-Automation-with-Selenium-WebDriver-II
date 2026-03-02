package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By managerLoginBtn = By.xpath("//button[text()='Bank Manager Login']");
    private By customerLoginBtn = By.xpath("//button[text()='Customer Login']");
    private By homeBtn = By.xpath("//button[text()='Home']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Step("Click Bank Manager Login")
    public ManagerPage clickManagerLogin() {
        click(managerLoginBtn);
        return new ManagerPage(driver);
    }

    @Step("Click Customer Login")
    public CustomerLoginPage clickCustomerLogin() {
        click(customerLoginBtn);
        return new CustomerLoginPage(driver);
    }

}

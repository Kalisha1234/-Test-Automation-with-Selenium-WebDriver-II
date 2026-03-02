package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userSelect = By.id("userSelect");
    private By loginBtn = By.xpath("//button[text()='Login']");

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void selectByVisibleText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Select(element).selectByVisibleText(text);
    }

    @Step("Login as customer: {customerName}")
    public AccountPage login(String customerName) {
        selectByVisibleText(userSelect, customerName);
        click(loginBtn);
        return new AccountPage(driver);
    }
}

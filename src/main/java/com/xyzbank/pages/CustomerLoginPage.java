package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage {
    private By userSelect = By.id("userSelect");
    private By loginBtn = By.xpath("//button[text()='Login']");

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login as customer: {customerName}")
    public AccountPage login(String customerName) {
        selectByVisibleText(userSelect, customerName);
        click(loginBtn);
        return new AccountPage(driver);
    }
}

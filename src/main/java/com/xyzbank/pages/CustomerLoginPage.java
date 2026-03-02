package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage {
    private BasePage basePage;
    private By userSelect = By.id("userSelect");
    private By loginBtn = By.xpath("//button[text()='Login']");

    public CustomerLoginPage(WebDriver driver) {
        this.basePage = new BasePage(driver);
    }

    @Step("Login as customer: {customerName}")
    public AccountPage login(String customerName) {
        basePage.selectByVisibleText(userSelect, customerName);
        basePage.click(loginBtn);
        return new AccountPage(basePage.driver);
    }
}

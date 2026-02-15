package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By managerLoginBtn = By.xpath("//button[text()='Bank Manager Login']");
    private By customerLoginBtn = By.xpath("//button[text()='Customer Login']");
    private By homeBtn = By.xpath("//button[text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
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

    @Step("Click Home button")
    public void clickHome() {
        click(homeBtn);
    }
}

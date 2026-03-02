package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private BasePage basePage;
    private By managerLoginBtn = By.xpath("//button[text()='Bank Manager Login']");
    private By customerLoginBtn = By.xpath("//button[text()='Customer Login']");
    private By homeBtn = By.xpath("//button[text()='Home']");

    public HomePage(WebDriver driver) {
        this.basePage = new BasePage(driver);
    }

    @Step("Click Bank Manager Login")
    public ManagerPage clickManagerLogin() {
        basePage.click(managerLoginBtn);
        return new ManagerPage(basePage.driver);
    }

    @Step("Click Customer Login")
    public CustomerLoginPage clickCustomerLogin() {
        basePage.click(customerLoginBtn);
        return new CustomerLoginPage(basePage.driver);
    }

    @Step("Click Home button")
    public void clickHome() {
        basePage.click(homeBtn);
    }
}

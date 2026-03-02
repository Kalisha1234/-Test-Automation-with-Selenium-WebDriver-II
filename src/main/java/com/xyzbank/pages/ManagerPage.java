package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerPage {
    private BasePage basePage;
    private By addCustomerBtn = By.xpath("//button[contains(text(),'Add Customer')]");
    private By openAccountBtn = By.xpath("//button[contains(text(),'Open Account')]");
    private By customersBtn = By.xpath("//button[contains(text(),'Customers')]");

    private By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    private By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private By postCodeInput = By.xpath("//input[@placeholder='Post Code']");
    private By addCustomerSubmitBtn = By.xpath("//button[@type='submit']");

    private By customerSelect = By.id("userSelect");
    private By currencySelect = By.id("currency");
    private By processBtn = By.xpath("//button[text()='Process']");

    private By deleteBtn = By.xpath("//button[text()='Delete']");

    public ManagerPage(WebDriver driver) {
        this.basePage = new BasePage(driver);
    }

    @Step("Click Add Customer button")
    public void clickAddCustomer() {
        basePage.click(addCustomerBtn);
    }

    @Step("Add customer: {firstName} {lastName}, PostCode: {postCode}")
    public void addCustomer(String firstName, String lastName, String postCode) {
        clickAddCustomer();
        basePage.type(firstNameInput, firstName);
        basePage.type(lastNameInput, lastName);
        basePage.type(postCodeInput, postCode);
        basePage.click(addCustomerSubmitBtn);
    }

    @Step("Accept alert")
    public String getAlertText() {
        try {
            basePage.wait.until(driver -> {
                try {
                    driver.switchTo().alert();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            });
            String alertText = basePage.driver.switchTo().alert().getText();
            basePage.driver.switchTo().alert().accept();
            return alertText;
        } catch (Exception e) {
            return "";
        }
    }

    @Step("Click Open Account button")
    public void clickOpenAccount() {
        basePage.click(openAccountBtn);
    }

    @Step("Open account for customer: {customerName} with currency: {currency}")
    public void openAccount(String customerName, String currency) {
        clickOpenAccount();
        basePage.selectByVisibleText(customerSelect, customerName);
        basePage.selectByVisibleText(currencySelect, currency);
        basePage.click(processBtn);
    }

    @Step("Click Customers button")
    public void clickCustomers() {
        basePage.click(customersBtn);
    }

    @Step("Delete first customer")
    public void deleteFirstCustomer() {
        clickCustomers();
        basePage.click(deleteBtn);
    }
}

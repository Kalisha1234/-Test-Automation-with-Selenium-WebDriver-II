package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerPage extends BasePage {
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
        super(driver);
    }

    @Step("Click Add Customer button")
    public void clickAddCustomer() {
        click(addCustomerBtn);
    }

    @Step("Add customer: {firstName} {lastName}, PostCode: {postCode}")
    public void addCustomer(String firstName, String lastName, String postCode) {
        clickAddCustomer();
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postCodeInput, postCode);
        click(addCustomerSubmitBtn);
    }

    @Step("Accept alert")
    public String getAlertText() {
        try {
            Thread.sleep(500);
            String alertText = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            return alertText;
        } catch (Exception e) {
            return "";
        }
    }

    @Step("Click Open Account button")
    public void clickOpenAccount() {
        click(openAccountBtn);
    }

    @Step("Open account for customer: {customerName} with currency: {currency}")
    public void openAccount(String customerName, String currency) {
        clickOpenAccount();
        selectByVisibleText(customerSelect, customerName);
        selectByVisibleText(currencySelect, currency);
        click(processBtn);
    }

    @Step("Click Customers button")
    public void clickCustomers() {
        click(customersBtn);
    }

    @Step("Delete first customer")
    public void deleteFirstCustomer() {
        clickCustomers();
        click(deleteBtn);
    }
}

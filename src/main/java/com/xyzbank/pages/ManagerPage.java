package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverWait longWait;


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
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }


    private void selectByVisibleText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Select(element).selectByVisibleText(text);
    }


    private String acceptAlertAndGetText() {
        try {
            wait.until(d -> {
                try {
                    d.switchTo().alert();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            });
            String alertText = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            return alertText;
        } catch (Exception e) {
            return "";
        }
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
        return acceptAlertAndGetText();
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

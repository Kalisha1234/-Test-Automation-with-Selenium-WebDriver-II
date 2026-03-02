package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By transactionsBtn = By.xpath("//button[contains(text(),'Transactions')]");
    private By depositBtn = By.xpath("//button[contains(text(),'Deposit')]");
    private By withdrawlBtn = By.xpath("//button[contains(text(),'Withdrawl')]");
    private By amountInput = By.xpath("//input[@placeholder='amount']");
    private By depositSubmitBtn = By.xpath("//button[@type='submit' and text()='Deposit']");
    private By withdrawSubmitBtn = By.xpath("//button[@type='submit' and text()='Withdraw']");
    private By balanceLabel = By.xpath("//div[contains(@class,'center')]//strong[2]");
    private By messageLabel = By.xpath("//span[contains(@class,'error')]");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void typeWithWait(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    private String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    @Step("Click Transactions button")
    public TransactionsPage clickTransactions() {
        click(transactionsBtn);
        return new TransactionsPage(driver);
    }

    @Step("Deposit amount: {amount}")
    public void deposit(String amount) {
        click(depositBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        typeWithWait(amountInput, amount);
        click(depositSubmitBtn);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(balanceLabel, ""));
    }

    @Step("Withdraw amount: {amount}")
    public void withdraw(String amount) {
        click(withdrawlBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        typeWithWait(amountInput, amount);
        click(withdrawSubmitBtn);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(messageLabel),
                ExpectedConditions.textToBePresentInElementLocated(balanceLabel, "")
        ));
    }

    @Step("Get current balance")
    public String getBalance() {
        return getText(balanceLabel);
    }

    @Step("Get message")
    public String getMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(messageLabel));
            return getText(messageLabel);
        } catch (Exception e) {
            return "";
        }
    }
}

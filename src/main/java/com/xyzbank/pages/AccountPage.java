package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage  {
    private BasePage basePage;
    private By transactionsBtn = By.xpath("//button[contains(text(),'Transactions')]");
    private By depositBtn = By.xpath("//button[contains(text(),'Deposit')]");
    private By withdrawlBtn = By.xpath("//button[contains(text(),'Withdrawl')]");

    private By amountInput = By.xpath("//input[@placeholder='amount']");
    private By depositSubmitBtn = By.xpath("//button[@type='submit' and text()='Deposit']");
    private By withdrawSubmitBtn = By.xpath("//button[@type='submit' and text()='Withdraw']");

    private By balanceLabel = By.xpath("//div[contains(@class,'center')]//strong[2]");

    //  FIXED: More flexible locator
    private By messageLabel = By.xpath("//span[contains(@class,'error')]");

    public AccountPage(WebDriver driver) {
        this.basePage = new BasePage(driver);
    }

    @Step("Click Transactions button")
    public TransactionsPage clickTransactions() {
        basePage.click(transactionsBtn);
        return new TransactionsPage(basePage.driver);
    }

    @Step("Deposit amount: {amount}")
    public void deposit(String amount) {
        basePage.click(depositBtn);
        basePage.wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        basePage.typeWithWait(amountInput, amount);
        basePage.click(depositSubmitBtn);
        basePage.wait.until(ExpectedConditions.textToBePresentInElementLocated(balanceLabel, ""));
    }

    @Step("Withdraw amount: {amount}")
    public void withdraw(String amount) {
        basePage.click(withdrawlBtn);
        basePage.wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        basePage.typeWithWait(amountInput, amount);
        basePage.click(withdrawSubmitBtn);
        basePage.wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(messageLabel),
            ExpectedConditions.textToBePresentInElementLocated(balanceLabel, "")
        ));
    }

    @Step("Get current balance")
    public String getBalance() {
        return basePage.getText(balanceLabel);
    }

    @Step("Get message")
    public String getMessage() {
        try {
            basePage.wait.until(ExpectedConditions.visibilityOfElementLocated(messageLabel));
            return basePage.getText(messageLabel);
        } catch (Exception e) {
            return "";
        }
    }

    //  Optional clean helper method (recommended)
    @Step("Check if transaction failed")
    public boolean isTransactionFailed() {
        return getMessage().contains("Transaction Failed");
    }
}
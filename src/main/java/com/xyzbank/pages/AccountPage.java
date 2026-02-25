package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

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
        super(driver);
    }

    @Step("Click Transactions button")
    public TransactionsPage clickTransactions() {
        click(transactionsBtn);
        return new TransactionsPage(driver);
    }

    @Step("Deposit amount: {amount}")
    public void deposit(String amount) {
        click(depositBtn);
        shortWait();
        typeWithWait(amountInput, amount);
        click(depositSubmitBtn);
        mediumWait();
    }

    @Step("Withdraw amount: {amount}")
    public void withdraw(String amount) {
        click(withdrawlBtn);
        shortWait();
        typeWithWait(amountInput, amount);
        click(withdrawSubmitBtn);
        mediumWait();
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

    //  Optional clean helper method (recommended)
    @Step("Check if transaction failed")
    public boolean isTransactionFailed() {
        return getMessage().contains("Transaction Failed");
    }
}
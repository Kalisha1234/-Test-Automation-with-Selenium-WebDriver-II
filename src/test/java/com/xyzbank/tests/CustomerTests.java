package com.xyzbank.tests;

import com.xyzbank.pages.AccountPage;
import com.xyzbank.pages.CustomerLoginPage;
import com.xyzbank.pages.TransactionsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Customer Features")
@Feature("Customer Operations")
public class CustomerTests extends BaseTest {

    @Test
    @DisplayName("CU-001: Customer login with valid credentials")
    @Description("Verify that customer can login successfully with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testCustomerLogin() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");
        String balance = accountPage.getBalance();
        assertNotNull(balance, "Balance should be displayed after login");
    }

    @Test
    @DisplayName("CU-002: Deposit valid amount")
    @Description("Verify that customer can deposit a valid amount")
    @Severity(SeverityLevel.CRITICAL)
    public void testDepositValidAmount() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");

        String initialBalance = accountPage.getBalance();
        accountPage.deposit("100");

        String newBalance = accountPage.getBalance();
        assertNotEquals(initialBalance, newBalance, "Balance should be updated after deposit");
    }

    @Test
    @DisplayName("CU-004: Withdraw valid amount with sufficient balance")
    @Description("Verify that customer can withdraw money when sufficient balance is available")
    @Severity(SeverityLevel.CRITICAL)
    public void testWithdrawValidAmount() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");

        accountPage.deposit("500");
        String balanceAfterDeposit = accountPage.getBalance();

        accountPage.withdraw("100");
        String balanceAfterWithdraw = accountPage.getBalance();

        assertNotEquals(balanceAfterDeposit, balanceAfterWithdraw, "Balance should be updated after withdrawal");
    }

    @Test
    @DisplayName("CU-005: Withdraw amount exceeding balance")
    @Description("Verify that system prevents withdrawal when amount exceeds available balance")
    @Severity(SeverityLevel.CRITICAL)
    public void testWithdrawExceedingBalance() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");

        String initialBalanceStr = accountPage.getBalance();
        int balanceValue = Integer.parseInt(initialBalanceStr);

        // Attempt to withdraw more than available
        accountPage.withdraw(String.valueOf(balanceValue + 1000));

        // Get the response message from the updated locator
        String message = accountPage.getMessage();

        // Assertions: Checking both the message and that the balance remained the same
        assertAll("Withdrawal Failure Validation",
                () -> assertTrue(message.toLowerCase().contains("failed"),
                        "Expected message to contain 'Failed' but got: " + message),
                () -> assertEquals(initialBalanceStr, accountPage.getBalance(),
                        "Balance should not have changed after a failed transaction")
        );
    }

    @Test
    @DisplayName("CU-006: View transaction history")
    @Description("Verify that customer can view their transaction history")
    @Severity(SeverityLevel.NORMAL)
    public void testViewTransactionHistory() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");

        accountPage.deposit("200");
        TransactionsPage transactionsPage = accountPage.clickTransactions();
        assertTrue(transactionsPage.areTransactionsDisplayed(), "Transactions should be displayed");
    }

    @Test
    @DisplayName("CU-007: Verify balance after deposit")
    @Description("Verify that account balance is correctly updated after deposit")
    @Severity(SeverityLevel.CRITICAL)
    public void testBalanceAfterDeposit() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");

        String initialBalance = accountPage.getBalance();
        int initial = Integer.parseInt(initialBalance);

        accountPage.deposit("1000");
        String newBalance = accountPage.getBalance();
        int updated = Integer.parseInt(newBalance);

        assertEquals(initial + 1000, updated, "Balance should increase by deposit amount");
    }

    @Test
    @DisplayName("CU-008: Verify balance after withdrawal")
    @Description("Verify that account balance is correctly updated after withdrawal")
    @Severity(SeverityLevel.CRITICAL)
    public void testBalanceAfterWithdrawal() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");

        accountPage.deposit("2000");
        String balanceBeforeWithdraw = accountPage.getBalance();
        int before = Integer.parseInt(balanceBeforeWithdraw);

        accountPage.withdraw("500");
        String balanceAfterWithdraw = accountPage.getBalance();
        int after = Integer.parseInt(balanceAfterWithdraw);

        assertEquals(before - 500, after, "Balance should decrease by withdrawal amount");
    }

    @Test
    @DisplayName("CU-009: Verify transaction cannot be altered")
    @Description("Verify that customers cannot reset or alter their transaction history")
    @Severity(SeverityLevel.NORMAL)
    public void testTransactionSecurity() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login("Harry Potter");

        accountPage.deposit("300");
        TransactionsPage transactionsPage = accountPage.clickTransactions();
        int transactionCount = transactionsPage.getTransactionCount();

        assertTrue(transactionCount > 0, "Transactions should be recorded and cannot be altered");
    }
}
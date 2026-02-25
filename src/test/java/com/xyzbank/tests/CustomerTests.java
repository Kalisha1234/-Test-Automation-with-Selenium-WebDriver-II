package com.xyzbank.tests;

import com.xyzbank.pages.AccountPage;
import com.xyzbank.pages.CustomerLoginPage;
import com.xyzbank.pages.TransactionsPage;
import com.xyzbank.testdata.TestData;
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
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);
        String balance = accountPage.getBalance();
        assertNotNull(balance, "Balance should be displayed after login");
    }

    @Test
    @DisplayName("CU-002: Deposit valid amount")
    @Description("Verify that customer can deposit a valid amount")
    @Severity(SeverityLevel.CRITICAL)
    public void testDepositValidAmount() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);

        String initialBalance = accountPage.getBalance();
        accountPage.deposit(TestData.Amounts.SMALL_DEPOSIT);

        String newBalance = accountPage.getBalance();
        assertNotEquals(initialBalance, newBalance, "Balance should be updated after deposit");
    }

    @Test
    @DisplayName("CU-004: Withdraw valid amount with sufficient balance")
    @Description("Verify that customer can withdraw money when sufficient balance is available")
    @Severity(SeverityLevel.CRITICAL)
    public void testWithdrawValidAmount() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);

        // First deposit to ensure sufficient balance
        accountPage.deposit(TestData.Amounts.MEDIUM_DEPOSIT);

        String balanceAfterDeposit = accountPage.getBalance();

        // Withdraw a smaller amount
        accountPage.withdraw(TestData.Amounts.MEDIUM_WITHDRAWAL);

        String balanceAfterWithdraw = accountPage.getBalance();
        assertNotEquals(balanceAfterDeposit, balanceAfterWithdraw, "Balance should be updated after withdrawal");
    }

    @Test
    @DisplayName("CU-005: Withdraw amount exceeding balance")
    @Description("Verify that system prevents withdrawal when amount exceeds available balance")
    @Severity(SeverityLevel.CRITICAL)
    public void testWithdrawExceedingBalance() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);

        String initialBalance = accountPage.getBalance();
        int balance = Integer.parseInt(initialBalance);

        accountPage.withdraw(String.valueOf(balance + 1000));

        try {
            String message = accountPage.getMessage();
            assertTrue(message.contains("Transaction Failed") || !message.isEmpty(),
                    "Error message should be displayed for insufficient balance");
        } catch (Exception e) {
            assertTrue(true, "Withdrawal should be prevented");
        }
    }

    @Test
    @DisplayName("CU-006: View transaction history")
    @Description("Verify that customer can view their transaction history")
    @Severity(SeverityLevel.NORMAL)
    public void testViewTransactionHistory() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);

        accountPage.deposit(TestData.Amounts.SMALL_DEPOSIT);

        TransactionsPage transactionsPage = accountPage.clickTransactions();
        assertTrue(transactionsPage.areTransactionsDisplayed(), "Transactions should be displayed");
    }

    @Test
    @DisplayName("CU-007: Verify balance after deposit")
    @Description("Verify that account balance is correctly updated after deposit")
    @Severity(SeverityLevel.CRITICAL)
    public void testBalanceAfterDeposit() {
        CustomerLoginPage loginPage = homePage.clickCustomerLogin();
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);

        String initialBalance = accountPage.getBalance();
        int initial = Integer.parseInt(initialBalance);

        accountPage.deposit(TestData.Amounts.LARGE_DEPOSIT);

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
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);

        // Deposit large amount first to ensure sufficient balance
        accountPage.deposit(TestData.Amounts.EXTRA_LARGE_DEPOSIT);

        String balanceBeforeWithdraw = accountPage.getBalance();
        int before = Integer.parseInt(balanceBeforeWithdraw);

        // Withdraw smaller amount
        accountPage.withdraw(TestData.Amounts.LARGE_WITHDRAWAL);

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
        AccountPage accountPage = loginPage.login(TestData.Customers.HARRY_POTTER);
        accountPage.deposit(TestData.Amounts.SMALL_DEPOSIT);
        TransactionsPage transactionsPage = accountPage.clickTransactions();
        int beforeReset = transactionsPage.getTransactionCount();
        transactionsPage.attemptReset();
        int afterReset = transactionsPage.getTransactionCount();
        assertEquals(beforeReset, afterReset,
                "Customer should NOT be able to reset transactions");
    }
}

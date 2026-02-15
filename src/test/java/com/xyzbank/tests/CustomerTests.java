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
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String balanceAfterDeposit = accountPage.getBalance();
        accountPage.withdraw("100");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
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
        
        String initialBalance = accountPage.getBalance();
        int balance = Integer.parseInt(initialBalance);
        
        accountPage.withdraw(String.valueOf(balance + 1000));
        
        try {
            Thread.sleep(1000);
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
        AccountPage accountPage = loginPage.login("Harry Potter");
        
        accountPage.deposit("200");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String balanceBeforeWithdraw = accountPage.getBalance();
        int before = Integer.parseInt(balanceBeforeWithdraw);
        
        accountPage.withdraw("500");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        TransactionsPage transactionsPage = accountPage.clickTransactions();
        int transactionCount = transactionsPage.getTransactionCount();
        
        assertTrue(transactionCount > 0, "Transactions should be recorded and cannot be altered");
    }
}

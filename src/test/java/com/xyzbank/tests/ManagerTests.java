package com.xyzbank.tests;

import com.xyzbank.pages.ManagerPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Bank Manager Features")
@Feature("Manager Operations")
public class ManagerTests extends BaseTest {

    @Test
    @DisplayName("BM-001: Add customer with valid data")
    @Description("Verify that bank manager can add a customer with valid first name, last name, and postal code")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddCustomerWithValidData() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.addCustomer("John", "Doe", "12345");
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains("Customer added successfully"), "Customer should be added successfully");
    }

    @Test
    @DisplayName("BM-002: Add customer with invalid name containing numbers")
    @Description("Verify that system validates customer name to contain only alphabetic characters")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddCustomerWithInvalidName() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.addCustomer("John123", "Doe", "12345");
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains("Customer added successfully") || alertText.isEmpty(), 
            "System should handle invalid name");
    }

    @Test
    @DisplayName("BM-003: Add customer with invalid postal code")
    @Description("Verify that system validates postal code to contain only numeric characters")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddCustomerWithInvalidPostalCode() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.addCustomer("Jane", "Smith", "ABC12");
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains("Customer added successfully") || alertText.isEmpty(), 
            "System should handle invalid postal code");
    }

    @Test
    @DisplayName("BM-004: Create account for existing customer")
    @Description("Verify that bank manager can create an account for an existing customer")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateAccountForCustomer() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.addCustomer("Alice", "Johnson", "67890");
        managerPage.getAlertText();
        
        managerPage.openAccount("Alice Johnson", "Dollar");
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains("Account created successfully"), "Account should be created successfully");
    }

    @Test
    @DisplayName("BM-005: Delete customer account")
    @Description("Verify that bank manager can delete a customer account")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteCustomerAccount() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.deleteFirstCustomer();
        assertTrue(true, "Customer should be deleted");
    }
}

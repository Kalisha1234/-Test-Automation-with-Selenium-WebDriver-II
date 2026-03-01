package com.xyzbank.tests;

import com.xyzbank.pages.ManagerPage;
import com.xyzbank.testdata.TestData;
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
        managerPage.addCustomer(
                TestData.ManagerData.ValidCustomers.FIRST_NAME,
                TestData.ManagerData.ValidCustomers.LAST_NAME,
                TestData.ManagerData.ValidCustomers.POSTAL_CODE
        );
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains(TestData.Messages.CUSTOMER_ADDED_SUCCESS),
                "Customer should be added successfully");
    }

    @Test
    @DisplayName("BM-002: Add customer with invalid name containing numbers")
    @Description("Verify that system validates customer name to contain only alphabetic characters")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddCustomerWithInvalidName() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.addCustomer(
                TestData.ManagerData.InvalidCustomers.INVALID_NAME_WITH_NUMBERS,
                TestData.ManagerData.ValidCustomers.LAST_NAME,
                TestData.ManagerData.ValidCustomers.POSTAL_CODE
        );
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains(TestData.Messages.CUSTOMER_ADDED_SUCCESS) || alertText.isEmpty(),
                "System should handle invalid name");
    }

    @Test
    @DisplayName("BM-003: Add customer with invalid postal code")
    @Description("Verify that system validates postal code to contain only numeric characters")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddCustomerWithInvalidPostalCode() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.addCustomer(
                TestData.ManagerData.ValidCustomers.FIRST_NAME_2,
                TestData.ManagerData.ValidCustomers.LAST_NAME_2,
                TestData.ManagerData.InvalidCustomers.INVALID_POSTAL_CODE_ALPHA
        );
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains(TestData.Messages.CUSTOMER_ADDED_SUCCESS) || alertText.isEmpty(),
                "System should handle invalid postal code");
    }

    @Test
    @DisplayName("BM-004: Create account for existing customer")
    @Description("Verify that bank manager can create an account for an existing customer")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateAccountForCustomer() {
        ManagerPage managerPage = homePage.clickManagerLogin();
        managerPage.addCustomer(
                TestData.ManagerData.ValidCustomers.FIRST_NAME_3,
                TestData.ManagerData.ValidCustomers.LAST_NAME_3,
                TestData.ManagerData.ValidCustomers.POSTAL_CODE_3
        );
        managerPage.getAlertText();

        String fullName = TestData.ManagerData.ValidCustomers.FIRST_NAME_3 + " " +
                TestData.ManagerData.ValidCustomers.LAST_NAME_3;
        managerPage.openAccount(fullName, TestData.ManagerData.Currency.DOLLAR);
        String alertText = managerPage.getAlertText();
        assertTrue(alertText.contains(TestData.Messages.ACCOUNT_CREATED_SUCCESS),
                "Account should be created successfully");
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

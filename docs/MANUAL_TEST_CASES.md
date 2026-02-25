# XYZ Bank - Manual Test Cases

## Test Execution Summary
**Application**: XYZ Bank  
**URL**: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login  
**Test Date**: [To be filled during execution]  
**Tester**: [To be filled]

---

## Bank Manager Test Cases

### TC-BM-001: Add Customer with Valid Data
**Priority**: High  
**Precondition**: Application is accessible

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to application URL | Home page displays with two buttons | | |
| 2 | Click "Bank Manager Login" | Manager page displays with three buttons | | |
| 3 | Click "Add Customer" | Form displays with First Name, Last Name, Post Code fields | | |
| 4 | Enter "John" in First Name | Text is entered | | |
| 5 | Enter "Doe" in Last Name | Text is entered | | |
| 6 | Enter "12345" in Post Code | Text is entered | | |
| 7 | Click "Add Customer" button | Alert displays "Customer added successfully with id: X" | | |
| 8 | Click OK on alert | Alert closes | | |

**Test Data**: First Name: John, Last Name: Doe, Post Code: 12345

---

### TC-BM-002: Add Customer with Invalid Name (Numbers)
**Priority**: High  
**Precondition**: On Bank Manager page

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Add Customer" | Form displays | | |
| 2 | Enter "John123" in First Name | Text is entered | | |
| 3 | Enter "Doe" in Last Name | Text is entered | | |
| 4 | Enter "12345" in Post Code | Text is entered | | |
| 5 | Click "Add Customer" button | Validation error or customer added (check app behavior) | | |

**Test Data**: First Name: John123, Last Name: Doe, Post Code: 12345

---

### TC-BM-003: Add Customer with Invalid Postal Code
**Priority**: High  
**Precondition**: On Bank Manager page

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Add Customer" | Form displays | | |
| 2 | Enter "Jane" in First Name | Text is entered | | |
| 3 | Enter "Smith" in Last Name | Text is entered | | |
| 4 | Enter "ABC12" in Post Code | Text is entered | | |
| 5 | Click "Add Customer" button | Validation error or customer added (check app behavior) | | |

**Test Data**: First Name: Jane, Last Name: Smith, Post Code: ABC12

---

### TC-BM-004: Open Account for Customer
**Priority**: High  
**Precondition**: At least one customer exists in the system

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Open Account" | Form displays with Customer and Currency dropdowns | | |
| 2 | Select a customer from dropdown | Customer is selected | | |
| 3 | Select "Dollar" from Currency dropdown | Currency is selected | | |
| 4 | Click "Process" button | Alert displays "Account created successfully with account Number: X" | | |
| 5 | Click OK on alert | Alert closes | | |

---

### TC-BM-005: View Customers List
**Priority**: Medium  
**Precondition**: At least one customer exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Customers" button | Table displays with customer list | | |
| 2 | Verify table columns | Columns: First Name, Last Name, Post Code, Account Number, Delete | | |
| 3 | Verify customer data | Previously added customers are visible | | |

---

### TC-BM-006: Delete Customer Account
**Priority**: Medium  
**Precondition**: At least one customer exists in the list

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Customers" button | Customer list displays | | |
| 2 | Click "Delete" button for first customer | Customer row is removed from table | | |
| 3 | Verify customer is deleted | Customer no longer appears in list | | |

---

## Customer Test Cases

### TC-CU-001: Customer Login
**Priority**: High  
**Precondition**: Customer exists with an account

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to home page | Home page displays | | |
| 2 | Click "Customer Login" | Login page displays with customer dropdown | | |
| 3 | Select "Harry Potter" from dropdown | Customer is selected | | |
| 4 | Click "Login" button | Account page displays with balance and buttons | | |
| 5 | Verify account details | Name, Account Number, Balance, Currency displayed | | |

---

### TC-CU-002: Deposit Valid Amount
**Priority**: High  
**Precondition**: Customer is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Note current balance | Balance value recorded | | |
| 2 | Click "Deposit" button | Amount input field displays | | |
| 3 | Enter "100" in amount field | Text is entered | | |
| 4 | Click "Deposit" button | Success message displays | | |
| 5 | Verify balance | Balance increased by 100 | | |

**Test Data**: Deposit Amount: 100

---

### TC-CU-003: Deposit Invalid Amount (Zero)
**Priority**: High  
**Precondition**: Customer is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Deposit" button | Amount input field displays | | |
| 2 | Enter "0" in amount field | Text is entered | | |
| 3 | Click "Deposit" button | Error message or validation prevents deposit | | |

**Test Data**: Deposit Amount: 0

---

### TC-CU-004: Withdraw Valid Amount
**Priority**: High  
**Precondition**: Customer is logged in with sufficient balance

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Deposit 500 first | Balance increases | | |
| 2 | Note current balance | Balance value recorded | | |
| 3 | Click "Withdrawl" button | Amount input field displays | | |
| 4 | Enter "100" in amount field | Text is entered | | |
| 5 | Click "Withdraw" button | Success message displays | | |
| 6 | Verify balance | Balance decreased by 100 | | |

**Test Data**: Withdraw Amount: 100

---

### TC-CU-005: Withdraw Amount Exceeding Balance
**Priority**: High  
**Precondition**: Customer is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Note current balance | Balance value recorded | | |
| 2 | Click "Withdrawl" button | Amount input field displays | | |
| 3 | Enter amount > balance | Text is entered | | |
| 4 | Click "Withdraw" button | Error message "Transaction Failed" displays | | |
| 5 | Verify balance | Balance remains unchanged | | |

---

### TC-CU-006: View Transaction History
**Priority**: Medium  
**Precondition**: Customer is logged in with transactions

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Perform a deposit | Transaction completed | | |
| 2 | Click "Transactions" button | Transaction page displays | | |
| 3 | Verify transaction table | Table shows Date-Time, Amount, Transaction Type | | |
| 4 | Verify recent transaction | Latest transaction is visible | | |

---

### TC-CU-007: Multiple Deposits and Balance Verification
**Priority**: High  
**Precondition**: Customer is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Note initial balance | Balance recorded | | |
| 2 | Deposit 100 | Balance increases by 100 | | |
| 3 | Deposit 200 | Balance increases by 200 | | |
| 4 | Verify total balance | Balance = Initial + 300 | | |

---

### TC-CU-008: Multiple Withdrawals and Balance Verification
**Priority**: High  
**Precondition**: Customer is logged in with balance >= 500

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Deposit 1000 | Balance increases | | |
| 2 | Note balance after deposit | Balance recorded | | |
| 3 | Withdraw 200 | Balance decreases by 200 | | |
| 4 | Withdraw 300 | Balance decreases by 300 | | |
| 5 | Verify total balance | Balance = Previous - 500 | | |

---

### TC-CU-009: Transaction History Integrity
**Priority**: Medium  
**Precondition**: Customer is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Perform 3 deposits | Transactions completed | | |
| 2 | Click "Transactions" | Transaction page displays | | |
| 3 | Count transaction rows | 3 transactions visible | | |
| 4 | Check for Reset button | Reset button exists (if present, note behavior) | | |
| 5 | Verify transactions cannot be edited | No edit functionality available | | |

---

## Test Execution Notes

### Defects Found
| Defect ID | Description | Severity | Status |
|-----------|-------------|----------|--------|
| | | | |

### Test Summary
- **Total Test Cases**: 17
- **Passed**: 
- **Failed**: 
- **Blocked**: 
- **Not Executed**: 

### Environment Details
- **Browser**: Microsoft Edge
- **Browser Version**: 
- **OS**: 
- **Screen Resolution**: 

### Additional Observations
[Add any additional notes or observations during manual testing]

---

**Sign-off**  
**Tester Name**: _______________  
**Date**: _______________  
**Signature**: _______________

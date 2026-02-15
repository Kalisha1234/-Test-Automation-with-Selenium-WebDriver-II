# XYZ Bank Test Automation - Test Plan

## 1. Introduction
This document outlines the test plan for automating the XYZ Bank application using Selenium WebDriver with Java, JUnit 5, and Allure reporting.

## 2. Test Objectives
- Validate Bank Manager functionalities (add customers, create accounts, delete accounts)
- Validate Customer functionalities (login, deposit, withdraw, view transactions)
- Ensure data validation rules are enforced
- Verify transaction integrity and security
- Achieve 90%+ test coverage for critical user flows

## 3. Scope

### In Scope:
- Bank Manager: Add customer, create account, delete account
- Customer: Login, deposit funds, withdraw funds, view transactions
- Input validation (customer names, postal codes, amounts)
- Balance calculations and updates
- Transaction history verification

### Out of Scope:
- Performance testing
- Security penetration testing
- Mobile responsiveness testing
- Backend API testing

## 4. Test Strategy

### 4.1 Test Approach
- **Framework**: Page Object Model (POM) with Selenium WebDriver
- **Test Framework**: JUnit 5
- **Browser**: Microsoft Edge
- **Reporting**: Allure Report
- **CI/CD**: GitHub Actions with Docker containerization

### 4.2 Test Types
- **Functional Testing**: Validate all user stories and acceptance criteria
- **Validation Testing**: Verify input validation rules
- **Regression Testing**: Ensure existing functionality remains intact

## 5. Test Environment

### 5.1 Application Under Test
- **URL**: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
- **Type**: Web Application (AngularJS)

### 5.2 Test Environment
- **OS**: Windows/Linux (Docker)
- **Browser**: Microsoft Edge (latest stable)
- **Java Version**: 11
- **Build Tool**: Maven 3.8+

## 6. Test Scenarios

### 6.1 Bank Manager Tests
| Test ID | Test Scenario | Priority |
|---------|--------------|----------|
| BM-001 | Add customer with valid data | High |
| BM-002 | Add customer with invalid name (numbers/special chars) | High |
| BM-003 | Add customer with invalid postal code (non-numeric) | High |
| BM-004 | Create account for existing customer | High |
| BM-005 | Delete customer account | Medium |
| BM-006 | Verify customer list after adding customer | Medium |

### 6.2 Customer Tests
| Test ID | Test Scenario | Priority |
|---------|--------------|----------|
| CU-001 | Customer login with valid credentials | High |
| CU-002 | Deposit valid amount | High |
| CU-003 | Deposit invalid amount (negative/zero) | High |
| CU-004 | Withdraw valid amount with sufficient balance | High |
| CU-005 | Withdraw amount exceeding balance | High |
| CU-006 | View transaction history | Medium |
| CU-007 | Verify balance after deposit | High |
| CU-008 | Verify balance after withdrawal | High |
| CU-009 | Verify transaction cannot be altered | Medium |

## 7. Test Data

### 7.1 Valid Test Data
- **Customer Names**: John Doe, Jane Smith, Alice Johnson
- **First Names**: John, Jane, Alice
- **Last Names**: Doe, Smith, Johnson
- **Postal Codes**: 12345, 67890, 11111
- **Deposit Amounts**: 100, 500, 1000
- **Withdrawal Amounts**: 50, 200, 500

### 7.2 Invalid Test Data
- **Invalid Names**: John123, @Jane, 456
- **Invalid Postal Codes**: ABC12, 123AB, ABCDE

## 8. Resources

### 8.1 Human Resources
- Test Automation Engineer: 1
- Duration: 2-3 weeks

### 8.2 Technical Resources
- Selenium WebDriver 4.15.0
- JUnit 5.10.0
- Allure Report 2.24.0
- WebDriverManager 5.6.2
- Docker
- GitHub Actions

## 9. Test Deliverables
- Test automation framework (Page Object Model)
- Automated test scripts
- Test execution reports (Allure)
- Docker configuration
- CI/CD pipeline (GitHub Actions)
- Test documentation

## 10. Entry and Exit Criteria

### 10.1 Entry Criteria
- Application is accessible
- Test environment is set up
- Test data is prepared
- Automation framework is ready

### 10.2 Exit Criteria
- All high-priority tests executed
- 90%+ pass rate achieved
- Critical defects resolved
- Test reports generated
- CI/CD pipeline operational

## 11. Risk and Mitigation

| Risk | Impact | Mitigation |
|------|--------|------------|
| Application downtime | High | Use local backup or staging environment |
| Browser compatibility issues | Medium | Use WebDriverManager for driver management |
| Flaky tests due to timing | Medium | Implement explicit waits and retry mechanism |
| CI/CD pipeline failures | Medium | Add comprehensive error handling and logging |

## 12. Schedule

| Phase | Duration | Deliverable |
|-------|----------|-------------|
| Test Plan Creation | 1 day | Test plan document |
| Framework Setup | 2 days | POM framework, CI/CD pipeline |
| Test Script Development | 5 days | Automated test scripts |
| Test Execution & Debugging | 3 days | Test results, bug reports |
| Reporting & Documentation | 2 days | Final reports, documentation |

## 13. Approval
This test plan requires approval from project stakeholders before test execution begins.

---
**Document Version**: 1.0  
**Last Updated**: 2024  
**Prepared By**: Test Automation Team

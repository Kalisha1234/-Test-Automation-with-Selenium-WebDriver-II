# XYZ Bank Test Automation

Selenium WebDriver test automation framework for XYZ Bank application using Java, JUnit 5, Maven, Docker, and GitHub Actions CI/CD.

## Project Overview

This project automates testing for the XYZ Bank application, covering both Bank Manager and Customer functionalities.

**Application URL**: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login

## Tech Stack

- **Language**: Java 11
- **Build Tool**: Maven
- **Test Framework**: JUnit 5
- **Automation Tool**: Selenium WebDriver 4.15.0
- **Browser**: Microsoft Edge
- **Reporting**: Allure Report
- **Containerization**: Docker
- **CI/CD**: GitHub Actions

## Project Structure

```
xyz-bank-automation/
├── .github/
│   └── workflows/
│       └── ci-cd.yml          # GitHub Actions CI/CD pipeline
├── docs/
│   └── TEST_PLAN.md           # Comprehensive test plan
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/xyzbank/
│   │           ├── pages/     # Page Object Model classes
│   │           └── utils/     # Utility classes
│   └── test/
│       ├── java/
│       │   └── com/xyzbank/
│       │       └── tests/     # Test classes
│       └── resources/
│           └── allure.properties
├── Dockerfile                  # Docker configuration
├── docker-compose.yml          # Docker Compose for Selenium Grid
├── pom.xml                     # Maven dependencies
└── README.md
```

## Features Tested

### Bank Manager
- Add customers with validation
- Create accounts for customers
- Delete customer accounts

### Customer
- Login functionality
- Deposit funds
- Withdraw money
- View transaction history
- Balance verification

## Prerequisites

- Java 11 or higher
- Maven 3.8+
- Microsoft Edge browser
- Docker (optional, for containerized execution)
- Git

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd xyz-bank-automation
```

2. Install dependencies:
```bash
mvn clean install -DskipTests
```

## Running Tests

### Local Execution

Run all tests:
```bash
mvn clean test
```

Run specific test class:
```bash
mvn test -Dtest=ManagerTests
mvn test -Dtest=CustomerTests
```

### Docker Execution

Build and run with Docker:
```bash
docker build -t xyz-bank-automation .
docker run --rm xyz-bank-automation
```

Run with Docker Compose (Selenium Grid):
```bash
docker-compose up --abort-on-container-exit
```

## Generating Reports

### Allure Report

Generate and view Allure report:
```bash
mvn allure:report
mvn allure:serve
```

The report will open automatically in your default browser.

## CI/CD Pipeline

The project includes a GitHub Actions workflow that:
1. Runs on push to main/develop branches
2. Executes all tests
3. Generates Allure reports
4. Builds Docker image
5. Runs tests in Docker container
6. Publishes test results as artifacts

## Test Plan

Detailed test plan is available in `docs/TEST_PLAN.md` covering:
- Test objectives and scope
- Test scenarios and acceptance criteria
- Test data and resources
- Risk mitigation strategies
- Schedule and deliverables

## Page Object Model

The framework uses Page Object Model (POM) design pattern:
- **BasePage**: Common page operations
- **HomePage**: Login selection
- **ManagerPage**: Bank manager operations
- **CustomerLoginPage**: Customer login
- **AccountPage**: Customer account operations
- **TransactionsPage**: Transaction history

## Test Coverage

| Feature | Test Cases | Status |
|---------|-----------|--------|
| Manager - Add Customer | 3 | ✓ |
| Manager - Create Account | 1 | ✓ |
| Manager - Delete Account | 1 | ✓ |
| Customer - Login | 1 | ✓ |
| Customer - Deposit | 2 | ✓ |
| Customer - Withdraw | 2 | ✓ |
| Customer - Transactions | 2 | ✓ |

**Total**: 12 automated test cases

## Latest Update
- All tests verified and ready for CI/CD execution

## Contributing

1. Create a feature branch
2. Make your changes
3. Run tests locally
4. Submit a pull request

## Troubleshooting

**Issue**: WebDriver not found
- **Solution**: WebDriverManager automatically downloads drivers, ensure internet connection

**Issue**: Tests fail in headless mode
- **Solution**: Check Docker configuration and browser compatibility

**Issue**: Allure report not generating
- **Solution**: Ensure AspectJ weaver is properly configured in pom.xml

## License

This project is for educational purposes.

## Contact

For questions or issues, please open a GitHub issue.

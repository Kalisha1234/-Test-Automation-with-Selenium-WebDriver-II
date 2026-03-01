# XYZ Bank Test Automation

Selenium WebDriver test automation framework for XYZ Bank application using Java, JUnit 5, Maven, and Allure reporting.

## Application Under Test

**URL**: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login

## Tech Stack

- **Language**: Java 11
- **Build Tool**: Maven
- **Test Framework**: JUnit 5
- **Automation**: Selenium WebDriver 4.15.0
- **Reporting**: Allure Report 2.24.0
- **Design Pattern**: Page Object Model (POM)
- **CI/CD**: GitHub Actions
- **Containerization**: Docker

## Project Structure

```
xyz-bank-automation/
├── .github/workflows/
│   └── ci-cd.yml              # CI/CD pipeline
├── src/
│   ├── main/java/com/xyzbank/
│   │   ├── pages/             # Page Object classes
│   │   └── utils/             # WebDriver management
│   └── test/java/com/xyzbank/
│       ├── listeners/         # Test listeners (screenshots)
│       ├── testdata/          # Test data
│       └── tests/             # Test classes
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## Features

✅ Page Object Model (POM) design pattern
✅ Selenium best practices (explicit waits only)
✅ Automatic screenshot capture on test failures
✅ Allure reporting with detailed test steps
✅ Docker support for containerized execution
✅ CI/CD pipeline with GitHub Actions
✅ ThreadLocal WebDriver for parallel execution support

## Test Coverage

### Bank Manager Tests
- Add customer with valid/invalid data
- Create accounts for customers
- Delete customer accounts

### Customer Tests
- Customer login
- Deposit funds with balance verification
- Withdraw funds with balance verification
- Insufficient balance validation
- Transaction history viewing
- Transaction security

## Prerequisites

- Java 11+
- Maven 3.8+
- Docker (optional)

## Quick Start

### 1. Clone Repository
```bash
git clone https://github.com/Kalisha1234/-Test-Automation-with-Selenium-WebDriver-II.git
cd xyz-bank-automation
```

### 2. Run Tests
```bash
mvn clean test
```

### 3. Generate Allure Report
```bash
mvn allure:serve
```

## Running Tests

### All Tests
```bash
mvn clean test
```

### Specific Test Class
```bash
mvn test -Dtest=CustomerTests
mvn test -Dtest=ManagerTests
```

### Headless Mode (Default)
```bash
mvn test -Dheadless=true
```

### With Browser UI
```bash
mvn test -Dheadless=false
```

## Docker Execution

### Build and Run
```bash
docker build -t xyz-bank-automation .
docker run --rm xyz-bank-automation
```

### Using Docker Compose
```bash
docker-compose up --abort-on-container-exit
```

## Allure Reports

### Generate and View
```bash
mvn allure:report
mvn allure:serve
```

### Features in Reports
- Test execution summary
- Test steps with descriptions
- Screenshots for failed tests
- Test duration and history
- Categorized by Epic and Feature

## CI/CD Pipeline

Automated pipeline runs on push to `main` branch:
1. ✅ Build project
2. ✅ Run smoke tests
3. ✅ Run all tests
4. ✅ Generate Allure reports
5. ✅ Upload test artifacts
6. ✅ Build and test Docker image

## Key Improvements

### Selenium Best Practices
- ❌ Removed implicit waits (anti-pattern)
- ❌ Removed Thread.sleep() calls
- ✅ Using explicit waits only
- ✅ Proper exception handling
- ✅ ThreadLocal WebDriver management

### Test Reporting
- ✅ Automatic screenshot capture on failures
- ✅ Allure @Step annotations for detailed reporting
- ✅ Test categorization with @Epic and @Feature
- ✅ Severity levels for test prioritization

## Troubleshooting

**WebDriver Issues**
- WebDriverManager auto-downloads drivers
- Ensure internet connection on first run

**Headless Mode Failures**
- Check browser compatibility
- Verify Docker configuration

**Allure Report Not Generating**
- Ensure AspectJ weaver is configured in pom.xml
- Check allure-results directory exists

## License

Educational project for test automation learning.

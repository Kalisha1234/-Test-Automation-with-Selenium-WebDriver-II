# Quick Start Guide - XYZ Bank Test Automation

## Step 1: Verify Prerequisites

Check if you have the required tools installed:

```bash
# Check Java version (should be 11+)
java -version

# Check Maven version (should be 3.8+)
mvn -version

# Check Docker (optional)
docker --version
```

## Step 2: Navigate to Project Directory

```bash
cd "C:\Users\k map\Desktop\xyz-bank-automation"
```

## Step 3: Install Dependencies

```bash
mvn clean install -DskipTests
```

This will download all required dependencies including:
- Selenium WebDriver
- JUnit 5
- Allure Report
- WebDriverManager

## Step 4: Run Tests

### Option A: Run All Tests
```bash
mvn clean test
```

### Option B: Run Specific Test Class
```bash
# Run only Manager tests
mvn test -Dtest=ManagerTests

# Run only Customer tests
mvn test -Dtest=CustomerTests
```

### Option C: Run Single Test Method
```bash
mvn test -Dtest=ManagerTests#testAddCustomerWithValidData
```

## Step 5: Generate and View Report

After test execution, generate Allure report:

```bash
# Generate report
mvn allure:report

# Open report in browser
mvn allure:serve
```

The report will automatically open in your default browser showing:
- Test execution summary
- Pass/Fail statistics
- Detailed test steps
- Screenshots (if configured)
- Execution timeline

## Step 6: Run with Docker (Optional)

### Build Docker Image
```bash
docker build -t xyz-bank-automation .
```

### Run Tests in Container
```bash
docker run --rm xyz-bank-automation
```

### Run with Selenium Grid
```bash
docker-compose up --abort-on-container-exit
```

## Step 7: Setup GitHub Repository

1. Initialize Git repository:
```bash
git init
git add .
git commit -m "Initial commit: XYZ Bank test automation framework"
```

2. Create repository on GitHub

3. Push to GitHub:
```bash
git remote add origin <your-repo-url>
git branch -M main
git push -u origin main
```

4. GitHub Actions will automatically run on push

## Common Commands Reference

| Command | Description |
|---------|-------------|
| `mvn clean` | Clean target directory |
| `mvn compile` | Compile source code |
| `mvn test` | Run all tests |
| `mvn allure:report` | Generate Allure report |
| `mvn allure:serve` | Generate and open report |
| `mvn clean test allure:report` | Full test cycle with report |

## Troubleshooting

### Issue: "mvn: command not found"
**Solution**: Add Maven to system PATH or use full path to mvn executable

### Issue: "JAVA_HOME not set"
**Solution**: Set JAVA_HOME environment variable:
```bash
# Windows
set JAVA_HOME=C:\Program Files\Java\jdk-11
set PATH=%JAVA_HOME%\bin;%PATH%
```

### Issue: Edge driver not found
**Solution**: WebDriverManager handles this automatically. Ensure internet connection.

### Issue: Tests fail with timeout
**Solution**: Increase wait time in DriverManager.java or check internet connection

## Project Structure Overview

```
xyz-bank-automation/
├── src/main/java/com/xyzbank/
│   ├── pages/          # Page Object classes
│   └── utils/          # Utility classes
├── src/test/java/com/xyzbank/tests/
│   ├── BaseTest.java   # Base test setup
│   ├── ManagerTests.java
│   └── CustomerTests.java
├── docs/
│   ├── TEST_PLAN.md
│   └── MANUAL_TEST_CASES.md
├── .github/workflows/
│   └── ci-cd.yml       # CI/CD pipeline
├── pom.xml             # Maven configuration
└── README.md
```

## Next Steps

1. ✅ Review test plan: `docs/TEST_PLAN.md`
2. ✅ Perform manual testing: `docs/MANUAL_TEST_CASES.md`
3. ✅ Run automated tests: `mvn test`
4. ✅ Review test results: `mvn allure:serve`
5. ✅ Push to GitHub for CI/CD
6. ✅ Monitor GitHub Actions workflow

## Support

For issues or questions:
1. Check README.md for detailed documentation
2. Review test plan and manual test cases
3. Check GitHub Actions logs for CI/CD issues
4. Review Allure reports for test failures

---

**Happy Testing! 🚀**

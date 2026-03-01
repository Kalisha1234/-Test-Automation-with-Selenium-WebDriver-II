# 🚀 XYZ BANK AUTOMATION - CHROME VERSION

## ✅ CHANGES MADE

### Primary Change: Browser Configuration
**FROM:** Microsoft Edge (default)  
**TO:** Google Chrome (default)

### Files Modified:
1. **src/main/java/com/xyzbank/utils/DriverManager.java**
   - Line 19: Changed default browser from "edge" to "chrome"
   - Lines 21-30: Chrome options now configurable for headless mode
   
2. **docs/TEST_PLAN.md**
   - Section 4.1: Updated browser from "Microsoft Edge" to "Google Chrome"
   - Section 5.2: Updated test environment browser specification

3. **README.md**
   - Tech Stack section: Updated browser reference
   - Prerequisites section: Changed from "Microsoft Edge browser" to "Google Chrome browser"

---

## 🎯 QUICK START GUIDE

### Prerequisites
- ✅ Java 11 or higher
- ✅ Maven 3.8+
- ✅ Google Chrome browser
- ✅ Docker (optional)
- ✅ Git

### Step 1: Verify Installation
```bash
# Check Java
java -version
# Expected: java version "11" or higher

# Check Maven
mvn -version
# Expected: Apache Maven 3.8+

# Check Chrome
google-chrome --version
# OR on Windows: chrome.exe --version
```

### Step 2: Install Dependencies
```bash
cd xyz-bank-automation
mvn clean install -DskipTests
```

### Step 3: Run Tests

#### Option A: Run with Chrome (Default)
```bash
mvn clean test
```

#### Option B: Run with Chrome in Non-Headless Mode
```bash
mvn clean test -Dheadless=false
```

#### Option C: Run with Edge (Still Supported)
```bash
mvn clean test -Dbrowser=edge
```

### Step 4: View Allure Report
```bash
# Method 1: Auto-open in browser
mvn allure:serve

# Method 2: Generate static report
mvn allure:report
# Then open: target/site/allure-maven-plugin/index.html
```

---

## 🐳 DOCKER EXECUTION

### Build Docker Image
```bash
docker build -t xyz-bank-automation .
```

### Run Tests in Docker
```bash
docker run --rm xyz-bank-automation
```

### Use Docker Compose
```bash
docker-compose up --abort-on-container-exit
```

---

## 📊 TEST EXECUTION RESULTS

### Expected Output:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.xyzbank.tests.CustomerTests
[INFO] Running com.xyzbank.tests.ManagerTests
[INFO] Running com.xyzbank.tests.SmokeTest
[INFO] Tests run: 14, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

### Test Breakdown:
- **Manager Tests**: 5 test cases
- **Customer Tests**: 9 test cases
- **Smoke Tests**: 2 test cases (in SmokeTest.java)
- **Total**: 14 automated tests (Note: Some tests may be in base classes)

---

## 🔧 CONFIGURATION OPTIONS

### Browser Selection
```bash
# Chrome (default)
mvn clean test

# Edge
mvn clean test -Dbrowser=edge
```

### Headless Mode
```bash
# Headless (default for CI/CD)
mvn clean test

# With browser UI
mvn clean test -Dheadless=false
```

### Run Specific Tests
```bash
# Run only Manager tests
mvn test -Dtest=ManagerTests

# Run only Customer tests
mvn test -Dtest=CustomerTests

# Run smoke tests
mvn test -Dtest=SmokeTest
```

---

## 📁 PROJECT STRUCTURE

```
xyz-bank-automation/
├── src/
│   ├── main/java/com/xyzbank/
│   │   ├── pages/              # Page Object Model
│   │   │   ├── AccountPage.java
│   │   │   ├── BasePage.java
│   │   │   ├── CustomerLoginPage.java
│   │   │   ├── HomePage.java
│   │   │   ├── ManagerPage.java
│   │   │   └── TransactionsPage.java
│   │   └── utils/
│   │       └── DriverManager.java    # ✨ Chrome configured here
│   └── test/java/com/xyzbank/tests/
│       ├── BaseTest.java
│       ├── CustomerTests.java        # 9 customer tests
│       ├── ManagerTests.java         # 5 manager tests
│       └── SmokeTest.java
├── docs/
│   ├── TEST_PLAN.md            # ✨ Updated for Chrome
│   ├── MANUAL_TEST_CASES.md
│   ├── PROJECT_CHECKLIST.md
│   ├── ARCHITECTURE.md
│   └── QUICK_START.md
├── .github/workflows/
│   └── ci-cd.yml               # GitHub Actions pipeline
├── Dockerfile                   # Docker configuration
├── docker-compose.yml
├── pom.xml                      # Maven dependencies
└── README.md                    # ✨ Updated for Chrome
```

---

## 🧪 TEST COVERAGE

### Bank Manager Features (5 tests)
| Test ID | Description | Priority |
|---------|-------------|----------|
| BM-001 | Add customer with valid data | Critical |
| BM-002 | Add customer with invalid name | Critical |
| BM-003 | Add customer with invalid postal code | Critical |
| BM-004 | Create account for customer | Critical |
| BM-005 | Delete customer account | Normal |

### Customer Features (9 tests)
| Test ID | Description | Priority |
|---------|-------------|----------|
| CU-001 | Customer login | Critical |
| CU-002 | Deposit valid amount | Critical |
| CU-004 | Withdraw valid amount | Critical |
| CU-005 | Withdraw exceeding balance | Critical |
| CU-006 | View transaction history | Normal |
| CU-007 | Verify balance after deposit | Critical |
| CU-008 | Verify balance after withdrawal | Critical |
| CU-009 | Verify transaction security | Normal |

---

## 🔄 CI/CD PIPELINE

### GitHub Actions Workflow
The project includes a complete CI/CD pipeline that:

1. ✅ Triggers on push to main/develop
2. ✅ Triggers on pull requests
3. ✅ Sets up Java 11 and Maven
4. ✅ Runs all tests in Chrome headless mode
5. ✅ Generates Allure reports
6. ✅ Builds Docker image
7. ✅ Runs tests in Docker container
8. ✅ Uploads test artifacts (30-day retention)

### Setup GitHub Actions
```bash
# 1. Initialize Git
git init

# 2. Add all files
git add .

# 3. Commit
git commit -m "Initial commit: XYZ Bank Automation with Chrome"

# 4. Create GitHub repository
# Go to https://github.com/new

# 5. Push to GitHub
git remote add origin https://github.com/YOUR_USERNAME/xyz-bank-automation.git
git branch -M main
git push -u origin main

# 6. GitHub Actions will automatically run!
```

---

## 📈 ALLURE REPORT FEATURES

The Allure report provides:
- ✅ Test execution overview
- ✅ Pass/Fail statistics
- ✅ Test duration metrics
- ✅ Categorization by Epic/Feature
- ✅ Detailed test steps
- ✅ Browser and environment info
- ✅ Historical trends (after multiple runs)

### Accessing Allure Report
```bash
# Local
mvn allure:serve

# From artifacts (GitHub Actions)
# 1. Go to Actions tab in GitHub
# 2. Click on workflow run
# 3. Download "allure-report" artifact
# 4. Extract and open index.html
```

---

## ⚠️ TROUBLESHOOTING

### Issue: ChromeDriver not found
**Solution:** WebDriverManager automatically downloads ChromeDriver. Ensure you have internet connection on first run.

### Issue: Tests fail in headless mode
**Solution:** Some web elements may behave differently in headless mode. Try running with `-Dheadless=false` to debug.

### Issue: Chrome version mismatch
**Solution:** WebDriverManager will download the correct ChromeDriver version. If issues persist, update Chrome browser.

### Issue: Port already in use (Docker)
**Solution:** 
```bash
docker-compose down
docker-compose up --abort-on-container-exit
```

### Issue: Allure report not generating
**Solution:** Ensure AspectJ weaver is working:
```bash
mvn clean install
mvn clean test
mvn allure:report
```

---

## 🎓 LEARNING RESOURCES

### Framework Patterns Used
- **Page Object Model (POM)**: Separates page logic from test logic
- **ThreadLocal WebDriver**: Supports parallel execution
- **Explicit Waits**: Handles dynamic content
- **Allure Annotations**: Enhanced reporting

### Key Classes to Understand
1. **DriverManager**: Browser initialization and management
2. **BasePage**: Common page operations (clicks, waits, etc.)
3. **BaseTest**: Test setup/teardown
4. **Page Objects**: Represent each page of the application

---

## 📝 BROWSER FLEXIBILITY

### Current Configuration
```java
// In DriverManager.java
String browser = System.getProperty("browser", "chrome");
```

This means:
- **Default**: Chrome
- **Override**: Use `-Dbrowser=edge` for Edge

### Headless Configuration
```java
if (System.getProperty("headless", "true").equals("true")) {
    // Run headless
}
```

This means:
- **Default**: Headless mode ON (good for CI/CD)
- **Override**: Use `-Dheadless=false` to see browser

---

## ✅ VERIFICATION CHECKLIST

Before running tests, verify:
- [ ] Java 11+ installed
- [ ] Maven 3.8+ installed
- [ ] Chrome browser installed
- [ ] Project dependencies downloaded (`mvn clean install`)
- [ ] Can access https://www.globalsqa.com/angularJs-protractor/BankingProject/

After running tests, verify:
- [ ] All tests passed
- [ ] Allure report generated
- [ ] No errors in console
- [ ] Test artifacts created in `target/` directory

---

## 🚀 NEXT STEPS

1. **Run tests locally** to ensure everything works
2. **Review Allure reports** to understand test results
3. **Push to GitHub** to trigger CI/CD pipeline
4. **Monitor GitHub Actions** for automated test execution
5. **Download artifacts** to review test results from CI/CD

---

## 📞 SUPPORT

For issues or questions:
1. Check the `REQUIREMENTS_VERIFICATION.md` file for detailed information
2. Review `docs/TEST_PLAN.md` for test strategy
3. Check `docs/ARCHITECTURE.md` for framework design
4. Refer to `README.md` for general documentation

---

**Version**: 2.0 (Chrome Edition)  
**Last Updated**: February 23, 2026  
**Status**: ✅ Ready for Execution

**Happy Testing! 🎉**

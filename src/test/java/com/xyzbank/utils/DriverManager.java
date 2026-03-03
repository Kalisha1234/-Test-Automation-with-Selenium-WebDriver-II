package com.xyzbank.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String BASE_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = System.getProperty("browser", "chrome");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--remote-allow-origins=*");

                if (System.getProperty("headless", "false").equals("true")) {
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }
                driver.set(new ChromeDriver(options));

            }

            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        }
        return driver.get();
    }

    public static void navigateToApp() {
        getDriver().get(BASE_URL);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}



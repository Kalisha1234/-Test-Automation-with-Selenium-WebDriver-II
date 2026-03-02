package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TransactionsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By transactionTable = By.xpath("//table[@class='table table-bordered table-striped']");
    private By transactionRows = By.xpath("//table[@class='table table-bordered table-striped']//tr");
    private By backBtn = By.xpath("//button[text()='Back']");
    private By resetBtn = By.xpath("//button[text()='Reset']");

    public TransactionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Get transaction count")
    public int getTransactionCount() {
        List<WebElement> rows = driver.findElements(transactionRows);
        return rows.size() - 1;
    }

    @Step("Check if transactions are displayed")
    public boolean areTransactionsDisplayed() {
        return isDisplayed(transactionTable);
    }

}

package com.xyzbank.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionsPage {
    private BasePage basePage;
    private By transactionTable = By.xpath("//table[@class='table table-bordered table-striped']");
    private By transactionRows = By.xpath("//table[@class='table table-bordered table-striped']//tr");
    private By backBtn = By.xpath("//button[text()='Back']");
    private By resetBtn = By.xpath("//button[text()='Reset']");

    public TransactionsPage(WebDriver driver) {
        this.basePage = new BasePage(driver);
    }

    @Step("Get transaction count")
    public int getTransactionCount() {
        List<WebElement> rows = basePage.driver.findElements(transactionRows);
        return rows.size() - 1; // Exclude header row
    }

    @Step("Check if transactions are displayed")
    public boolean areTransactionsDisplayed() {
        return basePage.isDisplayed(transactionTable);
    }

    @Step("Click Back button")
    public void clickBack() {
        basePage.click(backBtn);
    }

    @Step("Check if Reset button exists")
    public boolean isResetButtonDisplayed() {
        return basePage.isDisplayed(resetBtn);
    }
}

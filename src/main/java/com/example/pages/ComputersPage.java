package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage {
    private WebDriver driver;

    private By desktopsLink = By.linkText("Desktops");
    private By sortByDropdown = By.id("products-orderby");

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDesktops() {
        driver.findElement(desktopsLink).click();
    }

    public void selectSortOption(String option) {
        driver.findElement(sortByDropdown).sendKeys(option);
    }
}
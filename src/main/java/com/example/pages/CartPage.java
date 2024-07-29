package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;
public class CartPage {
    private WebDriver driver;

    private WebDriverWait wait;
    private static final Logger log = Logger.getLogger(String.valueOf(CartPage.class));
    private By addToCartButton1 = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]");
    private By addToCartButton2 = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]");
    private By addToCartButton3 = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]");
    private By totalPriceElement = By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong");
    private By removeItemButton = By.xpath("//button[@class=\"remove-btn\"]");
    private By updatedTotalPriceElement = By.cssSelector(".cart-total-right .product-price");

    private By ramOption = By.xpath("//*[@id=\"product_attribute_2\"]");



    private By CartLbl = By.xpath("//span[@class='cart-label']");



    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addDesktopToCart() throws InterruptedException {
        log.info("Adding Desktop to cart");
        driver.findElement(addToCartButton1).click();
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(ramOption));
        driver.findElement(ramOption).click();
        dropdown.findElement(By.xpath("//option[. = '2 GB']")).click();
        driver.findElement(By.id("product_attribute_3_6")).click();
        driver.findElement(By.id("add-to-cart-button-1")).click();
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton2));
        driver.findElement(addToCartButton2).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton3));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton3));
        driver.findElement(addToCartButton3).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton3));
        Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(CartLbl));
        driver.findElement(CartLbl).click();


    }

    public String getTotalPrice() {
        log.info("Getting total price");
        driver.findElement(CartLbl).click();
        return driver.findElement(totalPriceElement).getText();
    }

    public void removeItemFromCart() {
        log.info("Removing item from cart");
        driver.findElement(removeItemButton).click();
    }

    public String getUpdatedTotalPrice() {
        log.info("Getting updated total price");
        return driver.findElement(updatedTotalPriceElement).getText();
    }
}

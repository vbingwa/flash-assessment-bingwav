package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.logging.Logger;


public class CheckoutPage {
    private WebDriver driver;

    private WebDriverWait wait;
    private By checkoutButton = By.id("checkout");
    private By city = By.id("BillingNewAddress_City");
    private By address1 = By.id("BillingNewAddress_Address1");
    private By zipcode = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private By paymentNextStepButton = By.id("payment-method-next-step");
    private By confirmOrderButton = By.id("input[type='submit']");

    private By acceptTermsOfService = By.id("termsofservice");

    private By saveButton = By.name("save");
    private By shippingMethodNextStepButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private By paymentMethodNextStepButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private By paymentInfoNextStepButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private By confirmOrderNextStepButton = By.cssSelector(".confirm-order-next-step-button");
    private By orderSummaryTitle = By.cssSelector(".section > .title > strong");
    private By orderCompletedContinueButton = By.cssSelector(".order-completed-continue-button");

    private By countryId = By.id("BillingNewAddress_CountryId");

    private By provinceId = By.id("BillingNewAddress_StateProvinceId");

    private By state = By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]/option[2]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void checkout() {

        driver.findElement(acceptTermsOfService).click();
        driver.findElement(checkoutButton).click();
    }

    public void acceptTerms() {

    driver.findElement(acceptTermsOfService).click();
    }

    public void fillCheckoutForm(String cityData, String addressLine1,String zipData, String phoneno) {
        wait.until(ExpectedConditions.elementToBeClickable(countryId));
        driver.findElement(countryId).click();
        WebElement dropdown = driver.findElement(countryId);
        dropdown.findElement(By.xpath("//option[. = 'United States']")).click();
        driver.findElement(city).sendKeys(cityData);
        driver.findElement(address1).sendKeys(addressLine1);
        driver.findElement(zipcode).sendKeys(zipData);
        driver.findElement(phoneNumber).sendKeys(phoneno);
        driver.findElement(provinceId).click();
        WebElement dropdownProvince = driver.findElement(provinceId);
        wait.until(ExpectedConditions.elementToBeClickable(provinceId));
        Select provinceSelect = new Select(dropdownProvince);
        provinceSelect.selectByIndex(1);
        driver.findElement(saveButton).click();


    }

    public void completeTransaction() {

        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodNextStepButton));
        driver.findElement(shippingMethodNextStepButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodNextStepButton));
        driver.findElement(paymentMethodNextStepButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoNextStepButton));
        driver.findElement(paymentInfoNextStepButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderNextStepButton));
        driver.findElement(confirmOrderNextStepButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(orderSummaryTitle));
        System.out.println(driver.findElement(orderSummaryTitle).getText());
        driver.findElement(orderCompletedContinueButton).click();
    }
}


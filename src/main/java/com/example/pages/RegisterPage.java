package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By logout = By.cssSelector(".ico-logout");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }



    public void registerUser(String fName, String lName, String emailadd, String pass) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
       driver.findElement(email).sendKeys(emailadd);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(registerButton).click();

    }

    public void logout()
    {
        driver.findElement(logout).click();
    }
}

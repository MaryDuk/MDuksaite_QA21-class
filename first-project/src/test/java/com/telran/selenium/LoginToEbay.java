package com.telran.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginToEbay extends TestBase{

    @Test

    public void logInTest () throws InterruptedException {
        driver.get("https://ebay.com");

        click(By.id("gh-ug"));

        click(By.id("userid"));
        driver.findElement(By.id("userid")).clear();
        driver.findElement(By.id("userid")).sendKeys("asdfghh");

        click(By.id("pass"));
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("12345");
        click(By.id("sgnBt"));
        Thread.sleep(5000);

    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

}

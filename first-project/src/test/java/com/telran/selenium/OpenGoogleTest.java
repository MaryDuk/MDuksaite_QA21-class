package com.telran.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenGoogleTest extends TestBase{
    @Test
    public void searchJavaTest () throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("java" + Keys.ENTER);
        //driver.navigate().to();
        Thread.sleep(5000);
    }
    @Test
    public void clickImFeelingLuckyButton (){
       //new Actions(driver).moveToElement(driver.findElement(By.name("btnI"))).pause(2).click().perform();
    }

}

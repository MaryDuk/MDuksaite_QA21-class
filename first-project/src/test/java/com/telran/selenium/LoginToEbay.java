package com.telran.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginToEbay extends TestBase{

    @Test

    public void logInTest () throws InterruptedException {
        // open web
        openSite("https://ebay.com");
        // init login
        initLogin();

        //fill Login form
        fillLoginForm("asdfghh@gmsdgkj.com", "12345");


        clickLoginButton(); // click Login button
        Thread.sleep(2000);

    }

}

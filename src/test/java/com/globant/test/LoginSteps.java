package com.globant.test;

import com.globant.pages.InventoryPage;
import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginSteps {
    private WebDriver driver;
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL + LoginPage.LOGIN_URL);
        loginPage = new LoginPage(driver);
    }

    @Parameters({"username", "password"})
    @Test
    public void successfulLoginTest(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        InventoryPage inventory = loginPage.clickLoginButton();
        Assert.assertTrue(inventory.getInventoryTitle().contains("Products"));
    }

    @Parameters({"username", "password"})
    @Test
    public void failedLoginTest(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

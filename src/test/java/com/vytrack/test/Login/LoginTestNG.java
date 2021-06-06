package com.vytrack.test.Login;

import com.vytrack.utility.Driver;
import com.vytrack.utility.Functionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.vytrack.utility.Constants.*;

public class LoginTestNG {

    WebDriver driver;

    @BeforeMethod
    public void  setup(){
        driver = Driver.getDriver();
        driver.get(qa3Env);
    }

    @Test(priority = 1)
    public void checkLogin(){
        Functionalities.login(driver, validTDuserName, validPassword);
        Assert.assertEquals(driver.getTitle(), dashbord);
    }

    @Test (priority = 2)
    public void checkLoginInvalidCredentials(){

        Functionalities.login(driver, invaliduserName, validPassword);
        WebElement error = Functionalities.ErrorMessage(driver);
        Assert.assertTrue(error.isDisplayed());
    }


    @AfterMethod
    public void tearDown()  {
        driver.close();
    }
}

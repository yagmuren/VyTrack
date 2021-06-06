package com.vytrack.test.Fleet_Vehicles;

import com.vytrack.utility.Driver;
import com.vytrack.utility.Functionalities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.vytrack.utility.Constants.*;
import static com.vytrack.utility.LoginLocators.*;

public class VehicleFunctionalityTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(qa3Env);
        Functionalities.login(driver, validTDuserName,validPassword);
    }

    @Test
    public void AC01VehicleInfoTest() {
        Functionalities.navigateToVehicles(driver);
        Assert.assertTrue(Functionalities.checkVehiclesDisplayed(driver));
    }



    @AfterMethod
    public void teardown(){
        driver.close();
    }
}

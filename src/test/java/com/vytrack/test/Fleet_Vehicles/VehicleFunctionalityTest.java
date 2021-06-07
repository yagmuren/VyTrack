package com.vytrack.test.Fleet_Vehicles;

import com.vytrack.utility.Driver;
import com.vytrack.utility.Functionalities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.vytrack.utility.Constants.*;

public class VehicleFunctionalityTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(qa3Env);
        Functionalities.login(driver, validTDuserName,validPassword);
        Functionalities.navigateToVehicles(driver);
    }

    @Test
    public void AC01VehicleInfoTest() {
        Assert.assertTrue(Functionalities.checkVehiclesDisplayed(driver));
    }

    @Test
    public void AC02GeneralInfo(){
        Assert.assertTrue(Functionalities.checkGeneralInfo(driver));
    }

    @Test
    public void AC03AddEvent(){
        Assert.assertTrue(Functionalities.verifyAddEvent(driver));
    }


    @AfterMethod
    public void teardown(){
        driver.close();
    }
}

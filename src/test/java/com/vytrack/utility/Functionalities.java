package com.vytrack.utility;

import org.openqa.selenium.*;

import java.util.List;

import static com.vytrack.utility.Constants.*;
import static com.vytrack.utility.Locators.*;


public class Functionalities {

    public static void login(WebDriver driver , String username, String password){
        WebElement userName = driver.findElement(By.xpath(usernameElement));
        userName.sendKeys(username);
        WebElement passwordElements = driver.findElement(By.xpath(passwordElement));
        passwordElements.sendKeys(password + Keys.ENTER);
    }

    public static WebElement ErrorMessage(WebDriver driver){
        return driver.findElement(By.xpath(errorElement));
    }

    public static void navigateToVehicles(WebDriver driver){
        WebElement fleetTab = driver.findElement(By.xpath(fleetNavigator));
        fleetTab.click();
        WebElement vehiclePage = driver.findElement(By.xpath(vehiclepageNavigator));
        vehiclePage.click();
    }

    public static boolean checkVehiclesDisplayed(WebDriver driver){
        List<WebElement> vehicleRowElement = driver.findElements(By.xpath(vehicleRow));
        boolean isDisplayed = false;
        for (WebElement element : vehicleRowElement) {
            if (element.isDisplayed()){
                isDisplayed = true;
                break;
            }
        }
        return isDisplayed;
    }

    public static boolean checkGeneralInfo(WebDriver driver){
        boolean isGeneralInfoVisible = true;
        int countEmpty = 0;
        WebElement clickToVehicle = driver.findElement(By.xpath(getVehicleRowSelect));
        clickToVehicle.click();
        List<WebElement> vehicleInfo = driver.findElements(By.xpath(VehicleInfo));
        for (WebElement element : vehicleInfo) {
            if (element.getText().isEmpty()){
                countEmpty++;
            }
            if (countEmpty > 1){
                isGeneralInfoVisible = false;
            }
        }

        return isGeneralInfoVisible;
    }

    public static boolean verifyAddEvent(WebDriver driver){
        WebElement vehicle = driver.findElement(By.xpath(getVehicleRowSelect));
        vehicle.click();
        WebElement addEventElement = driver.findElement(By.xpath(addEvent));
        addEventElement.click();
        WebElement titleElement = driver.findElement(By.xpath(title));
        titleElement.sendKeys(addEventTitle +Keys.ENTER);
        WebElement activity = driver.findElement(By.xpath(activityTab));
        activity.click();
        WebElement eventElement = driver.findElement(By.xpath(event));
        return eventElement.getText().equals(addEventTitle);
    }

}

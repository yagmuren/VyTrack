package com.vytrack.utility;

import org.openqa.selenium.*;

import java.sql.Driver;
import java.util.List;

import static com.vytrack.utility.LoginLocators.*;


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
        WebElement fleetTab = driver.findElement(By.xpath(fleetNaviagtor));
        fleetTab.click();
        WebElement vehiclePage = driver.findElement(By.xpath(vehiclepageNavigator));
        vehiclePage.click();
    }

    public static boolean checkVehiclesDisplayed(WebDriver driver){
        List<WebElement> vehicleRowElement = driver.findElements(By.xpath(vehicleRow));
        boolean isDisplayed = false;
        for (WebElement element : vehicleRowElement) {
            if (element.isDisplayed()){
                System.out.println(element.getText());
                isDisplayed = true;
                break;
            }
        }
        return isDisplayed;
    }

}

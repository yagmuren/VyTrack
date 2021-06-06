package com.vytrack.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

        public static WebDriver driver;

        public static WebDriver getDriver(){

            String browser = ConfigurationReader.getProperty("browser");

                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
                        break;
                    default:
                        throw new RuntimeException();
                }

            return driver;
        }






}

package com.vytrack.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {


    public static Properties properties;

    static {

        try{

            properties = new Properties();
            properties.load(new FileInputStream("Configuration.properties"));

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);


    }

}

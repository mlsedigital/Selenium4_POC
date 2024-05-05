package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public Properties init_prop() {

        prop = new Properties();
        try {
            String configFile = "src/test/resources/config/config.properties";
            FileInputStream ip = new FileInputStream(configFile);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Mechanism to read the properties from the command line
        System.getProperties().forEach((key, value) -> {
            prop.setProperty(key.toString(), value.toString());
        });

        return prop;

    }

}

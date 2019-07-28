package com.wwhale.tariff.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public Properties getProperties() {

        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

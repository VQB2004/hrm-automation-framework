package com.quocbao.tests.helpers;

import com.quocbao.tests.utils.LogUtils;

import java.io.*;
import java.util.Properties;

public class PropertiesHelper {
    private static final String CONFIGS_STRING =
            "src/test/resources/configs/config.properties";
    private static Properties PROPERTIES = loadFile();

    private static Properties loadFile() {
        Properties properties = new Properties();
        String path = SystemHelper.getCurrentDir() + CONFIGS_STRING;
        try (FileInputStream fis = new FileInputStream(path)){
            properties.load(fis);
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
        }
        return properties;
    }

    public static String getValue(String key) {
        return PROPERTIES.getProperty(key);
    }


}

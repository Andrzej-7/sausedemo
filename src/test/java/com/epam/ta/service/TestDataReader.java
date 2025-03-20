package com.epam.ta.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle;

    static {
        String env = System.getProperty("environment", "qa");
        try {
            resourceBundle = ResourceBundle.getBundle(env);
            System.out.println(env + ".properties loaded successfully!");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + env + ".properties!", e);
        }
    }

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}

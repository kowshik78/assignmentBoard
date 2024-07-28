package utils;

import tests.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    public Properties config = new Properties();
    private final String propertyFilePath = BaseTest.resourcesRoot+"config.properties";// Set Path of config.properties
    File file;

    public ConfigProperties() throws IOException {

        file = new File(propertyFilePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        config.load(fileInputStream);
    }
}

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //1:53
    public static String read(String key)  {
        return read(key, Constants.CONFIGURATION_FILEPATH);
    }

    public static String read(String key, String path)  {

        Properties  properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path))
        {
            properties.load(fis);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

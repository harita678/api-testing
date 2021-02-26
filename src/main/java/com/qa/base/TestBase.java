package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop;
    int responseCode200 = 200;
    int responseCode400 = 400;
    int responseCode404 = 404;

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream io = new FileInputStream("C:/Users/Harita/Desktop/Idea_work_space/restapi/src/main/resources/config.properties");
        prop.load(io);
        System.out.println(prop.getProperty("URL"));
    }
}


package com.qa.test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetApiTest extends TestBase {
    String url;
    String serviceUrl;
    String uri;
    RestClient restClient;

    public GetApiTest() throws IOException {
    }

    @BeforeMethod
    public void setUp() throws IOException {
        TestBase testBase = new TestBase();

        url = prop.getProperty("URL");
        serviceUrl = prop.getProperty("serviceURL");
        uri = url + serviceUrl;
    }
    @Test
    public  void testGet() throws IOException {
        restClient = new RestClient();
        restClient.get(uri);
    }
}

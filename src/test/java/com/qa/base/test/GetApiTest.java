
package com.qa.base.test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;



public class GetApiTest extends TestBase {
    String url;
    String serviceUrl;
    String uri;
    RestClient restClient;
    int statusCode;
    CloseableHttpResponse closebaleHttpResponse;

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
        statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
        String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(),"UTF-8");
        JSONObject jsonResponse = new JSONObject(responseString);

        //total:
        String totalValue = TestUtil.getValueByJPath(jsonResponse, "/total");
        System.out.println("value of total is-->"+ totalValue);
        Assert.assertEquals(Integer.parseInt(totalValue), 12);

        //get the value from JSON ARRAY:
        String lastName = TestUtil.getValueByJPath(jsonResponse, "/data[0]/last_name");
        String id = TestUtil.getValueByJPath(jsonResponse, "/data[0]/id");
        String avatar = TestUtil.getValueByJPath(jsonResponse, "/data[0]/avatar");
        String firstName = TestUtil.getValueByJPath(jsonResponse, "/data[0]/first_name");
    }
}

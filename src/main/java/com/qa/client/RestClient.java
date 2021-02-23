package com.qa.client;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {


    // create GET Method, which will call the URL and get the response in the form of JSON object
    public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

        /*Call HTTPClients class from HTTPClient library added in POM.xml.
Call createDefault() method present in HTTPClients class, which will create a client connection.
And this createDefault() method returns "CloseableHttpClient" object which is an abstract class.
And we are creating a reference to that abstract class */
        CloseableHttpClient httpClient = HttpClients.createDefault();


  /*create an object for HttpGet class, which is used for HTTP GET Request. And pass the URL which is to be loaded*/
        HttpGet httpget = new HttpGet(url); //http get request

       /* for(Map.Entry<String,String> entry : headerMap.entrySet()){
            httpget.addHeader(entry.getKey(), entry.getValue());
        }*/

        /*execute the HTTP GET Request, means it will hit the GET API call as we click SEND button from POSTMAN client.
httpClient.execute() method returns the response "CloseableHttpResponse" interface and store it in reference variable
So the complete response is stored in CloseableHttpResponse
And fetch all the details, in our test case/test method */
        CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
        return closebaleHttpResponse;

    }



}

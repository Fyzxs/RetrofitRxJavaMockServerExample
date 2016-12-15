package com.example.quinngil.myapplication;

import com.example.quinngil.myapplication.simple.network.NetworkCall;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.mockito.ArgumentMatchers.anyString;

public class MainActivityIntegrationTest {

    @Rule
    public final MockWebServer server = new MockWebServer();


    @Test
    public void Creation(){
        server.enqueue(new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody("{\"FirstName\":\"MORE_DOOOM\"}"));

        new NetworkCall(server.url("/"));

        MainActivity mainActivity = new FakeMainActivity();
        mainActivity.postOnResume();

        Mockito.verify(mainActivity.getSimpleView()).setText(anyString());
    }

}

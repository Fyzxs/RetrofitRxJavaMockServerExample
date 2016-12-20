package com.example.fyzxs.myapplication.main;

import com.example.fyzxs.myapplication.log.FyzLog;
import com.example.fyzxs.myapplication.network.NetworkCall;

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
        //Arrange
        server.enqueue(new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody("{\"FirstName\":\"MORE_DOOOM\"}"));

        FyzLog.logToSystem();

        new NetworkCall(server.url("/"));

        final MainActivity mainActivity = new FakeMainActivity();

        //Act
        mainActivity.postOnResume();

        //Assert
        Mockito.verify(mainActivity.getSimpleView()).setText(anyString());
        //Additional UI setting validation here
    }

}

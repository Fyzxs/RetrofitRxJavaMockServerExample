package com.example.fyzxs.myapplication;

import com.example.fyzxs.myapplication.simple.SimpleApi;
import com.example.fyzxs.myapplication.simple.SimpleApiErrorResponse;
import com.example.fyzxs.myapplication.simple.SimpleApiErrorResponseJsonAdapter;
import com.example.fyzxs.myapplication.simple.SimpleApiResponse;
import com.example.fyzxs.myapplication.simple.SimpleApiResponseJsonAdapter;
import com.example.fyzxs.myapplication.network.RetrofitException;
import com.example.fyzxs.myapplication.network.RxErrorHandlingCallAdapterFactory;
import com.squareup.moshi.Moshi;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleApiMockingTest {
    @Rule
    public final MockWebServer server = new MockWebServer();
    private Retrofit retrofit;

    @Before
    public void setUp() throws Exception {
        //needs to set up SimpleApiNetwork instead of doing this here
        retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add(new SimpleApiResponseJsonAdapter())
                        .add(new SimpleApiErrorResponseJsonAdapter()).build()))
                .build();

    }

    @Test
    public void successResponse(){
        final NetworkBehavior networkBehavior = NetworkBehavior.create();
        final MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(networkBehavior)
                .build();
        final BehaviorDelegate<SimpleApi> delegate =  mockRetrofit.create(SimpleApi.class);
        final SimpleApi mockSimpleApi = new MockSimpleApi(delegate);
        final TestSubscriber<SimpleApiResponse> testSubscriber = new TestSubscriber<>();

        //Act
        final Observable<SimpleApiResponse> response = mockSimpleApi.getSimpleResponse();
        response.subscribe(testSubscriber);


        //Assert
        testSubscriber.assertValueCount(1);
        testSubscriber.assertCompleted();
    }

    @Test
    public void errorResponse() throws IOException {
        server.enqueue(new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
                .setBody("{\"ErrorCode\":404,\"ErrorMessage\":\"DOOOM\"}"));

        final SimpleApi service = retrofit.create(SimpleApi.class);
        final TestSubscriber<SimpleApiResponse> testSubscriber = new TestSubscriber<>();

        //Act
        final Observable<SimpleApiResponse> response = service.getSimpleResponse();
        response.subscribe(testSubscriber);

        //Assert
        final RetrofitException.RetrofitHttpException httpException = ((RetrofitException.RetrofitHttpException)testSubscriber.getOnErrorEvents().get(0));
        final SimpleApiErrorResponse simpleApiErrorResponse = httpException.bodyAs(SimpleApiErrorResponse.class);
        final StringBuilder sb = new StringBuilder();
        testSubscriber.assertValueCount(0);
        testSubscriber.assertError(RetrofitException.class);
        assertThat(httpException.code()).isEqualTo(HttpURLConnection.HTTP_NOT_FOUND);
        assertThat(simpleApiErrorResponse.writeFriendlyMessage(sb).toString()).isEqualTo("<string name=\"simple_api_error_friendly_message_code_404/>");
        sb.setLength(0);
        assertThat(simpleApiErrorResponse.writeResponseMessage(sb).toString()).isEqualTo("DOOOM");
        assertThat(simpleApiErrorResponse.formatFriendlyMessage("%s")).isEqualTo("<string name=\"simple_api_error_friendly_message_code_404/>");
    }
}

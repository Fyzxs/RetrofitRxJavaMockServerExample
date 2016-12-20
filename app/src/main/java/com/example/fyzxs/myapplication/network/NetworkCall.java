package com.example.fyzxs.myapplication.network;

import com.example.fyzxs.myapplication.simple.SimpleApi;
import com.example.fyzxs.myapplication.simple.SimpleApiErrorResponseJsonAdapter;
import com.example.fyzxs.myapplication.simple.SimpleApiResponseJsonAdapter;
import com.squareup.moshi.Moshi;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkCall {

    //This is a boundary layer, this is allowing us to fake
    private static HttpUrl serverUrl;

    private static final Converter.Factory moshiFactory = MoshiConverterFactory.create(new Moshi.Builder().add(new SimpleApiResponseJsonAdapter())
            .add(new SimpleApiErrorResponseJsonAdapter()).build());

    public NetworkCall(String serverUrl){
        this(HttpUrl.parse(serverUrl));
    }
    public NetworkCall(HttpUrl serverUrl){
        NetworkCall.serverUrl = serverUrl;
    }
    public static SimpleApi create(){
        return new Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(new OkHttpClient().newBuilder().addInterceptor(new LoggingInterceptor()).build())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(moshiFactory)
                .build().create(SimpleApi.class);
    }
}

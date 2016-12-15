package com.example.quinngil.myapplication.simple.network;

import com.example.quinngil.myapplication.simple.SimpleApi;
import com.example.quinngil.myapplication.simple.SimpleApiErrorResponseJsonAdapter;
import com.example.quinngil.myapplication.simple.SimpleApiResponseJsonAdapter;
import com.squareup.moshi.Moshi;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkCall {

    //This is a boundary layer, this is allowing us to fake
    private static HttpUrl serverUrl;

    public NetworkCall(HttpUrl serverUrl){
        NetworkCall.serverUrl = serverUrl;
    }
    public static SimpleApi create(){
        return new Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add(new SimpleApiResponseJsonAdapter())
                        .add(new SimpleApiErrorResponseJsonAdapter()).build()))
                .build().create(SimpleApi.class);
    }
}
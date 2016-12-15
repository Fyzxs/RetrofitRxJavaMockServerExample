package com.example.quinngil.myapplication.simple;

import retrofit2.http.GET;
import rx.Observable;

public interface SimpleApi {
    @GET("/qod.json")
    Observable<SimpleApiResponse> getSimpleResponse();
}

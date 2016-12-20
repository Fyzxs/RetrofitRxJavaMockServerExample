package com.example.fyzxs.myapplication.simple;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

//Should be moved package - limited by earlier tests
public class SimpleApiResponseJsonAdapter {
    @FromJson
    /* package */ SimpleApiResponse simpleApiResponseFromJson(SimpleApiResponseJson simpleApiResponseJson) {
        return new SimpleApiResponse(simpleApiResponseJson.FirstName);
    }

    @ToJson
    /* package */ SimpleApiResponseJson simpleApiResponseToJson(SimpleApi ignored) { return null; }
}

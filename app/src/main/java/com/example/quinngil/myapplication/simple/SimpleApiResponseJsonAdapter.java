package com.example.quinngil.myapplication.simple;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

public class SimpleApiResponseJsonAdapter {
    @FromJson
    SimpleApiResponse simpleApiResponseFromJson(SimpleApiResponseJson simpleApiResponseJson) {
        return new SimpleApiResponse(simpleApiResponseJson.FirstName);
    }

    @ToJson
    SimpleApiResponseJson simpleApiResponseToJson(SimpleApi ignored) { return null; }
}

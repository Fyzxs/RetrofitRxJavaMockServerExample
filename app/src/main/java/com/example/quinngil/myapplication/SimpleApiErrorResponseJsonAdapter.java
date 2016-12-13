package com.example.quinngil.myapplication;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

public class SimpleApiErrorResponseJsonAdapter {
    @FromJson
    SimpleApiErrorResponse simpleApiResponseFromJson(SimpleApiErrorResponseJson simpleApiErrorResponseJson) {
        return new SimpleApiErrorResponse(simpleApiErrorResponseJson.ErrorCode, simpleApiErrorResponseJson.ErrorMessage);
    }

    @ToJson
    SimpleApiResponseJson simpleApiResponseToJson(SimpleApi ignored) { return null; }
}

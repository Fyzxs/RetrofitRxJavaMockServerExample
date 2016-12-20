package com.example.fyzxs.myapplication.simple;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

//Should be moved package - limited by earlier tests
public class SimpleApiErrorResponseJsonAdapter {
    @FromJson
    /* package */ SimpleApiErrorResponse simpleApiResponseFromJson(SimpleApiErrorResponseJson simpleApiErrorResponseJson) {
        return new SimpleApiErrorResponse(simpleApiErrorResponseJson.ErrorCode, simpleApiErrorResponseJson.ErrorMessage);
    }

    @ToJson
    /* package */ SimpleApiResponseJson simpleApiResponseToJson(SimpleApi ignored) { return null; }
}

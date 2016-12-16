package com.example.quinngil.myapplication.simple;

import com.example.quinngil.myapplication.simple.network.NetworkCall;

import rx.Observable;

//Understands ???
public class SimpleApiAccess {

    public Observable<SimpleApiResponse> latestSimpleApiResponse(){
        return NetworkCall.create().getSimpleResponse();
    }
}

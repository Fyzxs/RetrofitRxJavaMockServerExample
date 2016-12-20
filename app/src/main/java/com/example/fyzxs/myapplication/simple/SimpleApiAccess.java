package com.example.fyzxs.myapplication.simple;

import com.example.fyzxs.myapplication.network.NetworkCall;

import rx.Observable;

//Understands ???
public class SimpleApiAccess {

    public Observable<SimpleApiResponse> latestSimpleApiResponse(){
        return SimpleApiNetwork.create().getSimpleResponse();
    }
}

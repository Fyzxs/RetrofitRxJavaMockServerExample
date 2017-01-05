package com.example.fyzxs.myapplication.main;

import com.example.fyzxs.myapplication.simple.SimpleApiAccess;

//Understands where the data for view lives
/* package */ class MainMediator {

    private final MainBridge mainBridge;

    /* package */ MainMediator(MainBridge mainBridge) {
        this.mainBridge = mainBridge;
    }

    /* package */ void retrieve() {
        retrieveSimpleApiResponse();
    }

    private void retrieveSimpleApiResponse() {
        new SimpleApiAccess().latestSimpleApiResponse().subscribe(mainBridge::renderSimpleApiResponse);
    }
}

package com.example.quinngil.myapplication;

import com.example.quinngil.myapplication.simple.SimpleApiAccess;

//Understands where the data for view lives
/* package */ class MainModel {

    private final MainViewModel mainViewModel;

    /* package */ MainModel(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    /* package */ void retrieve() {
        retrieveSimpleApiResponse();
    }

    private void retrieveSimpleApiResponse() {
        new SimpleApiAccess().latestSimpleApiResponse().subscribe(mainViewModel::renderSimpleApiResponse);
    }
}

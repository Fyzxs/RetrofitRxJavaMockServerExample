package com.example.quinngil.myapplication;

import com.example.quinngil.myapplication.simple.network.NetworkCall;

public class MainViewModel {

    private MainActivity mainActivity;
    private MainModel mainModel;

    /* package */ MainViewModel(MainActivity mainActivity){
        this(mainActivity, new MainModel());
    }
    /* package */ MainViewModel(MainActivity mainActivity, MainModel mainModel){
        this.mainActivity = mainActivity;
        this.mainModel = mainModel;
    }


    public void prepare() {
        NetworkCall.create().getSimpleResponse().subscribe(simpleApiResponse -> {
            mainActivity.getSimpleView().setText(simpleApiResponse.welcomeMessage());
        });
    }
}

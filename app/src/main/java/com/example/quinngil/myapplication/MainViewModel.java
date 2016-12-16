package com.example.quinngil.myapplication;

import com.example.quinngil.myapplication.simple.SimpleApiResponse;

//Understands how to render view data
/* package */ class MainViewModel {

    private MainActivity mainActivity;
    private MainModel mainModel;

    /* package */ MainViewModel(MainActivity mainActivity){
        this(mainActivity, null);
    }
    /* package */ MainViewModel(MainActivity mainActivity, MainModel mainModel){
        this.mainActivity = mainActivity;
        this.mainModel = mainModel != null ? mainModel : new MainModel(this);
    }


    /* package */ void render() {
        mainModel.retrieve();
    }

    /* package */ void renderSimpleApiResponse(SimpleApiResponse simpleApiResponse) {
        simpleApiResponse.writeWelcomeMessage(mainActivity.getSimpleView());
    }
}

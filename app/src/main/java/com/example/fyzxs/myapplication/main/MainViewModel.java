package com.example.fyzxs.myapplication.main;

import com.example.fyzxs.myapplication.log.FyzLog;
import com.example.fyzxs.myapplication.simple.SimpleApiResponse;

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
        FyzLog.v("rendering SimpleApiResponse");//This is to blow up android.util.log
        simpleApiResponse.writeWelcomeMessage(mainActivity.getSimpleView());
    }
}

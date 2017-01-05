package com.example.fyzxs.myapplication.main;

import com.example.fyzxs.myapplication.log.FyzLog;
import com.example.fyzxs.myapplication.simple.SimpleApiResponse;

//Understands how to render view data
/* package */ class MainBridge {

    private MainActivity mainActivity;
    private MainMediator mainMediator;

    /* package */ MainBridge(MainActivity mainActivity){
        this(mainActivity, null);
    }
    /* package */ MainBridge(MainActivity mainActivity, MainMediator mainMediator){
        this.mainActivity = mainActivity;
        this.mainMediator = mainMediator != null ? mainMediator : new MainMediator(this);
    }


    /* package */ void render() {
        mainMediator.retrieve();
    }

    /* package */ void renderSimpleApiResponse(SimpleApiResponse simpleApiResponse) {
        FyzLog.v("rendering SimpleApiResponse");//This is to blow up android.util.log
        simpleApiResponse.writeWelcomeMessage(mainActivity.getSimpleView());
        //Alternate method of writing data
        final StringBuilder sb = new StringBuilder();
        simpleApiResponse.writeWelcomeMessageTo(sb);
        mainActivity.updateSimpleView(sb.toString());

    }
}
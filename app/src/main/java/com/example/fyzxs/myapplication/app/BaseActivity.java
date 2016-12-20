package com.example.fyzxs.myapplication.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fyzxs.myapplication.log.FyzLog;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FyzLog.v("super.onCreate done");

        postOnCreate(savedInstanceState);
        FyzLog.v("postOnCreate done");

        bindViews();
        FyzLog.v("bindViews done");
    }

    /**
     *  This is where all your findViewById should go
     */
    protected abstract void bindViews();

    /**
     * This is any post onCreate stuff
     */
    protected abstract void postOnCreate(Bundle savedInstanceState);

    @Override
    protected void onResume(){
        super.onResume();
        FyzLog.v("super.onResume done");

        postOnResume();
        FyzLog.v("postOnResume done");
    }

    /**
     * Calls at the end of onResume
     */
    protected void postOnResume() {}
}

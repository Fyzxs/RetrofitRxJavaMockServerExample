package com.example.quinngil.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();

        postOnCreate(savedInstanceState);
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
        postOnResume();
    }

    /**
     * Calls at the end of onResume
     */
    protected void postOnResume() {}
}

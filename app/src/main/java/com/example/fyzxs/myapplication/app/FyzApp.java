package com.example.fyzxs.myapplication.app;

import android.app.Application;

public class FyzApp extends Application {

    private static FyzApp instance;

    /**
     * It's how we get a globally available context without the Context param chain
     * @return
     */
    public static FyzApp applicationInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}

package com.example.fyzxs.myapplication.app;

import android.app.Application;

public class App extends Application {

    private static App instance;

    /**
     * It's how we get a globally available context without the Context param chain
     * @return
     */
    public static App applicationInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}

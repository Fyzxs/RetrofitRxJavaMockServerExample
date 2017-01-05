package com.example.fyzxs.myapplication.main;

import android.os.Bundle;
import android.widget.TextView;

import com.example.fyzxs.myapplication.app.BaseActivity;
import com.example.fyzxs.myapplication.R;

//Understands the view(s) of the MainActivity
public abstract class MainActivity extends BaseActivity {

    private TextView simple;
    private MainBridge mainBridge;

    public MainActivity(){
        mainBridge = new MainBridge(this);
    }

    @Override
    protected void bindViews() {
        simple = (TextView)findViewById(R.id.simpleValue);
    }

    @Override
    protected void postOnCreate(Bundle savedInstanceState){
        //The layout is part of the view(s)
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void postOnResume(){
        mainBridge.render();
    }

    /* protected */ TextView getSimpleView(){
        return simple;
    }

    public void updateSimpleView(final String value) {
        simple.setText(value);
    }
}

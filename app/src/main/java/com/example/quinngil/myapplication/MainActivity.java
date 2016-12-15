package com.example.quinngil.myapplication;

import android.os.Bundle;
import android.widget.TextView;

//Understands the view(s) of the MainActivity
public class MainActivity extends BaseActivity {

    private TextView simple;
    private MainViewModel mainViewModel;

    public MainActivity(){
        mainViewModel = new MainViewModel(this);
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
        mainViewModel.prepare();
    }

    /* protected */ TextView getSimpleView(){
        return simple;
    }
}

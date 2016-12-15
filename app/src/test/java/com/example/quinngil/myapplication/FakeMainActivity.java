package com.example.quinngil.myapplication;

import android.widget.TextView;

import org.mockito.Mockito;

public class FakeMainActivity extends MainActivity {

    TextView simpleView = Mockito.mock(TextView.class);

    @Override
    /* package */ TextView getSimpleView(){
        return simpleView;
    }

}

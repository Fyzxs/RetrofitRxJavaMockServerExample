package com.example.fyzxs.myapplication.main;

import android.widget.TextView;

import com.example.fyzxs.myapplication.main.MainActivity;

import org.mockito.Mockito;

/* package */ class FakeMainActivity extends MainActivity {

    /* package */ TextView simpleView = Mockito.mock(TextView.class);

    @Override
    /* package */ TextView getSimpleView(){
        return simpleView;
    }

}

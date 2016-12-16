package com.example.quinngil.myapplication.simple;

import android.widget.TextView;

public class SimpleApiResponse {

    private final String firstName;

    public SimpleApiResponse(final String firstName){
        this.firstName = firstName;
    }

    public void writeWelcomeMessage(TextView textView){
        textView.setText("Good day, " + firstName + ". The time is currently Fake o'clock");
    }
}

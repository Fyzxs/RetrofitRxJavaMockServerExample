package com.example.fyzxs.myapplication.simple;

import android.widget.TextView;

import com.example.fyzxs.myapplication.R;
import com.example.fyzxs.myapplication.app.FyzApp;

public class SimpleApiResponse {

    private final String firstName;

    public SimpleApiResponse(final String firstName){
        this.firstName = firstName;
    }

    public void writeWelcomeMessage(final TextView textView){
        textView.setText(
                FyzApp.applicationInstance().getString(
                        R.string.simple_api_response_personalized_greeting, firstName));
    }

    public void writeWelcomeMessageTo(final StringBuilder sb) {
        sb.append(FyzApp.applicationInstance().getString(
                R.string.simple_api_response_personalized_greeting, firstName));
    }
}

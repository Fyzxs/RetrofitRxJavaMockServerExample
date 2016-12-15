package com.example.quinngil.myapplication.simple;

public class SimpleApiResponse {

    private final String firstName;

    public SimpleApiResponse(final String firstName){
        this.firstName = firstName;
    }

    public String welcomeMessage(){
        return "Good day, " + firstName + ". The time is currently Fake o'clock";
    }
}

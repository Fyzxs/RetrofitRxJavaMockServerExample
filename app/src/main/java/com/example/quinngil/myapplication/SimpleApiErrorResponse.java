package com.example.quinngil.myapplication;

public class SimpleApiErrorResponse {

    private final String errorMessage;
    private final int errorCode;

    /* package */ SimpleApiErrorResponse(int errorCode, String message) {
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public StringBuilder writeFriendlyMessage(final StringBuilder sb){
        sb.append("<string name=\"simple_api_error_friendly_message_code_" + errorCode + "/>");
        return sb;
    }

    public StringBuilder writeResponseMessage(final StringBuilder sb){
        sb.append(errorMessage);
        return sb;
    }

    public String formatFriendlyMessage(final String format){
        return String.format(format, "<string name=\"simple_api_error_friendly_message_code_" + errorCode + "/>");
    }
}


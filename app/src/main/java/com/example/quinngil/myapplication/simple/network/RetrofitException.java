package com.example.quinngil.myapplication.simple.network;

/*
 * Copyright (c) 2016 Premera Blue Cross. All Rights Reserved.
 */

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.HttpURLConnection;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

//Understands the error from retrofit
public class RetrofitException extends RuntimeException {
    /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    private static final Object UnexpectedSlug = new Object();
    /**
     * An {@link java.io.IOException} occurred while communicating to the server.
     */
    private static final Object NetworkSlug = new Object();

    protected final Response response;
    protected final Retrofit retrofit;
    protected final Object exceptionSlug;


    private RetrofitException(final String message, final Response response, final Object exceptionSlug, final Throwable exception, final Retrofit retrofit) {
        super(message, exception);
        this.response = response;
        this.retrofit = retrofit;
        this.exceptionSlug = exceptionSlug;
    }

    /* package */ static RetrofitException httpError(Response response, Retrofit retrofit) {
        String message = response.code() + " " + response.message();
        return new RetrofitHttpException(message, response, retrofit);
    }

    /* package */ static RetrofitException networkError(IOException exception) {
        return new RetrofitException(exception.getMessage(), null,
                NetworkSlug,
                exception,
                null);
    }

    /* package */ static RetrofitException unexpectedError(Throwable exception) {
        return new RetrofitException(exception.getMessage(), null,
                UnexpectedSlug,
                exception,
                null);
    }


    /**
     * A non-200 HTTP status code was received from the server.
     */
    //Understands the http error response
    public final static class RetrofitHttpException extends RetrofitException{

        private RetrofitHttpException(String message, Response response, Retrofit retrofit) {
            super(message, response, null, null, retrofit);
        }

        /**
         * HTTP response body converted to specified {@code type}. {@code null} if there is no
         * response.
         *
         * @throws IOException if unable to convert the body to the specified {@code type}.
         */
        public <T> T bodyAs(Class<T> type) throws IOException {
            if (response == null || response.errorBody() == null) {
                return null;
            }
            Converter<ResponseBody, T> converter = retrofit.responseBodyConverter(type,
                    new Annotation[0]);
            return converter.convert(response.errorBody());
        }

        /**
         * HTTP Response Code. Use {@link HttpURLConnection} for statically defined values.
         */
        public int code(){
            return response.code();
        }
    }

    public boolean isUnexpectedException(){
        return exceptionSlug == UnexpectedSlug;
    }
    public boolean isNetworkException(){
        return exceptionSlug == NetworkSlug;
    }
    public boolean isHttpException(){
        return this instanceof RetrofitHttpException;
    }
}
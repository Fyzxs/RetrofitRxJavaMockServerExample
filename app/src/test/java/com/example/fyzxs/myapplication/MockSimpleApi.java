package com.example.fyzxs.myapplication;

import com.example.fyzxs.myapplication.simple.SimpleApi;
import com.example.fyzxs.myapplication.simple.SimpleApiResponse;

import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/* package */ class MockSimpleApi implements SimpleApi {

    private final BehaviorDelegate<SimpleApi> delegate;

    /* package */ MockSimpleApi(BehaviorDelegate<SimpleApi> delegate){
        this.delegate = delegate;
    }


    @Override
    public Observable<SimpleApiResponse> getSimpleResponse() {
        return delegate.returningResponse(new SimpleApiResponse("AFirstName")).getSimpleResponse();
    }
}

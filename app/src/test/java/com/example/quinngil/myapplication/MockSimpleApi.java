package com.example.quinngil.myapplication;

import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

public class MockSimpleApi implements SimpleApi {

    private final BehaviorDelegate<SimpleApi> delegate;

    public MockSimpleApi(BehaviorDelegate<SimpleApi> delegate){
        this.delegate = delegate;
    }


    @Override
    public Observable<SimpleApiResponse> getSimpleResponse() {

        return delegate.returningResponse(new SimpleApiResponse("AFirstName")).getSimpleResponse();
    }
}

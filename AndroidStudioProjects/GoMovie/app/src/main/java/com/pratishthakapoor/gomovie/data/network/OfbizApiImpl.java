package com.pratishthakapoor.gomovie.data.network;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by tanmayvijayvargiya on 25/02/17.
 */
public class OfbizApiImpl implements OfbizApiHelper {

    @Inject
    public OfbizApiImpl(){

    }


    @Override
    public Observable<NetworkResponse> facebookLogin(String userId, String emailId, String username, String accessToken) {
        return null;
    }
}

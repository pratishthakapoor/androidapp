package com.pratishthakapoor.gomovie.data.network;

import rx.Observable;

/**
 * Created by tanmayvijayvargiya on 25/02/17.
 */
public interface OfbizApiHelper {

    Observable<NetworkResponse> facebookLogin(String userId,
                                              String emailId,
                                              String username, String accessToken);
}

package com.pratishthakapoor.gomovie.ui.home.account;

import java.util.List;

import com.pratishthakapoor.gomovie.data.network.response.ReviewOverview;
import com.pratishthakapoor.gomovie.data.network.response.UserInfoResponse;
import com.pratishthakapoor.gomovie.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
public interface AccountView extends MvpView {
    public void setUserInfo(UserInfoResponse user);
    public void setReviews(List<ReviewOverview> reviews);

}

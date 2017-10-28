package com.pratishthakapoor.gomovie.ui.settings.followSelect;

import java.util.List;

import com.pratishthakapoor.gomovie.data.network.response.FbFriendsResponse;
import com.pratishthakapoor.gomovie.ui.base.MvpView;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
public interface FollowSelectView extends MvpView {
    void setUsers(List<FbFriendsResponse> fbFriendsResponses);
    void navigateToHome();
}

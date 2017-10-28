package com.pratishthakapoor.gomovie.ui.home.search;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.data.network.response.SearchResponse;

/**
 * Created by tanmayvijayvargiya on 08/04/17.
 */

@Layout(R.layout.user_overview)
public class UserOverviewItem {
    @View(R.id.user_profile)
    ImageView userProfile;
    @View(R.id.user_name)
    TextView userName;

    SearchResponse.UserOverview user;
    Context context;
    Callback callback;

    public UserOverviewItem(SearchResponse.UserOverview user, Context context, Callback callback) {
        this.user = user;
        this.context = context;
        this.callback = callback;
    }

    @Resolve
    public void onResolve(){
        Picasso.with(context)
                .load(user.userProfileUrl)
                .into(userProfile);

        userName.setText(user.userName);
    }

    public interface  Callback{
        public void onItemClick(UserOverviewItem item);
    }
}

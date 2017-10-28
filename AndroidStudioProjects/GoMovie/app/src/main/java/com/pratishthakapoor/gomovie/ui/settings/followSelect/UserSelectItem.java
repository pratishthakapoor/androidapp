package com.pratishthakapoor.gomovie.ui.settings.followSelect;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.data.network.response.FbFriendsResponse;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
@NonReusable
@Layout(R.layout.user_select_item)
public class UserSelectItem {
    Context context;
    FbFriendsResponse user;
    Callback mCallback;
    @View(R.id.user_profile)
    ImageView userProfile;
    @View(R.id.user_name)
    TextView userName;
    @View(R.id.user_checkbox)
    CheckBox userCheckbox;
    @View(R.id.user_select_item)
    RelativeLayout userSelectItem;

    public interface Callback{
        void onClick(String id, boolean isChecked);
    }

    public UserSelectItem(Callback callback, Context context, FbFriendsResponse user) {
        this.context = context;
        this.user = user;
        this.mCallback = callback;

    }

    @Resolve
    public void onResolve(){
        Picasso.with(context).load(user.getProfilePicture()).into(userProfile);
        userName.setText(user.getName());
        userCheckbox.setChecked(user.isFollowing());

        userCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCallback.onClick(user.getId(), b);
            }
        });
        userSelectItem.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                userCheckbox.setChecked(!userCheckbox.isChecked());
            }
        });
    }
}

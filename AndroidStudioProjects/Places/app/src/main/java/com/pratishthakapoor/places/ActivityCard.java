package com.pratishthakapoor.places;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

/**
 * Created by Pratishtha on 9/20/2017.
 */

@Layout(R.layout.activity_card_view)
public class ActivityCard {

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nametxt)
    private TextView nameTxt;


    @View(R.id.descriptionTxt)
    private TextView descriptionTxt;

    @View(R.id.weatherTxt)
    private TextView weatherTxt;

    private Profile mProfile;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    public ActivityCard(Context context, Profile profile, SwipePlaceHolderView mSwipeView)
    {
        mContext = context;
        mProfile = profile;
        mSwipeView.addView(this);
    }

    @Resolve
    private void onResolved()
    {
        Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
        nameTxt.setText(mProfile.getName() + ", " + mProfile.getLocation());
        descriptionTxt.setText(mProfile.getDescription());
        weatherTxt.setText(mProfile.getWeather());
    }

    @SwipeOut
    private void onSwipedOut()
    {
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private  void onSwipeCancelState()
    {
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn()
    {
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState()
    {
        Log.d("EVENT", "onswipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState()
    {
        Log.d("EVENT", "onSwipeOutState");
    }
}

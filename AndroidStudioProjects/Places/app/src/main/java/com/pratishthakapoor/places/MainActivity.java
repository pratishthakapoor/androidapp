package com.pratishthakapoor.places;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.util.Util;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                    .setPaddingTop(20)
                    .setRelativeScale(0.01f)
                    .setSwipeInMsgLayoutId(R.layout.activiyt_swipe_in_view)
                    .setSwipeOutMsgLayoutId(R.layout.activity_swipe_out_view));
        List<Profile> array = Utils.loadProfiles(this.getApplicationContext());
        Log.d("array_size","-->"+array.size());
        for(Profile profile:array)
        {
            Log.d("loop_times","->"+array);
            mSwipeView.addView(new ActivityCard(mContext, profile, mSwipeView));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSwipeView.doSwipe(false);
                Log.i("Reject","Rejected");
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSwipeView.doSwipe(true);
                Log.i("AcceptBtn","Accept");
            }
        });

    }
}

package com.pratishthakapoor.placeholderexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mindorks.placeholderview.ExpandablePlaceHolderView;
import com.pratishthakapoor.placeholderexample.utils.Utils;

public class MainActivity extends AppCompatActivity {

    private ExpandablePlaceHolderView mExpandableView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();
        mExpandableView = (ExpandablePlaceHolderView) findViewById(R.id.expandable_view);

        for(Feed feed: Utils.loadFeeds(this.getApplicationContext()))
        {
            mExpandableView.addView(new HeadingView(context,feed.getHeading()));
            for(Info info:feed.getInfoList())
            {
                mExpandableView.addView(new InfoView(context,info));
            }
        }
    }
}

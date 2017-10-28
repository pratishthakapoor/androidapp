package com.pratishthakapoor.placeholderexample;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

/**
 * Created by Pratishtha on 9/19/2017.
 */

@Layout(R.layout.feed_item)

public class InfoView {
    @ParentPosition
    private int mParentPosition;

    @ChildPosition
    private int mChildPosition;

    @View(R.id.title_txt)
    private TextView titleTxt;

    @View(R.id.caption_txt)
    private TextView captionTxt;

    @View(R.id.time_txt)
    private TextView timeTxt;

    @View(R.id.image_view)
    private ImageView imageView;

    private Info mInfo;
    private Context mContext;

    public InfoView(Context context, Info info) {
        mContext = context;
        mInfo = info;
    }

    @Resolve
    private void onResolved() {
        titleTxt.setText(mInfo.getTitle());
        captionTxt.setText(mInfo.getCaption());
        timeTxt.setText(mInfo.getTime());
        Glide.with(mContext).load(mInfo.getImageUrl()).into(imageView);
    }
}

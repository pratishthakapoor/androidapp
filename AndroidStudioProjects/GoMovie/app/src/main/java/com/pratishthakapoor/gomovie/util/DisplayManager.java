package com.pratishthakapoor.gomovie.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by tanmayvijayvargiya on 25/12/16.
 */

public class DisplayManager {

    public static float getPixelsFromDp(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }
}

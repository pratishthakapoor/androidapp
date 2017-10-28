package com.pratishthakapoor.gomovie.data;

import java.util.List;

import com.pratishthakapoor.gomovie.data.db.DbHelper;
import com.pratishthakapoor.gomovie.data.network.ApiHelper;
import com.pratishthakapoor.gomovie.data.network.OfbizApiHelper;
import com.pratishthakapoor.gomovie.data.prefs.PreferenceHelper;
import com.pratishthakapoor.gomovie.model.Feed;
import rx.Observable;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
public interface DataManager extends DbHelper, PreferenceHelper, ApiHelper, OfbizApiHelper {
    Observable<List<Feed>> getUserTimeline(String userId, String fromId);
}

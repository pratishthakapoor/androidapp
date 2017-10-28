package com.pratishthakapoor.gomovie.ui.home.FeedsFragment;

import android.support.annotation.Nullable;
import android.util.Log;

import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import in.co.gomovie.gomovieapp.data.DataManager;
import in.co.gomovie.gomovieapp.data.network.NetworkResponse;
import in.co.gomovie.gomovieapp.model.Feed;
import in.co.gomovie.gomovieapp.model.FeedGroup;
import in.co.gomovie.gomovieapp.model.MovieStat;
import in.co.gomovie.gomovieapp.ui.base.BasePresenter;
import in.co.gomovie.gomovieapp.ui.base.MenuFragment;
import in.co.gomovie.gomovieapp.util.AppConstants;
import in.co.gomovie.gomovieapp.util.Event;
import in.co.gomovie.gomovieapp.util.MenuComponent;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by tanmayvijayvargiya on 17/02/17.
 */
public class FeedsPresenterImpl<V extends FeedsView> extends BasePresenter<V> implements FeedsPresenter<V> {

    List<Feed> feedList = new ArrayList<Feed>();
    Subscription loadingSub;
    @Inject
    public FeedsPresenterImpl(DataManager dataManager) {
        super(dataManager);
        Log.d("Feeds","======BEING CREATED=====");
    }

    private String mode = "";

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        fetchFeeds(null);
    }

    private void fetchFeeds(String fromId) {
        if(loadingSub == null || loadingSub.isUnsubscribed()){
            getMvpView().showLoading("Loading Feeds...");
            if(mode.equals(AppConstants.MOVIE_FEED_MODE)){

                loadingSub = getDataManager().getMovieFeed(getDataManager().getCurrentUserid(),fromId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<List<Feed>>() {
                            @Override
                            public void call(List<Feed> feeds) {
                                addFeeds(feeds);
                                loadingSub.unsubscribe();
                            }
                        });
            }
            if(mode.equals(AppConstants.TIMELINE_MODE)){
                loadingSub = getDataManager().getUserTimeline(getDataManager().getCurrentUserid(), fromId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<List<Feed>>() {
                            @Override
                            public void call(List<Feed> feeds) {
                                addFeeds(feeds);
                                loadingSub.unsubscribe();
                            }
                        });
            }
            if(mode.equals(AppConstants.FOLLOWING_MODE)){
                loadingSub = getDataManager().userFollowingFeed(getDataManager().getCurrentUserid())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<List<FeedGroup>>() {
                            @Override
                            public void call(List<FeedGroup> feedGroups) {
                                addFeedGroups(feedGroups);
                                loadingSub.unsubscribe();
                            }
                        });
            }
        }

    }

    private void addFeeds(List<Feed> feeds){
        checkViewAttached();
        this.feedList.addAll(feeds);
        getMvpView().hideLoading();
        getMvpView().addFeeds(feeds);
    }

    private void addFeedGroups(List<FeedGroup> feedGroups){
        checkViewAttached();
        getMvpView().hideLoading();
        getMvpView().addFeedGroups(feedGroups);
    }


    @Override
    public void addToWishList(final String movieId) {
        String sessionId = getDataManager().getSessionId();
        getDataManager().addToWishList(sessionId, movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NetworkResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NetworkResponse networkResponse) {
                        Log.d("FeedPresenter", networkResponse.getMessage());
                    }
                });
    }

    @Override
    public void addToSeenList(final String movieId) {
        String sessionId = getDataManager().getSessionId();
        getDataManager().addToSeenList(sessionId, movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NetworkResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NetworkResponse networkResponse) {
                        Log.d("FeedPresenter", networkResponse.getMessage());
                    }
                });
    }

    @Override
    public void removeFromWishList(final String movieId) {
        String sessionId = getDataManager().getSessionId();
        getDataManager().removeFromWishList(sessionId, movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NetworkResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NetworkResponse networkResponse) {
                        Log.d("FeedPresenter", networkResponse.getMessage());
                    }
                });
    }

    @Override
    public void removeFromSeenList(final String movieId) {
        String sessionId = getDataManager().getSessionId();
        getDataManager().removeFromSeenList(sessionId, movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NetworkResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NetworkResponse networkResponse) {
                        Log.d("FeedPresenter", networkResponse.getMessage());
                    }
                });

    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public void onEvent(Event event, Map<String, Object> context) {
        switch (event){
            case MOVIE_MENU_CLICK:
                String movieId = (String) context.get("movieId");
                String movieName = (String) context.get("movieName");
                onMovieMenuClick(movieId, movieName);
                break;
            case VIDEO_CLICK:
                String videoId = (String) context.get("videoId");
                if(videoId != null)
                    getMvpView().playVideo(videoId);
                break;
            case IMAGE_CLICK:
                String photoUrl = (String) context.get("photoUrl");
                getMvpView().showPhotoOverlay(photoUrl);
                break;
            case LIKE_FEED:
                String foreignId = (String) context.get("foreign_id");
                likeActivity(foreignId, true);
                break;
            case UNLIKE_FEED:
                String foreign_id = (String) context.get("foreign_id");
                likeActivity(foreign_id, false);
                break;
            case COMMENT_CLICK:
                Log.d("Comment", "Comment Click");
                foreignId = (String) context.get("foreign_id");
                getMvpView().showCommentActivity(foreignId);
                break;
            case USER_TITLE_CLICK:
                String userId = (String) context.get("userId");
                getMvpView().showUserAccountFragment(userId);
                break;
        }
    }

    private void likeActivity(String foreignId, boolean doLike) {
        getDataManager().likeActivity(getDataManager().getCurrentUserid(),
                foreignId, doLike)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NetworkResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NetworkResponse networkResponse) {
                        Log.d("Like", networkResponse.getMessage());
                    }
                });
    }

    @Override
    public void endOfListReached() {
        if(feedList.size() > 0) {
            Feed feed = feedList.get(feedList.size() - 1);
            String fromId = feed.getId();
            fetchFeeds(fromId);
        }
    }

    private void onMovieMenuClick(final String movieId, final String movieName) {
        getDataManager().getMovieStat(movieId, new QueryTransaction.QueryResultSingleCallback<MovieStat>() {
            @Override
            public void onSingleQueryResult(QueryTransaction transaction, @Nullable MovieStat movieStat) {
                Log.d("MovieStat", "I got a result");
                List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();

                if(movieStat != null){
                    if(movieStat.isInWantToWatchList())
                        menuComponents.add(new MenuComponent(3,"Remove from wish list"));
                    else
                        menuComponents.add(new MenuComponent(1,"Add To wish list"));

                    if(movieStat.isInSeenList())
                        menuComponents.add(new MenuComponent(4,"Remove from seen list"));
                    else
                        menuComponents.add(new MenuComponent(2,"Add To seen list"));
                }else{
                    menuComponents.add(new MenuComponent(1,"Add To wish list"));
                    menuComponents.add(new MenuComponent(2,"Add To seen list"));
                }
                menuComponents.add(new MenuComponent(5,"Review"));

                getMvpView().showMenuOverlay( menuComponents, new MenuFragment.MenuCallback() {
                    @Override
                    public void onClick(MenuComponent mc) {
                        switch (mc.id){
                            case 1:
                                addToWishList(movieId);
                                break;
                            case 2:
                                addToSeenList(movieId);
                                break;
                            case 3:
                                removeFromWishList(movieId);
                                break;
                            case 4:
                                removeFromSeenList(movieId);
                                break;
                            case 5:
                                getMvpView().openReviewActivity(movieId, movieName);
                                break;
                        }
                    }
                });

            }
        }, new Transaction.Error() {
            @Override
            public void onError(Transaction transaction, Throwable error) {
                Log.d("MovieStat", "I got a error");
                error.printStackTrace();
            }
        });


    }

}

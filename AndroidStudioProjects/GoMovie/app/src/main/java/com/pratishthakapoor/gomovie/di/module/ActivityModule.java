package com.pratishthakapoor.gomovie.di.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import com.pratishthakapoor.gomovie.di.ActivityContext;
import com.pratishthakapoor.gomovie.ui.comment.CommentPresenter;
import com.pratishthakapoor.gomovie.ui.comment.CommentPresenterImpl;
import com.pratishthakapoor.gomovie.ui.comment.CommentView;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsPresenter;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsPresenterImpl;
import com.pratishthakapoor.gomovie.ui.home.FeedsFragment.FeedsView;
import com.pratishthakapoor.gomovie.ui.home.account.AccountPresenter;
import com.pratishthakapoor.gomovie.ui.home.account.AccountPresenterImpl;
import com.pratishthakapoor.gomovie.ui.home.account.AccountView;
import com.pratishthakapoor.gomovie.ui.home.review.WriteReviewPresenter;
import com.pratishthakapoor.gomovie.ui.home.review.WriteReviewPresenterImpl;
import com.pratishthakapoor.gomovie.ui.home.review.WriteReviewView;
import com.pratishthakapoor.gomovie.ui.home.search.SearchPresenter;
import com.pratishthakapoor.gomovie.ui.home.search.SearchPresenterImpl;
import com.pratishthakapoor.gomovie.ui.home.search.SearchView;
import com.pratishthakapoor.gomovie.ui.login.LoginPresenter;
import com.pratishthakapoor.gomovie.ui.login.LoginPresenterImpl;
import com.pratishthakapoor.gomovie.ui.login.LoginView;
import com.pratishthakapoor.gomovie.ui.movieInfo.MovieInfoPresenter;
import com.pratishthakapoor.gomovie.ui.movieInfo.MovieInfoPresenterImpl;
import com.pratishthakapoor.gomovie.ui.movieInfo.MovieInfoView;
import com.pratishthakapoor.gomovie.ui.review.ReviewListPresenter;
import com.pratishthakapoor.gomovie.ui.review.ReviewListPresenterImpl;
import com.pratishthakapoor.gomovie.ui.review.ReviewListView;
import com.pratishthakapoor.gomovie.ui.settings.followSelect.FollowSelectPresenter;
import com.pratishthakapoor.gomovie.ui.settings.followSelect.FollowSelectPresenterImpl;
import com.pratishthakapoor.gomovie.ui.settings.followSelect.FollowSelectView;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }

    // Provide presenters
    @Provides
    LoginPresenter<LoginView> provideLoginPresenter(LoginPresenterImpl<LoginView> presenter){
        return presenter;
    }

    @Provides
    FeedsPresenter<FeedsView> provideFeedsPresenter(FeedsPresenterImpl<FeedsView> presenter){
        return presenter;
    }
    @Provides
    AccountPresenter<AccountView> provideAccountPresenter(AccountPresenterImpl<AccountView> presenter){
        return presenter;
    }

    @Provides
    FollowSelectPresenter<FollowSelectView> provideFollowSelectPresenter(FollowSelectPresenterImpl<FollowSelectView> presenter){
        return presenter;
    }

    @Provides
    MovieInfoPresenter<MovieInfoView> provideMovieInfoPresenter(MovieInfoPresenterImpl<MovieInfoView> presenter){
        return presenter;
    }

    @Provides
    SearchPresenter<SearchView> provideSerachPresenter(SearchPresenterImpl<SearchView> presenter){

        return presenter;
    }

    @Provides
    WriteReviewPresenter<WriteReviewView> provideWriteReviewPresenter(WriteReviewPresenterImpl<WriteReviewView> presenter){
        return presenter;
    }
    @Provides
    ReviewListPresenter<ReviewListView> provieReviewListPresenter(ReviewListPresenterImpl<ReviewListView> presenter){
        return presenter;
    }
    @Provides
    CommentPresenter<CommentView> provideCommentPresenter(CommentPresenterImpl<CommentView> presenter){
        return presenter;
    }
}

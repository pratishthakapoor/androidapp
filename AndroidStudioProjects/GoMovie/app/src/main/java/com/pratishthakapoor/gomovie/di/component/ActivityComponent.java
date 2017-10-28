package com.pratishthakapoor.gomovie.di.component;

import dagger.Component;
import com.pratishthakapoor.gomovie.di.PerActivity;
import com.pratishthakapoor.gomovie.di.module.ActivityModule;
import com.pratishthakapoor.gomovie.ui.comment.CommentActivity;
import com.pratishthakapoor.gomovie.ui.home.FeedContainerFragment.FeedContainerFragment;
import com.pratishthakapoor.gomovie.ui.home.account.AccountFragment;
import com.pratishthakapoor.gomovie.ui.home.review.WriteReviewActivity;
import com.pratishthakapoor.gomovie.ui.home.search.SearchActivity;
import com.pratishthakapoor.gomovie.ui.login.LoginActivity;
import com.pratishthakapoor.gomovie.ui.movieInfo.MovieInfoActivity;
import com.pratishthakapoor.gomovie.ui.review.ReviewListFragment;
import com.pratishthakapoor.gomovie.ui.settings.followSelect.FollowSelectActivity;

/**
 * Created by tanmayvijayvargiya on 12/02/17.
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
    void inject(FollowSelectActivity followSelectActivity);
    void inject(MovieInfoActivity movieInfoActivity);
    void inject(FeedContainerFragment fragment);
    void inject(AccountFragment fragment);
    void inject(SearchActivity searchActivity);
    void inject(WriteReviewActivity reviewActivity);
    void inject(ReviewListFragment reviewListFragment);
    void inject(CommentActivity commentActivity);
}

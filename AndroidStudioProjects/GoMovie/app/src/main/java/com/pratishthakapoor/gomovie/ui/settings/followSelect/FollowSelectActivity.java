package com.pratishthakapoor.gomovie.ui.settings.followSelect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.data.network.response.FbFriendsResponse;
import com.pratishthakapoor.gomovie.ui.base.BaseActivity;
import com.pratishthakapoor.gomovie.ui.home.MainActivity;

/**
 * Created by tanmayvijayvargiya on 01/04/17.
 */
public class FollowSelectActivity extends BaseActivity implements FollowSelectView, UserSelectItem.Callback {

    @Inject
    FollowSelectPresenter<FollowSelectView> presenter;

    @BindView(R.id.follow_select_container)
    PlaceHolderView followSelectContainer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        setContentView(R.layout.activity_follow_select);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Follow Users");
        ButterKnife.bind(this);
        presenter.onAttach(this);
    }

    public static Intent getIntent(Context context){
        return new Intent(context, FollowSelectActivity.class);
    }

    @Override
    public void setUsers(List<FbFriendsResponse> fbFriendsResponses) {
        for(FbFriendsResponse user: fbFriendsResponses){
            Log.d("user select", user.getName());
            followSelectContainer.addView(new UserSelectItem(this,this,user));
        }
    }

    @Override
    public void navigateToHome() {
        startActivity(MainActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void onClick(String id, boolean isChecked) {
        presenter.onUserItemClick(id, isChecked);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.follow_select,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_follow :
                presenter.onFollowClick();
                break;
            case R.id.menu_skip:
                presenter.onSkipClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

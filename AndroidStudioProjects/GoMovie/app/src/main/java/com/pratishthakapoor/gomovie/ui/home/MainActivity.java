package com.pratishthakapoor.gomovie.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.iid.FirebaseInstanceId;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.gomovie.gomovieapp.R;
import in.co.gomovie.gomovieapp.ui.base.BaseActivity;
import in.co.gomovie.gomovieapp.ui.home.FeedContainerFragment.FeedContainerFragment;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.FeedsFragment;
import in.co.gomovie.gomovieapp.ui.home.FeedsFragment.feedViewHolder.FollowingFeedFragment;
import in.co.gomovie.gomovieapp.ui.home.account.AccountFragment;
import in.co.gomovie.gomovieapp.ui.home.discover.DiscoverFragment;
import in.co.gomovie.gomovieapp.ui.home.search.SearchActivity;
import in.co.gomovie.gomovieapp.ui.login.LoginActivity;

public class MainActivity extends BaseActivity implements DiscoverFragment.OnFragmentInteractionListener, AccountFragment.OnFragmentInteractionListener, FeedsFragment.Interactor{

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    FeedContainerFragment feedsFragment = new FeedContainerFragment();
    DiscoverFragment discoverFragment = new DiscoverFragment();
    AccountFragment accountFragment = new AccountFragment();
    FollowingFeedFragment followingFeedFragment = new FollowingFeedFragment();


    int currentFragment = 0;
    private static String ARG_CURRENT_FRAG = "current_frag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        ButterKnife.bind(this);
        LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_actionbar, null);
        actionBar.setCustomView(v);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(0);
        }
        if(savedInstanceState != null){
            currentFragment = savedInstanceState.getInt(ARG_CURRENT_FRAG,0);
        }
        switch (currentFragment){
            case 0:
                showFeedsFragment();
                break;
            case 1:
                showDiscoverFragment();
                break;
            case 2:
                showAccountFragment();
                break;
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Log.d("MENU",item.getItemId() + "|Item id");
                        switch (item.getItemId()){
                            case R.id.nav_feed:
                                showFeedsFragment();
                                break;
                            case R.id.nav_discover :
                                showDiscoverFragment();
                                break;

                            case R.id.nav_account :
                                showAccountFragment();
                                break;
                        }
                        return true;
                    }
                }
        );
        Log.d("Firebase", "token "+ FirebaseInstanceId.getInstance().getToken());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentFragment = savedInstanceState.getInt(ARG_CURRENT_FRAG, 0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(ARG_CURRENT_FRAG, currentFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout :
                logout();
                break;
            case R.id.menu_search:
                showSearchActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSearchActivity() {
        startActivity(SearchActivity.getStartIntent(this));

    }

    private void logout() {
        LoginManager.getInstance().logOut();
        startActivity(LoginActivity.getIntent(MainActivity.this));
        finish();
    }

    public static Intent getStartIntent(Context context){
        return new Intent(context, MainActivity.class);
    }

    void showFeedsFragment(){
        showActionBar();
        currentFragment = 0;
        Toast.makeText(MainActivity.this, "Feeds",Toast.LENGTH_SHORT).show();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_1, feedsFragment)
                .addToBackStack("FEEDS").commit();
    }

    void showDiscoverFragment(){
        showActionBar();
        currentFragment = 1;
        Toast.makeText(MainActivity.this, "Discover",Toast.LENGTH_SHORT).show();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_1,followingFeedFragment)
                .addToBackStack("DISCOVER").commit();
    }

    void showAccountFragment(){
        showActionBar();
        currentFragment = 1;
        Toast.makeText(MainActivity.this, "Discover",Toast.LENGTH_SHORT).show();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_1,accountFragment)
                .addToBackStack("ACCOUNT").commit();
    }

    @Override
    public void hiderActionBar() {
        getSupportActionBar().hide();

    }

    @Override
    public void showActionBar() {
        getSupportActionBar().show();
    }

    @Override
    public void showAccountFragment(String userId) {
        showActionBar();
        Log.d("Account", "Show account fragment for user id : "  + userId);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_1,AccountFragment.getInstance(userId))
                .addToBackStack("ACCOUNT").commit();
    }
}

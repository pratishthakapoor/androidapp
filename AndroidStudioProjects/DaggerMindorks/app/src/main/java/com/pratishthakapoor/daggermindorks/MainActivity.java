package com.pratishthakapoor.daggermindorks;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pratishthakapoor.daggermindorks.Data.DataManager;
import com.pratishthakapoor.daggermindorks.Model.User;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;

    private TextView mTVUserInfo;
    private TextView mTVAccessToken;

    public ActivityComponent getActivityComponent()
    {
        if(activityComponent == null)
        {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }

        return activityComponent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mTVUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTVAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        dataManager.saveAccessToken("ASDR123443JFDJ43543J543H3K543");
        String token = dataManager.getAccessToken();
        if(token != null)
        {
            mTVAccessToken.setText(token);
        }
    }

    private void createUser()
    {
        try{
            dataManager.createUser(new User("Ali","1367, Gurgaon, Haryana, India"));
        } catch (Exception e) {e.printStackTrace();}

    }

    private void getUser()
    {
        try
        {
            User user = dataManager.getUser(1L);
            mTVUserInfo.setText(user.toString());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

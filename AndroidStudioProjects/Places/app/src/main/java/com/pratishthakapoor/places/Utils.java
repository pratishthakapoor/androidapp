package com.pratishthakapoor.places;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pratishtha on 9/20/2017.
 */

public class Utils {

    private static final String TAG = "Utils";

    public static List<Profile> loadProfiles(Context context) {
        try{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray array = new JSONArray(loadJSONFromAsset(context,"profiles.json"));
            List<Profile> profileList = new ArrayList<>();
            for(int i=0;i<array.length();i++)
            {
                Log.d("json obj",array.getJSONObject(i).toString());
                Profile profile = gson.fromJson(array.getJSONObject(i).toString(), Profile.class);
                profileList.add(profile);
                Log.d("list size","====>"+profileList.size());
                //int k = array.length();
                //System.out.print(k);
            }
            return profileList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static String loadJSONFromAsset(Context context, String jsonFileName) {

        String json = null;
        InputStream is = null;
        try
        {
            AssetManager manager = context.getAssets();
            Log.d(TAG, "path "+jsonFileName);
            is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            System.out.print(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
     return json;

    }
}

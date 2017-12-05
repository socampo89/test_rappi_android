package com.android.test.rappi.appstorerappi.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.android.test.rappi.appstorerappi.Models.Feed;
import com.android.test.rappi.appstorerappi.NetworkUtil;
import com.android.test.rappi.appstorerappi.services.AppleApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    //Retrofit - Configuration
    private static final String BASE_URL = "https://itunes.apple.com/us/" ;
    private static final String TAG_SHARED_PREFERENCES_FEED = "TAG_SHARED_PREF_FEED";
    Retrofit retrofit;
    // Service
    AppleApi serviceApple;

    // Create the instance
    private static App instance;

    boolean isConnected;


    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(2000); //for splash
        instance = this;
        initRetrofit();
        initAppleServices();
        checkConn();
    }

    public static App getInstance(){
        return instance;
    }

    public void initAppleServices(){
        if(retrofit == null)
            initRetrofit();
        serviceApple = retrofit.create(AppleApi.class);
    }

    public void initRetrofit(){
        //Configuramos Retrofit para que funcione con Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void checkConn(){
        if(NetworkUtil.getConnectivityStatus(instance)==NetworkUtil.TYPE_NOT_CONNECTED){
            setConnected(false);
            Toast.makeText(getApplicationContext(),"No hay coneccion a internet",Toast.LENGTH_LONG).show();
        }
        else
        {
            setConnected(true);
        }

    }

    public Retrofit getRetrofit() {
        if(retrofit==null)
            initRetrofit();
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public AppleApi getServiceApple() {
        if(serviceApple == null)
            initAppleServices();
        return serviceApple;
    }

    public void setServiceApple(AppleApi serviceApple) {
        this.serviceApple = serviceApple;
    }

    public void saveDataOnSharedPreferences(Feed feed){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefsEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(feed);
        prefsEditor.putString(TAG_SHARED_PREFERENCES_FEED, json);
        prefsEditor.apply();
    }

    public Feed getDataSharedPreferences(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = prefs.getString(TAG_SHARED_PREFERENCES_FEED, null);
        if(json!=null){
            return gson.fromJson(json, Feed.class);
        }
        else
            return null;

    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}

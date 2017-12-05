package com.android.test.rappi.appstorerappi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sergio on 5/12/2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //open the main activity
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

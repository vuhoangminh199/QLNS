package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,DrawerNavigationBar.class);
        startActivity(intent);
        finish();
    }
}

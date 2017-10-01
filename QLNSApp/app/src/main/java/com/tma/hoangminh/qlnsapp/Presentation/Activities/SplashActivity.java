package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.R;

public class SplashActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SurfaceHolder mFirstSurface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        getSupportActionBar().hide();
        toggleHideyBar();
        initINtroVideo();
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager.getActiveNetworkInfo() == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Thông Báo!!").setMessage("Bạn Hãy Bật 3G để tiếo tục!!!");
                builder.setPositiveButton("Thử Lại", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int i) {
                        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
                        registerReceiver(receiver, intentFilter);
                        if (connectivityManager.getActiveNetworkInfo() != null) {
                            //GoToMain()
                        }
                    }
                });
                builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int i) {
                        System.exit(0);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(false);
                dialog.show();
            } else {
                //GoToMain();
            }
        }
    };

    public void GoToMain(){
        Intent intent = new Intent(SplashActivity.this, DrawerNavigationBar.class);
        startActivity(intent);
        finish();
    }

    private void initINtroVideo() {
        final SurfaceView first = (SurfaceView) findViewById(R.id.surface);
        first.getHolder().addCallback(new SurfaceHolder.Callback2() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mFirstSurface = holder;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.intro_splash);
                mediaPlayer.setVolume(0,0);
                mediaPlayer.setDisplay(mFirstSurface);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        GoToMain();
                    }
                });
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }

            @Override
            public void surfaceRedrawNeeded(SurfaceHolder holder) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    System.exit(0);
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    public void toggleHideyBar() {
        int newUiOptions = getWindow().getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE;
        }

        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
    }
}

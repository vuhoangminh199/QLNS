package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.R;

public class ChooseDatabaseActivity extends AppCompatActivity {
    Button btnNhom1, btnNhom2, btnNhom3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_database_activity);
        Init();
        Listener();
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager.getActiveNetworkInfo() == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChooseDatabaseActivity.this);
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

    public void Init() {
        btnNhom1 = (Button) findViewById(R.id.btnnhom1);
        btnNhom2 = (Button) findViewById(R.id.btnnhom2);
        btnNhom3 = (Button) findViewById(R.id.btnnhom3);
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

    public void Listener() {
        btnNhom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerNavigationBar.URL = "http://apiqlns.somee.com/api/";
                Intent intent = new Intent(ChooseDatabaseActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });
        btnNhom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerNavigationBar.URL = "http://bookloverapi.somee.com/api/";
                Intent intent = new Intent(ChooseDatabaseActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });
        btnNhom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerNavigationBar.URL = "";
                Intent intent = new Intent(ChooseDatabaseActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

    }
}

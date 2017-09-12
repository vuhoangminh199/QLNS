


package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.tma.hoangminh.qlnsapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
        tab.setup();
        TabHost.TabSpec spec;

        //tab Dang Nhap
        spec = tab.newTabSpec("t1");
        spec.setContent(R.id.tabDangnhap);
        spec.setIndicator("Đăng Nhập");
        tab.addTab(spec);

        //tab Dang Ky
        spec = tab.newTabSpec("t2");
        spec.setContent(R.id.tabDangky);
        spec.setIndicator("Đăng Ký");
        tab.addTab(spec);

        //set default tab
        tab.setCurrentTab(0);
    }
}

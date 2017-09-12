package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.tma.hoangminh.qlnsapp.R;

public class ThreeFragment extends android.support.v4.app.Fragment {
    public static ThreeFragment newInstance() {
        ThreeFragment fragment = new ThreeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        final TabHost tab = view.findViewById(android.R.id.tabhost);
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
        return view;
    }
}

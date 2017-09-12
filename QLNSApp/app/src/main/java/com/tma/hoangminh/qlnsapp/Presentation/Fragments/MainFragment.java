package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.tma.hoangminh.qlnsapp.R;

public class MainFragment extends android.support.v4.app.Fragment {

    private ViewFlipper mViewFlipper;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewFlipper = view.findViewById(R.id.view_flipper);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(2000);
        mViewFlipper.startFlipping();
        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.in_from_left));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.out_from_left));
        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.in_from_right));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.out_from_right));
        return view;
    }
}

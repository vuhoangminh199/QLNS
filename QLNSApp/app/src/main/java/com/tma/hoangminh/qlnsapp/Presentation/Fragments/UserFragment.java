package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tma.hoangminh.qlnsapp.Presentation.Activities.LoginResgiserActivity;
import com.tma.hoangminh.qlnsapp.R;

public class UserFragment extends android.support.v4.app.Fragment {
    View view;
    TextView txtSignIn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);
        Init();
        Listener();

        return view;
    }

    public void Init(){
        txtSignIn = view.findViewById(R.id.textview_signin_signup);

    }

    public void Listener(){
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToSignIn = new Intent(UserFragment.this.getContext(),LoginResgiserActivity.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(getContext(),R.anim.top_from_bottom, R.anim.bottom_from_top);
                startActivity(intentToSignIn, options.toBundle());

            }
        });
    }
}

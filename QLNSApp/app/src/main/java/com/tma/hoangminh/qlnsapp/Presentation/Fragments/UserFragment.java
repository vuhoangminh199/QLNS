package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.UserMapping;
import com.tma.hoangminh.qlnsapp.Presentation.Activities.LoginResgiserActivity;
import com.tma.hoangminh.qlnsapp.R;

import static android.content.Context.MODE_PRIVATE;

public class UserFragment extends android.support.v4.app.Fragment {
    private View view;
    private TextView txtSignIn;
    private static final int key = 2;
    private SharedPreferences preferences;
    private String name;
    private boolean logged;
    private LinearLayout layoutLogout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
         preferences = UserFragment.this.getActivity().getSharedPreferences("LOGIN", MODE_PRIVATE);
         name = preferences.getString("TENKH", null);
         logged = preferences.getBoolean("LOGGED", false);
    }

    @Override
    public void onResume() {
        super.onResume();
        preferences = UserFragment.this.getActivity().getSharedPreferences("LOGIN", MODE_PRIVATE);
        name = preferences.getString("TENKH", null);
        logged = preferences.getBoolean("LOGGED", false);
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
        layoutLogout = view.findViewById(R.id.layoutLogout);
        txtSignIn = view.findViewById(R.id.textview_signin_signup);
        if(logged){
            txtSignIn.setText(name);
        } else {
            txtSignIn.setText("Đăng Nhập/ Đăng Kí");
        }
    }

    public void Listener(){
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!logged){
                    Intent intentToSignIn = new Intent(UserFragment.this.getContext(),LoginResgiserActivity.class);
                    ActivityOptions options =
                            ActivityOptions.makeCustomAnimation(getContext(),R.anim.top_from_bottom, R.anim.bottom_from_top);
                    startActivityForResult(intentToSignIn, key, options.toBundle());
                }
            }
        });

        layoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new UserMapping().CommitNullData(UserFragment.this.getContext());
                logged = false;
                txtSignIn.setText("Đăng Nhập/ Đăng Kí");
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == key && resultCode == key){
            String s = data.getStringExtra("username");
            txtSignIn.setText(s);
        }
    }
}

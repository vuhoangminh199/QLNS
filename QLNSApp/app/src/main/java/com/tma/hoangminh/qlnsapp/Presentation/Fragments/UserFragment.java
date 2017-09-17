package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.tma.hoangminh.qlnsapp.Presentation.Presenters.UserPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.UserView;
import com.tma.hoangminh.qlnsapp.R;

public class UserFragment extends android.support.v4.app.Fragment implements UserView{
    private  EditText editPhone, editPassword, editRname, editRphone, editRpassword;
    private Button btnLogin, btnRegister;
    private TabHost tab;
    private UserPresenter presenter;
    private TextView phoneerror, passworderror, phoneRerror, nameRerror, passRerror;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        tab = view.findViewById(android.R.id.tabhost);
        editPhone = view.findViewById(R.id.edit_sdt);
        editPassword = view.findViewById(R.id.edit_matkhau);
        editRname = view.findViewById(R.id.edit_register_name);
        editRphone = view.findViewById(R.id.edit_register_phone);
        editRpassword = view.findViewById(R.id.edit_register_password);
        btnLogin = view.findViewById(R.id.btnDangNhap);
        btnRegister = view.findViewById(R.id.btndangky);
        phoneerror = view.findViewById(R.id.phone_error);
        passworderror = view.findViewById(R.id.password_error);
        nameRerror = view.findViewById(R.id.name_register_error);
        phoneRerror = view.findViewById(R.id.phone_register_error);
        passRerror = view.findViewById(R.id.pass_register_error);
        SetUpTab();
        Init();
        Listener();
        return view;
    }

    public void SetUpTab(){
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

    public void Init(){
        presenter = new UserPresenter(UserFragment.this);
    }

    public void Listener(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPressLogin();
            }
        });

        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalText(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalText(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editRname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalTextRegister(1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editRphone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalTextRegister(2);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editRpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalTextRegister(3);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPressRegister();
            }
        });
    }

    @Override
    public String getPhonenumber() {
        return editPhone.getText().toString();
    }

    @Override
    public String getPassword() {
        return editPassword.getText().toString();
    }

    @Override
    public String getRPhonenumber() {
        return editRphone.getText().toString();
    }

    @Override
    public String getRPassword() {
        return editRpassword.getText().toString();
    }

    @Override
    public String getRName() {
        return editRname.getText().toString();
    }

    @Override
    public void navigationLoginSuccess() {
        Toast.makeText(UserFragment.this.getContext(),"Thanh cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorPassword(String mes) {
        passworderror.setText(mes.toString());
        passworderror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorPassword() {
        passworderror.setVisibility(View.GONE);
    }

    @Override
    public void showErrorPhone(String mes) {
        phoneerror.setText(mes.toString());
        phoneerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorPhone() {
        phoneerror.setVisibility(View.GONE);
    }

    @Override
    public void showLoginFail() {
        Toast.makeText(UserFragment.this.getContext(),"Thanh cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigationRegisterSuccess() {
        Toast.makeText(UserFragment.this.getContext(),"Dang ki Thang Cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorRPassword(String mes) {
        passRerror.setText(mes.toString());
        passRerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorRPassword() {
        passRerror.setVisibility(View.GONE);
    }

    @Override
    public void showErrorRPhone(String mes) {
        phoneRerror.setText(mes.toString());
        phoneRerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorRPhone() {
        phoneRerror.setVisibility(View.GONE);
    }

    @Override
    public void showErrorRName(String mes) {
        nameRerror.setText(mes.toString());
        nameRerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorRName() {
        nameRerror.setVisibility(View.GONE);
    }

    @Override
    public void showRegisterFail() {
        Toast.makeText(UserFragment.this.getContext(),"Dang ki That Bai", Toast.LENGTH_SHORT).show();
    }
}

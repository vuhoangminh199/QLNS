package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.tma.hoangminh.qlnsapp.Presentation.Presenters.UserPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.UserView;
import com.tma.hoangminh.qlnsapp.R;

public class LoginRegisterActivity extends AppCompatActivity implements UserView {
    private EditText editPhone, editPassword, editRname, editRphone, editRpassword;
    private Button btnLogin, btnRegister;
    private TabHost tab;
    private UserPresenter presenter;
    private TextView phoneerror, passworderror, phoneRerror, nameRerror, passRerror;
    private Toolbar toolbar;
    private ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_signup);
        Init();
        SetUpTab();
        Listener();
    }

    public void SetUpTab() {
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

    public void Init() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_register);
        tab = (TabHost) findViewById(android.R.id.tabhost);
        editPhone = (EditText) findViewById(R.id.edit_sdt);
        editPassword = (EditText) findViewById(R.id.edit_matkhau);
        editRname = (EditText) findViewById(R.id.edit_register_name);
        editRphone = (EditText) findViewById(R.id.edit_register_phone);
        editRpassword = (EditText) findViewById(R.id.edit_register_password);
        btnLogin = (Button) findViewById(R.id.btnDangNhap);
        btnRegister = (Button) findViewById(R.id.btndangky);
        phoneerror = (TextView) findViewById(R.id.phone_error);
        passworderror = (TextView) findViewById(R.id.password_error);
        nameRerror = (TextView) findViewById(R.id.name_register_error);
        phoneRerror = (TextView) findViewById(R.id.phone_register_error);
        passRerror = (TextView) findViewById(R.id.pass_register_error);
        presenter = new UserPresenter(LoginRegisterActivity.this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left);
        getSupportActionBar().setTitle("");
        progressDialog = new ProgressDialog(LoginRegisterActivity.this);
        progressDialog.setMessage("Vui Lòng Chờ......");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
    }

    public void Listener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
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
                progressDialog.show();
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
    public void navigationLoginSuccess(String name) {
        progressDialog.hide();
        Toast.makeText(LoginRegisterActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        getIntent().putExtra("username",name);
        setResult(2,getIntent());
        finish();

    }

    @Override
    public void showErrorPassword(String mes) {
        progressDialog.hide();
        passworderror.setText(mes.toString());
        passworderror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorPassword() {
        passworderror.setVisibility(View.GONE);
    }

    @Override
    public void showErrorPhone(String mes) {
        progressDialog.hide();
        phoneerror.setText(mes.toString());
        phoneerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorPhone() {
        phoneerror.setVisibility(View.GONE);
    }

    @Override
    public void showLoginFail() {
        progressDialog.hide();
        Toast.makeText(LoginRegisterActivity.this, "Mật Khẩu hoặc Số điện thoại không đúng", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigationRegisterSuccess(String name) {
        progressDialog.hide();
        Toast.makeText(LoginRegisterActivity.this, "Dang ki Thang Cong", Toast.LENGTH_SHORT).show();
        getIntent().putExtra("username",name);
        setResult(2,getIntent());
        finish();
    }

    @Override
    public void showErrorRPassword(String mes) {
        progressDialog.hide();
        passRerror.setText(mes.toString());
        passRerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorRPassword() {
        passRerror.setVisibility(View.GONE);
    }

    @Override
    public void showErrorRPhone(String mes) {
        progressDialog.hide();
        phoneRerror.setText(mes.toString());
        phoneRerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorRPhone() {
        phoneRerror.setVisibility(View.GONE);
    }

    @Override
    public void showErrorRName(String mes) {
        progressDialog.hide();
        nameRerror.setText(mes.toString());
        nameRerror.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorRName() {
        nameRerror.setVisibility(View.GONE);
    }

    @Override
    public void showRegisterFail() {
        progressDialog.hide();
        Toast.makeText(LoginRegisterActivity.this, "Dang ki That Bai", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                overridePendingTransition(R.anim.bottom_from_top,R.anim.top_from_bottom);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

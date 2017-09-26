package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tma.hoangminh.qlnsapp.Presentation.Presenters.ChangeProfilePresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.ChangeProfileView;
import com.tma.hoangminh.qlnsapp.R;

public class ChangeProfileActivity extends AppCompatActivity implements ChangeProfileView {
    private EditText editName, editPassold, editPassnew, editCfpassnew;
    private CheckBox cbChange;
    private Button btnChangePass;
    private Toolbar toolbar;
    private LinearLayout layout;
    private TextView txtNameError, txtPassOldError, txtPassNewError, txtCfPassNewError;
    private ChangeProfilePresenter presenter;
    private SharedPreferences preferences;
    private String tenkh, makh, matkhau , email, diachi, sdt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_profile_user);
        Init();
        Listener();
    }

    public void Init() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_change);
        editName = (EditText) findViewById(R.id.edit_change_name);
        editPassold = (EditText) findViewById(R.id.edit_password_old);
        editPassnew = (EditText) findViewById(R.id.edit_change_newpassword);
        editCfpassnew = (EditText) findViewById(R.id.edit_change_cfpass);
        cbChange = (CheckBox) findViewById(R.id.cb_changepass);
        btnChangePass = (Button) findViewById(R.id.btnchange);
        layout = (LinearLayout) findViewById(R.id.layout_change);
        txtNameError = (TextView) findViewById(R.id.name_change_error);
        txtPassOldError = (TextView) findViewById(R.id.passold_change_error);
        txtPassNewError = (TextView) findViewById(R.id.passnew_change_error);
        txtCfPassNewError = (TextView) findViewById(R.id.cfpass_change_error);
        presenter = new ChangeProfilePresenter(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left);
        getSupportActionBar().setTitle("");

        preferences = this.getSharedPreferences("LOGIN", MODE_PRIVATE);
        makh = preferences.getString("MAKH", null);
        tenkh = preferences.getString("TENKH", null);
        diachi = preferences.getString("DIACHI", null);
        sdt = preferences.getString("SODIENTHOAI", null);
        email = preferences.getString("EMAIL", null);
        matkhau = preferences.getString("MATKHAU", null);

        editName.setText(tenkh);
    }

    public void Listener() {
        cbChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbChange.isChecked()) {
                    layout.setVisibility(View.VISIBLE);
                } else {
                    layout.setVisibility(View.GONE);
                }
            }
        });

        editName.addTextChangedListener(new TextWatcher() {
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

        editPassnew.addTextChangedListener(new TextWatcher() {
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

        editPassnew.addTextChangedListener(new TextWatcher() {
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

        editCfpassnew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalTextRegister(4);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPressChange();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public String getName() {
        return editName.getText().toString();
    }

    @Override
    public String getOldPassword() {
        return editPassold.getText().toString();
    }

    @Override
    public String getNewPassword() {
        return editPassnew.getText().toString();
    }

    @Override
    public String getCfNewPassword() {
        return editCfpassnew.getText().toString();
    }

    @Override
    public String getTruePass() {
        return matkhau;
    }

    @Override
    public String getPhone() {
        return sdt;
    }

    @Override
    public String getMaKH() {
        return makh;
    }

    @Override
    public String getTenKH() {
        return tenkh;
    }

    @Override
    public String getEmailKH() {
        return email;
    }

    @Override
    public String getDiachiKH() {
        return diachi;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public boolean getStateCB() {
        return cbChange.isChecked();
    }

    @Override
    public void navigationChangeSuccess(String name) {
        getIntent().putExtra("username",name);
        setResult(3,getIntent());
        finish();
    }

    @Override
    public void showErrorPasswordOld(String mes) {
        txtPassOldError.setText(mes);
        txtPassOldError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorPasswordOld() {
        txtPassOldError.setVisibility(View.GONE);
    }

    @Override
    public void showErrorPasswordNew(String mes) {
        txtPassNewError.setText(mes);
        txtPassNewError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorPasswordNew() {
        txtPassNewError.setVisibility(View.GONE);
    }

    @Override
    public void showErrorCfPasswordNew(String mes) {
        txtCfPassNewError.setText(mes);
        txtCfPassNewError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorCfPasswordNew() {
        txtCfPassNewError.setVisibility(View.GONE);
    }

    @Override
    public void showErrorName(String mes) {
        txtNameError.setText(mes);
        txtNameError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorName() {
        txtNameError.setVisibility(View.GONE);
    }
}

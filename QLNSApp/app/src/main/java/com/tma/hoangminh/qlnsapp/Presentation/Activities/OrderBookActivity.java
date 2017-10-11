package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tma.hoangminh.qlnsapp.Domain.Model.CT_DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.OrderBookPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.OrderBookView;
import com.tma.hoangminh.qlnsapp.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class    OrderBookActivity extends AppCompatActivity implements OrderBookView{
    private Toolbar toolbar;
    private ImageView myImage;
    private TextView txtTitle, txtArt, txtPrice, txtNumber, txtNameError, txtPhoneError, txtAddressError;
    private Button btnOrder, btnLefl, btnRight;
    private EditText editName, editPhone, editAddress;
    private Intent myIntent;
    private int myNumber = 1;
    private String masach, title, art, makh;
    private int soluongton, price, itemInListDh;
    private OrderBookPresenter presenter;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_book);
        Init();
        Listener();
    }

    public void Init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar_orderbook);
        myImage = (ImageView) findViewById(R.id.image_orderbook);
        txtTitle = (TextView) findViewById(R.id.title_orderbook);
        txtArt = (TextView) findViewById(R.id.art_orderbook);
        txtPrice = (TextView) findViewById(R.id.price_orderbook);
        txtNumber = (TextView) findViewById(R.id.textview_number);
        txtNameError = (TextView) findViewById(R.id.name_error);
        txtPhoneError = (TextView) findViewById(R.id.phone_error);
        txtAddressError = (TextView) findViewById(R.id.address_error);
        btnOrder = (Button) findViewById(R.id.btn_order);
        btnLefl = (Button) findViewById(R.id.btnleft);
        btnRight = (Button) findViewById(R.id.btnright);
        editName = (EditText) findViewById(R.id.edit_name);
        editPhone = (EditText) findViewById(R.id.edit_phone);
        editAddress = (EditText) findViewById(R.id.edit_address);
        presenter = new OrderBookPresenter(OrderBookActivity.this);
        presenter.SetUpListDh();
        preferences = OrderBookActivity.this.getSharedPreferences("LOGIN", MODE_PRIVATE);
        makh = preferences.getString("MAKH", null);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left);
        getSupportActionBar().setTitle("");
        myIntent = getIntent();
        masach = myIntent.getStringExtra("masach_order");
        title = myIntent.getStringExtra("tensach_order");
        art = myIntent.getStringExtra("tacgia_order");
        price = myIntent.getIntExtra("giasach_order", 0);
        soluongton = myIntent.getIntExtra("soluongton_order", 0);
        try {
            URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHImage/" + masach);
            Glide.with(this).fromUrl().asBitmap().load(url).centerCrop().into(myImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        txtNumber.setText(myNumber+"");
        txtTitle.setText(title);
        txtArt.setText(art);
        txtPrice.setText(price+" Đ");
    }

    public void Listener(){
        btnLefl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myNumber > 1 ){
                    txtNumber.setText((--myNumber)+"");
                    txtPrice.setText(myIntent.getIntExtra("giasach_order", 0) * myNumber + "Đ");
                }
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soluongton > myNumber ){
                    txtNumber.setText("" + (++myNumber));
                    txtPrice.setText(myIntent.getIntExtra("giasach_order", 0) * myNumber +"Đ");
                } else {
                    Toast.makeText(OrderBookActivity.this,"Số lượng chỉ có " + soluongton , Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (makh == null || makh.equals("")){
                    Toast.makeText(OrderBookActivity.this,"Bạn cần phải đăng nhập để đặt sách hihi", Toast.LENGTH_SHORT);
                } else {
                    long millis=System.currentTimeMillis();
                    long twoDay = millis + TimeUnit.HOURS.toMillis(1l) * 48;
                    java.sql.Date date=new java.sql.Date(millis);
                    java.sql.Date dateOrder=new java.sql.Date(twoDay);
                    DatHang datHang = new DatHang("123", makh, editPhone.getText().toString(),
                            editAddress.getText().toString(), date.toString(),
                            dateOrder.toString(), myIntent.getIntExtra("giasach_order", 0) * myNumber, true);

                    CT_DatHang ct_datHang = new CT_DatHang(datHang.getMadathang(), masach,
                            myNumber, price, myIntent.getIntExtra("giasach_order", 0) * myNumber, 0, null);
                    presenter.onPressOrder(datHang, ct_datHang);
                }

            }
        });

        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalText(2);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalText(1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.onBackNormalText(3);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String getName() {
        return editName.getText().toString();
    }

    @Override
    public String getPhone() {
        return editPhone.getText().toString();
    }

    @Override
    public String getAddress() {
        return editAddress.getText().toString();
    }

    @Override
    public void navigatorToSuccess() {
        long millis=System.currentTimeMillis();
        long twoDay = millis + TimeUnit.HOURS.toMillis(1l) * 48;
        java.sql.Date date=new java.sql.Date(twoDay);
        AlertDialog.Builder builder = new AlertDialog.Builder(OrderBookActivity.this);
        builder.setTitle("Thông Báo").setMessage("Sách sẽ được giao vào " + date);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public void SetUpListDh(List<DatHang> listDh) {
        itemInListDh = listDh.size();
    }

    @Override
    public void showErrorAddress(String mes) {
        txtAddressError.setText(mes);
        txtAddressError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorAddress() {
        txtAddressError.setVisibility(View.GONE);
    }

    @Override
    public void showErrorPhone(String mes) {
        txtPhoneError.setText(mes);
        txtPhoneError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorPhone() {
        txtPhoneError.setVisibility(View.GONE);
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

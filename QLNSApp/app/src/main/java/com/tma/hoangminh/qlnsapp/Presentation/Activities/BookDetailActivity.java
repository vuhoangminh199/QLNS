package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.BookDetailPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.BookDetailView;
import com.tma.hoangminh.qlnsapp.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookDetailActivity extends AppCompatActivity implements BookDetailView {
    private ArrayList<Integer> imageList;
    private Intent myIntent;
    private int mypos;
    private ImageView myImageBack, myImageBG, myImageDetail;
    private BookDetailPresenter presenter;
    private TextView titleBar,artBar,titleBook,artBook,priceBook,desBook;
    private String myMasach;
    private Button btnOrder;
    private Sach mySach;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        Init();
        Listener();
    }

    public void Init(){
        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        presenter = new BookDetailPresenter(this);
        myImageBG = (ImageView) findViewById(R.id.image_bg);
        titleBar = (TextView) findViewById(R.id.title_bar);
        artBar = (TextView) findViewById(R.id.art_bar);
        btnOrder = (Button) findViewById(R.id.btnorder);
        titleBook = (TextView) findViewById(R.id.title_book);
        artBook = (TextView) findViewById(R.id.art_book);
        desBook = (TextView) findViewById(R.id.des_book);
        priceBook = (TextView) findViewById(R.id.price_book);
        myImageBack = (ImageView) findViewById(R.id.imageBack);
        myImageDetail = (ImageView) findViewById(R.id.image_bookdetail);
        myIntent = getIntent();
        myMasach = myIntent.getStringExtra("masach");
        mypos = myIntent.getIntExtra("pos", 0);
    }

    public void Listener(){
        myImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPressBack();
            }
        });
        presenter.SetUpListBook();
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPressOrder(mySach);
            }
        });
    }

    @Override
    public void navigationBack() {
        finish();
    }

    @Override
    public void SetUpListBook(List<Sach> listBook) {
        for (int i = 0; i<listBook.size();i++) {
            if(listBook.get(i).getMasach().equals(myMasach)){
                mySach = listBook.get(i);
                titleBar.setText(listBook.get(i).getTensach());
                artBar.setText(listBook.get(i).getTacgia());
                titleBook.setText(listBook.get(i).getTensach());
                artBook.setText(listBook.get(i).getTacgia());
                desBook.setText(listBook.get(i).getMota());
                priceBook.setText(listBook.get(i).getDongiaban()+ " Đ");
                try {
                    URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHImage/" + myMasach);
                    Glide.with(this).fromUrl().asBitmap().load(url).centerCrop().into(myImageBG);
                    Glide.with(this).fromUrl().asBitmap().load(url).centerCrop().into(myImageDetail);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public void navigateToOrder(Sach sach) {
        if(sach.getSoluongton() == 0 ){
            Toast.makeText(BookDetailActivity.this, "Sách đã hết vui lòng quay lại sau", Toast.LENGTH_LONG ).show();
        } else {
            Intent intentToOrder = new Intent(BookDetailActivity.this, OrderBookActivity.class);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(this, R.anim.top_from_bottom, R.anim.bottom_from_top);
            intentToOrder.putExtra("masach_order", sach.getMasach());
            intentToOrder.putExtra("tensach_order", sach.getTensach());
            intentToOrder.putExtra("tacgia_order", sach.getTacgia());
            intentToOrder.putExtra("giasach_order", sach.getDongiaban());
            intentToOrder.putExtra("soluongton_order", sach.getSoluongton());
            startActivity(intentToOrder, options.toBundle());
        }
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

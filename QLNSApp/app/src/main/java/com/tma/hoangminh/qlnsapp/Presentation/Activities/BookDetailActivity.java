package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.ImageView;

import com.tma.hoangminh.qlnsapp.Presentation.Adapters.BookDetailAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.BookDetailPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.BookDetailView;
import com.tma.hoangminh.qlnsapp.R;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity implements BookDetailView {
    private RecyclerView myRecyclerViewDetail;
    private RecyclerView.LayoutManager myManagerDetail;
    private BookDetailAdapter bookDetailAdapter;
    private ArrayList<Integer> imageList;
    private Intent myIntent;
    private int mypos;
    private ImageView myImageBack;
    private BookDetailPresenter presenter;

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
        myImageBack = (ImageView) findViewById(R.id.imageBack);
        myRecyclerViewDetail = (RecyclerView) findViewById(R.id.recycler_view_bookdetail);
        myRecyclerViewDetail.setHasFixedSize(true);
        myManagerDetail = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewDetail.setLayoutManager(myManagerDetail);
        myRecyclerViewDetail.setNestedScrollingEnabled(false);
        bookDetailAdapter = new BookDetailAdapter(imageList);
        myRecyclerViewDetail.setAdapter(bookDetailAdapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(myRecyclerViewDetail);
        myIntent = getIntent();
        mypos = myIntent.getIntExtra("pos", 0);
        myRecyclerViewDetail.smoothScrollToPosition(mypos);
    }

    public void Listener(){
        myImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPressBack();
            }
        });
    }

    @Override
    public void navigationBack() {
        finish();
    }
}

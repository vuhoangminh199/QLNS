package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tma.hoangminh.qlnsapp.Presentation.Adapters.BookGridAdapter;
import com.tma.hoangminh.qlnsapp.R;

import java.util.ArrayList;

public class BookGridAcitivity extends AppCompatActivity {
    private RecyclerView myRecyclerViewGrid;
    private RecyclerView.LayoutManager myManagerGrid;
    private BookGridAdapter bookGridAdapter;
    private ArrayList<Integer> imageList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_book);
        Init();
    }

    public void Init(){
        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        myRecyclerViewGrid = (RecyclerView) findViewById(R.id.recycler_view_grid);
        myManagerGrid = new GridLayoutManager(this, 4);
        myRecyclerViewGrid.setHasFixedSize(true);
        myRecyclerViewGrid.setLayoutManager(myManagerGrid);
        myRecyclerViewGrid.setNestedScrollingEnabled(false);
        bookGridAdapter = new BookGridAdapter(imageList);
        myRecyclerViewGrid.setAdapter(bookGridAdapter);
    }
}

package com.tma.hoangminh.qlnsapp.Presentation.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.TypeBookApdater;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.TypeBookPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.TypeBookView;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;

public class TypeBookActivity extends AppCompatActivity implements TypeBookView{
    private ListView myTypeList;
    private TypeBookApdater myTypeAdapter;
    private TypeBookPresenter presenter;
    private ProgressBar progressBar;
    private List<Sach> myListSach;
    private Intent myIntent;
    private String matl;
    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_book);
        Init();
        Listener();
    }

    public void Init(){
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.statusBar);
        myTypeList = (ListView) findViewById(R.id.listview_type);
        progressBar = (ProgressBar) findViewById(R.id.progressbar_type);
        myIntent = getIntent();
        matl = myIntent.getStringExtra("matl");
        presenter = new TypeBookPresenter(this);
        presenter.SetUpTypeBook(matl);
        progressBar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left);
        getSupportActionBar().setTitle("");
    }

    public void Listener(){
        myTypeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentToDetailBook = new Intent(TypeBookActivity.this, BookDetailActivity.class);
                intentToDetailBook.putExtra("pos", i);
                intentToDetailBook.putExtra("masach", myListSach.get(i).getMasach());
                startActivity(intentToDetailBook);
            }
        });
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void SetUpTypeBook(List<Sach> listBook) {
        myTypeAdapter = new TypeBookApdater(this,listBook);
        myTypeList.setAdapter(myTypeAdapter);
        myListSach = listBook;
        progressBar.setVisibility(View.GONE);
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
}

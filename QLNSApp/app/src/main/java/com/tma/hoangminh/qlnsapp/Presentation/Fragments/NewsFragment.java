package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Activities.BookDetailActivity;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.NewsAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.NewsPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.NewsView;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;

public class NewsFragment extends android.support.v4.app.Fragment implements NewsView {
    private ListView myNewsList;
    private NewsAdapter myNewsListAdapter;
    private View view;
    private NewsPresenter presenter;
    private ProgressBar progressBar;
    private List<Sach> myListSach;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        Init();
        Listener();
        return view;
    }

    public void Init(){
        myNewsList = view.findViewById(R.id.listview_news);
        progressBar = view.findViewById(R.id.progressbar_news);
        presenter = new NewsPresenter(NewsFragment.this);
        progressBar.setVisibility(View.VISIBLE);
        presenter.SetUpListBook();
    }

    public void Listener(){
        myNewsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentToDetailBook = new Intent(NewsFragment.this.getContext(), BookDetailActivity.class);
                intentToDetailBook.putExtra("pos", i);
                intentToDetailBook.putExtra("masach", myListSach.get(i).getMasach());
                startActivity(intentToDetailBook);
            }
        });
    }
    @Override
    public void SetUpListBook(List<Sach> listBook) {
        myNewsListAdapter = new NewsAdapter(NewsFragment.this.getContext(), listBook);
        myNewsList.setAdapter(myNewsListAdapter);
        myListSach = listBook;
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void SetUpListBookHot(List<Sach> listBook) {

    }
}

package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Domain.UseCase.GetListBookUseCase;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.NewsAdapter;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;

public class NewsFragment extends android.support.v4.app.Fragment {
    private ListView myNewsList;
    private NewsAdapter myNewsListAdapter;
    private List<Sach> mySachList;
    private GetListBookUseCase useCase;
    private View view;
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
        return view;
    }

    public void Init(){
        useCase = new GetListBookUseCase();
        mySachList = useCase.getBookList();
        myNewsList = view.findViewById(R.id.listview_news);
        myNewsListAdapter = new NewsAdapter(NewsFragment.this.getContext(), mySachList);
        myNewsList.setAdapter(myNewsListAdapter);
    }
}

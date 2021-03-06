package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Domain.UseCase.GetListBookUseCase;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.SearchListAdapter;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;

public class SearchFragment extends android.support.v4.app.Fragment {
    private ListView mySearchList;
    private SearchListAdapter mySearchListAdapter;
    private List<Sach> mySachList;
    private GetListBookUseCase useCase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        Init();
        mySearchList = view.findViewById(R.id.listview_search);
        mySearchListAdapter = new SearchListAdapter(SearchFragment.this.getContext(), mySachList);
        mySearchList.setAdapter(mySearchListAdapter);
        return view;
    }

    public void Init(){
        useCase = new GetListBookUseCase();
        mySachList = useCase.getBookList();
    }
}

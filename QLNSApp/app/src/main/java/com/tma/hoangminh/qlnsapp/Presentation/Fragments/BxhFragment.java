package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Activities.BookDetailActivity;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.BxhAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.BxhPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.BxhView;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;


public class BxhFragment extends android.support.v4.app.Fragment implements BxhView{
    private ListView myListView;
    private View view;
    private BxhAdapter adapter;
    private List<Sach> listBook;
    private BxhPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Bảng Xếp Hạng");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bxh, container, false);
        Init();
        Listener();
        return view;
    }

    public void Init(){
        myListView = view.findViewById(R.id.list_view_bxh);
        presenter = new BxhPresenter(this);
        presenter.SetUpListBookHot();
    }

    public void Listener(){
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentToDetailBook = new Intent(BxhFragment.this.getContext(), BookDetailActivity.class);
                intentToDetailBook.putExtra("pos", i);
                intentToDetailBook.putExtra("masach", listBook.get(i).getMasach());
                startActivity(intentToDetailBook);
            }
        });
    }

    @Override
    public void SetUpListBook(List<Sach> sachList) {
        listBook = sachList;
        adapter = new BxhAdapter(BxhFragment.this.getContext(), sachList);
        myListView.setAdapter(adapter);
    }
}

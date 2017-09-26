package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.ChonLocAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.HotAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.PhatHanhAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.ThichAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.NewsPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.NewsView;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;

public class MainFragment extends android.support.v4.app.Fragment implements NewsView {

    private ViewFlipper mViewFlipper;
    private RecyclerView myRecyclerViewChonLoc, myRecyclerViewPhatHanh, myRecyclerViewHot, myRecyclerViewThich;
    private RecyclerView.LayoutManager myManagerChonLoc, myManagerPhatHanh, myManagerHot, myManagerThich;
    private ChonLocAdapter myAdapterChonLoc;
    private PhatHanhAdapter myAdapterPhatHanh;
    private HotAdapter myAdapterHot;
    private ThichAdapter myAdapterThich;
    private NewsPresenter presenter;
    private ProgressBar progressBarChonLoc, progressBarHot, progressBarPhatHanh, progressBarThich;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        Init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewFlipper = view.findViewById(R.id.view_flipper);
        myRecyclerViewChonLoc = view.findViewById(R.id.recycler_view);
        myRecyclerViewPhatHanh =(RecyclerView) view.findViewById(R.id.recycler_view_phathanh);
        myRecyclerViewHot = view.findViewById(R.id.recycler_view_hot);
        myRecyclerViewThich = view.findViewById(R.id.recycler_view_thich);
        progressBarChonLoc = view.findViewById(R.id.progressbar_chonloc);
        progressBarHot = view.findViewById(R.id.progressbar_hot);
        progressBarPhatHanh = view.findViewById(R.id.progressbar_phathanh);
        progressBarThich = view.findViewById(R.id.progressbar_thich);
        progressBarChonLoc.setVisibility(View.VISIBLE);
        progressBarPhatHanh.setVisibility(View.VISIBLE);
        progressBarHot.setVisibility(View.VISIBLE);
        progressBarThich.setVisibility(View.VISIBLE);

        myRecyclerViewChonLoc.setVisibility(View.GONE);
        myRecyclerViewPhatHanh.setVisibility(View.GONE);
        myRecyclerViewHot.setVisibility(View.GONE);
        myRecyclerViewThich.setVisibility(View.GONE);


        SetUpFlipper();

        SetUpAdapter();
        return view;
    }

    public void Init(){
        presenter = new NewsPresenter(MainFragment.this);
        presenter.SetUpListBook();
        presenter.SetUpListBookHot();
    }

    public void SetUpAdapter(){
         /*-Chon Loc Adapter-*/
        myRecyclerViewChonLoc.setHasFixedSize(true);
        myManagerChonLoc = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewChonLoc.setLayoutManager(myManagerChonLoc);
        myRecyclerViewChonLoc.setNestedScrollingEnabled(false);


        /*-Phat Hanh Adapter-*/
        myRecyclerViewPhatHanh.setHasFixedSize(true);
        myManagerPhatHanh = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewPhatHanh.setLayoutManager(myManagerPhatHanh);
        myRecyclerViewPhatHanh.setNestedScrollingEnabled(false);


         /*-Hot Adapter-*/
        myRecyclerViewHot.setHasFixedSize(true);
        myManagerHot = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewHot.setLayoutManager(myManagerHot);
        myRecyclerViewHot.setNestedScrollingEnabled(false);

         /*-Thich Adapter-*/
        myRecyclerViewThich.setHasFixedSize(true);
        myManagerThich = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewThich.setLayoutManager(myManagerThich);
        myRecyclerViewThich.setNestedScrollingEnabled(false);

    }

    public void SetUpFlipper(){
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(3500);
        mViewFlipper.startFlipping();
        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.in_from_left));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.out_from_left));
        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.in_from_right));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainFragment.this.getContext(), R.anim.out_from_right));
    }

    @Override
    public void SetUpListBook(List<Sach> listBook) {
        myAdapterChonLoc = new ChonLocAdapter(getContext(),listBook);
        myRecyclerViewChonLoc.setAdapter(myAdapterChonLoc);
        myAdapterThich = new ThichAdapter(getContext(), listBook);
        myRecyclerViewThich.setAdapter(myAdapterThich);
        myAdapterHot = new HotAdapter(getContext(), listBook);
        myRecyclerViewHot.setAdapter(myAdapterHot);
        progressBarChonLoc.setVisibility(View.GONE);
        progressBarHot.setVisibility(View.GONE);
        progressBarThich.setVisibility(View.GONE);
        myRecyclerViewChonLoc.setVisibility(View.VISIBLE);
        myRecyclerViewHot.setVisibility(View.VISIBLE);
        myRecyclerViewThich.setVisibility(View.VISIBLE);
    }

    @Override
    public void SetUpListBookHot(List<Sach> listBook) {
        myAdapterPhatHanh = new PhatHanhAdapter(listBook);
        myRecyclerViewPhatHanh.setAdapter(myAdapterPhatHanh);
        myRecyclerViewPhatHanh.setVisibility(View.VISIBLE);
        progressBarPhatHanh.setVisibility(View.GONE);
    }
}

package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.tma.hoangminh.qlnsapp.Presentation.Adapters.BanChayAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.ChonLocAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.HotAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.PhatHanhAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.ThichAdapter;
import com.tma.hoangminh.qlnsapp.R;

import java.util.ArrayList;

public class MainFragment extends android.support.v4.app.Fragment {

    private ViewFlipper mViewFlipper;
    private RecyclerView myRecyclerViewChonLoc, myRecyclerViewPhatHanh, myRecyclerViewHot, myRecyclerViewBanChay, myRecyclerViewThich;
    private RecyclerView.LayoutManager myManagerChonLoc, myManagerPhatHanh, myManagerHot, myManagerBanChay, myManagerThich;
    private ChonLocAdapter myAdapterChonLoc;
    private PhatHanhAdapter myAdapterPhatHanh;
    private HotAdapter myAdapterHot;
    private BanChayAdapter myAdapterBanChay;
    private ThichAdapter myAdapterThich;
    private ArrayList<Integer> imageList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewFlipper = view.findViewById(R.id.view_flipper);
        myRecyclerViewChonLoc = view.findViewById(R.id.recycler_view);
        myRecyclerViewPhatHanh = view.findViewById(R.id.recycler_view_phathanh);
        myRecyclerViewHot = view.findViewById(R.id.recycler_view_hot);
        myRecyclerViewBanChay = view.findViewById(R.id.recycler_view_banchay);
        myRecyclerViewThich = view.findViewById(R.id.recycler_view_thich);
        SetUpFlipper();
        Init();
        SetUpAdapter();
        return view;
    }

    public void Init(){
        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);
        imageList.add(R.drawable.ic_booksplash);

    }

    public void SetUpAdapter(){
         /*-Chon Loc Adapter-*/
        myRecyclerViewChonLoc.setHasFixedSize(true);
        myManagerChonLoc = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewChonLoc.setLayoutManager(myManagerChonLoc);
        myRecyclerViewChonLoc.setNestedScrollingEnabled(false);
        myAdapterChonLoc = new ChonLocAdapter(imageList);
        myRecyclerViewChonLoc.setAdapter(myAdapterChonLoc);

        /*-Phat Hanh Adapter-*/
        myRecyclerViewPhatHanh.setHasFixedSize(true);
        myManagerPhatHanh = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewPhatHanh.setLayoutManager(myManagerPhatHanh);
        myRecyclerViewPhatHanh.setNestedScrollingEnabled(false);
        myAdapterPhatHanh = new PhatHanhAdapter(imageList);
        myRecyclerViewPhatHanh.setAdapter(myAdapterPhatHanh);

         /*-Hot Adapter-*/
        myRecyclerViewHot.setHasFixedSize(true);
        myManagerHot = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewHot.setLayoutManager(myManagerHot);
        myRecyclerViewHot.setNestedScrollingEnabled(false);
        myAdapterHot = new HotAdapter(imageList);
        myRecyclerViewHot.setAdapter(myAdapterHot);

         /*-Ban Chay Adapter-*/
        myRecyclerViewBanChay.setHasFixedSize(true);
        myManagerBanChay = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewBanChay.setLayoutManager(myManagerBanChay);
        myRecyclerViewBanChay.setNestedScrollingEnabled(false);
        myAdapterBanChay = new BanChayAdapter(imageList);
        myRecyclerViewBanChay.setAdapter(myAdapterBanChay);

         /*-Thich Adapter-*/
        myRecyclerViewThich.setHasFixedSize(true);
        myManagerThich = new LinearLayoutManager(MainFragment.this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewThich.setLayoutManager(myManagerThich);
        myRecyclerViewThich.setNestedScrollingEnabled(false);
        myAdapterThich = new ThichAdapter(imageList);
        myRecyclerViewThich.setAdapter(myAdapterThich);
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
}

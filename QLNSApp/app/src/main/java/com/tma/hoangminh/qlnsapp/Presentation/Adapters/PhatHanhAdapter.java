package com.tma.hoangminh.qlnsapp.Presentation.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tma.hoangminh.qlnsapp.Presentation.Activities.BookDetailActivity;
import com.tma.hoangminh.qlnsapp.R;

import java.util.ArrayList;

public class PhatHanhAdapter extends RecyclerView.Adapter<PhatHanhAdapter.ViewHolder> {

    private ArrayList<Integer> imageList;
    private int myPosition;
    private static final int key = 1;
    private Context myContext;

    public PhatHanhAdapter(ArrayList<Integer> imageList) {
        this.imageList = imageList;
    }

    @Override
    public PhatHanhAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_phathanh, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PhatHanhAdapter.ViewHolder holder, final int position) {
        holder.myImage.setImageResource(imageList.get(position));
        holder.myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDetail = new Intent(myContext, BookDetailActivity.class);
                intentToDetail.putExtra("pos",position);
                ((Activity)myContext).startActivityForResult(intentToDetail, key);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView myImage;

        public ViewHolder(View itemView) {
            super(itemView);
            myContext = itemView.getContext();
            myImage = itemView.findViewById(R.id.image_phathanh);
        }
    }
}

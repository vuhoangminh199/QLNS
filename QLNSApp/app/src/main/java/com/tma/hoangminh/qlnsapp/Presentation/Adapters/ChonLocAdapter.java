package com.tma.hoangminh.qlnsapp.Presentation.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Activities.BookDetailActivity;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChonLocAdapter extends RecyclerView.Adapter<ChonLocAdapter.ViewHolder> {

    private List<Sach> listBook;
    private Context context;
    private static final int key = 1;

    public ChonLocAdapter(Context context, List<Sach> listBook) {
        this.listBook = listBook;
        this.context = context;
    }

    @Override
    public ChonLocAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_chonloc, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ChonLocAdapter.ViewHolder holder, final int position) {
        long seed = System.nanoTime();
        Collections.shuffle(listBook, new Random(seed));
        try {
            URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHImage/" + listBook.get(position).getMasach());
            Glide.with(context).fromUrl().asBitmap().load(url).centerCrop().into(holder.myImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        holder.myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDetail = new Intent(context, BookDetailActivity.class);
                intentToDetail.putExtra("pos", position);
                intentToDetail.putExtra("masach", listBook.get(position).getMasach());
                ((Activity)context).startActivityForResult(intentToDetail, key);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView myImage;

        public ViewHolder(View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.image_chonloc);
        }
    }
}

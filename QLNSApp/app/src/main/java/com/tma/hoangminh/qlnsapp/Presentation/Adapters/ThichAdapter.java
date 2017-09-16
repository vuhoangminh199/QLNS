package com.tma.hoangminh.qlnsapp.Presentation.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tma.hoangminh.qlnsapp.R;

import java.util.ArrayList;


public class ThichAdapter extends RecyclerView.Adapter<ThichAdapter.ViewHolder> {

    private ArrayList<Integer> imageList;

    public ThichAdapter(ArrayList<Integer> imageList) {
        this.imageList = imageList;
    }

    @Override
    public ThichAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_phathanh, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ThichAdapter.ViewHolder holder, int position) {
        holder.myImage.setImageResource(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView myImage;

        public ViewHolder(View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.image_phathanh);
        }
    }
}

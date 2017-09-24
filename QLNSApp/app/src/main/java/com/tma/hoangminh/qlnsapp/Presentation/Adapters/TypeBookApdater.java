package com.tma.hoangminh.qlnsapp.Presentation.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TypeBookApdater extends BaseAdapter {

    private Context context;
    private List<Sach> bookList;
    private LayoutInflater inflater;

    public TypeBookApdater(Context context, List<Sach> bookList) {
        this.context = context;
        this.bookList = bookList;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int i) {
        return bookList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_row_news, null);
        ImageView imageBook = (ImageView) view.findViewById(R.id.image_news);
        TextView bookTitle = (TextView) view.findViewById(R.id.title_news);
        TextView bookDes = (TextView) view.findViewById(R.id.des_mes);
        try {
            URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHImage/" + bookList.get(i).getMasach());
            Glide.with(context).fromUrl().asBitmap().load(url).centerCrop().into(imageBook);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        bookTitle.setText(bookList.get(i).getTensach());
        bookDes.setText(bookList.get(i).getMota());
        return view;
    }
}

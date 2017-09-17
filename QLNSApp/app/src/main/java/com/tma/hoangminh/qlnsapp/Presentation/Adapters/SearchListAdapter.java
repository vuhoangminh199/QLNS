package com.tma.hoangminh.qlnsapp.Presentation.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;

public class SearchListAdapter extends BaseAdapter{

    private Context context;
    private List<Sach> bookList;
    private LayoutInflater inflater;

    public SearchListAdapter(Context context, List<Sach> bookList) {
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
        view = inflater.inflate(R.layout.item_search_list, null);
        ImageView imageBook = (ImageView) view.findViewById(R.id.imageBook);
        TextView bookTitle = (TextView) view.findViewById(R.id.bookTitle);
        TextView bookArt = (TextView) view.findViewById(R.id.bookArt);
        TextView bookprovide = (TextView) view.findViewById(R.id.bookProvide);
        //imageBook.setImageResource(bookList.get(i).getAnhbia());
        imageBook.setImageResource(R.drawable.ic_booksplash);
        bookTitle.setText(bookList.get(i).getTensach());
        bookArt.setText(bookList.get(i).getTacgia());
        bookprovide.setText(bookList.get(i).getNhaxuatban());
        return view;
    }
}

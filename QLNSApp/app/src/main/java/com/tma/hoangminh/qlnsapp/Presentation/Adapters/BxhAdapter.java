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

public class BxhAdapter extends BaseAdapter {

    private Context context;
    private List<Sach> bookList;
    private LayoutInflater inflater;

    public BxhAdapter(Context context, List<Sach> bookList) {
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
        if(i == 0){
            view = inflater.inflate(R.layout.fragment_bxh_first_item, null);
            ImageView imageBook = (ImageView) view.findViewById(R.id.imageview_FI);
            TextView title = (TextView) view.findViewById(R.id.title_FI);
            TextView art = (TextView) view.findViewById(R.id.art_FI);
            TextView provider = (TextView) view.findViewById(R.id.provider_FI);
            try {
                URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHImage/" + bookList.get(i).getMasach());
                Glide.with(context).fromUrl().asBitmap().load(url).centerCrop().into(imageBook);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            title.setText(bookList.get(i).getTensach());
            art.setText(bookList.get(i).getTacgia());
            provider.setText(bookList.get(i).getNhaxuatban());
            return view;
        } else {
            view = inflater.inflate(R.layout.fragment_bxh_second_item, null);
            ImageView imageBook = (ImageView) view.findViewById(R.id.imageview_SI);
            TextView title = (TextView) view.findViewById(R.id.textview_BTSI);
            TextView art = (TextView) view.findViewById(R.id.textview_ASI);
            TextView provider = (TextView) view.findViewById(R.id.textview_PSI);
            TextView number = (TextView) view.findViewById(R.id.second_counter);
            try {
                URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHImage/" + bookList.get(i).getMasach());
                Glide.with(context).fromUrl().asBitmap().load(url).centerCrop().into(imageBook);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            title.setText(bookList.get(i).getTensach());
            art.setText(bookList.get(i).getTacgia());
            provider.setText(bookList.get(i).getNhaxuatban());
            switch (i) {
                case 1:
                    number.setText("2");
                    break;
                case 2:
                    number.setText("3");
                    break;
                case 3:
                    number.setText("4");
                    break;
                case 4:
                    number.setText("5");
                    break;
                case 5:
                    number.setText("6");
                    break;
                case 6:
                    number.setText("7");
                    break;
                case 7:
                    number.setText("8");
                    break;
                case 8:
                    number.setText("9");
                    break;
                case 9:
                    number.setText("10");
                    break;
            }
            return view;
        }
    }
}

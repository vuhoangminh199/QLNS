package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import android.os.AsyncTask;

import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.BookMapping;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.BookService;
import com.tma.hoangminh.qlnsapp.Presentation.Views.BxhView;

import java.util.ArrayList;
import java.util.List;

public class BxhPresenter {
    private BxhView view;
    private List<Sach> listBook;
    private List<Sach> bxhBook;

    public BxhPresenter(BxhView view) {
        this.view = view;
    }

    public void SetUpListBookHot() {

        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {
                return new BookService().getListBookHot();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                listBook = new ArrayList<Sach>();
                bxhBook = new ArrayList<Sach>();
                listBook = new BookMapping().ParseBook(s);
                if (listBook != null){
                    if (listBook.size() > 0) {
                        for (int i = 0; i < 10; i++) {
                            bxhBook.add(listBook.get(i));
                        }
                        view.SetUpListBook(bxhBook);
                    }
                }
            }
        }.execute();
    }
}

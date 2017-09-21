package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import android.os.AsyncTask;

import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.BookMapping;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.BookService;
import com.tma.hoangminh.qlnsapp.Presentation.Views.NewsView;

import java.util.ArrayList;
import java.util.List;

public class NewsPresenter {

    private NewsView view;
    private List<Sach> listBook;
    public NewsPresenter(NewsView view) {
        this.view = view;
    }

    public void SetUpListBook(){

        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {
                return new BookService().getListBook();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                listBook = new ArrayList<Sach>();
                listBook = new BookMapping().ParseBook(s);
                if (listBook.size() > 0 ) {
                    view.SetUpListBook(listBook);
                }
            }
        }.execute();
    }

    public void SetUpListBookHot(){

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
                listBook = new BookMapping().ParseBook(s);
                if (listBook.size() > 0 ) {
                    view.SetUpListBookHot(listBook);
                }
            }
        }.execute();
    }
}

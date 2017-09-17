package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import com.tma.hoangminh.qlnsapp.Presentation.Views.BookDetailView;


public class BookDetailPresenter {
    private BookDetailView view;

    public BookDetailPresenter(BookDetailView view) {
        this.view = view;
    }

    public void onPressBack(){
        view.navigationBack();
    }
}

package com.tma.hoangminh.qlnsapp.Presentation.Views;

import android.content.Context;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import java.util.List;

public interface SearchView {
    Context getContext();
    void SetUpListBookHot(List<Sach> listBook);
    void ListBookByName(List<Sach> listBook);
}

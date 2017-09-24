package com.tma.hoangminh.qlnsapp.Presentation.Views;

import android.content.Context;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import java.util.List;

public interface TypeBookView {
    Context getContext();
    void SetUpTypeBook(List<Sach> listBook);

}

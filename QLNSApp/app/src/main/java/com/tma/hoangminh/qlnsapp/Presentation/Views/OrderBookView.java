package com.tma.hoangminh.qlnsapp.Presentation.Views;

import android.content.Context;

import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;

import java.util.List;

public interface OrderBookView {
    Context getContext();
    String getName();
    String getPhone();
    String getAddress();
    void navigatorToSuccess();
    void SetUpListDh(List<DatHang> listDh);

    void showErrorAddress(String mes);
    void hideErrorAddress();
    void showErrorPhone(String mes);
    void hideErrorPhone();
    void showErrorName(String mes);
    void hideErrorName();
}

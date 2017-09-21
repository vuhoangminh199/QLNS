package com.tma.hoangminh.qlnsapp.Presentation.Views;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import java.util.List;

public interface OrderBookView {
    String getName();
    String getPhone();
    String getAddress();
    void navigatorToSuccess();
    void SetUpListBook(List<Sach> listBook);

    void showErrorAddress(String mes);
    void hideErrorAddress();
    void showErrorPhone(String mes);
    void hideErrorPhone();
    void showErrorName(String mes);
    void hideErrorName();
}

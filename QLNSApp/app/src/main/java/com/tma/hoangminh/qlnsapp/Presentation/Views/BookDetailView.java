package com.tma.hoangminh.qlnsapp.Presentation.Views;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import java.util.List;

public interface BookDetailView {
    void navigationBack();
    void SetUpListBook(List<Sach> listBook);
    void navigateToOrder(Sach sach);
}

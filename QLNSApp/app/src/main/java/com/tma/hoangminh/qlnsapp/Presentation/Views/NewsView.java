package com.tma.hoangminh.qlnsapp.Presentation.Views;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import java.util.List;

public interface NewsView {
    void SetUpListBook(List<Sach> listBook);
    void SetUpListBookHot(List<Sach> listBook);
}

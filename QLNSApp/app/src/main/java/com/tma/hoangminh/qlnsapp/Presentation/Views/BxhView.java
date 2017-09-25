package com.tma.hoangminh.qlnsapp.Presentation.Views;

import android.content.Context;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import java.util.List;

public interface BxhView {
    Context getContext();
    void SetUpListBook(List<Sach> sachList);
}

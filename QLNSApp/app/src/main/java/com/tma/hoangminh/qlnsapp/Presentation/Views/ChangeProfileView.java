package com.tma.hoangminh.qlnsapp.Presentation.Views;

import android.content.Context;

public interface ChangeProfileView {
    String getName();
    String getOldPassword();
    String getNewPassword();
    String getCfNewPassword();
    String getTruePass();
    String getPhone();
    String getMaKH();
    String getTenKH();
    String getEmailKH();
    String getDiachiKH();
    Context getContext();
    boolean getStateCB();

    void navigationChangeSuccess(String name);
    void showErrorPasswordOld(String mes);
    void hideErrorPasswordOld();
    void showErrorPasswordNew(String mes);
    void hideErrorPasswordNew();
    void showErrorCfPasswordNew(String mes);
    void hideErrorCfPasswordNew();
    void showErrorName(String mes);
    void hideErrorName();

}

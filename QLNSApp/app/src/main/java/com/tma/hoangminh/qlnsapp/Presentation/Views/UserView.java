package com.tma.hoangminh.qlnsapp.Presentation.Views;

public interface UserView {
    String getPhonenumber();
    String getPassword();
    String getRPhonenumber();
    String getRPassword();
    String getRName();
    void navigationLoginSuccess(String name);
    void showErrorPassword(String mes);
    void hideErrorPassword();
    void showErrorPhone(String mes);
    void hideErrorPhone();
    void showLoginFail();

    void navigationRegisterSuccess(String name);
    void showErrorRPassword(String mes);
    void hideErrorRPassword();
    void showErrorRPhone(String mes);
    void hideErrorRPhone();
    void showErrorRName(String mes);
    void hideErrorRName();
    void showRegisterFail();
}

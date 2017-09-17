package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import com.tma.hoangminh.qlnsapp.Presentation.Views.UserView;

public class UserPresenter {
    private UserView view;

    public UserPresenter(UserView view) {
        this.view = view;
    }

    public void onPressLogin(){
       String phoneNumber = view.getPhonenumber();
       String password = view.getPassword();

       if(phoneNumber.isEmpty()){
           view.showErrorPhone("Không được trống");
       } else if (phoneNumber.length() < 10 || phoneNumber.length() > 12 ){
           view.showErrorPhone("Độ dài không phù hợp");
       }

       if(password.isEmpty()){
           view.showErrorPassword("Không được trống");
           return;
       } else if (password.length() < 6) {
           view.showErrorPassword("Mật khẩu không ít hơn 6 kí tự");
           return;
       }

       // boolean isLogin = service.login(phone,pass);

       if(phoneNumber.equals("0123456789") && password.equals("123123")){
           view.navigationLoginSuccess();
       } else {
           view.showLoginFail();
       }
    }

    public void onBackNormalText(boolean flag){
        if (flag){
            view.hideErrorPhone();
        } else {
            view.hideErrorPassword();
        }
    }

    public void onPressRegister(){
        String phoneNumber = view.getRPhonenumber();
        String password = view.getRPassword();
        String name = view.getRName();
        boolean checkIsValid = false;
        if(name.isEmpty()){
            view.showErrorRName("Không được trống");
            checkIsValid = true;
        } else if (name.length() < 6) {
            checkIsValid = true;
            view.showErrorRName("Mật khẩu không ít hơn 6 kí tự");
        }

        if(phoneNumber.isEmpty()){
            checkIsValid = true;
            view.showErrorRPhone("Không được trống");
        } else if (phoneNumber.length() < 10 || phoneNumber.length() > 12 ){
            view.showErrorRPhone("Độ dài không phù hợp");
            checkIsValid = true;
        }

        if(password.isEmpty()){
            checkIsValid = true;
            view.showErrorRPassword("Không được trống");
            return;
        } else if (password.length() < 6) {
            checkIsValid = true;
            view.showErrorRPassword("Mật khẩu không ít hơn 6 kí tự");
            return;
        }

        // boolean isLogin = service.login(phone,pass);
        if (!checkIsValid){
            view.navigationRegisterSuccess();
        } else {
            view.showRegisterFail();
        }

    }

    public void onBackNormalTextRegister(int flag){
        if (flag == 1){
            view.hideErrorRName();
        } else if (flag == 2) {
            view.hideErrorRPhone();
        } else {
            view.hideErrorRPassword();
        }
    }
}

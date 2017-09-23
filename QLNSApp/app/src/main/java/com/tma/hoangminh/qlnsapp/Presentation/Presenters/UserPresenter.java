package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tma.hoangminh.qlnsapp.Domain.Model.KhachHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.UserMapping;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.UserService;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.Presentation.Views.UserView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserPresenter {
    private UserView view;
    private KhachHang khachHang;

    public UserPresenter(UserView view) {
        this.view = view;
    }

    public void onPressLogin() {
        final String phoneNumber = view.getPhonenumber();
        final String password = view.getPassword();
        if (phoneNumber.isEmpty()) {
            view.showErrorPhone("Không được trống");
        } else if (phoneNumber.length() < 10 || phoneNumber.length() > 12) {
            view.showErrorPhone("Độ dài không phù hợp");
        }

        if (password.isEmpty()) {
            view.showErrorPassword("Không được trống");
            return;
        } else if (password.length() < 6) {
            view.showErrorPassword("Mật khẩu không ít hơn 6 kí tự");
            return;
        }

        // boolean isLogin = service.login(phone,pass);
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {
                return new UserService().LoginUser(phoneNumber, password);
                //return  new UserService().getUser();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                khachHang = new KhachHang();
                khachHang = new UserMapping().ParseUser(s);
                if (khachHang != null) {
                    new UserMapping().CommitInternalData(khachHang, (AppCompatActivity)view);
                    view.navigationLoginSuccess(khachHang.getTenkh());
                } else {
                    view.showLoginFail();
                }
            }
        }.execute();
    }

    public void onBackNormalText(boolean flag) {
        if (flag) {
            view.hideErrorPhone();
        } else {
            view.hideErrorPassword();
        }
    }

    public void onPressRegister() {
        final String phoneNumber = view.getRPhonenumber();
        final String password = view.getRPassword();
        String name = view.getRName();
        boolean checkIsValid = false;
        if (name.isEmpty()) {
            view.showErrorRName("Không được trống");
            checkIsValid = true;
        } else if (name.length() < 6) {
            checkIsValid = true;
            view.showErrorRName("Mật khẩu không ít hơn 6 kí tự");
        }

        if (phoneNumber.isEmpty()) {
            checkIsValid = true;
            view.showErrorRPhone("Không được trống");
        } else if (phoneNumber.length() < 10 || phoneNumber.length() > 12) {
            view.showErrorRPhone("Độ dài không phù hợp");
            checkIsValid = true;
        }

        if (password.isEmpty()) {
            checkIsValid = true;
            view.showErrorRPassword("Không được trống");
            return;
        } else if (password.length() < 6) {
            checkIsValid = true;
            view.showErrorRPassword("Mật khẩu không ít hơn 6 kí tự");
            return;
        }
        // boolean isLogin = service.login(phone,pass);
        if (!checkIsValid) {
            final KhachHang user = new KhachHang("123", name, "ABC", phoneNumber, "123", password);
//            new AsyncTask<Void, Void, Boolean>() {
//                @Override
//                protected Boolean doInBackground(Void... params) {
//                    return new UserService().PostUser(user);
//                }
//
//                @Override
//                protected void onPostExecute(Boolean s) {
//                    super.onPostExecute(s);
//                    if(s){
//                        Toast.makeText(((AppCompatActivity)view),"Dang ki thanh cong",Toast.LENGTH_SHORT).show();
//                        new UserMapping().CommitInternalData(user, (AppCompatActivity)view);
//                        view.navigationRegisterSuccess(user.getTenkh());
//                    } else {
//                        Toast.makeText(((AppCompatActivity)view),"Dang ki that bai vui long dang ki lai",Toast.LENGTH_SHORT).show();
//                        view.showRegisterFail();
//                    }
//                }
//            }.execute();
            RequestQueue queue = Volley.newRequestQueue((AppCompatActivity)view);
            String url = DrawerNavigationBar.URL + "KHACHHANGs/PostKHACHHANG";
            final HashMap<String, String> params = new HashMap<>();
            params.put("makh", user.getMakh());
            params.put("tenkh", user.getTenkh());
            params.put("diachi", user.getDiachi());
            params.put("sodienthoai", user.getSodienthoai());
            params.put("email", user.getEmail());
            params.put("matkhaukh", user.getMatkhaukh());
            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url,
                    new JSONObject(params), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Toast.makeText(((AppCompatActivity)view),"Dang ki thanh cong",Toast.LENGTH_SHORT).show();
                    new UserMapping().CommitInternalData(user, (AppCompatActivity)view);
                    view.navigationRegisterSuccess(user.getTenkh());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(((AppCompatActivity)view),"Dang ki that bai vui long dang ki lai",Toast.LENGTH_SHORT).show();
                    view.showRegisterFail();
                }
            }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Content-Type","application/json; charset=utf-8");
                    return params;
                }

            };
            VolleyLog.DEBUG = true;
            queue.add(stringRequest);
        } else {
            view.showRegisterFail();
        }

    }

    public void onBackNormalTextRegister(int flag) {
        if (flag == 1) {
            view.hideErrorRName();
        } else if (flag == 2) {
            view.hideErrorRPhone();
        } else {
            view.hideErrorRPassword();
        }
    }
}

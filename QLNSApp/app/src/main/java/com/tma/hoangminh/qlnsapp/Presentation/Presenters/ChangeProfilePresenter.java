package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tma.hoangminh.qlnsapp.Domain.Model.KhachHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.UserMapping;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.Presentation.Views.ChangeProfileView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeProfilePresenter {
    private ChangeProfileView view;
    private List<Sach> listBook;

    public ChangeProfilePresenter(ChangeProfileView view) {
        this.view = view;
    }

    public void onPressChange() {
        String name = view.getName();
        String oldpass = view.getOldPassword();
        String newpass = view.getNewPassword();
        String cfnewpass = view.getCfNewPassword();
        String truewpass = view.getTruePass();
        String phone = view.getPhone();
        String makh = view.getMaKH();
        String diachikh = view.getDiachiKH();
        String emailkh = view.getEmailKH();
        Boolean isCheck = view.getStateCB();
        boolean checkIsValid = false;

        if (isCheck) {
            if (name.isEmpty()) {
                view.showErrorName("Không được trống");
                checkIsValid = true;
            } else if (name.length() < 6) {
                checkIsValid = true;
                view.showErrorName("Tên không ít hơn 6 kí tự");
            }

            if (oldpass.isEmpty()) {
                checkIsValid = true;
                view.showErrorPasswordOld("Không được trống");
            } else if (oldpass.length() < 6) {
                view.showErrorPasswordOld("Mật khẩu không ít hơn 6 kí tự");
                checkIsValid = true;
            } else if (!truewpass.equals(oldpass.toString())) {
                checkIsValid = true;
                view.showErrorPasswordOld("Mật khẩu không đúng");
            }

            if (newpass.isEmpty()) {
                checkIsValid = true;
                view.showErrorPasswordNew("Không được trống");
                return;
            } else if (newpass.length() < 6) {
                checkIsValid = true;
                view.showErrorPasswordNew("Mật khẩu không ít hơn 6 kí tự");
                return;
            }

            if (cfnewpass.isEmpty()) {
                checkIsValid = true;
                view.showErrorCfPasswordNew("Không được trống");
                return;
            } else if (!cfnewpass.equals(newpass)) {
                checkIsValid = true;
                view.showErrorCfPasswordNew("Mật khẩu xác nhận không đúng");
                return;
            }

            if (!checkIsValid) {
                final KhachHang user = new KhachHang(makh, name, diachikh, phone, emailkh, newpass);

                RequestQueue queue = Volley.newRequestQueue((AppCompatActivity) view);
                String url = DrawerNavigationBar.URL + "KHACHHANGs/PutKHACHHANG/" + makh;
                final HashMap<String, String> params = new HashMap<>();
                params.put("makh", user.getMakh());
                params.put("tenkh", user.getTenkh());
                params.put("diachi", user.getDiachi());
                params.put("sodienthoai", user.getSodienthoai());
                params.put("email", user.getEmail());
                params.put("matkhaukh", user.getMatkhaukh());
                JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.PUT, url,
                        new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(((AppCompatActivity) view), "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                        new UserMapping().CommitInternalData(user, (AppCompatActivity) view);
                        view.navigationChangeSuccess(user.getTenkh());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(((AppCompatActivity) view), "Lưu Thất Bại Quay Lại Sau", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                        try {
                            String jsonString = new String(response.data,
                                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));

                            JSONObject result = null;

                            if (jsonString != null && jsonString.length() > 0)
                                result = new JSONObject(jsonString);

                            return Response.success(result,
                                    HttpHeaderParser.parseCacheHeaders(response));
                        } catch (UnsupportedEncodingException e) {
                            return Response.error(new ParseError(e));
                        } catch (JSONException je) {
                            return Response.error(new ParseError(je));
                        }
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Content-Type", "application/json; charset=utf-8");
                        return params;
                    }

                };
                VolleyLog.DEBUG = true;
                queue.add(stringRequest);
            }
        } else {
            if (name.isEmpty()) {
                view.showErrorName("Không được trống");
                checkIsValid = true;
            } else if (name.length() < 6) {
                checkIsValid = true;
                view.showErrorName("Tên không ít hơn 6 kí tự");
            }
            if (!checkIsValid) {
                final KhachHang user = new KhachHang(makh, name, diachikh, phone, emailkh, truewpass);

                RequestQueue queue = Volley.newRequestQueue((AppCompatActivity) view);
                String url = DrawerNavigationBar.URL + "KHACHHANGs/PutKHACHHANG/" + makh;
                final HashMap<String, String> params = new HashMap<>();
                params.put("makh", user.getMakh());
                params.put("tenkh", user.getTenkh());
                params.put("diachi", user.getDiachi());
                params.put("sodienthoai", user.getSodienthoai());
                params.put("email", user.getEmail());
                params.put("matkhaukh", user.getMatkhaukh());
                JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.PUT, url,
                        new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(((AppCompatActivity) view), "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                        new UserMapping().CommitInternalData(user, (AppCompatActivity) view);
                        view.navigationChangeSuccess(user.getTenkh());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(((AppCompatActivity) view), "Lưu Thất Bại Quay Lại Sau", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                        try {
                            String jsonString = new String(response.data,
                                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));

                            JSONObject result = null;

                            if (jsonString != null && jsonString.length() > 0)
                                result = new JSONObject(jsonString);

                            return Response.success(result,
                                    HttpHeaderParser.parseCacheHeaders(response));
                        } catch (UnsupportedEncodingException e) {
                            return Response.error(new ParseError(e));
                        } catch (JSONException je) {
                            return Response.error(new ParseError(je));
                        }
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Content-Type", "application/json; charset=utf-8");
                        return params;
                    }

                };
                VolleyLog.DEBUG = true;
                queue.add(stringRequest);
            }
        }
    }

    public void onBackNormalTextRegister(int flag) {
        if (flag == 1) {
            view.hideErrorName();
        } else if (flag == 2) {
            view.hideErrorPasswordOld();
        } else if (flag == 3) {
            view.hideErrorPasswordNew();
        } else if (flag == 4) {
            view.hideErrorCfPasswordNew();
        }
    }

}

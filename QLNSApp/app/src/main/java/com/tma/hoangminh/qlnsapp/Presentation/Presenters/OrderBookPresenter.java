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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tma.hoangminh.qlnsapp.Domain.Model.CT_DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.OrderMapping;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.OrderService;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.Presentation.Views.OrderBookView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBookPresenter {
    private OrderBookView view;
    private List<Sach> listBook;
    public OrderBookPresenter(OrderBookView view) {
        this.view = view;
    }

    public void onPressOrder(final DatHang datHang, final CT_DatHang ct_datHang){
        final String phoneNumber = view.getPhone();
        final String address = view.getAddress();
        String name = view.getName();
        boolean checkIsValid = false;
        if (name.isEmpty()) {
            view.showErrorName("Không được trống");
            checkIsValid = true;
        } else if (name.length() < 6) {
            checkIsValid = true;
            view.showErrorName("Tên không ít hơn 6 kí tự");
        }

        if (phoneNumber.isEmpty()) {
            checkIsValid = true;
            view.showErrorPhone("Không được trống");
        } else if (phoneNumber.length() < 10 || phoneNumber.length() > 12) {
            view.showErrorPhone("Độ dài không phù hợp(10-12)");
            checkIsValid = true;
        }

        if (address.isEmpty()) {
            checkIsValid = true;
            view.showErrorAddress("Không được trống");
            return;
        }

        if (!checkIsValid) {
            new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected Boolean doInBackground(Void... params) {
                    return new OrderService().PostOrder(datHang);
                }

                @Override
                protected void onPostExecute(Boolean s) {
                    super.onPostExecute(s);
                    if(s){
                        RequestQueue queue = Volley.newRequestQueue(view.getContext());
                        String url = DrawerNavigationBar.URL + "DATHANGs/GetDATHANGs";
                        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                OrderMapping orderMapping = new OrderMapping();
                                List<DatHang> datHangs=  orderMapping.DatHang(response);
                                RequestQueue queue = Volley.newRequestQueue(view.getContext());
                                String url = DrawerNavigationBar.URL + "CT_DATHANGs/PostCT_DATHANG";


                                final HashMap<String, String> params = new HashMap<>();
                                params.put("madathang",datHangs.get(datHangs.size()-1).getMadathang());
                                params.put("masach", ct_datHang.getMasach());
                                params.put("soluongdat", ct_datHang.getSoluongdat()+"");
                                params.put("dongia", ct_datHang.getDongia()+"");
                                params.put("thanhtien", ct_datHang.getThanhtien()+"");
                                params.put("delflag", ct_datHang.getDelflag()+"");

                                JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url,
                                        new JSONObject(params), new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        view.navigatorToSuccess();
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText((AppCompatActivity) view, "Đã có lỗi Order Book", Toast.LENGTH_SHORT).show();
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
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText((AppCompatActivity)view,"Không load được list đặt hàng",Toast.LENGTH_SHORT).show();
                            }
                        }){
                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                Map<String,String> params = new HashMap<String, String>();
                                params.put("Content-Type","application/json; charset=utf-8");
                                return params;
                            }
                        };
                        queue.add(getRequest);
                    } else {
                        Toast.makeText((AppCompatActivity)view,"Đã có lỗi Order Book",Toast.LENGTH_SHORT).show();
                    }
                }
            }.execute();
        }


    }

    public void SetUpListDh(){

        RequestQueue queue = Volley.newRequestQueue(view.getContext());
            String url = DrawerNavigationBar.URL + "DATHANGs/GetDATHANGs";
            JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    OrderMapping orderMapping = new OrderMapping();
                    view.SetUpListDh(orderMapping.DatHang(response));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText((AppCompatActivity)view,"Không load được list đặt hàng",Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Content-Type","application/json; charset=utf-8");
                    return params;
                }
            };
            queue.add(getRequest);
    }

    public void onBackNormalText(int flag) {
        if (flag == 1) {
            view.hideErrorPhone();
        } else if(flag == 2) {
            view.hideErrorName();
        } else {
            view.hideErrorAddress();
        }
    }
}

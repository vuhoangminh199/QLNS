package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tma.hoangminh.qlnsapp.Domain.Model.CT_DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.BookMapping;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.BookService;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.OrderService;
import com.tma.hoangminh.qlnsapp.Presentation.Views.OrderBookView;

import java.util.ArrayList;
import java.util.List;

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
            view.showErrorPhone("Độ dài không phù hợp");
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
                        new AsyncTask<Void, Void, Boolean>() {
                            @Override
                            protected void onPreExecute() {
                                super.onPreExecute();
                            }

                            @Override
                            protected Boolean doInBackground(Void... params) {
                                return new OrderService().PostOrderDetail(ct_datHang);
                            }

                            @Override
                            protected void onPostExecute(Boolean s) {
                                super.onPostExecute(s);
                                if (s){
                                    view.navigatorToSuccess();
                                } else {
                                    Toast.makeText((AppCompatActivity)view,"Co loi OrderBookDetail",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }.execute();
                    } else {
                        Toast.makeText((AppCompatActivity)view,"Co loi OrderBook",Toast.LENGTH_SHORT).show();
                    }
                }
            }.execute();
        }
    }

    public void SetUpListBook(){

        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {
                return new BookService().getListBook();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                listBook = new ArrayList<Sach>();
                listBook = new BookMapping().ParseBook(s);
                if (listBook.size() > 0 ) {
                    view.SetUpListBook(listBook);
                }
            }
        }.execute();
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

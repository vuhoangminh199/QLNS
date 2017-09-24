package com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookMapping {

    public List<Sach> ParseBook(String id) {
        Sach book = null;
        List<Sach> listBook = new ArrayList<>();
        try {
            String masach, tensach, matheloai, anhbia, mota, nhaxuatban, tacgia, ngayxuatban;
            int dongiaban, luotmua, khuyenmai, soluongton, delflag;
            Boolean tinhtrang;
            if (id != null) {
                JSONArray array = new JSONArray(id);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    masach = object.getString("masach");
                    tensach = object.getString("tensach");
                    matheloai = object.getString("matheloai");
                    anhbia = object.getString("anhbia");
                    mota = object.getString("mota");
                    nhaxuatban = object.getString("nhaxuatban");
                    tacgia = object.getString("tacgia");
                    ngayxuatban = object.getString("ngayxuatban");
                    dongiaban = object.getInt("dongiaban");
                    luotmua = object.getInt("luotmua");
                    khuyenmai = object.getInt("khuyenmai");
                    soluongton = object.getInt("soluongton");
                    delflag = object.getInt("delflag");
                    tinhtrang = object.getBoolean("tinhtrang");

                    book = new Sach(masach, tensach, matheloai, anhbia, mota,
                            nhaxuatban, tacgia, ngayxuatban, dongiaban, luotmua, khuyenmai, soluongton, delflag, tinhtrang);
                    listBook.add(book);
                }
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listBook;
    }

    public List<Sach> ParseTypeBook(JSONArray array) {
        Sach book = null;
        List<Sach> listBook = new ArrayList<>();
        try {
            String masach, tensach, matheloai, anhbia, mota, nhaxuatban, tacgia, ngayxuatban;
            int dongiaban, luotmua, khuyenmai, soluongton, delflag;
            Boolean tinhtrang;
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    masach = object.getString("masach");
                    tensach = object.getString("tensach");
                    matheloai = object.getString("matheloai");
                    anhbia = object.getString("anhbia");
                    mota = object.getString("mota");
                    nhaxuatban = object.getString("nhaxuatban");
                    tacgia = object.getString("tacgia");
                    ngayxuatban = object.getString("ngayxuatban");
                    dongiaban = object.getInt("dongiaban");
                    luotmua = object.getInt("luotmua");
                    khuyenmai = object.getInt("khuyenmai");
                    soluongton = object.getInt("soluongton");
                    delflag = object.getInt("delflag");
                    tinhtrang = object.getBoolean("tinhtrang");

                    book = new Sach(masach, tensach, matheloai, anhbia, mota,
                            nhaxuatban, tacgia, ngayxuatban, dongiaban, luotmua, khuyenmai, soluongton, delflag, tinhtrang);
                    listBook.add(book);
                }
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listBook;
    }


}

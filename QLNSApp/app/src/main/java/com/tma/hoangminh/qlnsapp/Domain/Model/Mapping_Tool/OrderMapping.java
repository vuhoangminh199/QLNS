package com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool;

import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderMapping {
    public List<DatHang> DatHang(JSONArray arrayDathang){
        List<DatHang> datHangs = new ArrayList<>();
        String madathang, makh, sdt, diachi, ngaydat, ngaygiao;
        int tongdonhang;
        boolean tinhtrang;
        for (int i = 0; i < arrayDathang.length(); i++) {
            JSONObject object = null;
            try {
                object = arrayDathang.getJSONObject(i);
                madathang = object.getString("madathang");
                makh = object.getString("makh");
                sdt = object.getString("sdt");
                diachi = object.getString("diachi");
                ngaydat = object.getString("ngaydat");
                ngaygiao = object.getString("ngaygiao");
                tongdonhang = object.getInt("tongdonhang");
                tinhtrang = object.getBoolean("tinhtrang");

                DatHang dh = new DatHang(madathang, makh, sdt, diachi, ngaydat, ngaygiao, tongdonhang, tinhtrang);
                datHangs.add(dh);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return datHangs;
    }
}

package com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool;

import android.content.Context;
import android.content.SharedPreferences;

import com.tma.hoangminh.qlnsapp.Domain.Model.KhachHang;

import org.json.JSONException;
import org.json.JSONObject;

public class UserMapping {
    public KhachHang ParseUser(String user) {
        KhachHang user1 = null;
        try {
            String makh, tenkh, diachi, sodienthoai, email, matkhaukh;
            if (user != null) {
                JSONObject object = new JSONObject(user);
                makh = object.getString("makh");
                tenkh = object.getString("tenkh");
                diachi = object.getString("diachi");
                sodienthoai = object.getString("sodienthoai");
                email = object.getString("email");
                matkhaukh = object.getString("matkhaukh");
                user1 = new KhachHang(makh, tenkh, diachi, sodienthoai, email, matkhaukh);
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user1;
    }

    public void CommitInternalData(KhachHang khachHang, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("LOGGED", true);
        editor.putString("MAKH", khachHang.getMakh());
        editor.putString("TENKH", khachHang.getTenkh());
        editor.putString("DIACHI", khachHang.getDiachi());
        editor.putString("SODIENTHOAI", khachHang.getSodienthoai());
        editor.putString("EMAIL", khachHang.getEmail());
        editor.putString("MATKHAU", khachHang.getMatkhaukh());
        editor.commit();
    }

    public void CommitNullData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("LOGGED", false);
        editor.putString("MAKH", null);
        editor.putString("TENKH", null);
        editor.putString("DIACHI", null);
        editor.putString("SODIENTHOAI", null);
        editor.putString("EMAIL", null);
        editor.putString("MATKHAU", null);
        editor.commit();
    }
}

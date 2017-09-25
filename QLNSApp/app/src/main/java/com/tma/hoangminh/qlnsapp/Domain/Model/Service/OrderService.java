package com.tma.hoangminh.qlnsapp.Domain.Model.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.tma.hoangminh.qlnsapp.Domain.Model.CT_DatHang;
import com.tma.hoangminh.qlnsapp.Domain.Model.DatHang;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OrderService extends Service {
    public OrderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Boolean PostOrder(DatHang datHang) {
        String s = "";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(DrawerNavigationBar.URL + "DATHANGs/PostDATHANGs");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("madathang", datHang.getMadathang());
            jsonObject.put("makh", datHang.getMakh());
            jsonObject.put("sdt", datHang.getSdt());
            jsonObject.put("diachi", datHang.getDiachi());
            jsonObject.put("ngaydat", datHang.getNgaydat());
            jsonObject.put("ngaygiao", datHang.getNgaygiao());
            jsonObject.put("tongdonhang", datHang.getTongdonhang());
            jsonObject.put("tinhtrang", datHang.isTinhtrang());

            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();

            outputStream.close();
            bufferedWriter.close();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                connection.disconnect();
                return true;
            }
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            connection.disconnect();

        } catch (JSONException e) {
            e.printStackTrace();
            connection.disconnect();
        }
        return false;
    }

    public Boolean PostOrderDetail(CT_DatHang ctDatHang) {
        try {
            URL url = new URL(DrawerNavigationBar.URL + "CT_DATHANGs/PostCT_DATHANG");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("madathang", ctDatHang.getMadathang());
            jsonObject.put("masach", ctDatHang.getMasach());
            jsonObject.put("soluongdat", ctDatHang.getSoluongdat());
            jsonObject.put("dongia", ctDatHang.getDongia());
            jsonObject.put("thanhtien", ctDatHang.getThanhtien());
            jsonObject.put("delflag", ctDatHang.getDelflag());


            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();

            outputStream.close();
            bufferedWriter.close();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                connection.disconnect();
                return true;
            }
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }


}

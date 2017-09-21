package com.tma.hoangminh.qlnsapp.Domain.Model.Service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BookService extends Service {
    public BookService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getListBook() {
        String s = "";
        try {
            URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHes");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            Log.d("connection", connection.getResponseCode() + " co");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String temp = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    s += temp;
                }

                Log.d("json", s);

                inputStream.close();
                bufferedReader.close();
            }
            connection.disconnect();
            return s;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getListBookHot() {
        String s = "";
        try {
            URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHesHot");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            Log.d("connection", connection.getResponseCode() + " co");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String temp = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    s += temp;
                }

                Log.d("json", s);

                inputStream.close();
                bufferedReader.close();
            }
            connection.disconnect();
            return s;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getImage(int id, Handler handler) {
        try {
            URL url = new URL(DrawerNavigationBar.URL + "SACHes/GetSACHImage/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "image/jpeg");
            connection.connect();

            Log.d("connection", connection.getResponseCode() + "");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Bundle bundle = new Bundle();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                bundle.putByteArray("imageArray", outputStream.toByteArray());
                //bundle.putString("eventName", event.getName());
                Message message = new Message();
                message.setData(bundle);

                handler.sendMessage(message);
                outputStream.close();
                inputStream.close();
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Lấy hình ảnh
}

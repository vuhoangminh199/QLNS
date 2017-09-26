package com.tma.hoangminh.qlnsapp.Domain.Model.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tma.hoangminh.qlnsapp.Domain.Model.KhachHang;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UserService extends Service {
    public UserService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public KhachHang getUserWithID(String id) {
        String s = "";
        KhachHang user = new KhachHang();
        try {
            URL url = new URL("String url" + "Userrs/GetUserr/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            Log.d("connection", connection.getResponseCode() + " co"); //getUser dc ma`

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String temp = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    s += temp;
                }

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                user = gson.fromJson(s, KhachHang.class);

                inputStream.close();
                bufferedReader.close();
            }
            connection.disconnect();
            return user;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean PostUser(KhachHang user) {
        String s = "";
        try {
            URL url = new URL(DrawerNavigationBar.URL + "KHACHHANGs/PostKHACHHANG");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("makh", user.getMakh());
            jsonObject.put("tenkh", user.getTenkh());
            jsonObject.put("diachi", user.getDiachi());
            jsonObject.put("sodienthoai", user.getSodienthoai());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("matkhaukh", user.getMatkhaukh());

            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();

            outputStream.close();
            bufferedWriter.close();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
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

    public Boolean PutUser(String id, KhachHang user) {
        try {
            URL url = new URL(DrawerNavigationBar.URL + "KHACHHANGs/PutKHACHHANG/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("tenkh", user.getTenkh());
            jsonObject.put("diachi", user.getDiachi());
            jsonObject.put("sodienthoai", user.getSodienthoai());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("matkhaukh", user.getMatkhaukh());

            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
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

    public String LoginUser(String phone, String password) {
        String s = "";
        HttpURLConnection connection = null;
        try {

            URL url = new URL(DrawerNavigationBar.URL + "KHACHHANGs/Login/" + phone + "/" + password);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();

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
        } catch (IOException e1) {
            e1.printStackTrace();
            connection.disconnect();
        }

        return null;
    }
}

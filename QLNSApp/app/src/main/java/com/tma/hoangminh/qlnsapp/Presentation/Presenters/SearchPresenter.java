package com.tma.hoangminh.qlnsapp.Presentation.Presenters;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.tma.hoangminh.qlnsapp.Domain.Model.Mapping_Tool.BookMapping;
import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Domain.Model.Service.BookService;
import com.tma.hoangminh.qlnsapp.Presentation.Fragments.DrawerNavigationBar;
import com.tma.hoangminh.qlnsapp.Presentation.Views.SearchView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPresenter {
    private SearchView view;
    private List<Sach> listBook;

    public SearchPresenter(SearchView view) {
        this.view = view;
    }

    public void SetUpListBook(String name) {
        RequestQueue queue = Volley.newRequestQueue(view.getContext());
        String url = DrawerNavigationBar.URL + "SACHes/GetSACHesByName/" + name;
        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                BookMapping typeMapping = new BookMapping();
                view.ListBookByName(typeMapping.ParseTypeBook(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((AppCompatActivity) view, "Không load được list Book", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=utf-8");
                return params;
            }
        };
        queue.add(getRequest);
    }

    public void SetUpListBookHot() {

        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... params) {
                return new BookService().getListBookHot();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                listBook = new ArrayList<Sach>();
                listBook = new BookMapping().ParseBook(s);
                if (listBook != null) {
                    if (listBook.size() > 0) {
                        view.SetUpListBookHot(listBook);
                    }
                }

            }
        }.execute();
    }
}

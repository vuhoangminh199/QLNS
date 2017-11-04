package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tma.hoangminh.qlnsapp.Domain.Model.Sach;
import com.tma.hoangminh.qlnsapp.Presentation.Activities.BookDetailActivity;
import com.tma.hoangminh.qlnsapp.Presentation.Adapters.SearchListAdapter;
import com.tma.hoangminh.qlnsapp.Presentation.Presenters.SearchPresenter;
import com.tma.hoangminh.qlnsapp.Presentation.Views.SearchView;
import com.tma.hoangminh.qlnsapp.R;

import java.util.List;

public class SearchFragment extends android.support.v4.app.Fragment implements SearchView {
    private ListView mySearchList;
    private SearchListAdapter mySearchListAdapter;
    private List<Sach> mySachList;
    private EditText editSearch;
    private ImageView imageSearch;
    private View view;
    private SearchPresenter presenter;
    private LinearLayout layouttop, layoutbot, row1, row2, row3;
    private TextView txtrow1, txtrow2, txtrow3;
    private String marow1, marow2, marow3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        Init();
        Listener();
        return view;
    }

    public void Init() {
        mySearchList = view.findViewById(R.id.listview_search);
        mySearchList.setVisibility(View.GONE);
        editSearch = view.findViewById(R.id.edit_search);
        imageSearch = view.findViewById(R.id.image_search);
        layouttop = view.findViewById(R.id.layout_1);
        layoutbot = view.findViewById(R.id.layoutbot);
        row1 = view.findViewById(R.id.rows_1);
        row2 = view.findViewById(R.id.rows_2);
        row3 = view.findViewById(R.id.rows_3);

        txtrow1 = view.findViewById(R.id.txtrow1);
        txtrow2 = view.findViewById(R.id.txtrow2);
        txtrow3 = view.findViewById(R.id.txtrow3);

        layouttop.setVisibility(View.VISIBLE);
        presenter = new SearchPresenter(this);
        presenter.SetUpListBookHot();
    }

    public void Listener() {
        editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i == EditorInfo.IME_ACTION_DONE) || ((keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (keyEvent.getAction() == KeyEvent.ACTION_DOWN))) {
                    //handle press done
                    if (!editSearch.getText().toString().equals("")) {
                        SearchBookByName(editSearch.getText().toString());
                    }
                    return true;
                } else {
                    return false;
                }
            }
        });

        imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editSearch.getText().toString().equals("")) {
                    SearchBookByName(editSearch.getText().toString());
                }

            }
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editSearch.getText().toString().equals("") || editSearch.getText().toString() == null) {
                    mySearchList.setVisibility(View.GONE);
                    layouttop.setVisibility(View.VISIBLE);
                    layoutbot.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDetailBook = new Intent(SearchFragment.this.getContext(), BookDetailActivity.class);
                intentToDetailBook.putExtra("masach", marow1);
                startActivity(intentToDetailBook);
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDetailBook = new Intent(SearchFragment.this.getContext(), BookDetailActivity.class);
                intentToDetailBook.putExtra("masach", marow2);
                startActivity(intentToDetailBook);
            }
        });

        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDetailBook = new Intent(SearchFragment.this.getContext(), BookDetailActivity.class);
                intentToDetailBook.putExtra("masach", marow3);
                startActivity(intentToDetailBook);
            }
        });

        mySearchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentToDetailBook = new Intent(SearchFragment.this.getContext(), BookDetailActivity.class);
                intentToDetailBook.putExtra("pos", i);
                intentToDetailBook.putExtra("masach", mySachList.get(i).getMasach());
                startActivity(intentToDetailBook);
            }
        });
    }

    public void SearchBookByName(String name) {
        presenter.SetUpListBook(name);
    }

    @Override
    public void SetUpListBookHot(List<Sach> listBook) {
        String s1 = null, s2 = null, s3 = null;
        for (int i = 0; i < listBook.size(); i++) {
            if (i == 0) {
                s1 = listBook.get(i).getTensach();
                marow1 = listBook.get(i).getMasach();
            } else if (i == 1) {
                s2 = listBook.get(i).getTensach();
                marow2 = listBook.get(i).getMasach();
            } else if (i == 2) {
                s3 = listBook.get(i).getTensach();
                marow3 = listBook.get(i).getMasach();
            }
        }
        txtrow1.setText(s1);
        txtrow2.setText(s2);
        txtrow3.setText(s3);

    }

    @Override
    public void ListBookByName(List<Sach> listBook) {
        if(getActivity()!=null){
            if (listBook.size() > 0) {
                mySachList = listBook;
                mySearchListAdapter = new SearchListAdapter(getActivity(), listBook);
                mySearchList.setAdapter(mySearchListAdapter);
                mySearchList.setVisibility(View.VISIBLE);
                layouttop.setVisibility(View.GONE);
                layoutbot.setVisibility(View.GONE);
            } else {
                mySearchList.setVisibility(View.GONE);
                layouttop.setVisibility(View.GONE);
                layoutbot.setVisibility(View.VISIBLE);
            }
        }
    }
}

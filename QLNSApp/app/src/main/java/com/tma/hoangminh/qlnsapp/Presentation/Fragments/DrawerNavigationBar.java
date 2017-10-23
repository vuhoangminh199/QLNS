package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tma.hoangminh.qlnsapp.Presentation.Activities.TypeBookActivity;
import com.tma.hoangminh.qlnsapp.R;

import static com.tma.hoangminh.qlnsapp.R.drawable.search_uncheck;

public class DrawerNavigationBar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private MainFragment mainFragment;
    private BxhFragment bxhFragment;
    private UserFragment userFragment;
    private NewsFragment fourFragment;
    private SearchFragment searchFragment;
    private BottomNavigationView bottomNavigationView;
    public static String URL = "http://192.168.0.128:1909/api/";
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager.getActiveNetworkInfo() == null) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(DrawerNavigationBar.this);
                builder.setTitle("Thông Báo!!").setMessage("Bạn Hãy Bật 3G để tiếo tục!!!");

                builder.setPositiveButton("Thử Lại", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int i) {
                        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
                        registerReceiver(receiver, intentFilter);
                        if (connectivityManager.getActiveNetworkInfo() != null) {

                        }
                    }
                });
                builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface di, int i) {
                        System.exit(0);
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(false);
                dialog.show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_navigation_bar);
        Init();
    }

    public void Init() {
        mainFragment = new MainFragment();
        bxhFragment = new BxhFragment();
        userFragment = new UserFragment();
        fourFragment = new NewsFragment();
        searchFragment = new SearchFragment();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setItemIconTintList(null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        bottomNavigationView.setSelectedItemId(R.id.action_item1);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        android.support.v4.app.Fragment selectedFragment = mainFragment;
                        Menu menu = bottomNavigationView.getMenu();
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = mainFragment;
                                item.setIcon(R.drawable.ic_booksplash);
                                menu.findItem(R.id.action_item2).setIcon(R.drawable.bxh_uncheck);
                                menu.findItem(R.id.action_item3).setIcon(search_uncheck);
                                menu.findItem(R.id.action_item4).setIcon(R.drawable.news_uncheck);
                                menu.findItem(R.id.action_item5).setIcon(R.drawable.user_unchecked);
                                break;
                            case R.id.action_item2:
                                selectedFragment = bxhFragment;
                                item.setIcon(R.drawable.bxh);
                                menu.findItem(R.id.action_item1).setIcon(R.drawable.booksplash_uncheck);
                                menu.findItem(R.id.action_item3).setIcon(search_uncheck);
                                menu.findItem(R.id.action_item4).setIcon(R.drawable.news_uncheck);
                                menu.findItem(R.id.action_item5).setIcon(R.drawable.user_unchecked);

                                break;
                            case R.id.action_item3:
                                selectedFragment = searchFragment;
                                item.setIcon(R.drawable.search);
                                menu.findItem(R.id.action_item2).setIcon(R.drawable.bxh_uncheck);
                                menu.findItem(R.id.action_item1).setIcon(R.drawable.booksplash_uncheck);
                                menu.findItem(R.id.action_item4).setIcon(R.drawable.news_uncheck);
                                menu.findItem(R.id.action_item5).setIcon(R.drawable.user_unchecked);
                                break;
                            case R.id.action_item4:
                                selectedFragment = fourFragment;
                                item.setIcon(R.drawable.news);
                                menu.findItem(R.id.action_item2).setIcon(R.drawable.bxh_uncheck);
                                menu.findItem(R.id.action_item3).setIcon(search_uncheck);
                                menu.findItem(R.id.action_item1).setIcon(R.drawable.booksplash_uncheck);
                                menu.findItem(R.id.action_item5).setIcon(R.drawable.user_unchecked);

                                break;
                            case R.id.action_item5:
                                selectedFragment = userFragment;
                                item.setIcon(R.drawable.user);
                                menu.findItem(R.id.action_item2).setIcon(R.drawable.bxh_uncheck);
                                menu.findItem(R.id.action_item3).setIcon(search_uncheck);
                                menu.findItem(R.id.action_item4).setIcon(R.drawable.news_uncheck);
                                menu.findItem(R.id.action_item1).setIcon(R.drawable.booksplash_uncheck);
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, mainFragment);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {

        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Ấn BACK một lần nữa để thoát",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_haihuoc) {
            IntetnToType("TL01");
        } else if (id == R.id.nav_thieunhi) {
            IntetnToType("TL02");
        } else if (id == R.id.nav_langman) {
            IntetnToType("TL03");
        } else if (id == R.id.nav_phieuluu) {
            IntetnToType("TL04");
        } else if (id == R.id.nav_chuyennganh) {
            IntetnToType("TL05");
        } else if (id == R.id.nav_kinhdi) {
            IntetnToType("TL06");
        } else if (id == R.id.nav_congnghe) {
            IntetnToType("TL07");
        } else if (id == R.id.nav_nhanvan) {
            IntetnToType("TL08");
        } else if (id == R.id.nav_tuoimoilon) {
            IntetnToType("TL09");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);  // OPEN DRAWER
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void IntetnToType(String idtype) {
        Intent intent = new Intent(DrawerNavigationBar.this, TypeBookActivity.class);
        intent.putExtra("matl", idtype);
        startActivity(intent);
    }

}

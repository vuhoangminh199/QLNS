package com.tma.hoangminh.qlnsapp.Presentation.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.tma.hoangminh.qlnsapp.R;

import static com.tma.hoangminh.qlnsapp.R.drawable.search_uncheck;

public class DrawerNavigationBar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private MainFragment mainFragment;
    private TwoFragment twoFragment;
    private UserFragment userFragment;
    private NewsFragment fourFragment;
    private SearchFragment searchFragment;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_navigation_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Init();
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
                                selectedFragment = twoFragment;
                                item.setIcon(R.drawable.bxh);
                                menu.findItem(R.id.action_item1).setIcon(R.drawable.booksplash_uncheck);
                                menu.findItem(R.id.action_item3).setIcon(R.drawable.search_uncheck);
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
                                menu.findItem(R.id.action_item3).setIcon(R.drawable.search_uncheck);
                                menu.findItem(R.id.action_item1).setIcon(R.drawable.booksplash_uncheck);
                                menu.findItem(R.id.action_item5).setIcon(R.drawable.user_unchecked);

                                break;
                            case R.id.action_item5:
                                selectedFragment = userFragment;
                                item.setIcon(R.drawable.user);
                                menu.findItem(R.id.action_item2).setIcon(R.drawable.bxh_uncheck);
                                menu.findItem(R.id.action_item3).setIcon(R.drawable.search_uncheck);
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

        //Manually displaying the first fragment - one time only
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
    }

    public void Init(){
        mainFragment = new MainFragment();
        twoFragment = new TwoFragment();
        userFragment = new UserFragment();
        fourFragment = new NewsFragment();
        searchFragment = new SearchFragment();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cn) {
            // Handle the camera action
        } else if (id == R.id.nav_kn) {

        } else if (id == R.id.nav_tn) {

        } else if (id == R.id.nav_tt) {

        } else if (id == R.id.nav_vh) {

        } else if (id == R.id.nav_tml) {

        } else if (id == R.id.nav_truyentranh) {

        } else if (id == R.id.nav_snv) {

        } else if (id == R.id.nav_vhm) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

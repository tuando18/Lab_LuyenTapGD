package com.dovantuan.lab_luyentapgd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.dovantuan.lab_luyentapgd.Fragments.Frag_ThoiTiet;
import com.dovantuan.lab_luyentapgd.Fragments.Frag_TinTuc;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout layout_chinh_drawer;
    Toolbar mToolbarr;
    NavigationView main_navigation_view;
    Frag_TinTuc frag01;
    Frag_ThoiTiet frag02;

    BottomNavigationView bottom_nav;
    FragmentManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        layout_chinh_drawer = findViewById(R.id.layout_chinh_drawer002);
        mToolbarr = findViewById(R.id.mToolbarr);
        main_navigation_view = findViewById(R.id.main_navigation_view002);

        bottom_nav = findViewById(R.id.buttom_nav);

        setSupportActionBar(mToolbarr);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, layout_chinh_drawer, mToolbarr, R.string.open, R.string.close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        layout_chinh_drawer.addDrawerListener(drawerToggle);

        frag01 = new Frag_TinTuc();
        frag02 = new Frag_ThoiTiet();

        sm = getSupportFragmentManager();
        sm.beginTransaction().add(R.id.frag_container002, frag01).commit();

        main_navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mnu_tintuc) {
                    sm.beginTransaction().replace(R.id.frag_container002, frag01).commit();

                } else if (item.getItemId() == R.id.mnu_thoitiet) {
                    sm.beginTransaction().replace(R.id.frag_container002, frag02).commit();
                }
                getSupportActionBar().setTitle(item.getTitle());
                layout_chinh_drawer.close();
                return true;
            }
        });

        /// bottom nav
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mnu_tintuc) {
                    sm.beginTransaction().replace(R.id.frag_container002, frag01).commit();

                } else if (item.getItemId() == R.id.mnu_thoitiet) {
                    sm.beginTransaction().replace(R.id.frag_container002, frag02).commit();
                }
                getSupportActionBar().setTitle(item.getTitle());
                return true;
            }
        });

    }
}
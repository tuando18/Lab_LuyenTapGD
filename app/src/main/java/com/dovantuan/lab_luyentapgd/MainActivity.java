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
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout layout_chinh_drawer001;
    Toolbar mToolbar;
    NavigationView main_navigation_view001;
    FragmentManager sm;

    Frag_ThoiTiet bottom1;
    Frag_TinTuc bottom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        layout_chinh_drawer001 = findViewById(R.id.layout_chinh_drawer001);
        mToolbar = findViewById(R.id.mToolbar);
        main_navigation_view001 = findViewById(R.id.main_navigation_view001);
        // hiển thị actionbar:
        setSupportActionBar(mToolbar);

        // hiển thị toggle nav
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, layout_chinh_drawer001, mToolbar, R.string.open, R.string.close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        layout_chinh_drawer001.addDrawerListener(drawerToggle);

        bottom1 = new Frag_ThoiTiet();
        bottom2 = new Frag_TinTuc();

        sm  =getSupportFragmentManager();
        sm.beginTransaction().add(R.id.frag_container001,bottom1).commit();

        main_navigation_view001.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_danhba) {
                    sm.beginTransaction().replace(R.id.frag_container001, bottom1).commit();
                } else if (item.getItemId() == R.id.menu_maytinh) {
                    sm.beginTransaction().replace(R.id.frag_container001, bottom2).commit();
                }
                getSupportActionBar().setTitle(item.getTitle());
                layout_chinh_drawer001.close();
                return true;
            }
        });
    }
}
package com.dovantuan.lab_luyentapgd;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.dovantuan.lab_luyentapgd.Fragments.Frag_Backup;
import com.dovantuan.lab_luyentapgd.Fragments.Frag_DanhBa;
import com.dovantuan.lab_luyentapgd.Fragments.Frag_ThoiTiet;
import com.dovantuan.lab_luyentapgd.Fragments.Frag_TinTuc;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout layout_chinh_drawer001;
    Toolbar mToolbar;
    NavigationView main_navigation_view001;
    FragmentManager sm;

    Frag_TinTuc frag01;
    Frag_ThoiTiet frag02;

    Frag_DanhBa frag03;

    Frag_Backup frag04;

    BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        layout_chinh_drawer001 = findViewById(R.id.layout_chinh_drawer001);
        mToolbar = findViewById(R.id.mToolbar1);
        main_navigation_view001 = findViewById(R.id.main_navigation_view001);

        bottom_nav = findViewById(R.id.buttom_nav);
        // hiển thị actionbar:
        setSupportActionBar(mToolbar);

        // hiển thị toggle nav
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, layout_chinh_drawer001, mToolbar, R.string.open, R.string.close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        layout_chinh_drawer001.addDrawerListener(drawerToggle);

        frag01 = new Frag_TinTuc();
        frag02 = new Frag_ThoiTiet();
        frag03 = new Frag_DanhBa();
        frag04 = new Frag_Backup();

        sm = getSupportFragmentManager();
        sm.beginTransaction().add(R.id.frag_container001, frag01).commit();

        main_navigation_view001.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    sm.beginTransaction().replace(R.id.frag_container001, frag01).commit();
                } else if (item.getItemId() == R.id.menu_maytinh) {
                    sm.beginTransaction().replace(R.id.frag_container001, frag02).commit();
                } else if (item.getItemId() == R.id.menu_danhba) {
                    sm.beginTransaction().replace(R.id.frag_container001, frag03).commit();
                } else if (item.getItemId() == R.id.mnu_backup) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Thong Bao");
                    builder.setIcon(android.R.drawable.ic_delete);
                    builder.setMessage("Ban Co Dong Y Goi Activity Moi Khong ?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Dong Y ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(MainActivity.this, BackUpActivity.class));
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton("Khong Dong Y", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                getSupportActionBar().setTitle(item.getTitle());
                layout_chinh_drawer001.close();

                return true;
            }
        });

        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mnu_tintuc) {
                    sm.beginTransaction().replace(R.id.frag_container001, frag01).commit();

                } else if (item.getItemId() == R.id.mnu_thoitiet) {
                    sm.beginTransaction().replace(R.id.frag_container001, frag02).commit();
                }
                getSupportActionBar().setTitle(item.getTitle());
                return true;
            }
        });
    }
}
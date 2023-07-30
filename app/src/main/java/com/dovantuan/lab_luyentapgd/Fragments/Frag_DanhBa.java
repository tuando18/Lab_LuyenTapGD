//package com.dovantuan.lab_luyentapgd.Fragments;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.widget.Toolbar;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//
//import com.dovantuan.lab_luyentapgd.R;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationBarView;
//import com.google.android.material.navigation.NavigationView;
//
//public class Frag_DanhBa extends Fragment {
//    DrawerLayout layout_chinh_drawer;
//    Toolbar mToolbarr;
//    NavigationView main_navigation_view;
//    Frag_TinTuc frag01;
//    Frag_ThoiTiet frag02;
//
//    BottomNavigationView bottom_nav;
//    FragmentManager sm;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_bottom,null);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        layout_chinh_drawer = view.findViewById(R.id.layout_chinh_drawer002);
//        mToolbarr = view.findViewById(R.id.mToolbarr);
//        main_navigation_view = view.findViewById(R.id.main_navigation_view002);
//
//        bottom_nav = view.findViewById(R.id.buttom_nav);
//
//        setSupportActionBar(mToolbarr);
//
//
//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, layout_chinh_drawer, mToolbarr, R.string.open, R.string.close);
//        drawerToggle.setDrawerIndicatorEnabled(true);
//        drawerToggle.syncState();
//        layout_chinh_drawer.addDrawerListener(drawerToggle);
//
//        frag01 = new Frag_TinTuc();
//        frag02 = new Frag_ThoiTiet();
//
//        sm = getSupportFragmentManager();
//        sm.beginTransaction().add(R.id.frag_container002, frag01).commit();
//
//        main_navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.mnu_tintuc) {
//                    sm.beginTransaction().replace(R.id.frag_container002, frag01).commit();
//
//                } else if (item.getItemId() == R.id.mnu_thoitiet) {
//                    sm.beginTransaction().replace(R.id.frag_container002, frag02).commit();
//                }
//                getSupportActionBar().setTitle(item.getTitle());
//                layout_chinh_drawer.close();
//                return true;
//            }
//        });
//
//        /// bottom nav
//        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.mnu_tintuc) {
//                    sm.beginTransaction().replace(R.id.frag_container002, frag01).commit();
//
//                } else if (item.getItemId() == R.id.mnu_thoitiet) {
//                    sm.beginTransaction().replace(R.id.frag_container002, frag02).commit();
//                }
//                getSupportActionBar().setTitle(item.getTitle());
//                return true;
//            }
//        });
//    }
//}

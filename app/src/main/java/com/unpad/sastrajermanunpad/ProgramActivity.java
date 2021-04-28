package com.unpad.sastrajermanunpad;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

public class ProgramActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager2 view_pager2;
    ProgramFragmentAdapter fragment_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Program");

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        view_pager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        fragment_adapter = new ProgramFragmentAdapter(fm, getLifecycle());

        view_pager2.setUserInputEnabled(false);

        view_pager2.setAdapter(fragment_adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Program"));
        tabLayout.addTab(tabLayout.newTab().setText("Hubungan"));
        tabLayout.addTab(tabLayout.newTab().setText("Kerjasama Internasional"));
        tabLayout.addTab(tabLayout.newTab().setText("Kerjasama Nasional"));
        tabLayout.addTab(tabLayout.newTab().setText("Kegiatan Akademik"));
        tabLayout.addTab(tabLayout.newTab().setText("Pembinaan"));
        tabLayout.addTab(tabLayout.newTab().setText("Proses Pengembangan Kurikulum"));
        tabLayout.addTab(tabLayout.newTab().setText("Kurikulum"));
        tabLayout.addTab(tabLayout.newTab().setText("Mata Kuliah"));
        tabLayout.addTab(tabLayout.newTab().setText("Deskripsi Mata Kuliah"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        view_pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}
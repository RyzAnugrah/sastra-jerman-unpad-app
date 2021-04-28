package com.unpad.sastrajermanunpad;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    ViewPager2 view_pager2;
    HomeFragmentAdapter fragment_adapter;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);;

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

        view_pager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        fragment_adapter = new HomeFragmentAdapter(fm, getLifecycle());
        view_pager2.setAdapter(fragment_adapter);

        view_pager2.setUserInputEnabled(false);

        view_pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profil:
                Intent intent_profil = new Intent(this, ProfilActivity.class);
                startActivity(intent_profil);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfilFragment()).commit();
                break;
            case R.id.nav_program:
                Intent intent_program = new Intent(this, ProgramActivity.class);
                startActivity(intent_program);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProgramFragment()).commit();
                break;
            case R.id.nav_staf:
                Intent intent_staf = new Intent(this, StafActivity.class);
                startActivity(intent_staf);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StafFragment()).commit();
                break;
            case R.id.nav_mahasiswa:
                Intent intent_mahasiswa = new Intent(this, MahasiswaActivity.class);
                startActivity(intent_mahasiswa);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MahasiswaFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }
}
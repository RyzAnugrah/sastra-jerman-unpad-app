package com.unpad.sastrajermanunpad;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

public class PostActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager2 view_pager2;
    PostFragmentAdapter fragment_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Postingan");

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        view_pager2 = findViewById(R.id.view_pager2);

        view_pager2.setUserInputEnabled(false);

        FragmentManager fm = getSupportFragmentManager();
        fragment_adapter = new PostFragmentAdapter(fm, getLifecycle());
        view_pager2.setAdapter(fragment_adapter);
    }
}
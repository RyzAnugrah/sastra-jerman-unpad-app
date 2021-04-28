package com.unpad.sastrajermanunpad;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class StafFragmentAdapter extends FragmentStateAdapter {
    public StafFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new DosenFragment();
            case 2:
                return new PrestasiDosenFragment();
        }
        return new StafFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

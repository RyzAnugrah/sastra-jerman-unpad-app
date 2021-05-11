package com.unpad.sastrajermanunpad;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MahasiswaFragmentAdapter extends FragmentStateAdapter {
    public MahasiswaFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SkripsiMahasiswaFragment();
            case 2:
                return new KegiatanMahasiswaFragment();
            case 3:
                return new PrestasiMahasiswaFragment();
            case 4:
                return new MahasiswaBaruFragment();
        }
        return new MahasiswaFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

package com.unpad.sastrajermanunpad;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ProgramFragmentAdapter extends FragmentStateAdapter {
    public ProgramFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new HubunganFragment();
            case 2:
                return new KerjasamaInternasionalFragment();
            case 3:
                return new KerjasamaNasionalFragment();
            case 4:
                return new KegiatanFragment();
            case 5:
                return new PembinaanFragment();
            case 6:
                return new ProsesFragment();
            case 7:
                return new KurikulumFragment();
            case 8:
                return new KuliahFragment();
            case 9:
                return new DeskripsiKuliahFragment();
        }
        return new ProgramFragment();
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

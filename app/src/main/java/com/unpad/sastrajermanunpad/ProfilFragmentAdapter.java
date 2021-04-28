package com.unpad.sastrajermanunpad;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ProfilFragmentAdapter extends FragmentStateAdapter {
    public ProfilFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new VisiMisiFragment();
            case 2:
                return new TujuanFragment();
            case 3:
                return new SasaranFragment();
            case 4:
                return new CapaianFragment();
            case 5:
                return new KompetensiUtamaFragment();
            case 6:
                return new KompetensiPendukungFragment();
            case 7:
                return new KompetensiLainFragment();
            case 8:
                return new LulusanFragment();
        }
        return new ProfilFragment();
    }

    @Override
    public int getItemCount() {
        return 9;
    }
}

package com.fonzo.tfg.ui.micomercio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.fonzo.tfg.ui.micomercio.misproductos.MisProductosFragment;
import com.fonzo.tfg.ui.micomercio.pedidos.PedidosFragment;

public class MiComercioTabsAdapter extends FragmentStateAdapter {
    public MiComercioTabsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return MisProductosFragment.newInstance(1);
            default:
                return PedidosFragment.newInstance(1);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

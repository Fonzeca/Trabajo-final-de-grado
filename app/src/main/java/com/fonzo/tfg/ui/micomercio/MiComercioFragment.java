package com.fonzo.tfg.ui.micomercio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fonzo.tfg.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MiComercioFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    public MiComercioFragment() {
    }

    public static MiComercioFragment newInstance(String param1) {
        MiComercioFragment fragment = new MiComercioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mi_comercio, container, false);

        viewPager2 = view.findViewById(R.id.mi_comercio_view_pager);
        viewPager2.setAdapter(new MiComercioTabsAdapter(getActivity()));

        tabLayout = view.findViewById(R.id.mi_comercio_tab_layout);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(R.string.tab_layout_productos);
                        break;
                    default:
                        tab.setText(R.string.tab_layout_pedidos);
                        break;
                }
            }
        });
        mediator.attach();

        return view;
    }
}
package com.fonzo.tfg.ui.comercios;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ComercioView;
import com.fonzo.tfg.ui.TesisViewModelFactory;
import com.fonzo.tfg.ui.comercios.viewmodel.ComerciosViewModel;

import java.util.List;

public class ListaComerciosFragment extends Fragment {
    //TODO: Cambiar nombre a mas entendibles
    private ComerciosViewModel comerciosViewModel;
    private RecyclerView recyclerView;

    public ListaComerciosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comercios_list, container, false);
        //TODO: Mejorar el appbar ese
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.lista_comercios_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        comerciosViewModel = new ViewModelProvider(requireActivity(), new TesisViewModelFactory(getContext())).get(ComerciosViewModel.class);


        recyclerView.setAdapter(new ComercioRecyclerViewAdapter(null));

        //Observer para el cambio de la lista
        comerciosViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<ComercioView>>() {
            public void onChanged(List<ComercioView> comercioViews) {
                recyclerView.setAdapter(new ComercioRecyclerViewAdapter(comercioViews));
            }
        });

        //Busca los comercios
        comerciosViewModel.initComercios();
    }
}
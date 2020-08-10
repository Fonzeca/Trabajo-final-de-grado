package com.fonzo.tfg.ui.micomercio.misproductos;

import android.content.Context;
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
import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.ui.TesisViewModelFactory;
import com.fonzo.tfg.ui.producto.viewmodel.ProductosViewModel;

import java.util.List;

public class MisProductosFragment extends Fragment {

    private MisProductosViewModel viewModel;
    private RecyclerView recyclerView;

    public MisProductosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mis_productos_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity(), new TesisViewModelFactory(getContext())).get(MisProductosViewModel.class);

        viewModel.init();

        recyclerView = view.findViewById(R.id.lista_mis_productos_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        recyclerView.setAdapter(new MisProductosRecyclerViewAdapter(null));

        viewModel.getListaProductos().observe(getViewLifecycleOwner(), new Observer<List<ProductoView>>() {
            public void onChanged(List<ProductoView> productoViews) {
                recyclerView.setAdapter(new MisProductosRecyclerViewAdapter(productoViews));
            }
        });


    }
}
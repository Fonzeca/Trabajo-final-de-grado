package com.fonzo.tfg.ui.producto;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ComercioView;
import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.ui.TesisViewModelFactory;
import com.fonzo.tfg.ui.producto.viewmodel.ProductosViewModel;

import java.util.List;
import java.util.Objects;

public class ListaProductoFragment extends Fragment {

    private ProductosViewModel productosViewModel;
    private ComercioView comercioView;

    private TextView textToolbar;

    public ListaProductoFragment(ComercioView comercioView) {
        this.comercioView = comercioView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_productos_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productosViewModel = new ViewModelProvider(requireActivity(), new TesisViewModelFactory(getContext())).get(ProductosViewModel.class);

        textToolbar = view.findViewById(R.id.producto_text_toolbar);
        if(comercioView!=null){
            textToolbar.setText(Objects.requireNonNull(comercioView).nombre);
        }

        RecyclerView recyclerView = view.findViewById(R.id.lista_productos_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProductoRecyclerViewAdapter(null));

        productosViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<ProductoView>>() {
            public void onChanged(List<ProductoView> productoViews) {
                recyclerView.setAdapter(new ProductoRecyclerViewAdapter(productoViews));
            }
        });

        productosViewModel.initProductos(comercioView.id);

    }
}
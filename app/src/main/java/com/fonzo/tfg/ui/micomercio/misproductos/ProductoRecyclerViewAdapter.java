package com.fonzo.tfg.ui.micomercio.misproductos;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;
import com.fonzo.tfg.R;
import com.fonzo.tfg.ui.producto.dummy.ContenidoDummyProducto;

public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> {

    private final List<ContenidoDummyProducto.DummyProducto> mValues;

    public ProductoRecyclerViewAdapter(List<ContenidoDummyProducto.DummyProducto> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_mis_productos_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.asignarDatos(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nombre;
        public final TextView precio;
        public ContenidoDummyProducto.DummyProducto mItem;

        public ViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.mis_productos_item_list_nombre_producto);
            precio = (TextView) view.findViewById(R.id.mis_productos_item_list_precio_producto);
        }

        public void asignarDatos(ContenidoDummyProducto.DummyProducto item){
            nombre.setText(item.nombre);
            precio.setText(item.precio);
        }

    }
}
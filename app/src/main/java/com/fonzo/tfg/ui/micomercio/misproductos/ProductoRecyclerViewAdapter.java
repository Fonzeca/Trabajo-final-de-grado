package com.fonzo.tfg.ui.micomercio.misproductos;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ProductoView;

public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> {

    private final List<ProductoView> mValues;

    public ProductoRecyclerViewAdapter(List<ProductoView> items) {
        if(items == null){
            items = new ArrayList<>();
        }
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
        public ProductoView mItem;

        public ViewHolder(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.mis_productos_item_list_nombre_producto);
            precio = (TextView) view.findViewById(R.id.mis_productos_item_list_precio_producto);
        }

        public void asignarDatos(ProductoView item){
            nombre.setText(item.nombre);
            precio.setText(""+item.precio);
        }

    }
}
package com.fonzo.tfg.ui.producto;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fonzo.tfg.ui.compra.DetallesCompra;
import com.fonzo.tfg.ui.producto.dummy.ContenidoDummyProducto.DummyProducto;

import java.util.List;
import com.fonzo.tfg.R;

public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolderProducto> implements View.OnClickListener {

    private final List<DummyProducto> mValues;

    public ProductoRecyclerViewAdapter(List<DummyProducto> items) {
        mValues = items;
    }

    @Override
    public ViewHolderProducto onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_productos_item_list, parent, false);
        view.setOnClickListener(this);
        return new ViewHolderProducto(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderProducto holder, int position) {
        holder.asignarDatos(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onClick(View v) {
        DetallesCompra detallesCompraDialog = new DetallesCompra(v.getContext());


        detallesCompraDialog.setTitle("Detalles");
        detallesCompraDialog.show();

    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder {
        public final TextView nombre;
        public final TextView precio;
        public DummyProducto mItem;

        public ViewHolderProducto(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.text_producto_nombre);
            precio = (TextView) view.findViewById(R.id.text_prodcuto_precio);
        }

        public void asignarDatos(DummyProducto item){
            nombre.setText(item.nombre);
            precio.setText(item.precio + "");
        }
    }
}
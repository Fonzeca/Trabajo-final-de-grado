package com.fonzo.tfg.ui.comercios;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fonzo.tfg.ui.comercios.dummy.ContenidoDummyComercio.DummyComercio;

import java.util.List;
import com.fonzo.tfg.R;
import com.fonzo.tfg.ui.producto.ComercioActivity;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyComercio}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ComercioRecyclerViewAdapter extends RecyclerView.Adapter<ComercioRecyclerViewAdapter.ViewHolderComercios> implements View.OnClickListener {

    private final List<DummyComercio> mValues;

    public ComercioRecyclerViewAdapter(List<DummyComercio> items) {
        mValues = items;
    }

    @Override
    public ViewHolderComercios onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_comercios_item_list, parent, false);
        view.setOnClickListener(this);
        return new ViewHolderComercios(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderComercios holder, int position) {
        holder.asignarDatos(mValues.get(position));

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(v.getContext(), ComercioActivity.class);
        v.getContext().startActivity(intent);
    }

    public class ViewHolderComercios extends RecyclerView.ViewHolder {
        public final TextView nombre;
        public final TextView direccion;

        public ViewHolderComercios(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.item_list_comercio_nombre);
            direccion = (TextView) view.findViewById(R.id.item_list_comercio_direccion);
        }

        public void asignarDatos(DummyComercio item){
            nombre.setText(item.nombre);
            direccion.setText(item.direccion);
        }
    }
}
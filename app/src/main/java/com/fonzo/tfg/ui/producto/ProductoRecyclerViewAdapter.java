package com.fonzo.tfg.ui.producto;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.ui.compra.DetallesCompra;

import java.util.ArrayList;
import java.util.List;
import com.fonzo.tfg.R;
import com.fonzo.tfg.ui.util.ProccessDialog;

public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolderProducto> {

    private final List<ProductoView> mValues;

    public ProductoRecyclerViewAdapter(List<ProductoView> items) {
        if(items == null){
            items = new ArrayList<>();
        }
        mValues = items;
    }

    @Override
    public ViewHolderProducto onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_productos_item_list, parent, false);
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


    public class ViewHolderProducto extends RecyclerView.ViewHolder {
        public final TextView nombre;
        public final TextView precio;

        private ProductoView producto;

        public ViewHolderProducto(View view) {
            super(view);
            nombre = (TextView) view.findViewById(R.id.text_producto_nombre);
            precio = (TextView) view.findViewById(R.id.text_prodcuto_precio);

            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    /*
                    ProccessDialog.show(v.getContext(),"","");

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                                ProccessDialog.cerrar();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }).start();
                    */

                    DetallesCompra dialog = new DetallesCompra(view.getContext(), producto);
                    dialog.setTitle("Detalles");
                    dialog.show();
                }
            });
        }

        public void asignarDatos(ProductoView item){
            producto = item;
            nombre.setText(item.nombre);
            precio.setText("$ " + item.precio);
        }
    }
}
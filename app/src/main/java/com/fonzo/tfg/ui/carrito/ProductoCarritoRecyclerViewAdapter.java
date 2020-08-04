package com.fonzo.tfg.ui.carrito;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.ui.compra.DetallesCompra;

public class ProductoCarritoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoCarritoRecyclerViewAdapter.ViewHolderProductoCarrito> {



	@NonNull
	@Override
	public ViewHolderProductoCarrito onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return null;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolderProductoCarrito holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 0;
	}

	public class ViewHolderProductoCarrito extends RecyclerView.ViewHolder {
		public final TextView nombre;
		public final TextView precio;


		public ViewHolderProductoCarrito(View view) {
			super(view);
			nombre = (TextView) view.findViewById(R.id.text_producto_nombre);
			precio = (TextView) view.findViewById(R.id.text_prodcuto_precio);

			view.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
				}
			});

		}

		public void asignarDatos(ProductoView sdfgsdgsdgsd){
			nombre.setText(sdfgsdgsdgsd.nombre);
			precio.setText(sdfgsdgsdgsd.precio + "");
		}
	}
}

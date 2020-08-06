package com.fonzo.tfg.ui.carrito;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ProductoCarritoView;
import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.ui.compra.DetallesCompra;

import java.util.ArrayList;
import java.util.List;

public class ProductoCarritoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoCarritoRecyclerViewAdapter.ViewHolderProductoCarrito> {

	private final List<ProductoCarritoView> mValues;

	public ProductoCarritoRecyclerViewAdapter(List<ProductoCarritoView> mValues) {
		if(mValues == null){
			mValues = new ArrayList<>();
		}
		this.mValues = mValues;
	}

	@NonNull
	@Override
	public ViewHolderProductoCarrito onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_productos_item_list, parent, false);
		return new ViewHolderProductoCarrito(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolderProductoCarrito holder, int position) {
		holder.asignarDatos(mValues.get(position));
	}

	@Override
	public int getItemCount() {
		return mValues.size();
	}

	public class ViewHolderProductoCarrito extends RecyclerView.ViewHolder {
		public final TextView nombre;
		public final TextView precio;
		public final TextView cantidad;


		public ViewHolderProductoCarrito(View view) {
			super(view);
			nombre = (TextView) view.findViewById(R.id.text_producto_nombre);
			precio = (TextView) view.findViewById(R.id.text_prodcuto_precio);
			cantidad = (TextView) view.findViewById(R.id.text_cantidad_producto);
			cantidad.setVisibility(View.VISIBLE);

			view.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
				}
			});

		}

		public void asignarDatos(ProductoCarritoView item){
			nombre.setText(item.nombre);
			precio.setText("$ " + item.precio);
			cantidad.setText("Cantidad: " + item.cantidad);
		}
	}
}

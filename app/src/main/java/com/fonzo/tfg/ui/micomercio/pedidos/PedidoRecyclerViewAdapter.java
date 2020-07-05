package com.fonzo.tfg.ui.micomercio.pedidos;

import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fonzo.tfg.ui.micomercio.pedidos.dummy.ContenidoDummyPedidos.DummyPedido;

import java.text.SimpleDateFormat;
import java.util.List;
import com.fonzo.tfg.R;

public class PedidoRecyclerViewAdapter extends RecyclerView.Adapter<PedidoRecyclerViewAdapter.ViewHolderPedidos> {

    private final List<DummyPedido> mValues;

    public PedidoRecyclerViewAdapter(List<DummyPedido> items) {
        mValues = items;
    }

    @Override
    public ViewHolderPedidos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pedidos_item_list, parent, false);
        return new ViewHolderPedidos(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderPedidos holder, int position) {
        holder.asignarDatos(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolderPedidos extends RecyclerView.ViewHolder {
        public final TextView nombreCliente;
        public final TextView dateTime;
        public final TextView estadoPedido;
        public DummyPedido mItem;

        public ViewHolderPedidos(View view) {
            super(view);
            nombreCliente = (TextView) view.findViewById(R.id.pedidos_nombre_cliente);
            dateTime = (TextView) view.findViewById(R.id.pedidos_date_time);
            estadoPedido = (TextView) view.findViewById(R.id.pedidos_estado);
        }
        public void asignarDatos(DummyPedido item){
            nombreCliente.setText(item.nombreCliente);
            SimpleDateFormat format = new SimpleDateFormat("MM/dd kk:mm");
            dateTime.setText(format.format(item.fechaHora) + " hs");
            estadoPedido.setText("En espera");
        }
    }
}
package com.fonzo.tfg.ui.micomercio.pedidos.dummy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContenidoDummyPedidos {

    public static final List<DummyPedido> ITEMS = new ArrayList<DummyPedido>();

    public static final Map<Integer, DummyPedido> ITEM_MAP = new HashMap<Integer, DummyPedido>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyPedido item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyPedido createDummyItem(int position) {
        return new DummyPedido(position, "Ester", Calendar.getInstance().getTime());
    }

    public static class DummyPedido {
        public final int id;
        public final String nombreCliente;
        public final Date fechaHora;
        public final int estado;

        //0: En espera
        //1: Para procesar
        //2: Cancelado
        //3: Despachado

        public DummyPedido(int id, String nombreCliente, Date fechaHora) {
            this.id = id;
            this.nombreCliente = nombreCliente;
            this.fechaHora = fechaHora;
            this.estado = 0;
        }
    }
}
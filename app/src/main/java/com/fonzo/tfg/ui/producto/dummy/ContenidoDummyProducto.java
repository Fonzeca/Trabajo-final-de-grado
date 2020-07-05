package com.fonzo.tfg.ui.producto.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContenidoDummyProducto {
    public static final List<DummyProducto> ITEMS = new ArrayList<DummyProducto>();

    public static final Map<Integer, DummyProducto> ITEM_MAP = new HashMap<Integer, DummyProducto>();

    private static final int COUNT = 25;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyProducto item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyProducto createDummyItem(int position) {
        return new DummyProducto(position, "Bonobom", "$ 20,00 ");
    }

    public static class DummyProducto {
        public final int id;
        public final String nombre;
        public final String precio;

        public DummyProducto(int id, String nombre, String precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }
    }
}
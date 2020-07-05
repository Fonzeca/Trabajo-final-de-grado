package com.fonzo.tfg.ui.comercios.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContenidoDummyComercio {

    public static final List<DummyComercio> ITEMS = new ArrayList<DummyComercio>();

    public static final Map<Integer, DummyComercio> ITEM_MAP = new HashMap<Integer, DummyComercio>();

    private static final int COUNT = 20;

    static {
        //Se agregan a la lista
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyComercio item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyComercio createDummyItem(int position) {
        return new DummyComercio(position, "Eluney", "Av Pueyrredon 282");
    }

    //Dummy
    public static class DummyComercio {
        public final int id;
        public final String nombre;
        public final String direccion;

        public DummyComercio(int id, String nombre, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
        }
    }
}
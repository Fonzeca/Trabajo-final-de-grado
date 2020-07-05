package com.fonzo.tfg.ui.compra;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fonzo.tfg.R;
import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DetallesCompra extends Dialog implements View.OnClickListener {

    private MaterialButton button;

    public DetallesCompra(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_compra);

        button = findViewById(R.id.dialog_producto_button_agregar_carrito);
        button.setOnClickListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Agregado al carrito exitosamente", Toast.LENGTH_SHORT);
        onBackPressed();
    }
}

package com.fonzo.tfg.ui.compra;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ProductoView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DetallesCompra extends Dialog implements View.OnClickListener {
    private ProductoView producto;
    private Context context;

    private MaterialButton button;
    private TextView textNombre;
    private TextView textPrecio;
    private TextView textEnStock;
    private TextInputEditText inputCantidad;
    private TextView textTotal;


    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public DetallesCompra(@NonNull Context context, ProductoView producto) {
        super(context);
        this.context = context;
        this.producto = producto;
        setContentView(R.layout.dialog_compra);



        button = findViewById(R.id.dialog_producto_button_agregar_carrito);
        button.setOnClickListener(this);

        textNombre = findViewById(R.id.dialog_producto_titulo);
        textNombre.setText(producto.nombre);

        textPrecio = findViewById(R.id.dialog_producto_precio);
        textPrecio.setText("Precio: $ " + String.format("%.2f", producto.precio));

        textEnStock = findViewById(R.id.dialog_producto_en_stock);
        if(producto.stock <= 0){
            textEnStock.setText("No hay stock");
            //TODO: Color rojo
        }else{
            textEnStock.setText("En hay stock");
            //TODO: Color verde
        }

        textTotal = findViewById(R.id.dialog_producto_total);

        inputCantidad = findViewById(R.id.dialog_producto_cantidad);
        inputCantidad.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            public void afterTextChanged(Editable s) {
                String cantidadStr = inputCantidad.getText().toString();
                String totalStr = "0.00";
                if(!cantidadStr.isEmpty()){
                    int cantidad = Integer.parseInt(cantidadStr);
                    if(cantidad > 0){
                        totalStr = String.format("%.2f", (cantidad * producto.precio));
                    }
                }
                textTotal.setText("Total: $ " + totalStr);
            }
        });
        inputCantidad.setText("1"); //Por defecto 1
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if(!inputCantidad.getText().toString().isEmpty()){
            Toast.makeText(context, "Agregado al carrito exitosamente", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else{
            Toast.makeText(context, "Debe insertar una cantidad", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.fonzo.tfg.ui.producto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ComercioView;
import com.fonzo.tfg.ui.carrito.CarritoActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ComercioActivity extends AppCompatActivity {
    private ComercioView comercioView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercio);

        comercioView = (ComercioView) getIntent().getSerializableExtra("comercio");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab_comercio_carrito);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CarritoActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.comercio_fragment_host, new ListaProductoFragment(comercioView)).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
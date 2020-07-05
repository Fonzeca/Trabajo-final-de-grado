package com.fonzo.tfg;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.fonzo.tfg.ui.comercios.ListaComerciosFragment;
import com.fonzo.tfg.ui.micomercio.MiComercioFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.abrir_toogle, R.string.cerrar_toogle);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.home_host_fragment, ListaComerciosFragment.newInstance(1)).commit();
            navigationView.setCheckedItem(R.id.nav_comprar);
        }

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_comprar:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_host_fragment, ListaComerciosFragment.newInstance(1)).commit();
                navigationView.setCheckedItem(R.id.nav_comprar);
                break;
            case R.id.nav_mi_comercio:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_host_fragment, MiComercioFragment.newInstance("asd")).commit();
                navigationView.setCheckedItem(R.id.nav_mi_comercio);
                break;
            case R.id.nav_estadisticas:

                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
}
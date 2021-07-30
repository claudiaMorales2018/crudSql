package com.example.mycrudapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivityDetalle extends AppCompatActivity {
 private Fragment fragment;
 private String id,nombre, raza, color, edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle);


        fragment = new DetalleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment).commit();
        this.obtenerDatos();
        this.trasladoFragment();

    }
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nombre = bundle.getString("nombre");
        raza = bundle.getString("raza");
        color = bundle.getString("color");
        edad = bundle.getString("edad");
    }

    private void trasladoFragment(){
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("nombre", nombre);
        bundle.putString("raza", raza);
        bundle.putString("color", color);
        bundle.putString("edad", edad);
        fragment.setArguments(bundle);
    }
}
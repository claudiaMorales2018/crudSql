package com.example.mycrudapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetalleFragment extends Fragment {

  private String id, nombre, raza, color, edad;


    public DetalleFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

       id= getArguments().getString("id");
       nombre =  getArguments().getString("nombre");
       raza= getArguments().getString("raza");
       color= getArguments().getString("color");
       edad=  getArguments().getString("edad");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_detalle, container, false);


        TextView textViewId, textViewNombre,textViewRaza,textViewColor,textViewEdad;
        textViewId = v.findViewById(R.id.idFrag);
        textViewNombre = v.findViewById(R.id.nombreFrag);
        textViewRaza = v.findViewById(R.id.RazaFrag);
        textViewColor = v.findViewById(R.id.colorFrag);
        textViewEdad = v.findViewById(R.id.edadFrag);

        textViewId.setText(id);
        textViewNombre.setText(nombre);
        textViewRaza.setText(raza);
        textViewColor.setText(color);
        textViewEdad.setText(edad);



        return v;
    }
}
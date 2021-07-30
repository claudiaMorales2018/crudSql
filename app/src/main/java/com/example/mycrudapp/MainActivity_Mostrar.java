package com.example.mycrudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mycrudapp.complementos.ConstantesSQL;
import com.example.mycrudapp.complementos.MascotasVO;

import java.util.ArrayList;

public class MainActivity_Mostrar extends AppCompatActivity {
 private ListView listView;

  // dos arreglos que me permitan
    ArrayList<String>listaDatos;
    ArrayList<MascotasVO>listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar);

        listView = findViewById(R.id.listaMostrar);

        this.mostrarMascota();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladoInformacion (position);
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaDatos);
        listView.setAdapter(arrayAdapter);



    }

    private void mostrarMascota(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,null,ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getWritableDatabase();
        try {
            MascotasVO mascotasVO;
            listaMascotas = new ArrayList<>();
            String ConsultaCompleta;
            ConsultaCompleta = "SELECT * FROM "+ConstantesSQL.TABLAS_MASCOTA+";";
            Cursor cursor = database.rawQuery(ConsultaCompleta,null);

            while (cursor.moveToNext()){

                mascotasVO= new MascotasVO();
                mascotasVO.setId(cursor.getInt(0));
                mascotasVO.setNombre(cursor.getString(1));
                mascotasVO.setRaza(cursor.getString(2));
                mascotasVO.setColor(cursor.getString(3));
                mascotasVO.setEdad(cursor.getInt(4));

                listaMascotas.add(mascotasVO);

            }

            listaDatos = new ArrayList<>();
            for (int i = 0; i <listaMascotas.size();i++){

                listaDatos.add(listaMascotas.get(i).getId()+"."+listaMascotas.get(i).getNombre());
            }

        }catch (Exception e){
            e.getMessage();
        }

    }
    private  void trasladoInformacion(int position){
        String idB, nombreB, razaB, colorB , edadB;

        idB = String.valueOf(listaMascotas.get(position).getId());
        nombreB = listaMascotas.get(position).getNombre();
        razaB = listaMascotas.get(position).getRaza();
        colorB = listaMascotas.get(position).getColor();
        edadB = String.valueOf(listaMascotas.get(position).getEdad());

        Intent intent = new Intent(getApplicationContext(), MainActivityDetalle.class);
        intent.putExtra("id", idB);
        intent.putExtra("nombre", nombreB);
        intent.putExtra("raza", razaB);
        intent.putExtra("color", colorB);
        intent.putExtra("edad", edadB);
        startActivity(intent);

    }
}
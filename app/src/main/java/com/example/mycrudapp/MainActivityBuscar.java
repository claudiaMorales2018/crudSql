package com.example.mycrudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycrudapp.complementos.ConstantesSQL;

public class MainActivityBuscar extends AppCompatActivity {

   private EditText editTextId;
   private TextView textViewNombre,textViewRaza,textViewColor,textViewEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar);


        editTextId = findViewById(R.id.edtBuscarMascota);
        textViewNombre = findViewById(R.id.txtNombreBuscar);
        textViewRaza = findViewById(R.id.txtRazaBuscar);
        textViewColor = findViewById(R.id.txtColorBuscar);
        textViewEdad = findViewById(R.id.txtColorBuscar);


    }

    public void onClick(View view) {

    this.buscarMascotas();



    }

    private void buscarMascotas(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,
                null,ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        String[] parametro = {editTextId.getText().toString()};
        if (!editTextId.getText().toString().isEmpty()){
            try {
                //Consulta por ID
                String consultaID;
                consultaID = "SELECT " + ConstantesSQL.CAMPO_NOMBRE + ", " + ConstantesSQL.CAMPO_RAZA + ", " +
                        ConstantesSQL.CAMPO_COLOR + ", " + ConstantesSQL.CAMPO_EDAD + " FROM " + ConstantesSQL.TABLAS_MASCOTA +
                        " WHERE " + ConstantesSQL.CAMPO_ID + " = ?;";
                //Objeto que permite obtener datos de una consulta de base de datos
                Cursor cursor = database.rawQuery(consultaID, parametro);
                cursor.moveToFirst();
                textViewNombre.setText(cursor.getString(0));
                textViewRaza.setText(cursor.getString(1));
                textViewColor.setText(cursor.getString(2));
                textViewEdad.setText(cursor.getString(3));
                cursor.close();
            }
            catch (Exception e){
                e.getMessage();
            }

        }
        else {
            Toast.makeText(this, "Debe de llenar el campo", Toast.LENGTH_SHORT).show();
        }

    }

}
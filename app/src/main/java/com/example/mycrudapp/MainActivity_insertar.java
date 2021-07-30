package com.example.mycrudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycrudapp.complementos.ConstantesSQL;

public class MainActivity_insertar extends AppCompatActivity {
 EditText editTextNombre,editTextRaza,editTextColor,editTextEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar);

        editTextNombre=findViewById(R.id.edtNombre);
        editTextRaza = findViewById(R.id.edtRaza);
        editTextColor= findViewById(R.id.edtColor);
        editTextEdad = findViewById(R.id.edtEdad);

    }
    public void Click(View view) {
        this.insertarMascotas();
    }

    private void insertarMascotas(){

        if (!editTextNombre.getText().toString().isEmpty()&&
        !editTextRaza.getText().toString().isEmpty()&&
        !editTextColor.getText().toString().isEmpty()&&
        !editTextEdad.getText().toString().isEmpty()) {

           ConectorSQLite conectorSQLite = new ConectorSQLite(this,ConstantesSQL.BD_MASCOTAS,
                   null,ConstantesSQL.VERSION)  ;

           SQLiteDatabase database = conectorSQLite.getWritableDatabase();

           try {
               String consultarInsertar;

               consultarInsertar= "INSERT INTO "+ConstantesSQL.TABLAS_MASCOTA +
                       "("+ConstantesSQL.CAMPO_NOMBRE+","
                       +ConstantesSQL.CAMPO_RAZA+", "
                       + ConstantesSQL.CAMPO_COLOR+", "
                       + ConstantesSQL.CAMPO_EDAD+
                       ") VALUES(' " + editTextNombre.getText().toString()+"'," +
                       editTextRaza.getText().toString()+ "','" +
                       editTextColor.getText().toString()+ "','" +
                       editTextEdad.getText().toString()+");";

               database.execSQL(consultarInsertar);
               database.close();
               editTextNombre.setText("");
               editTextRaza.setText("");
               editTextColor.setText("");
               editTextEdad.setText("");

               Toast.makeText(this, "Datos Insertados Correctamente ", Toast.LENGTH_SHORT).show();


           }catch (Exception e){
               e.getMessage();

           }

        }
        else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


}
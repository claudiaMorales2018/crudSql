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

public class MainActivityEliminar extends AppCompatActivity {

  private EditText editText;
  private TextView textViewNombre,textViewRaza,textViewColor,textViewEdad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar);


        editText = findViewById(R.id.edtBuscarMascotaEliminar);
        textViewNombre = findViewById(R.id.txtNombreEliminar);
        textViewRaza = findViewById(R.id.txtRazaEliminar);
        textViewColor = findViewById(R.id.txtColorEliminar);
        textViewEdad = findViewById(R.id.txtEdadEliminar);




    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnBuscarMascotaEliminar:
                this.ConsultarId();
                break;
            case R.id.btnEliminarMascotas:
                this.eliminarMascota();
                break;
    }

    }
    private void ConsultarId(){
        if (!editText.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,null,ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getReadableDatabase();
            String[] parametro = {editText.getText().toString()};
            try {
                String consultarID;
                consultarID = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+", "+
                        ConstantesSQL.CAMPO_RAZA+", "+
                        ConstantesSQL.CAMPO_COLOR+", "+
                        ConstantesSQL.CAMPO_EDAD+" FROM "+ConstantesSQL.TABLAS_MASCOTA+" WHERE "+
                        ConstantesSQL.CAMPO_ID+"= ?;";
                Cursor cursor = database.rawQuery(consultarID,parametro);
                cursor.moveToFirst();
                textViewNombre.setText(cursor.getString(0));
                textViewRaza.setText(cursor.getString(1));
                textViewColor.setText(cursor.getString(2));
                textViewEdad.setText(cursor.getString(3));
                cursor.close();
            }
            catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar el campo a buscar", Toast.LENGTH_SHORT).show();
        }
    }
    private void eliminarMascota(){
        if(!editText.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,null,ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaEliminar;
                consultaEliminar = "DELETE FROM "+ConstantesSQL.TABLAS_MASCOTA+
                        " WHERE "+ConstantesSQL.CAMPO_ID+"= "+editText.getText().toString()+";";
                database.execSQL(consultaEliminar);
                database.close();
                editText.setText("");
                textViewNombre.setText("");
                textViewRaza.setText("");
                textViewColor.setText("");
                textViewEdad.setText("");
                Toast.makeText(this, "Datos Eliminados Correctamente", Toast.LENGTH_SHORT).show();

            }
            catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "Debe de llenar el dato a buscar", Toast.LENGTH_SHORT).show();
        }
    }

    }


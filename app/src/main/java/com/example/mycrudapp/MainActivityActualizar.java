package com.example.mycrudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycrudapp.complementos.ConstantesSQL;

public class MainActivityActualizar extends AppCompatActivity {

  private EditText editTextBuscar, editTextNombre,
  editTextRaza,editTextColor,editTextEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar);

        editTextBuscar = findViewById(R.id.edtBuscarMascota);
        editTextNombre= findViewById(R.id.edtNombreActualizar);
        editTextEdad= findViewById(R.id.edtRazaActualizar);
        editTextColor=findViewById(R.id.edtColorActualizar);
        editTextEdad= findViewById(R.id.edtEdadActualizar);


    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnBuscarMascotasActualizar:
                this.consultarID();
                break;

            case R.id.btnActualizarMascotas:
                this.actualizarMascota();
                break;
        }
    }

    private void consultarID(){

        if(!editTextBuscar.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getReadableDatabase();
            String[] parametro = {editTextBuscar.getText().toString()};
            try {
                String consultarID;
                consultarID = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_RAZA+", "+
                        ConstantesSQL.CAMPO_COLOR+", "+ConstantesSQL.CAMPO_EDAD+" FROM "+ConstantesSQL.TABLAS_MASCOTA+
                        " WHERE "+ConstantesSQL.CAMPO_ID+" = ?;";
                Cursor cursor = database.rawQuery(consultarID, parametro);
                cursor.moveToFirst();
                editTextNombre.setText(cursor.getString(0));
                editTextRaza.setText(cursor.getString(1));
                editTextColor.setText(cursor.getString(2));
                editTextEdad.setText(cursor.getString(3));
                cursor.close();
            }
            catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe ingresar el dato a buscar", Toast.LENGTH_SHORT).show();
        }

    }
    public void actualizarMascota(){
        if(!editTextBuscar.getText().toString().isEmpty() && !editTextNombre.getText().toString().isEmpty()
                && !editTextRaza.getText().toString().isEmpty() && !editTextColor.getText().toString().isEmpty()
                && !editTextEdad.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaActualizar;
                consultaActualizar = "UPDATE "+ConstantesSQL.TABLAS_MASCOTA+" SET "+
                        ConstantesSQL.CAMPO_NOMBRE+"= '"+editTextNombre.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_RAZA+"= '"+editTextRaza.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_COLOR+"= '"+editTextColor.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_EDAD+"= "+editTextEdad.getText().toString()+" WHERE "+
                        ConstantesSQL.CAMPO_ID+"= "+editTextBuscar.getText().toString()+";";
                database.execSQL(consultaActualizar);
                database.close();

                editTextBuscar.setText("");
                editTextNombre.setText("");
                editTextRaza.setText("");
                editTextColor.setText("");
                editTextEdad.setText("");
                Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.getMessage();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los datos", Toast.LENGTH_SHORT).show();
        }


    }
}
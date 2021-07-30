package com.example.mycrudapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mycrudapp.complementos.ConstantesSQL;

public class ConectorSQLite extends SQLiteOpenHelper {


    //segun opciones elegimos el primer Constructor
    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Crear la tabla
        sqLiteDatabase.execSQL(ConstantesSQL.CREAR_TABLE_MASCOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Borrar la tabla si ya existe
        sqLiteDatabase.execSQL(ConstantesSQL.BORRAR_TABLA);
        onCreate(sqLiteDatabase);

    }
}

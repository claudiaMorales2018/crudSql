package com.example.mycrudapp.complementos;

public class ConstantesSQL {

    // constantes para utilizacion de las consultas
    public static final String BD_MASCOTAS= "bd_mascotas";
    // tablas

    public static final String TABLAS_MASCOTA= "tbl_mascota";
    //campos de las tablas

    public static final String CAMPO_ID = "id_mascotas";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_RAZA = "raza";
    public static final String CAMPO_COLOR = "color";
    public static final String CAMPO_EDAD = "edad";

    public static final String CREAR_TABLE_MASCOTA= "CREATE TABLE "+TABLAS_MASCOTA+
            "("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE+ " TEXT NOT NULL, "
            + CAMPO_RAZA+" TEXT NOT NULL , "
            +CAMPO_COLOR+" TEXT NOT NULL, "
            +CAMPO_EDAD+" INTEGER NOT NULL);";

    public static final String BORRAR_TABLA = "DROP TABLE IF EXISTS"+TABLAS_MASCOTA;

    public static final int VERSION= 1;
}

package com.example.yeialel.persistencia2;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BaseDatos {

    // AQUI SE MOSTRARA LOS PASOS PARA CREAR UNA TABLA EN LA APLICACION

    //ESTOS SON LOS CAMPOS QUE TENDRA LA TABLA
    public static final String NOMBRE_TABLA = "listado_de_perros";  // nombre de la tabla en la base de datos
    public static final String NOMBRE_COLUMNA1 = "Id";
    public static final String NOMBRE_COLUMNA2 = "Nombre_Mascota";
    public static final String NOMBRE_COLUMNA3 = "Nombre_Propietario";
    public static final String NOMBRE_COLUMNA4 = "Raza_Mascota";

    private static final String TIPO_CAMPO = " TEXT";
    private static final String COMA = ",";

    //ESTO PARA CONTROLAR SI LA BD YA ESXISTE
    protected static final String SQL_DELETE_ENTRIES =  "DROP TABLE IF EXISTS " + BaseDatos.NOMBRE_TABLA;

    // ESTO ES PARA CREAR LA TABLA
    protected static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
                    BaseDatos.NOMBRE_TABLA + " (" +
                    BaseDatos.NOMBRE_COLUMNA1 + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL " + COMA +
                    BaseDatos.NOMBRE_COLUMNA2 + TIPO_CAMPO + COMA +
                    BaseDatos.NOMBRE_COLUMNA3 + TIPO_CAMPO + COMA +
                    BaseDatos.NOMBRE_COLUMNA4 + TIPO_CAMPO + " )";

    //CONSTRUCTOR
    public BaseDatos() {
    }

}

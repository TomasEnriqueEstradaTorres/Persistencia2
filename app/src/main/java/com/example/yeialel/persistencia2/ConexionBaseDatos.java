package com.example.yeialel.persistencia2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBaseDatos extends SQLiteOpenHelper {

    // CON ESTA CLASE SE CREARA LA CONEXION CON LA BASE DE DATOS

    //Aqui se crea una constante de clase para la version de base de datos
    public static final int VERSION_BASE_DATOS = 1;

    //Esto es el nombre de la base de datos
    public static final String NOMBRE_BASE_DATOS = "Datos_Mascotas.db";

    //CONSTRUCTOR
    public ConexionBaseDatos(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BaseDatos.SQL_CREATE_ENTRIES);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(BaseDatos.SQL_CREATE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


}

package com.alejandroflores.sql_conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DB extends SQLiteOpenHelper {

    static String DB_NAME="usuarios.db";
    static int DB_VERSION=1;

//    Constructor de la clase
    public DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREAR_TABLA = "CREATE TABLE IF NOT EXISTS usuario " +
                "(id_usuario INTEGER PRIMARY KEY ," +
                "nombre_usuario TEXT," +
                "apellido_usuario TEXT," +
                "RFC_usuario text)";

        db.execSQL(SQL_CREAR_TABLA);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

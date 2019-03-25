package com.alejandroflores.sql_conexion;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


//  Clase del objeto usuario
public class Usuario {

    public Usuario(){

    }

//    Constructor
    private Usuario(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndex("id_usuario"));
        nombre = cursor.getString(cursor.getColumnIndex("nombre_usuario"));
        apellido = cursor.getString(cursor.getColumnIndex("apellido_usuario"));
        RFC = cursor.getString(cursor.getColumnIndex("RFC_usuario"));
    }


//    Propiedades de la clase
    private long id;
    private String nombre;
    private String apellido;
    private String RFC;


//    Getters y Setters de la clase
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }


//    Método para obtener un objeto de tipo lista de usuarios
    public static ArrayList<Usuario> getUsuariosList(Context context){
        ArrayList<Usuario> listUsuarios = new ArrayList<>();
        DB helper = new DB(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(true, "usuario", new String[]{"id_usuario", "nombre_usuario","apellido_usuario","RFC_usuario"},
                null, null, null, null, "id_usuario", null);
        while (cursor.moveToNext()){
            listUsuarios.add(new Usuario(cursor));
        }
        cursor.close();
        db.close();

        return listUsuarios;
    }


//    Método para obtener un usuario en concreto
    public static Usuario getUsuario(Context context, long id){
        Usuario usuario = null;
        DB helper = new DB(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String where = "id_usuario = " + String.valueOf(id);
        Cursor cursor = db.query(true, "usuario", new String[]{"id_usuario", "nombre_usuario","apellido_usuario","RFC_usuario"},
                where, null, null, null, null, null);

        if (cursor.moveToFirst())
            usuario = new Usuario(cursor);

            cursor.close();
            db.close();

        return usuario;
    }


//    Método para insertar un usuario en la DB
    public void insertUsuario(Context context){
        ContentValues values = new ContentValues();
        values.put("nombre_usuario", this.nombre);
        values.put("apellido_usuario", this.apellido);
        values.put("RFC_usuario", this.RFC);

        DB helper = new DB(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        this.id = db.insert("usuario", null, values);
        db.close();
    }


//    Método para actualizar un usuario
    public void updateUsuario(Context context){
        ContentValues values = new ContentValues();
        values.put("nombre", this.nombre);
        values.put("apellido", this.apellido);
        values.put("RFC", this.RFC);
        String where = "id_usuario = " + String.valueOf(this.id);

        DB helper = new DB(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.update("usuario", values, where, null);
        db.close();
    }

//    Método para eliminar un usuario
    public void deleteUsuario(Context context){
        String where = "id_usuario = ?";
        String[] whereArgs = new String[1];
        whereArgs[0] = String.valueOf(this.id);

        DB helper = new DB(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("usuario", where,whereArgs);
        db.close();
    }

}
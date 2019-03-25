package com.alejandroflores.sql_conexion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarUsuarios extends AppCompatActivity {

//    Objeto listView que tenemos en el layout
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios);

//        Unimos el objeto con el id del listview de la vista
        listView = (ListView) findViewById(R.id.ListViewUsuarios);

        llenarLista();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                verUsuario(id);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        llenarLista();
    }

    private void verUsuario(Long id){
        Intent intent = new Intent(this, VerUsuario.class);
        intent.putExtra("Id", id+1);
        startActivity(intent);
    }

    private void llenarLista(){

//        Obtenemos los usuarios de la DB en una lista llamada usuarios
        ArrayList<Usuario> usuarios = Usuario.getUsuariosList(this);
//        Creamos un adaptador y le pasamos por parametro la lista usuarios al item usuarioAdapter
        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(this, usuarios);
//        le damos el adaptador a nuestra listview del layout
        listView.setAdapter(usuarioAdapter);
    }


}

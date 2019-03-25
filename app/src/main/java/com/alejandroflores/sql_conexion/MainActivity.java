package com.alejandroflores.sql_conexion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

//    Creamos variables que contendran a los botones y editText que tenemos en la vista
    private EditText editTextNombre, editTextApellidos, editTextRFC;
    private Button buttonInsertarDb, buttonVerRegistros;

//    Creamos las variables para los campos
    String nombre, apellidos, RFC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Asignamos los elementos del layout a su variable correspondiente
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextApellidos = (EditText) findViewById(R.id.editTextApellidos);
        editTextRFC = (EditText) findViewById(R.id.editTextRFC);
        buttonInsertarDb = (Button) findViewById(R.id.buttonInsertarDb);
        buttonVerRegistros = (Button) findViewById(R.id.buttonVerRegistros);

//        Método onClick del botón para insertar datos a la db

        buttonVerRegistros.setOnClickListener((View v) -> cambiarActivity() );

//        Método onClick del botón para ver los registros de la db

        buttonInsertarDb.setOnClickListener((View v) -> insertarRegistroDB() );
    }

//    Clase para cambiar a la activity donde estan nuestros registros
    public void cambiarActivity(){
        Intent intent = new Intent(this, MostrarUsuarios.class);
        startActivity(intent);

    }

//    Clase para insertar datos en la DB
    public void insertarRegistroDB(){
        getDatosEnPantalla();
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellidos);
        usuario.setRFC(RFC);
        usuario.insertUsuario(this);

    }

//    Clase para obtener los datos de la pantalla
    private void getDatosEnPantalla(){
        nombre = editTextNombre.getText().toString();
        apellidos = editTextApellidos.getText().toString();
        RFC = editTextRFC.getText().toString();
        limpiarDatos();
    }


//    Clase para limpiar datos en pantalla
    private void limpiarDatos(){
        editTextApellidos.setText("");
        editTextNombre.setText("");
        editTextRFC.setText("");
    }


}




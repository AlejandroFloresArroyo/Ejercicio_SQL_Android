package com.alejandroflores.sql_conexion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VerUsuario extends AppCompatActivity {

    TextView tvID, tvNombre,tvApellidos,tvRFC;
    LinearLayout llyUsuarios;
    Button btnEliminar;

    Usuario usuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuario);
        tvID = findViewById(R.id.textViewId);
        tvNombre = findViewById(R.id.textViewNombre);
        tvApellidos = findViewById(R.id.textViewApellidos);
        tvRFC = findViewById(R.id.textViewRFC);
        llyUsuarios = findViewById(R.id.layoutUsuarios);
        btnEliminar = findViewById(R.id.buttonEliminar);

        Intent intent = getIntent();
        long usuarioId = intent.getLongExtra("Id", -1);

        usuario = Usuario.getUsuario(this, usuarioId);

        tvID.setText(String.valueOf(usuario.getId()));
        tvNombre.setText(usuario.getNombre());
        tvApellidos.setText(usuario.getApellido());
        tvRFC.setText(usuario.getRFC());

        btnEliminar.setOnClickListener((View v ) -> {
            usuario.deleteUsuario(this);
        });
    }
}

package com.alejandroflores.sql_conexion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    Context context;

//    Constructor donde recibiremos un objeto lista con los datos a inflar
    public UsuarioAdapter(Context context, List<Usuario> usuarioList) {
    super(context, -1, usuarioList);
    this.context = context;
    }


//    Metodo para inflar el listview
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_item, null);
        } else {
            view = convertView;
        }

        Usuario usuario = getItem(position);
        view.setTag(usuario);

        TextView id = (TextView) view.findViewById(R.id.list_item_id);
        TextView nombre = (TextView) view.findViewById(R.id.list_item_nombre);
        TextView apellidos = (TextView) view.findViewById(R.id.list_item_apellidos);
        TextView rfc = (TextView) view.findViewById(R.id.list_item_rfc);

        id.setText(String.valueOf(usuario.getId()));
        nombre.setText(usuario.getNombre());
        apellidos.setText(usuario.getApellido());
        rfc.setText(usuario.getRFC());

        return view;
    }
}

package com.example.moneyapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistroIngresos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistroIngresos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroIngresos extends Fragment implements View.OnClickListener{

    private EditText fecha, ingreso;
    private int codigo=0;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_registro_ingresos, container, false);
        Button b = (Button) view.findViewById(R.id.button3);
        b.setOnClickListener(this);

        fecha = (EditText) view.findViewById(R.id.fecha);
        ingreso = (EditText) view.findViewById(R.id.ingreso);

        return view;
    }


    public void registro(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "ingresos", null, 1 );
        SQLiteDatabase bd = admin.getWritableDatabase();
        codigo = codigo + 1;
        String cod = Integer.toString(codigo);
        String date = fecha.getText().toString();
        String valor = ingreso.getText().toString();



        bd.execSQL("insert into ingresos (codigo, fecha, ingreso) values ("+cod+",'"+date+"',"+valor+")");
        bd.close();


        fecha.setText("");
        ingreso.setText("");
        Toast.makeText(getContext(), "Se cargaron los datos correctamente",Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onClick(View view) {

        registro(view);

    }
}

package com.example.moneyapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class RegistrarGastos extends Fragment {
    private Button b;
    private EditText fecha, gasto, categorias;
    private int codigo =0;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_registrar_gastos, container, false);

        gasto = (EditText) view.findViewById(R.id.editText);
        fecha = (EditText) view.findViewById(R.id.editText2);
        categorias = (EditText) view.findViewById(R.id.editText3);

        return view;
    }

    public void registrarIngreso(View view) {
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(getContext(), "gastos", null, 1 );
        SQLiteDatabase bd = admin.getWritableDatabase();
        codigo = codigo + 1;
        String cod = Integer.toString(codigo);
        String date = fecha.getText().toString();
        String valor = gasto.getText().toString();
        String categoria=categorias.getText().toString();



        bd.execSQL("insert into gastos(codigo, fecha, gasto, categoria) values ("+cod+",'"+date+"',"+valor+","+categoria+")");
        bd.close();


        fecha.setText("");
        gasto.setText("");
        categorias.setText("");
        Toast.makeText(getContext(), "Se cargaron los datos correctamente",Toast.LENGTH_SHORT).show();
    }

}

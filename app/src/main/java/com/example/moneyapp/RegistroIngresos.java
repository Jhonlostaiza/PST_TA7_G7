package com.example.moneyapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class RegistroIngresos extends Fragment implements View.OnClickListener{

    private Button b;
    private EditText fecha, ingreso;
    private int codigo =0;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_registro_ingresos, container, false );

        b = (Button) view.findViewById(R.id.registrarIngreso);
        ingreso = (EditText) view.findViewById(R.id.editText);
        fecha = (EditText) view.findViewById(R.id.editText2);

        b.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    public void registrarIngreso(View view) {
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(getContext(), "ingresos", null, 1 );
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

    public void onClick(View view) {
        registrarIngreso(view);

    }


}

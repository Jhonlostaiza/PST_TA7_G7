package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String usuario="grupo7";
    private String contraseña="grupo7";
    private EditText user;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inicioSesion(View view){
        user=(EditText)findViewById(R.id.usuario);
        password=(EditText)findViewById(R.id.contraseña);
        if (usuario.equals(user.getText().toString().trim()) && contraseña.equals(password.getText().toString().trim())){
            Intent i = new Intent(this, Inicio.class );
            startActivity(i);
            finish();
        }
        else {
            Toast.makeText(this, "El usuario o contraseña ingresados son incorrectos!",Toast.LENGTH_SHORT).show();
            user.setText("");
            password.setText("");
        }
    }

    public String getUsuario(){
        return usuario;
    }
}

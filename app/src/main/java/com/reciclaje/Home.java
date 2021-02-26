package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;
    TextView nombre;
    int id = 0;
    Usuario u;
    UsuarioDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        nombre = (TextView) findViewById(R.id.nombreUsuario);

        btnReciclar = (ImageButton) findViewById(R.id.btnReciclaje);
        btnPuntos = (ImageButton) findViewById(R.id.btnPuntos);
        btnCuenta = (ImageButton) findViewById(R.id.btnCuenta);

        btnReciclar.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnCuenta.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHome:
                break;
            case R.id.btnReciclaje:
                Intent b = new Intent(Home.this, Reciclaje.class);
                startActivity(b);
                break;
            case R.id.btnPuntos:
                Intent c = new Intent(Home.this, Puntos.class);
                startActivity(c);
                break;
            case R.id.btnCuenta:
                Intent d = new Intent(Home.this, Account.class);
                startActivity(d);
                break;


        }
    }
}


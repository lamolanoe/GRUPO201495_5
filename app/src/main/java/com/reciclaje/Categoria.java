package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;

public class Categoria extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;

    int id=0;
    Usuario u;
    UsuarioDao dao;

    String idUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }



        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnReciclar = (ImageButton) findViewById(R.id.btnReciclaje);
        btnPuntos = (ImageButton) findViewById(R.id.btnPuntos);

        btnReciclar.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnHome.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.btnHome:
                Intent g = new Intent(Categoria.this, Home.class);
                startActivity(g);
                break;
            case R.id.btnReciclaje:
                Intent p = new Intent(Categoria.this, Reciclaje.class);
                startActivity(p);

                break;
            case R.id.btnPuntos:
                Intent d = new Intent(Categoria.this, Puntos.class);
                startActivity(d);
                break;
            case R.id.btnCuenta:

                break;

        }
    }
}
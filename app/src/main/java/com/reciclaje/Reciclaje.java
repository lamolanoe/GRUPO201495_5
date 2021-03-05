package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;

public class Reciclaje extends AppCompatActivity implements View.OnClickListener{
    Button btnLocalidad,btnCategoria;
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;

   int id=0;
Usuario u;
UsuarioDao dao;

    String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclaje);

   Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }

        btnLocalidad = (Button) findViewById(R.id.btnLocalidad);
        btnCategoria = (Button) findViewById(R.id.btnCategoria);
        btnLocalidad.setOnClickListener(this);
        btnCategoria.setOnClickListener(this);


        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnPuntos = (ImageButton) findViewById(R.id.btnPuntos);
        btnCuenta = (ImageButton) findViewById(R.id.btnCuenta);

        btnHome.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnCuenta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
          case R.id.btnLocalidad:
                Intent a=new Intent(Reciclaje.this,Localidad.class);
                //a.putExtra("Id",id);
                startActivity(a);
                break;
          case R.id.btnCategoria:
                Intent e=new Intent(Reciclaje.this,Categoria.class);
                //a.putExtra("Id",id);
                startActivity(e);
                break;

            case R.id.btnHome:
                Intent b = new Intent(Reciclaje.this, Home.class);
                startActivity(b);
                break;
            case R.id.btnReciclaje:

                break;
            case R.id.btnPuntos:
                Intent c = new Intent(Reciclaje.this, Puntos.class);
                startActivity(c);
                break;
            case R.id.btnCuenta:
                Intent d = new Intent(Reciclaje.this, Account.class);
                startActivity(d);
                break;



        }
    }
}
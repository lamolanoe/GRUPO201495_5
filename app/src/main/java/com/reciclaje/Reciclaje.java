package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;

public class Reciclaje extends AppCompatActivity implements View.OnClickListener{
    Button btnLocalidad,btnCategoria;
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;

   int id=0;
Usuario u;
UsuarioDao dao;
    String idUsuario;
    ImageView como_reciclar;

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

     como_reciclar = findViewById(R.id.como_reciclar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
          case R.id.btnLocalidad:
              Bundle btnL = new Bundle();
                Intent a=new Intent(Reciclaje.this,Localidad.class);
              btnL.putString("Id", idUsuario);
              a.putExtras(btnL);
                startActivity(a);
                break;
          case R.id.btnCategoria:
              Bundle btnCa = new Bundle();
                Intent e=new Intent(Reciclaje.this,Categoria.class);
              btnCa.putString("Id", idUsuario);
              e.putExtras(btnCa);
                startActivity(e);
                break;

            case R.id.btnHome:
                Bundle btnH = new Bundle();
                Intent b = new Intent(Reciclaje.this, Home.class);
                btnH.putString("Id", idUsuario);
                b.putExtras(btnH);
                startActivity(b);
                break;
            case R.id.btnReciclaje:
                Bundle btnR = new Bundle();
                Intent p = new Intent(Reciclaje.this, Reciclaje.class);
                btnR.putString("Id", idUsuario);
                p.putExtras(btnR);
                startActivity(p);
                break;
            case R.id.btnPuntos:

                break;
            case R.id.btnCuenta:
                Bundle btnC = new Bundle();
                Intent d = new Intent(Reciclaje.this, Account.class);
                btnC.putString("Id", idUsuario);
                d.putExtras(btnC);
                startActivity(d);
                break;



        }
    }
}
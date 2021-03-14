package com.reciclaje;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;
import com.reciclaje.persona.MostrarEditarPersonaActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Categoria extends AppCompatActivity implements View.OnClickListener {
    ImageView blanco, negro, verde, blano, nego, bla;
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;

   int id=0;
Usuario u;
UsuarioDao dao;
ImageView basura;

    String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        blanco = findViewById(R.id.blanco);
        negro = findViewById(R.id.negro);
        verde = findViewById(R.id.verde);
         blano = findViewById(R.id.blano);
         nego = findViewById(R.id.nego);
         bla = findViewById(R.id.bla);
         basura = findViewById(R.id.basura);

        btnReciclar = (ImageButton) findViewById(R.id.btnReciclaje);
          btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnPuntos = (ImageButton) findViewById(R.id.btnPuntos);
        btnCuenta = (ImageButton) findViewById(R.id.btnCuenta);
        btnReciclar.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnCuenta.setOnClickListener(this);
    }
     @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.btnHome:
                Bundle btnH = new Bundle();
                Intent g = new Intent(Categoria.this, Home.class);
                btnH.putString("Id", idUsuario);
                g.putExtras(btnH);
                startActivity(g);
                break;

            case R.id.btnPuntos:
                Bundle btnP = new Bundle();
                Intent d = new Intent(Categoria.this, Puntos.class);
                btnP.putString("Id", idUsuario);
                d.putExtras(btnP);
                startActivity(d);
                break;
            case R.id.btnCuenta:
                Bundle btnC = new Bundle();
                Intent c = new Intent(Categoria.this, Account.class);
                btnC.putString("Id", idUsuario);
                c.putExtras(btnC);
                startActivity(c);
                break;
            case R.id.btnReciclaje:
                Bundle btnR = new Bundle();
                Intent p = new Intent(Categoria.this, Reciclaje.class);
                btnR.putString("Id", idUsuario);
                p.putExtras(btnR);
                startActivity(p);
                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Bundle btnC = new Bundle();
                Intent c = new Intent(Categoria.this, Reciclaje.class);
                btnC.putString("Id", idUsuario);
                c.putExtras(btnC);
                startActivity(c);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
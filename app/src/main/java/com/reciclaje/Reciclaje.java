package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Reciclaje extends AppCompatActivity implements View.OnClickListener{
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclaje);

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
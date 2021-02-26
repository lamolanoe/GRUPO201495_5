package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Puntos extends AppCompatActivity implements View.OnClickListener{
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnReciclar = (ImageButton) findViewById(R.id.btnReciclaje);
        btnCuenta = (ImageButton) findViewById(R.id.btnCuenta);

        btnHome.setOnClickListener(this);
        btnReciclar.setOnClickListener(this);
        btnCuenta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHome:
                Intent b = new Intent(Puntos.this, Home.class);
                startActivity(b);
                break;
            case R.id.btnReciclaje:
                Intent c = new Intent(Puntos.this, Reciclaje.class);
                startActivity(c);

                break;
            case R.id.btnPuntos:

                break;
            case R.id.btnCuenta:
                Intent d = new Intent(Puntos.this, Account.class);
                startActivity(d);
                break;


        }
    }
}

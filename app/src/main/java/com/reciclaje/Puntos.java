package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Puntos extends AppCompatActivity implements View.OnClickListener{
    Button btnScan;
    EditText txtResultado;
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;
    String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }

        btnScan = findViewById(R.id.btnScan);
        txtResultado = findViewById(R.id.txtResultado);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrador = new IntentIntegrator(Puntos.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("lector - CDP");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
            }
        });

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
                Bundle btnH = new Bundle();
                Intent b = new Intent(Puntos.this, Home.class);
                btnH.putString("Id", idUsuario);
                b.putExtras(btnH);
                startActivity(b);
                break;
            case R.id.btnReciclaje:
                Bundle btnR = new Bundle();
                Intent c = new Intent(Puntos.this, Reciclaje.class);
                btnR.putString("Id", idUsuario);
                c.putExtras(btnR);
                startActivity(c);

                break;
            case R.id.btnPuntos:

                break;
            case R.id.btnCuenta:
                Bundle btnC = new Bundle();
                Intent d = new Intent(Puntos.this, Account.class);
                btnC.putString("Id", idUsuario);
                d.putExtras(btnC);
                startActivity(d);
                break;


        }
    }
    protected void onActivityResultant(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Lectura Cancelada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,result.getContents(), Toast.LENGTH_SHORT).show();
                txtResultado.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

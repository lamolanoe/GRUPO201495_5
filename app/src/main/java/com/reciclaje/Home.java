package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;

import java.net.URI;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;
    TextView nombre;
    int id = 0;
    Usuario u;
    UsuarioDao dao;

    String idUsuario;

    private Button btnlink;
    private String direccion;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }

        nombre = (TextView) findViewById(R.id.nombreUsuario);

        btnReciclar = (ImageButton) findViewById(R.id.btnReciclaje);
        btnPuntos = (ImageButton) findViewById(R.id.btnPuntos);
        btnCuenta = (ImageButton) findViewById(R.id.btnCuenta);

        btnReciclar.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnCuenta.setOnClickListener(this);
        btnlink = (Button)findViewById(R.id.btnlink);
        direccion="";
        foto = findViewById(R.id.foto);
        btnlink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHome:
                break;
            case R.id.btnReciclaje:
                Bundle btnR = new Bundle();
                Intent b = new Intent(Home.this, Reciclaje.class);
                btnR.putString("Id", idUsuario);
                b.putExtras(btnR);
                startActivity(b);
                break;
            case R.id.btnPuntos:
                Bundle btnP = new Bundle();
                Intent c = new Intent(Home.this, Puntos.class);
                btnP.putString("Id", idUsuario);
                c.putExtras(btnP);
                startActivity(c);
                break;
            case R.id.btnCuenta:
                Bundle extras = new Bundle();
                Intent d = new Intent(Home.this, Account.class);
                extras.putString("Id", idUsuario);
                d.putExtras(extras);
                startActivity(d);
                break;
            case R.id.btnlink:
            direccion="https://www.eltiempo.com/noticias/reciclaje-en-bogota";
            irAweb(direccion);
                break;

                default:
                break;

}
    }

    public void irAweb(String d){
        Uri uri = Uri.parse(d);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}


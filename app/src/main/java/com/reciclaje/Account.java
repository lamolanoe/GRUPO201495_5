package com.reciclaje;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;
import com.reciclaje.perfil.PerfilActivity;
import com.reciclaje.persona.MostrarEditarPersonaActivity;

public class Account extends AppCompatActivity implements View.OnClickListener {
Button btnEditar,btnEliminar,btnMostrar,btnSalir, btnCambiarPassword;
    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;

int id=0;
Usuario u;
UsuarioDao dao;

    String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }

        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnReciclar = (ImageButton) findViewById(R.id.btnReciclaje);
        btnPuntos = (ImageButton) findViewById(R.id.btnPuntos);

        btnReciclar.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnHome.setOnClickListener(this);

        btnCambiarPassword = (Button) findViewById(R.id.btnCambiarPassword);
        btnCambiarPassword.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditar:
                Intent a=new Intent(Account.this,Editar.class);
                //a.putExtra("Id",id);
                startActivity(a);
                break;
            case R.id.btnEliminar:
                AlertDialog.Builder b= new AlertDialog.Builder(this);
                b.setMessage("¿Estas seguro de eliminar tu cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dao.deleteUsuario(id)) {
                            Toast.makeText(Account.this, "Registro Eliminado", Toast.LENGTH_LONG).show();
                            Intent a = new Intent(Account.this, LoginActivity.class);
                            startActivity(a);
                            finish();
                        }else{
                            Toast.makeText(Account.this, "Error", Toast.LENGTH_LONG).show();

                        }
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
                break;
            case R.id.btnMostrar:
                Bundle extras = new Bundle();
                Intent c=new Intent(Account.this, MostrarEditarPersonaActivity.class);
                extras.putString("Id", idUsuario);
                c.putExtras(extras);
                startActivity(c);
                break;
            case R.id.btnSalir:
                Intent i2=new Intent(Account.this,LoginActivity.class);
                startActivity(i2);
                finish();
                break;
            case R.id.btnHome:
                Intent g = new Intent(Account.this, Home.class);
                startActivity(g);
                break;
            case R.id.btnReciclaje:
                Intent p = new Intent(Account.this, Reciclaje.class);
                startActivity(p);

                break;
            case R.id.btnPuntos:
                Intent d = new Intent(Account.this, Puntos.class);
                startActivity(d);
                break;
            case R.id.btnCuenta:

                break;
            case R.id.btnCambiarPassword:
                Bundle e = new Bundle();
                Intent cp = new Intent(Account.this, CambioPasswordActivity.class);
                e.putString("Id", idUsuario);
                cp.putExtras(e);
                startActivity(cp);
                break;
        }
    }
}
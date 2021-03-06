package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Usuario;

public class Editar extends AppCompatActivity implements View.OnClickListener {
    EditText ediUser, ediPass, ediNombre, ediCiudad;
    Button btnActualizar, btnCancelar;
    int id = 0;
    Usuario u;
    UsuarioDao dao;
    Intent x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        ediUser = (EditText) findViewById(R.id.EdiUser);
        ediPass = (EditText) findViewById(R.id.EdiPass);
        ediNombre = (EditText) findViewById(R.id.EdiNombre);
        ediCiudad = (EditText) findViewById(R.id.EdiCiudad);
        btnActualizar = (Button) findViewById(R.id.btnEdiActualizar);
        btnCancelar = (Button) findViewById(R.id.btnEdiCancelar);
        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id = b.getInt("Id");
        dao = new UsuarioDao(this);
        u = dao.getUsuarioById(id);
        ediUser.setText(u.getUsuario());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEdiActualizar:

                u.setUsuario(ediUser.getText().toString());
                u.setUsuario(ediPass.getText().toString());
                u.setUsuario(ediNombre.getText().toString());
                u.setUsuario(ediCiudad.getText().toString());
                if (!u.isNull()) {
                    Toast.makeText(this, "Error: Campos Vacios", Toast.LENGTH_LONG).show();
                } else if (dao.updateUsuario(u)) {
                    Toast.makeText(this, "Acualización Exitosa", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Editar.this, Account.class);
                    i2.putExtra("Id",u.getId());
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this, "No se puede actualizar", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnEdiCancelar:
                Intent i2 = new Intent(Editar.this, Account.class);

                startActivity(i2);
                finish();
                break;
        }
    }
}




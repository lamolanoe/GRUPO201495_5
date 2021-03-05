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
import com.reciclaje.persona.CrearPersonaActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
    EditText us, pas, nom, ciu;
    Button reg, can;
    UsuarioDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        us=(EditText)findViewById(R.id.RegUser);
        pas=(EditText)findViewById(R.id.RegPass);
        nom=(EditText)findViewById(R.id.RegNombre);
        ciu=(EditText)findViewById(R.id.RegCiudad);
        reg=(Button) findViewById(R.id.btnRegRegistrar);
        can=(Button) findViewById(R.id.btnRegCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new UsuarioDao(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegRegistrar:
                Usuario u = new Usuario();
                u.setUsuario(us.getText().toString());
                String pass = pas.getText().toString();
                u.setPassword(codePassword(pass));
                u.setNombre(nom.getText().toString());
                u.setCiudad(ciu.getText().toString());
                if(!u.isNull()) {
                    Toast.makeText(this, "Error: Campos Vacios", Toast.LENGTH_LONG).show();
                }else {
                    Long id = dao.insertUsuario(u);
                    if (id != null) {
                        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                        Bundle extras = new Bundle();
                        Intent i2 = new Intent(Registrar.this, CrearPersonaActivity.class);
                        extras.putString("id", id.toString());
                        i2.putExtras(extras);
                        startActivity(i2);
                        finish();
                    } else {
                        Toast.makeText(this, "Usuario ya Registrado", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.btnRegCancelar:
                Intent i = new Intent(Registrar.this, LoginActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }

    public String codePassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
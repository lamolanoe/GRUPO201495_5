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
import com.reciclaje.ui.account.AccountFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText user, pass;
    Button btnEntrar, btnRegistrar;
    UsuarioDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText) findViewById(R.id.User);
        pass=(EditText) findViewById(R.id.Pass);
        btnEntrar=(Button) findViewById(R.id.btnEntrar);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrar);
        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new UsuarioDao(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEntrar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error: Campos Vacios",Toast.LENGTH_LONG).show();
                }else if (dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this,"Datos Correctos",Toast.LENGTH_LONG).show();
                    Bundle extras = new Bundle();
                    Intent i2=new Intent(LoginActivity.this, Home.class);
                    extras.putString("Id", String.valueOf(ux.getId()));
                    i2.putExtras(extras);
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"Usuario y/o Password Incorrectos",Toast.LENGTH_LONG).show();

                }

                break;
            case R.id.btnRegistrar:
                Intent i=new Intent(LoginActivity.this,Registrar.class);
                startActivity(i);
                break;
        }

    }

}
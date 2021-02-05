package com.reciclaje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reciclaje.R;

import java.sql.BatchUpdateException;

public class LoginActivity extends Activity {

    private EditText etUsuario;
    private EditText etContrasena;
    private Button btnIniciar;
    private Button btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText) findViewById(R.id.et_usuario);
        etContrasena = (EditText) findViewById(R.id.et_contrasena);
        btnIniciar = (Button) findViewById(R.id.btn_iniciar);
        btnNuevo = (Button) findViewById(R.id.btn_nuevo);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsuario.getText().toString().equals("grupo5") &&
                        etContrasena.getText().toString().equals("1234")){
                    Intent i=new Intent (LoginActivity.this, MainActivity.class);
                    Bundle b=new Bundle();
                    b.putString("user",etUsuario.getText().toString());
                    i.putExtras(b);
                    startActivity(i);

                }
                else{
                    Toast.makeText(getApplicationContext(), R.string.mensaje_error,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

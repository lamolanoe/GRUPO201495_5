package com.reciclaje.persona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reciclaje.Home;
import com.reciclaje.MainActivity;
import com.reciclaje.R;
import com.reciclaje.model.dao.PersonaDao;
import com.reciclaje.model.entity.Persona;

public class CrearPersonaActivity extends AppCompatActivity implements View.OnClickListener{

    PersonaDao personaDao;
    Button guardar, cancelar;
    String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("id");
        }

        guardar=(Button) findViewById(R.id.btnCrearPersona);
        //cancelar=(Button) findViewById(R.id.btnCancelar);
        guardar.setOnClickListener(this);
        //cancelar.setOnClickListener(this);
        personaDao = new PersonaDao(this);
    }

    @Override
    public void onClick(View v) {

        Persona persona = new Persona();

        switch (v.getId()) {
            case R.id.btnCrearPersona:
                persona.setNombre(((EditText) findViewById(R.id.crearNombre)).getText().toString());
                persona.setApellido(((EditText) findViewById(R.id.crearApellido)).getText().toString());
                persona.setCorreo(((EditText) findViewById(R.id.crearCorreo)).getText().toString());
                persona.setTelefono(((EditText) findViewById(R.id.crearTelefono)).getText().toString());
                persona.setIdUsuario(Integer.parseInt(idUsuario));
                Long idPersona = personaDao.createPersona(persona);

                if (idPersona != null) {
                    Toast exitoso = Toast.makeText(getApplicationContext(), "Información guardada exitosamente", Toast.LENGTH_LONG);
                    exitoso.setGravity(Gravity.RIGHT, 200, 50);
                    exitoso.show();
                } else {
                    Toast error = Toast.makeText(getApplicationContext(), "Error al guardar la información", Toast.LENGTH_LONG);
                    error.setGravity(Gravity.RIGHT, 200, 50);
                    error.show();
                }

                Bundle extras = new Bundle();
                Intent intent = new Intent(CrearPersonaActivity.this, Home.class);
                extras.putString("id", idUsuario);
                intent.putExtras(extras);
                startActivity(intent);

                break;

            /*case R.id.btnCancelar:
                Intent i = new Intent(CrearPersonaActivity.this, MainActivity.class);
                startActivity(i);

                break;*/
        }

    }

}
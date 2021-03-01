package com.reciclaje.persona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reciclaje.MainActivity;
import com.reciclaje.R;
import com.reciclaje.model.dao.PersonaDao;
import com.reciclaje.model.entity.Persona;

public class MostrarEditarPersonaActivity extends AppCompatActivity {

    String idUsuario;
    PersonaDao personaDao;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_editar_persona);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }

        personaDao = new PersonaDao(this);
        persona = personaDao.getPersonaByIdUsuario(idUsuario);

        EditText et_nombre = findViewById(R.id.editNombrePersona);
        et_nombre.setText(persona.getNombre());
        EditText et_apellido = findViewById(R.id.editapellidoPersona);
        et_apellido.setText(persona.getApellido());
        /*EditText et_usuario = findViewById(R.id.editUsuarioPersona);
        et_usuario.setText("laura");*/
        EditText et_email = findViewById(R.id.editCorreoPersona);
        et_email.setText(persona.getCorreo());
        EditText et_telefono = findViewById(R.id.editTelefonoPersona);
        et_telefono.setText(persona.getTelefono());

        Button btnEditPersona = (Button) findViewById(R.id.editPersona);
        btnEditPersona.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                persona.setNombre(et_nombre.getText().toString());
                persona.setApellido(et_apellido.getText().toString());
                persona.setCorreo(et_email.getText().toString());
                persona.setTelefono(et_telefono.getText().toString());
                int idPersona = personaDao.updatePersona(persona);
                if (idPersona == 1) {
                    Toast exitoso = Toast.makeText(getApplicationContext(), "Información actualiazada exitosamente", Toast.LENGTH_LONG);
                    exitoso.setGravity(Gravity.RIGHT, 200, 50);
                    exitoso.show();
                } else {
                    Toast error = Toast.makeText(getApplicationContext(), "Error al actualizar la información", Toast.LENGTH_LONG);
                    error.setGravity(Gravity.RIGHT, 0, 0);
                    error.show();
                }
            }
        });
    }


}
package com.reciclaje.persona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.reciclaje.R;
import com.reciclaje.model.dao.PersonaDao;
import com.reciclaje.model.entity.Persona;

public class MostrarEditarPersonaActivity extends AppCompatActivity {

    String idUsuario;
    PersonaDao personaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_editar_persona);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }

        personaDao = new PersonaDao(this);
        Persona persona = personaDao.getPersonaByIdUsuario(idUsuario);

        EditText et_nombre = findViewById(R.id.editNombrePersona);
        et_nombre.setText(persona.getNombre());
        EditText et_apellido = findViewById(R.id.editapellidoPersona);
        et_apellido.setText(persona.getApellido());
        EditText et_email = findViewById(R.id.editCorreoPersona);
        et_email.setText(persona.getCorreo());
        EditText et_telefono = findViewById(R.id.editTelefonoPersona);
        et_telefono.setText(persona.getTelefono());
    }
}
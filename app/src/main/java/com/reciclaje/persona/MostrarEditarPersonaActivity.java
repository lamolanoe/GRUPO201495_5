package com.reciclaje.persona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.reciclaje.Account;
import com.reciclaje.CambioPasswordActivity;
import com.reciclaje.Home;
import com.reciclaje.Puntos;
import com.reciclaje.R;
import com.reciclaje.Reciclaje;
import com.reciclaje.model.dao.PersonaDao;
import com.reciclaje.model.dao.UsuarioDao;
import com.reciclaje.model.entity.Persona;
import com.reciclaje.model.entity.Usuario;

public class MostrarEditarPersonaActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnHome,btnReciclar,btnPuntos,btnCuenta;
    Button guardar;
    EditText et_nombre, et_apellido, et_usuario, et_email, et_telefono;
    String idUsuario;
    PersonaDao personaDao;
    Persona persona;
    UsuarioDao usuarioDao;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_editar_persona);

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            idUsuario = getIntent().getStringExtra("Id");
        }

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnReciclar = (ImageButton) findViewById(R.id.btnReciclaje);
        btnPuntos = (ImageButton) findViewById(R.id.btnPuntos);
        btnCuenta = (ImageButton) findViewById(R.id.btnCuenta);

        btnReciclar.setOnClickListener(this);
        btnPuntos.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnCuenta.setOnClickListener(this);

        guardar=(Button) findViewById(R.id.editPersona);
        guardar.setOnClickListener(this);

        personaDao = new PersonaDao(this);
        usuarioDao = new UsuarioDao(this);
        persona = personaDao.getPersonaByIdUsuario(idUsuario);
        usuario = usuarioDao.getUsuarioById(Integer.parseInt(idUsuario));

        et_nombre = findViewById(R.id.editNombrePersona);
        et_nombre.setText(persona.getNombre());
        et_apellido = findViewById(R.id.editapellidoPersona);
        et_apellido.setText(persona.getApellido());
        et_usuario = findViewById(R.id.editUsuarioPersona);
        et_usuario.setText(usuario.getUsuario());
        et_email = findViewById(R.id.editCorreoPersona);
        et_email.setText(persona.getCorreo());
        et_telefono = findViewById(R.id.editTelefonoPersona);
        et_telefono.setText(persona.getTelefono());

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.editPersona:
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

                break;

            /*case R.id.btnCancelar:
                Intent i = new Intent(CrearPersonaActivity.this, MainActivity.class);
                startActivity(i);

                break;*/

            case R.id.btnHome:
                Bundle btnH = new Bundle();
                Intent g = new Intent(MostrarEditarPersonaActivity.this, Home.class);
                btnH.putString("Id", idUsuario);
                g.putExtras(btnH);
                startActivity(g);
                break;
            case R.id.btnReciclaje:
                Bundle btnR = new Bundle();
                Intent p = new Intent(MostrarEditarPersonaActivity.this, Reciclaje.class);
                btnR.putString("Id", idUsuario);
                p.putExtras(btnR);
                startActivity(p);
                break;
            case R.id.btnPuntos:
                Bundle btnP = new Bundle();
                Intent d = new Intent(MostrarEditarPersonaActivity.this, Puntos.class);
                btnP.putString("Id", idUsuario);
                d.putExtras(btnP);
                startActivity(d);
                break;
            case R.id.btnCuenta:
                Bundle btnC = new Bundle();
                Intent c = new Intent(MostrarEditarPersonaActivity.this, Account.class);
                btnC.putString("Id", idUsuario);
                c.putExtras(btnC);
                startActivity(c);
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Bundle btnC = new Bundle();
                Intent c = new Intent(MostrarEditarPersonaActivity.this, Account.class);
                btnC.putString("Id", idUsuario);
                c.putExtras(btnC);
                startActivity(c);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
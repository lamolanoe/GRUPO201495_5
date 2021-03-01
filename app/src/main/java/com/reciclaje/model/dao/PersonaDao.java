package com.reciclaje.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.reciclaje.model.entity.Persona;
import com.reciclaje.model.entity.Usuario;

public class PersonaDao {

    SQLiteDatabase sqLiteDatabase;
    Persona persona;
    Context context;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBPersonas";
    public static final String TABLE_NAME = "create table if not exists persona(idPersona integer primary key autoincrement, nombre text, apellido text, correo text, telefono text, idUsuario integer)";

    public PersonaDao(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(DATABASE_NAME, context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(TABLE_NAME);
        persona = new Persona();
    }

    public Long createPersona(Persona persona) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", persona.getNombre());
        contentValues.put("apellido", persona.getApellido());
        contentValues.put("correo", persona.getCorreo());
        contentValues.put("telefono", persona.getTelefono());
        contentValues.put("idUsuario", persona.getIdUsuario());
        return (sqLiteDatabase.insert("persona", null, contentValues));
    }

    public Persona getPersonaByIdPersona(String idPersona) {
        Persona persona = new Persona();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM persona where idPersona = ?", new String[] {idPersona});
        if (c.moveToLast()) {
            persona.setIdPersona(c.getInt(c.getColumnIndex("idPersona")));
            persona.setNombre(c.getString(c.getColumnIndex("nombre")));
            persona.setApellido(c.getString(c.getColumnIndex("apellido")));
            persona.setCorreo(c.getString(c.getColumnIndex("correo")));
            persona.setTelefono(c.getString(c.getColumnIndex("telefono")));
            persona.setIdUsuario(c.getInt(c.getColumnIndex("idUsuario")));
            return persona;
        }
        return null;
    }

    public Persona getPersonaByIdUsuario(String idUsuario) {
        Persona persona = new Persona();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM persona where idUsuario = ?", new String[] {idUsuario});
        if (c.moveToLast()) {
            persona.setIdPersona(c.getInt(c.getColumnIndex("idPersona")));
            persona.setNombre(c.getString(c.getColumnIndex("nombre")));
            persona.setApellido(c.getString(c.getColumnIndex("apellido")));
            persona.setCorreo(c.getString(c.getColumnIndex("correo")));
            persona.setTelefono(c.getString(c.getColumnIndex("telefono")));
            persona.setIdUsuario(c.getInt(c.getColumnIndex("idUsuario")));
            return persona;
        }
        return null;
    }

    public int updatePersona(Persona persona) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", persona.getNombre());
        contentValues.put("apellido", persona.getApellido());
        contentValues.put("correo", persona.getCorreo());
        contentValues.put("telefono", persona.getTelefono());
        return (sqLiteDatabase.update("persona", contentValues,"idPersona=?",new String[] {persona.getIdPersona().toString()}));
    }
}

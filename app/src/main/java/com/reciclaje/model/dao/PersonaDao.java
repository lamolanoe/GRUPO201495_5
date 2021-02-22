package com.reciclaje.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.reciclaje.model.entity.Persona;

public class PersonaDao {

    SQLiteDatabase sqLiteDatabase;
    Persona persona;
    Context context;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBPersonas";
    public static final String TABLE_NAME = "create table if not exists persona(idPersona integer primary key autoincrement, nombre text, apellido text, correo text, telefono text, idUsuario text)";

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
}

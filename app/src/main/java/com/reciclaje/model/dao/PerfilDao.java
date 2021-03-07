package com.reciclaje.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.reciclaje.model.entity.Perfil;
import com.reciclaje.model.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PerfilDao {

    SQLiteDatabase sqLiteDatabase;
    Perfil perfil;
    Context context;
    public static final String DATABASE_NAME = "DBPerfiles";
    public static final String TABLE_NAME = "create table if not exists perfil(idPerfil integer primary key autoincrement, descripcion text)";
    public static final String INSERT_PROFILE ="INSERT INTO perfil(descripcion) SELECT usuario WHERE NOT EXISTS (SELECT 1 FROM perfil WHERE descripcion = 'usuario'))";

    public PerfilDao(Context context){
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(DATABASE_NAME, context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(TABLE_NAME);
        sqLiteDatabase.execSQL(INSERT_PROFILE);
        perfil = new Perfil();
    }

    public Long createPerfil(Perfil perfil) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("descripcion", perfil.getDescripcion());
        return (sqLiteDatabase.insert("perfil", null, contentValues));
    }

    public int updatePerfil(Perfil perfil) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("descripcion", perfil.getDescripcion());
        return (sqLiteDatabase.update("perfil", contentValues,"idPerfil=?",new String[] {perfil.getIdPerfil().toString()}));
    }

    public Perfil getPerfilById(String idPerfil) {
        Perfil perfil = new Perfil();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM perfil where idPerfil = ?", new String[] {idPerfil});
        if (c.moveToLast()) {
            perfil.setIdPerfil(c.getInt(c.getColumnIndex("idPerfil")));
            perfil.setDescripcion(c.getString(c.getColumnIndex("descripcion")));
            return perfil;
        }
        return null;
    }

    public List<Perfil> getAllPerfil() {
        Perfil perfil = new Perfil();
        List<Perfil> list = new ArrayList<>();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM perfil", new String[] {});
        if (c.moveToLast()) {
            do {
                perfil.setIdPerfil(c.getInt(c.getColumnIndex("idPerfil")));
                perfil.setDescripcion(c.getString(c.getColumnIndex("descripcion")));
                list.add(perfil);
            }while(c.moveToNext());
        }
        return list;
    }
}

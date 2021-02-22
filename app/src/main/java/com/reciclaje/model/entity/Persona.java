package com.reciclaje.model.entity;

import java.util.UUID;

public class Persona {

    private String idPersona;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String idUsuario;

    public Persona(){}

    public Persona(String idPersona, String nombre, String apellido,
                  String correo, String telefono, String idUsuario) {
        this.idPersona = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.idUsuario = idUsuario;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}

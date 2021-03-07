package com.reciclaje.model.entity;

public class Perfil {

    private Integer idPerfil;
    private String descripcion;

    public Perfil() {}

    public Perfil(Integer idPerfil, String descripcion){
        this.descripcion = descripcion;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

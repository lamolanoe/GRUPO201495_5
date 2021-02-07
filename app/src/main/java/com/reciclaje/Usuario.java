package com.reciclaje;

public class Usuario {
    int Id;
    String Usuario, Password, Nombre, Ciudad;

    public Usuario() {
    }

    public Usuario(String usuario, String password, String nombre, String ciudad) {
        Usuario = usuario;
        Password = password;
        Nombre = nombre;
        Ciudad = ciudad;
    }

    public boolean isNull(){
        if(Nombre.equals("")&&Ciudad.equals("")&&Usuario.equals("")&&Password.equals("")){
            return  false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Ciudad='" + Ciudad + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }


}
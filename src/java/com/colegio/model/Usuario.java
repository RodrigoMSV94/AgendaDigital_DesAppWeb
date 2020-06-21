package com.colegio.model;

public class Usuario {
    
    private String id_usuario;
    private int dni_usuario; 
    private String nombre;
    private String apellido;
    private int id_perfil;

    public Usuario(String id_usuario, int dni_usuario, String nombre, String apellido, int id_perfil) {
        this.id_usuario = id_usuario;
        this.dni_usuario = dni_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_perfil = id_perfil;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(int dni_usuario) {
        this.dni_usuario = dni_usuario;
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

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    
    
}

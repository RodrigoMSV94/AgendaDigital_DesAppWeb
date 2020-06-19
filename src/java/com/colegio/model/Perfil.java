package com.colegio.model;

public class Perfil {
    
    private int id_perfil;
    private String tipo;

    public Perfil(int id_perfil, String tipo) {
        this.id_perfil = id_perfil;
        this.tipo = tipo;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}

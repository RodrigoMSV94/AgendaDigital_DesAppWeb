package com.colegio.model;

public class PeriodoEscolar {
    
    private int id_periodoEscolar;
    private String nombre;
    
    public PeriodoEscolar(int id_periodoEscolar, String nombre) {
        this.id_periodoEscolar = id_periodoEscolar;
        this.nombre = nombre;
    }

    public int getId_periodoEscolar() {
        return id_periodoEscolar;
    }

    public void setId_periodoEscolar(int id_periodoEscolar) {
        this.id_periodoEscolar = id_periodoEscolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

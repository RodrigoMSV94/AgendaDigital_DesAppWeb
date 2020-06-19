package com.colegio.model;

public class BarraNavegacion {
    private String nomControlador;
    private String nomOpcion;

    public BarraNavegacion(String nomControlador, String nomOpcion) {
        this.nomControlador = nomControlador;
        this.nomOpcion = nomOpcion;
    }

    public String getNomControlador() {
        return nomControlador;
    }

    public void setNomControlador(String nomControlador) {
        this.nomControlador = nomControlador;
    }

    public String getNomOpcion() {
        return nomOpcion;
    }

    public void setNomOpcion(String nomOpcion) {
        this.nomOpcion = nomOpcion;
    }
   
}

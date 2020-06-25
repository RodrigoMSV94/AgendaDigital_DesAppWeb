package com.colegio.model;

public class Grado {
    private String id_grado;
    private String grado;
    private String seccion;

    public Grado(String id_grado, String grado, String seccion) {
        this.id_grado = id_grado;
        this.grado = grado;
        this.seccion = seccion;
    }

    public String getId_grado() {
        return id_grado;
    }

    public void setId_grado(String id_grado) {
        this.id_grado = id_grado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
}


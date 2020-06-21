package com.colegio.model;

public class Matricula {
    
    private String id_matricula;
    private String id_alumno;
    private String id_grado;
    private String responsable_matricula;
    private String fecha_registro;

    public Matricula(String id_matricula, String id_alumno, String id_grado, String responsable_matricula, String fecha_registro) {
        this.id_matricula = id_matricula;
        this.id_alumno = id_alumno;
        this.id_grado = id_grado;
        this.responsable_matricula = responsable_matricula;
        this.fecha_registro = fecha_registro;
    }

    public String getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(String id_matricula) {
        this.id_matricula = id_matricula;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getId_grado() {
        return id_grado;
    }

    public void setId_grado(String id_grado) {
        this.id_grado = id_grado;
    }

    public String getResponsable_matricula() {
        return responsable_matricula;
    }

    public void setResponsable_matricula(String responsable_matricula) {
        this.responsable_matricula = responsable_matricula;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    

}

package com.colegio.model;

public class Tarea {

    private String id_empleado;
    private String id_curso;
    private String id_grado;
    private String descripcion;
    private String fecha_registro;
    
    private String nomCurso;

    public Tarea(String id_empleado, String id_curso, String id_grado, String descripcion, String fecha_registro) {
        this.id_empleado = id_empleado;
        this.id_curso = id_curso;
        this.id_grado = id_grado;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
    }

    public Tarea(String nomCurso, String descripcion) {
        this.nomCurso = nomCurso;
        this.descripcion = descripcion;
    }
    

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getId_grado() {
        return id_grado;
    }

    public void setId_grado(String id_grado) {
        this.id_grado = id_grado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }
    
}

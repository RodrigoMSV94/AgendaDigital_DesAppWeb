package com.colegio.model;

public class Incidencia {
    
    private String id_alumno;
    private String id_empleado;
    private String id_curso;
    private String descripcion;
    private String fecha_cita;
    
    private String nomCurso;

    public Incidencia(String id_alumno, String id_empleado, String id_curso, String descripcion, String fecha_cita) {
        this.id_alumno = id_alumno;
        this.id_empleado = id_empleado;
        this.id_curso = id_curso;
        this.descripcion = descripcion;
        this.fecha_cita = fecha_cita;
    }

    public Incidencia(String nomCurso,String descripcion) {
        this.nomCurso = nomCurso;
        this.descripcion = descripcion;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }
    
}

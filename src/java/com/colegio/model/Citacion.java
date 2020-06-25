package com.colegio.model;

public class Citacion {
    
    private int id_cita;
    private String id_alumno;
    private String id_empleado;
    private String motivo;
    private String fecha_cita;
    private String fecha_registro;
    
    private String nomDocente;
    private String apeDocente;
    
    private String nomAlumno;
    private String apeAlumno;
    
    public Citacion(int id_cita, String id_alumno, String id_empleado, String motivo, String fecha_cita, String fecha_registro) {
        this.id_cita = id_cita;
        this.id_alumno = id_alumno;
        this.id_empleado = id_empleado;
        this.motivo = motivo;
        this.fecha_cita = fecha_cita;
        this.fecha_registro = fecha_registro;
    }

    public Citacion(String nomDocente, String apeDocente,String motivo, String fecha_cita) {
        this.nomDocente = nomDocente;
        this.apeDocente = apeDocente;
        this.motivo = motivo;
        this.fecha_cita = fecha_cita;
    }

    public Citacion(int id_cita, String id_alumno, String nomAlumno, String apeAlumno, String motivo, String fecha_cita, String fecha_registro) {
        this.id_cita = id_cita;
        this.id_alumno = id_alumno;
        this.nomAlumno = nomAlumno;
        this.apeAlumno = apeAlumno;
        this.motivo = motivo;
        this.fecha_cita = fecha_cita;
        this.fecha_registro = fecha_registro;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getNomDocente() {
        return nomDocente;
    }

    public void setNomDocente(String nomDocente) {
        this.nomDocente = nomDocente;
    }

    public String getApeDocente() {
        return apeDocente;
    }

    public void setApeDocente(String apeDocente) {
        this.apeDocente = apeDocente;
    }

    public String getNomAlumno() {
        return nomAlumno;
    }

    public void setNomAlumno(String nomAlumno) {
        this.nomAlumno = nomAlumno;
    }

    public String getApeAlumno() {
        return apeAlumno;
    }

    public void setApeAlumno(String apeAlumno) {
        this.apeAlumno = apeAlumno;
    }
    
    
}

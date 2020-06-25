package com.colegio.model;

public class Asistencia {
    private String id_alumno;
    private String id_curso;
    private String id_grado;
    private int asistio;
    private String fecha_registro;
    
    private String nomCurso;
    
    private String nomAlumno;
    private String apeAlumno;
    
    public Asistencia(){}
    
    public Asistencia(String id_alumno, String id_curso, String id_grado, int asistio, String fecha_registro) {
        this.id_alumno = id_alumno;
        this.id_curso = id_curso;
        this.id_grado = id_grado;
        this.asistio = asistio;
        this.fecha_registro = fecha_registro;
    }

    public Asistencia(String id_alumno, String id_curso, String id_grado, int asistio, String fecha_registro, String nomAlumno, String apeAlumno) {
        this.id_alumno = id_alumno;
        this.id_curso = id_curso;
        this.id_grado = id_grado;
        this.asistio = asistio;
        this.fecha_registro = fecha_registro;
        this.nomAlumno = nomAlumno;
        this.apeAlumno = apeAlumno;
    }

    public Asistencia(String id_grado,String id_alumno , String nomAlumno, String apeAlumno, int asistio) {
        this.id_alumno = id_alumno;
        this.id_grado = id_grado;
        this.nomAlumno = nomAlumno;
        this.apeAlumno = apeAlumno;
        this.asistio = asistio;
    }

    public Asistencia(String nomCurso, int asistio) {
        this.nomCurso = nomCurso;
        this.asistio = asistio;
    }
    

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
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

    public int getAsistio() {
        return asistio;
    }

    public void setAsistio(int asistio) {
        this.asistio = asistio;
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

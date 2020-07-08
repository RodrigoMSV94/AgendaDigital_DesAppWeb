package com.colegio.model;

public class Calificacion {
    
    private String id_alumno;
    private String id_curso;
    private int practica_calificada_1;
    private int practica_calificada_2;
    private int practica_calificada_3;
    private int examen_final;
    private int promedio;
    private int id_periodoEscolar;
    
    private String nomCurso;
    
    private String nomAlumno;
    private String apeAlumno;

    public Calificacion(String id_alumno, String id_curso, int practica_calificada_1, int practica_calificada_2, int practica_calificada_3, int examen_final, int promedio, int id_periodoEscolar) {
        this.id_alumno = id_alumno;
        this.id_curso = id_curso;
        this.practica_calificada_1 = practica_calificada_1;
        this.practica_calificada_2 = practica_calificada_2;
        this.practica_calificada_3 = practica_calificada_3;
        this.examen_final = examen_final;
        this.promedio = promedio;
        this.id_periodoEscolar = id_periodoEscolar;
    }

    public Calificacion(String id_curso, String nomCurso,int practica_calificada_1, int practica_calificada_2, int practica_calificada_3, int examen_final) {
        this.id_curso = id_curso;
        this.nomCurso = nomCurso;
        this.practica_calificada_1 = practica_calificada_1;
        this.practica_calificada_2 = practica_calificada_2;
        this.practica_calificada_3 = practica_calificada_3;
        this.examen_final = examen_final;
    }

    public Calificacion(String id_alumno, String nomAlumno, String apeAlumno) {
        this.id_alumno = id_alumno;
        this.nomAlumno = nomAlumno;
        this.apeAlumno = apeAlumno;
    }
    
    public Calificacion(String id_alumno, String nomAlumno, String apeAlumno,int practica_calificada_1, int practica_calificada_2, int practica_calificada_3, int examen_final) {
        this.id_alumno = id_alumno;
        this.nomAlumno = nomAlumno;
        this.apeAlumno = apeAlumno;
        this.id_curso = id_curso;
        this.nomCurso = nomCurso;
        this.practica_calificada_1 = practica_calificada_1;
        this.practica_calificada_2 = practica_calificada_2;
        this.practica_calificada_3 = practica_calificada_3;
        this.examen_final = examen_final;
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

    public int getPractica_calificada_1() {
        return practica_calificada_1;
    }

    public void setPractica_calificada_1(int practica_calificada_1) {
        this.practica_calificada_1 = practica_calificada_1;
    }

    public int getPractica_calificada_2() {
        return practica_calificada_2;
    }

    public void setPractica_calificada_2(int practica_calificada_2) {
        this.practica_calificada_2 = practica_calificada_2;
    }

    public int getPractica_calificada_3() {
        return practica_calificada_3;
    }

    public void setPractica_calificada_3(int practica_calificada_3) {
        this.practica_calificada_3 = practica_calificada_3;
    }

    public int getExamen_final() {
        return examen_final;
    }

    public void setExamen_final(int examen_final) {
        this.examen_final = examen_final;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public int getId_periodoEscolar() {
        return id_periodoEscolar;
    }

    public void setId_periodoEscolar(int id_periodoEscolar) {
        this.id_periodoEscolar = id_periodoEscolar;
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

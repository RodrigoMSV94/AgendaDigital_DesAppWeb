package com.colegio.model;

public class Curso {
    private String id_curso;
    private String nombre;
    private String id_empleado;

    public Curso(String id_curso, String nombre, String id_empleado) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.id_empleado = id_empleado;
    }

    public Curso(String id_curso, String nombre) {
        this.id_curso = id_curso;
        this.nombre = nombre;
    }
    
    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    
}

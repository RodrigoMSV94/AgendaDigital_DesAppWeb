package com.colegio.model;

public class Empleado {
 
    private String id_empleado;
    private int dni_empleado;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String profesion;
    private String especialidad;
    private double sueldo;
    private int telefono;
    private String correo;
    private String contrasena;
    private String fecha_registro;
    private int id_perfil;
    private String estado;

    public Empleado(String id_empleado, int dni_empleado, String nombre, String apellido, int edad, String sexo, String profesion, String especialidad, double sueldo, int telefono, String correo, String contrasena, String fecha_registro, int id_perfil, String estado) {
        this.id_empleado = id_empleado;
        this.dni_empleado = dni_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.profesion = profesion;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fecha_registro = fecha_registro;
        this.id_perfil = id_perfil;
        this.estado = estado;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getDni_empleado() {
        return dni_empleado;
    }

    public void setDni_empleado(int dni_empleado) {
        this.dni_empleado = dni_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}

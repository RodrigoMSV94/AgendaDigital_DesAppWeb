package com.colegio.model;

public class Alumno {
    
    private String id_alumno;
    private int dni_alumno;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String lugar_nacimiento;
    private String direccion;
    private int telefono_emergencia;
    private String correo;
    private String contrasena;
    private String nombres_apoderado;
    private String ocupacion;
    private String fecha_registro;
    private int id_perfil;
    private String estado;

    public Alumno(String id_alumno, int dni_alumno, String nombre, String apellido, String fecha_nacimiento, String lugar_nacimiento, String direccion, int telefono_emergencia, String correo, String contrasena, String nombres_apoderado, String ocupacion, String fecha_registro, int id_perfil, String estado) {
        this.id_alumno = id_alumno;
        this.dni_alumno = dni_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.direccion = direccion;
        this.telefono_emergencia = telefono_emergencia;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombres_apoderado = nombres_apoderado;
        this.ocupacion = ocupacion;
        this.fecha_registro = fecha_registro;
        this.id_perfil = id_perfil;
        this.estado = estado;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getDni_alumno() {
        return dni_alumno;
    }

    public void setDni_alumno(int dni_alumno) {
        this.dni_alumno = dni_alumno;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono_emergencia() {
        return telefono_emergencia;
    }

    public void setTelefono_emergencia(int telefono_emergencia) {
        this.telefono_emergencia = telefono_emergencia;
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

    public String getNombres_apoderado() {
        return nombres_apoderado;
    }

    public void setNombres_apoderado(String nombres_apoderado) {
        this.nombres_apoderado = nombres_apoderado;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
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

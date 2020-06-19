package com.colegio.idao;

import com.colegio.model.Alumno;
import com.colegio.model.Empleado;

public interface ILoginDAO {
    public Empleado LoginEmpleado(String correo, String contrasena);
    public Alumno LoginAlumno(String correo, String contrasena);
}

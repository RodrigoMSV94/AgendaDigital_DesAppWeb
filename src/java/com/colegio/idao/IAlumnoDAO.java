package com.colegio.idao;

import com.colegio.model.Alumno;
import java.util.List;

public interface IAlumnoDAO {
    public List<Alumno> ListarAlumnos();
    public boolean RegistrarAlumno(Alumno objAlumno);
    public boolean ActualizarAlumno(Alumno objAlumno);
    public boolean EliminarAlumno(String id_alumno);
    public Alumno ObtenerAlumno(String id_alumno);
    public List<Alumno> ObtenerAlumnoPorDNI(int dni_alumno);
}

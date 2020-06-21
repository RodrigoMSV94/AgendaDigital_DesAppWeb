package com.colegio.idao;


import com.colegio.model.Citacion;
import java.util.List;

public interface ICitacionDAO {
    public List<Citacion> ListarCitacionesAlumno(String id_alumno);
    public List<Citacion> ListarCitacionesDocente(String id_empleado);
    public boolean RegistrarCitacion(Citacion objCitacion);
    public boolean ActualizarCitacion(Citacion objCitacion);
    public boolean EliminarCitacion(int id_cita);
    public Citacion ObtenerCitacion(int id_cita);
    public List<Citacion> ListarCitasAlumno(String id_alumno);
    public List<Citacion> ListarCitasAlumnoFecha(String id_alumno, String fecha_cita);
    
}

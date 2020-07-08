package com.colegio.idao;

import com.colegio.model.Calificacion;
import java.util.List;

public interface ICalificacionDAO {
    
    public List<Calificacion> ListarCalificaciones(String id_alumno,String id_curso);
    public boolean RegistrarCalificacion(Calificacion objCalificacion);
    public boolean ActualizarCalificacion(Calificacion objCalificacion);
    public boolean EliminarCalificacion(String id_alumno,String id_curso);
    public Calificacion ObtenerCalificacion(String id_alumno,String id_curso);
    public List<Calificacion> ListarCalifAlumnoPerEscolar(String id_alumno,int id_periodoEscolar);
    public List<Calificacion> ObtenerListarAlumGrado(String id_grado);
    public List<Calificacion> ListarCalifAlum(String id_grado, String id_alumno, int id_periodoEscolar);
    public List<Calificacion> ObtenerCalifAlumGrado(String id_grado,String id_alumno);
    
}

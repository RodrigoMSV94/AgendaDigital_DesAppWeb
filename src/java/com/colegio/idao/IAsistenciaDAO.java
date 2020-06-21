package com.colegio.idao;

import com.colegio.model.Asistencia;
import java.util.List;

public interface IAsistenciaDAO {
    
    public List<Asistencia> ListarAsistencias(String id_curso, String id_grado);
    public boolean RegistrarAsistencia(Asistencia objCitacion);
    public boolean ActualizarAsistencia(Asistencia objCitacion);
    public boolean EliminarAsistencia(String id_alumno,String id_curso,String id_grado,String fecha_registro);
    public Asistencia ObtenerAsistencia(String id_alumno,String id_curso,String id_grado,String fecha_registro);
    public List<Asistencia> ListarAsisAlumnoFecha(String id_alumno,String fecha_registro);
    
}

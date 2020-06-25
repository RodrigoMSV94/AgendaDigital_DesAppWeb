package com.colegio.idao;

import com.colegio.model.Incidencia;
import java.util.List;

public interface IIncidenciaDAO {
    
    public List<Incidencia> ListarIncidencias();
    public boolean RegistrarIncidencia(Incidencia objIncidencia);
    public boolean ActualizarIncidencia(Incidencia objIncidencia);
    public boolean EliminarIncidencia(String id_curso,String id_grado);
    public boolean EliminarIncAlumCurFecha(String id_alumno, String id_curso,String fecha_cita);
    public Incidencia ObtenerIncidencia(String id_curso,String id_grado);
    public Incidencia ObtenerIncAlumCurFecha(String id_alumno, String id_curso,String fecha_cita);
    public List<Incidencia> ListaIncAlumnoFecha(String id_alumno,String fecha_cita);
    public List<Incidencia> ListarIncDocente(String id_empleado,String fecha_ini, String fecha_fin);
    public List<Incidencia> ListarIncDocenteAlumno(String id_empleado, String id_alumno, String fecha_ini, String fecha_fin);
    
}

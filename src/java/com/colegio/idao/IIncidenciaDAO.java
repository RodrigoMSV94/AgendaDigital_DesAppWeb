package com.colegio.idao;

import com.colegio.model.Incidencia;
import java.util.List;

public interface IIncidenciaDAO {
    
    public List<Incidencia> ListarIncidencias();
    public boolean RegistrarIncidencia(Incidencia objIncidencia);
    public boolean ActualizarIncidencia(Incidencia objIncidencia);
    public boolean EliminarIncidencia(String id_curso,String id_grado);
    public Incidencia ObtenerIncidencia(String id_curso,String id_grado);
    public List<Incidencia> ListaIncAlumnoFecha(String id_alumno,String fecha_cita);
    
}

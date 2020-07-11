package com.colegio.idao;

import com.colegio.model.Tarea;
import java.util.List;

public interface ITareaDAO {
    
    public List<Tarea> ListarTareas();
    public boolean RegistrarTarea(Tarea objTarea);
    public boolean ActualizarTarea(Tarea objTarea);
    public boolean EliminarTarea(String id_curso,String id_grado);
    public Tarea ObtenerTarea(String id_curso,String id_grado, String fecha_registro);
    public List<Tarea> ListaTareaGradoFecha(String id_alumno,String fecha_registro);
    
}

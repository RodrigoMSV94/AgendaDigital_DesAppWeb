package com.colegio.idao;

import com.colegio.model.Matricula;
import java.util.List;

public interface IMatriculaDAO {
    public List<Matricula> ListarMatriculas();
    public boolean RegistrarMatricula(Matricula objMatricula);
    public boolean ActualizarMatricula(Matricula objMatricula);
    public boolean EliminarMatricula(String id_matricula);
    public Matricula ObtenerMatricula(String id_matricula);
    public Matricula ObtenerMatriculaAlumno(String id_alumno);
}

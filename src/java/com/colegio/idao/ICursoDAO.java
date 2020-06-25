package com.colegio.idao;

import com.colegio.model.Curso;
import java.util.List;

public interface ICursoDAO {
    public List<Curso> ListarCursos();
    public List<Curso> ListarCursoGrado(String id_grado);
}

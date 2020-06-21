package com.colegio.idao;

import com.colegio.model.PeriodoEscolar;
import java.util.List;

public interface IPeriodoEscolar {
    
    public List<PeriodoEscolar> ListarPeriodosEscolares();
    public boolean RegistrarPeriodoEscolar(PeriodoEscolar objPerioEscolar);
    public boolean ActualizarPeriodoEscolar(PeriodoEscolar objPerioEscolar);
    public boolean EliminarPeriodoEscolar(int id_periodoEscolar);
    public PeriodoEscolar ObtenerPeriodoEscolar(int id_periodoEscolar);
    
}

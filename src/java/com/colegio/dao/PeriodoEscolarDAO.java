package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IPeriodoEscolar;
import com.colegio.model.PeriodoEscolar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeriodoEscolarDAO implements IPeriodoEscolar{

    @Override
    public List<PeriodoEscolar> ListarPeriodosEscolares() {
        List<PeriodoEscolar> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultquery = statement.executeQuery("{call usp_ListarPeriodosEscolares}");
            while (resultquery.next()) {
                lista.add(
                        new PeriodoEscolar(
                                resultquery.getInt(1),
                                resultquery.getString(2)
                        )
                );
            }
            resultquery.close();
            statement.close();
            objBDConnection.desconectarBD();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean RegistrarPeriodoEscolar(PeriodoEscolar objPerioEscolar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarPeriodoEscolar(PeriodoEscolar objPerioEscolar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarPeriodoEscolar(int id_periodoEscolar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PeriodoEscolar ObtenerPeriodoEscolar(int id_periodoEscolar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

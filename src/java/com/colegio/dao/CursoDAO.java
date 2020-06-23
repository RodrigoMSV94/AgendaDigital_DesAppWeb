package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.ICursoDAO;
import com.colegio.model.Curso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements ICursoDAO{

    @Override
    public List<Curso> ListarCursos() {
        List<Curso> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultquery = statement.executeQuery("{call usp_ListarCursos}");
            while (resultquery.next()) {
                lista.add(
                        new Curso(
                                resultquery.getString(1),
                                resultquery.getString(2),
                                resultquery.getString(3)
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
    
}
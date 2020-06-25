package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IGradoDAO;
import com.colegio.model.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GradoDAO implements IGradoDAO{

    @Override
    public List<Grado> ListarGrado() {
        List<Grado> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultquery = statement.executeQuery("{call usp_ListarGrados}");
            while (resultquery.next()) {
                lista.add(
                        new Grado(
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

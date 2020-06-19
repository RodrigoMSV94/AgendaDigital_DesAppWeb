package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IPerfilDAO;
import com.colegio.model.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PerfilDAO implements IPerfilDAO{

    @Override
    public List<Perfil> ListarPerfiles() {
        List<Perfil> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultquery = statement.executeQuery("{call usp_ListarPerfiles}");
            while (resultquery.next()) {
                lista.add(
                        new Perfil(
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
    public boolean RegistrarPerfil(Perfil objPerfil) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarPerfil(?)}");
            pst.setString(1, objPerfil.getTipo());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean ActualizarPerfil(Perfil objPerfil) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarPerfil(?,?)}");
            pst.setInt(1, objPerfil.getId_perfil());
            pst.setString(2, objPerfil.getTipo());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean EliminarPerfil(int id_perfil) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_EliminarPerfil(?)}");
            pst.setInt(1,id_perfil);
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public Perfil ObtenerPerfil(int id_perfil) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Perfil objPerfil = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerPerfil(?)}");
            pst.setInt(1, id_perfil);
            
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objPerfil = new Perfil(
                        res.getInt(1), 
                        res.getString(2)
                );
            }
            
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return objPerfil;
    }
    
}

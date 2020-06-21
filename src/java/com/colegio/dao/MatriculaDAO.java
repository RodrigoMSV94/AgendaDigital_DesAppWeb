package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IMatriculaDAO;
import com.colegio.model.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO implements IMatriculaDAO{

    @Override
    public List<Matricula> ListarMatriculas() {
        List<Matricula> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultquery = statement.executeQuery("{call usp_ListarMatriculas}");
            while (resultquery.next()) {
                lista.add(
                        new Matricula(
                                resultquery.getString(1),
                                resultquery.getString(2),
                                resultquery.getString(3),
                                resultquery.getString(4),
                                resultquery.getString(5)
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
    public boolean RegistrarMatricula(Matricula objMatricula) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarMatricula(?,?,?,?)}");
            pst.setString(1, objMatricula.getId_alumno());
            pst.setString(2, objMatricula.getId_grado());
            pst.setString(3, objMatricula.getId_matricula());
            pst.setString(4, objMatricula.getFecha_registro());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean ActualizarMatricula(Matricula objMatricula) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarMatricula(?,?,?,?,?)}");
            pst.setString(1, objMatricula.getId_matricula());
            pst.setString(2, objMatricula.getId_alumno());
            pst.setString(3, objMatricula.getId_grado());
            pst.setString(4, objMatricula.getId_matricula());
            pst.setString(5, objMatricula.getFecha_registro());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean EliminarMatricula(String id_matricula) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_EliminarMatricula(?)}");
            pst.setString(1,id_matricula);
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public Matricula ObtenerMatricula(String id_matricula) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Matricula objMatricula = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerMatricula(?)}");
            pst.setString(1, id_matricula);
            
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objMatricula = new Matricula(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)
                );
            }
            
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            objMatricula = null;
        }
        return objMatricula;
    }

    @Override
    public Matricula ObtenerMatriculaAlumno(String id_alumno) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Matricula objMatricula = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerMatriculaAlumno(?)}");
            pst.setString(1, id_alumno);
            
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objMatricula = new Matricula(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)
                );
            }
            
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            objMatricula = null;
        }
        return objMatricula;
    }
    
}

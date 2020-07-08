package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.ICalificacionDAO;
import com.colegio.model.Calificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalificacionDAO implements ICalificacionDAO{

    @Override
    public List<Calificacion> ListarCalificaciones(String id_alumno, String id_curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarCalificacion(Calificacion objCalificacion) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;

        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarCalificacion(?,?,?,?,?,?,?,?)}");
            pst.setString(1, objCalificacion.getId_alumno());
            pst.setString(2, objCalificacion.getId_curso());
            pst.setInt(3, objCalificacion.getPractica_calificada_1());
            pst.setInt(4, objCalificacion.getPractica_calificada_1());
            pst.setInt(5, objCalificacion.getPractica_calificada_1());
            pst.setInt(6, objCalificacion.getExamen_final());
            pst.setInt(7, objCalificacion.getPromedio());
            pst.setInt(8, objCalificacion.getId_periodoEscolar());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return rpta;
    }

    @Override
    public boolean ActualizarCalificacion(Calificacion objCalificacion) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        System.out.println("objCalificacion.getId_alumno(): " + objCalificacion.getId_alumno());
        System.out.println("objCalificacion.getId_curso(): " + objCalificacion.getId_curso());
        System.out.println("objCalificacion.getPractica_calificada_1(): " + objCalificacion.getPractica_calificada_1());
        System.out.println("objCalificacion.getPractica_calificada_2(): " + objCalificacion.getPractica_calificada_2());
        System.out.println("objCalificacion.getPractica_calificada_3(): " + objCalificacion.getPractica_calificada_3());
        System.out.println("objCalificacion.getExamen_final(): " + objCalificacion.getExamen_final());
        System.out.println("objCalificacion.getPromedio(): " + objCalificacion.getPromedio());
        System.out.println("objCalificacion.getId_periodoEscolar(): " + objCalificacion.getId_periodoEscolar());
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarCalificacion(?,?,?,?,?,?,?,?)}");
            pst.setString(1, objCalificacion.getId_alumno());
            pst.setString(2, objCalificacion.getId_curso());
            pst.setInt(3, objCalificacion.getPractica_calificada_1());
            pst.setInt(4, objCalificacion.getPractica_calificada_2());
            pst.setInt(5, objCalificacion.getPractica_calificada_3());
            pst.setInt(6, objCalificacion.getExamen_final());
            pst.setInt(7, objCalificacion.getPromedio());
            pst.setInt(8, objCalificacion.getId_periodoEscolar());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return rpta;
    }

    @Override
    public boolean EliminarCalificacion(String id_alumno, String id_curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public Calificacion ObtenerCalificacion(String id_alumno, String id_curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Calificacion> ObtenerListarAlumGrado(String id_grado) {
        List<Calificacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerListarAlumGrado(?)}");
            pst.setString(1, id_grado);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Calificacion(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getString(3)
                    )
                );
            }
            pst.close();
            objBDConnection.desconectarBD();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    //CalificacionAlumnoController
    @Override
    public List<Calificacion> ListarCalifAlumnoPerEscolar(String id_alumno, int id_periodoEscolar) {
        List<Calificacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarCalifAlumnoPerEscolar(?,?)}");
            pst.setString(1, id_alumno);
            pst.setInt(2, id_periodoEscolar);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Calificacion(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getInt(3),
                        resultquery.getInt(4),
                        resultquery.getInt(5),
                        resultquery.getInt(6)
                    )
                );
            }
            pst.close();
            objBDConnection.desconectarBD();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Calificacion> ListarCalifAlum(String id_grado,String id_curso, int id_periodoEscolar) {
        List<Calificacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarCalifAlum(?,?,?)}");
            pst.setString(1, id_grado);
            pst.setString(2, id_curso);
            pst.setInt(3, id_periodoEscolar);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Calificacion(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        resultquery.getInt(4),
                        resultquery.getInt(5),
                        resultquery.getInt(6),
                        resultquery.getInt(7)
                    )
                );
            }
            pst.close();
            objBDConnection.desconectarBD();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Calificacion> ObtenerCalifAlumGrado(String id_grado, String id_alumno) {
        List<Calificacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerCalifAlumGrado(?,?)}");
            pst.setString(1, id_grado);
            pst.setString(2, id_alumno);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Calificacion(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        0,
                        0,
                        0,
                        0
                    )
                );
            }
            pst.close();
            objBDConnection.desconectarBD();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
}

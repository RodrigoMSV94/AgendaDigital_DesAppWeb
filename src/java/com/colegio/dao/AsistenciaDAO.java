package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IAsistenciaDAO;
import com.colegio.model.Asistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO implements IAsistenciaDAO{

    @Override
    public List<Asistencia> ListarAsistencias(String id_curso, String id_grado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarAsistencia(Asistencia objCitacion) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarAsistencia(?,?,?,?,?)}");
            pst.setString(1, objCitacion.getId_alumno());
            pst.setString(2, objCitacion.getId_curso());
            pst.setString(3, objCitacion.getId_grado());
            pst.setInt(4, objCitacion.getAsistio());
            pst.setString(5, objCitacion.getFecha_registro());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean ActualizarAsistencia(Asistencia objCitacion) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarAsistencia(?,?,?,?,?)}");
            pst.setString(1, objCitacion.getId_alumno());
            pst.setString(2, objCitacion.getId_curso());
            pst.setString(3, objCitacion.getId_grado());
            pst.setInt(4, objCitacion.getAsistio());
            pst.setString(5, objCitacion.getFecha_registro());
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
    public boolean EliminarAsistencia(String id_alumno, String id_curso, String id_grado, String fecha_registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asistencia ObtenerAsistencia(String id_alumno, String id_curso, String id_grado, String fecha_registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asistencia> ListarAsisAlumnoFecha(String id_alumno, String fecha_registro) {
        List<Asistencia> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarAsisAlumnoFecha(?,?)}");
            pst.setString(1, id_alumno);
            pst.setString(2, fecha_registro);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Asistencia(
                        resultquery.getString(1),
                        resultquery.getInt(2)
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
    public List<Asistencia> ObtenerListarAsisGraCurFecha(String id_grado, String id_curso, String fecha_registro) {
        List<Asistencia> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerListarAsisGraCurFecha(?,?,?)}");
            pst.setString(1, id_grado);
            pst.setString(2, id_curso);
            pst.setString(3, fecha_registro);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Asistencia(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        resultquery.getString(4),
                        resultquery.getInt(5)
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
    public List<Asistencia> ObtenerListarAsisGra(String id_grado) {
        List<Asistencia> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerListarAsisGra(?)}");
            pst.setString(1, id_grado);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Asistencia(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        resultquery.getString(4),
                        1
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

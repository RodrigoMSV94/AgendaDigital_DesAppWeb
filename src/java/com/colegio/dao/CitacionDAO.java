package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.ICitacionDAO;
import com.colegio.model.Citacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitacionDAO implements ICitacionDAO{

    @Override
    public boolean RegistrarCitacion(Citacion objCitacion) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarCitacion(?,?,?,?,?)}");
            pst.setString(1, objCitacion.getId_alumno());
            pst.setString(2, objCitacion.getId_empleado());
            pst.setString(3, objCitacion.getMotivo());
            pst.setString(4, objCitacion.getFecha_cita());
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
    public boolean ActualizarCitacion(Citacion objCitacion) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarCitacion(?,?,?,?,?,?)}");
            pst.setInt(1, objCitacion.getId_cita());
            pst.setString(2, objCitacion.getId_alumno());
            pst.setString(3, objCitacion.getId_empleado());
            pst.setString(4, objCitacion.getMotivo());
            pst.setString(5, objCitacion.getFecha_cita());
            pst.setString(6, objCitacion.getFecha_registro());

            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean EliminarCitacion(int id_cita) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_EliminarCitacion(?)}");
            pst.setInt(1,id_cita);
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public Citacion ObtenerCitacion(int id_cita) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Citacion objCitacion = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerCitacion(?)}");
            pst.setInt(1, id_cita);
            //int id_cita, String id_alumno, String id_empleado, String motivo, String fecha_cita, String fecha_registro
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objCitacion = new Citacion(
                        res.getInt(1), 
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6)
                );
            }
            
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return objCitacion;
    }

    @Override
    public List<Citacion> ListarCitasAlumno(String id_alumno) {
        List<Citacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarCitasAlumno(?)}");
            pst.setString(1, id_alumno);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Citacion(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        resultquery.getString(4)
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
    public List<Citacion> ListarCitasAlumnoFecha(String id_alumno, String fecha_cita) {
        List<Citacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarCitasAlumnoFecha(?,?)}");
            pst.setString(1, id_alumno);
            pst.setString(2, fecha_cita);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Citacion(
                        resultquery.getString(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        resultquery.getString(4)
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
    public List<Citacion> ListarCitasDocente(String id_empleado, String fecha_ini, String fecha_fin) {
        List<Citacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarCitasDocente(?,?,?)}");
            pst.setString(1, id_empleado);
            pst.setString(2, fecha_ini);
            pst.setString(3, fecha_fin);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Citacion(
                        resultquery.getInt(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        resultquery.getString(4),
                        resultquery.getString(5),
                        resultquery.getString(6),
                        resultquery.getString(7)
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
    public List<Citacion> ListarCitDocenAlumno(String id_empleado, String id_alumno, String fecha_ini, String fecha_fin) {
        List<Citacion> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarCitDocenAlumno(?,?,?,?)}");
            pst.setString(1, id_empleado);
            pst.setString(2, id_alumno);
            pst.setString(3, fecha_ini);
            pst.setString(4, fecha_fin);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Citacion(
                        resultquery.getInt(1),
                        resultquery.getString(2),
                        resultquery.getString(3),
                        resultquery.getString(4),
                        resultquery.getString(5),
                        resultquery.getString(6),
                        resultquery.getString(7)
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
    public List<Citacion> ListarCitacionesAlumno(String id_alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Citacion> ListarCitacionesDocente(String id_empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

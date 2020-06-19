package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.model.Alumno;
import com.colegio.idao.IAlumnoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO implements IAlumnoDAO{

    @Override
    public List<Alumno> ListarAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultquery = statement.executeQuery("{call usp_ListarAlumnos}");
            while (resultquery.next()) {
                lista.add(
                        new Alumno(
                                resultquery.getString(1),
                                resultquery.getInt(2),
                                resultquery.getString(3),
                                resultquery.getString(4),
                                resultquery.getString(5),
                                resultquery.getString(6),
                                resultquery.getString(7),
                                resultquery.getInt(8),
                                resultquery.getString(9),
                                resultquery.getString(10),
                                resultquery.getString(11),
                                resultquery.getString(12),
                                resultquery.getString(13),
                                resultquery.getInt(14),
                                resultquery.getString(15)
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
    public boolean RegistrarAlumno(Alumno objAlumno) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setInt(1, objAlumno.getDni_alumno());
            pst.setString(2, objAlumno.getNombre());
            pst.setString(3, objAlumno.getApellido());
            pst.setString(4, objAlumno.getFecha_nacimiento());
            pst.setString(5, objAlumno.getLugar_nacimiento());
            pst.setString(6, objAlumno.getDireccion());
            pst.setInt(7, objAlumno.getTelefono_emergencia());
            pst.setString(8, objAlumno.getCorreo());
            pst.setString(9, objAlumno.getContrasena());
            pst.setString(10, objAlumno.getNombres_apoderado());
            pst.setString(11, objAlumno.getOcupacion());
            pst.setString(12, objAlumno.getFecha_registro());
            pst.setInt(13, objAlumno.getId_perfil());
            pst.setString(14, objAlumno.getEstado());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean ActualizarAlumno(Alumno objAlumno) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, objAlumno.getId_alumno());
            pst.setInt(2, objAlumno.getDni_alumno());
            pst.setString(3, objAlumno.getNombre());
            pst.setString(4, objAlumno.getApellido());
            pst.setString(5, objAlumno.getFecha_nacimiento());
            pst.setString(6, objAlumno.getLugar_nacimiento());
            pst.setString(7, objAlumno.getDireccion());
            pst.setInt(8, objAlumno.getTelefono_emergencia());
            pst.setString(9, objAlumno.getCorreo());
            pst.setString(10, objAlumno.getContrasena());
            pst.setString(11, objAlumno.getNombres_apoderado());
            pst.setString(12, objAlumno.getOcupacion());
            pst.setString(13, objAlumno.getFecha_registro());
            pst.setInt(14, objAlumno.getId_perfil());
            pst.setString(15, objAlumno.getEstado());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean EliminarAlumno(String id_alumno) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_EliminarAlumno(?)}");
            pst.setString(1,id_alumno);
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public Alumno ObtenerAlumno(String id_alumno) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Alumno objAlumno = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerAlumno(?)}");
            pst.setString(1, id_alumno);
            
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objAlumno = new Alumno(
                        res.getString(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6),
                        res.getString(7),
                        res.getInt(8),
                        res.getString(9),
                        res.getString(10),
                        res.getString(11),
                        res.getString(12),
                        res.getString(13),
                        res.getInt(14),
                        res.getString(15)
                );
            }
            
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            objAlumno = null;
        }
        return objAlumno;
    }

    @Override
    public List<Alumno> ObtenerAlumnoPorDNI(int dni_alumno) {
        List<Alumno> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerAlumnoPorDNI(?)}");
            pst.setInt(1, dni_alumno);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(
                        new Alumno(
                                resultquery.getString(1),
                                resultquery.getInt(2),
                                resultquery.getString(3),
                                resultquery.getString(4),
                                resultquery.getString(5),
                                resultquery.getString(6),
                                resultquery.getString(7),
                                resultquery.getInt(8),
                                resultquery.getString(9),
                                resultquery.getString(10),
                                resultquery.getString(11),
                                resultquery.getString(12),
                                resultquery.getString(13),
                                resultquery.getInt(14),
                                resultquery.getString(15)
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

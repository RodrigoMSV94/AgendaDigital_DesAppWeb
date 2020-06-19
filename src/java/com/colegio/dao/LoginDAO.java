package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.model.Alumno;
import com.colegio.model.Empleado;
import com.colegio.idao.ILoginDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILoginDAO{

    @Override
    public Empleado LoginEmpleado(String correo, String contrasena) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Empleado objEmpleado = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_LoginEmpleado(?,?)}");
            pst.setString(1, correo);
            pst.setString(2, contrasena);
            
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objEmpleado = new Empleado(
                        res.getString(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getString(4),
                        res.getInt(5),
                        res.getString(6),
                        res.getString(7),
                        res.getString(8),
                        res.getDouble(9),
                        res.getInt(10),
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
            objEmpleado = null;
        }
        return objEmpleado;
    }

    @Override
    public Alumno LoginAlumno(String correo, String contrasena) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Alumno objAlumno = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_LoginAlumno(?,?)}");
            pst.setString(1, correo);
            pst.setString(2, contrasena);
            
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
  
}

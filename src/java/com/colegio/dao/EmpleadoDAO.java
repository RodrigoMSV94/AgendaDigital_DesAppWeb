package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IEmpleadoDAO;
import com.colegio.model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements IEmpleadoDAO{

    @Override
    public List<Empleado> ListarEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultquery = statement.executeQuery("{call usp_ListarEmpleados}");
            while (resultquery.next()) {
                lista.add(
                        new Empleado(
                                resultquery.getString(1),
                                resultquery.getInt(2),
                                resultquery.getString(3),
                                resultquery.getString(4),
                                resultquery.getInt(5),
                                resultquery.getString(6),
                                resultquery.getString(7),
                                resultquery.getString(8),
                                resultquery.getDouble(9),
                                resultquery.getInt(10),
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
    public boolean RegistrarEmpleado(Empleado objEmpleado) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setInt(1, objEmpleado.getDni_empleado());
            pst.setString(2, objEmpleado.getNombre());
            pst.setString(3, objEmpleado.getApellido());
            pst.setInt(4, objEmpleado.getEdad());
            pst.setString(5, objEmpleado.getSexo());
            pst.setString(6, objEmpleado.getProfesion());
            pst.setString(7, objEmpleado.getEspecialidad());
            pst.setDouble(8, objEmpleado.getSueldo());
            pst.setInt(9, objEmpleado.getTelefono());
            pst.setString(10, objEmpleado.getCorreo());
            pst.setString(11, objEmpleado.getContrasena());
            pst.setString(12, objEmpleado.getFecha_registro());
            pst.setInt(13, objEmpleado.getId_perfil());
            pst.setString(14, objEmpleado.getEstado());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean ActualizarEmpleado(Empleado objEmpleado) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, objEmpleado.getId_empleado());
            pst.setInt(2, objEmpleado.getDni_empleado());
            pst.setString(3, objEmpleado.getNombre());
            pst.setString(4, objEmpleado.getApellido());
            pst.setInt(5, objEmpleado.getEdad());
            pst.setString(6, objEmpleado.getSexo());
            pst.setString(7, objEmpleado.getProfesion());
            pst.setString(8, objEmpleado.getEspecialidad());
            pst.setDouble(9, objEmpleado.getSueldo());
            pst.setInt(10, objEmpleado.getTelefono());
            pst.setString(11, objEmpleado.getCorreo());
            pst.setString(12, objEmpleado.getContrasena());
            pst.setString(13, objEmpleado.getFecha_registro());
            pst.setInt(14, objEmpleado.getId_perfil());
            pst.setString(15, objEmpleado.getEstado());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean EliminarEmpleado(String id_empleado) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_EliminarEmpleado(?)}");
            pst.setString(1,id_empleado);
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public Empleado ObtenerEmpleado(String id_empleado) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Empleado objEmpleado = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerEmpleado(?)}");
            pst.setString(1, id_empleado);
            
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
            
        }
        return objEmpleado;
    }
    
}

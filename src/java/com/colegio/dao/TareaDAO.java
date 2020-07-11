package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.ITareaDAO;
import com.colegio.model.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO implements ITareaDAO{

    @Override
    public List<Tarea> ListarTareas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarTarea(Tarea objTarea) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarTarea(?,?,?,?,?)}");
            pst.setString(1,objTarea.getId_empleado());
            pst.setString(2,objTarea.getId_curso());
            pst.setString(3,objTarea.getId_grado());
            pst.setString(4,objTarea.getDescripcion());
            pst.setString(5,objTarea.getFecha_registro());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean ActualizarTarea(Tarea objTarea) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarTarea(?,?,?,?,?)}");
            pst.setString(1,objTarea.getId_empleado());
            pst.setString(2,objTarea.getId_curso());
            pst.setString(3,objTarea.getId_grado());
            pst.setString(4,objTarea.getDescripcion());
            pst.setString(5,objTarea.getFecha_registro());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean EliminarTarea(String id_curso, String id_grado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tarea ObtenerTarea(String id_curso, String id_grado, String fecha_registro) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Tarea objTarea = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerTarea(?,?,?)}");
            pst.setString(1, id_curso);
            pst.setString(2, id_grado);
            pst.setString(3, fecha_registro);
            
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objTarea = new Tarea(
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
            
        }
        return objTarea;
    }

    @Override
    public List<Tarea> ListaTareaGradoFecha(String id_alumno, String fecha_registro) {
        List<Tarea> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerTareaGradoFecha(?,?)}");
            pst.setString(1, id_alumno);
            pst.setString(2, fecha_registro);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Tarea(
                        resultquery.getString(1), 
                        resultquery.getString(2)
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

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarTarea(Tarea objTarea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarTarea(String id_curso, String id_grado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tarea ObtenerTarea(String id_curso, String id_grado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

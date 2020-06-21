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
    public List<Citacion> ListarCitacionesAlumno(String id_alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Citacion> ListarCitacionesDocente(String id_empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarCitacion(Citacion objCitacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarCitacion(Citacion objCitacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarCitacion(int id_cita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Citacion ObtenerCitacion(int id_cita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}

package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.ICalificacionDAO;
import com.colegio.model.Calificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CalificacionDAO implements ICalificacionDAO{

    @Override
    public List<Calificacion> ListarCalificaciones(String id_alumno, String id_curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarCalificacion(Calificacion objCalificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarCalificacion(Calificacion objCalificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                        resultquery.getInt(2),
                        resultquery.getInt(3),
                        resultquery.getInt(4),
                        resultquery.getInt(4)
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

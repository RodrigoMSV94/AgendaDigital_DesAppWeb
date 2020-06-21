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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarAsistencia(Asistencia objCitacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}

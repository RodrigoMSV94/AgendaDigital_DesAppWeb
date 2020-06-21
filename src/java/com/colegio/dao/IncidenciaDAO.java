package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IIncidenciaDAO;
import com.colegio.model.Incidencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDAO implements IIncidenciaDAO{

    @Override
    public List<Incidencia> ListarIncidencias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarIncidencia(Incidencia objIncidencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarIncidencia(Incidencia objIncidencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarIncidencia(String id_curso, String id_grado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Incidencia ObtenerIncidencia(String id_curso, String id_grado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> ListaIncAlumnoFecha(String id_alumno, String fecha_cita) {
        List<Incidencia> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerIncAlumnoFecha(?,?)}");
            pst.setString(1, id_alumno);
            pst.setString(2, fecha_cita);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                System.out.println("resultquery.getString(1) = " + resultquery.getString(1));
                System.out.println("resultquery.getString(2) = " + resultquery.getString(2));
                lista.add(new Incidencia(
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

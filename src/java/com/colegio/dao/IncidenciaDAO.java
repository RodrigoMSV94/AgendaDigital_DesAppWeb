package com.colegio.dao;

import com.colegio.bd.BDConnection;
import com.colegio.idao.IIncidenciaDAO;
import com.colegio.model.Curso;
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
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_RegistrarIncidencia(?,?,?,?,?)}");
            pst.setString(1, objIncidencia.getId_alumno());
            pst.setString(2, objIncidencia.getId_empleado());
            pst.setString(3, objIncidencia.getId_curso());
            pst.setString(4, objIncidencia.getDescripcion());
            pst.setString(5, objIncidencia.getFecha_cita());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
    }

    @Override
    public boolean ActualizarIncidencia(Incidencia objIncidencia) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ActualizarIncidencia(?,?,?,?,?)}");
            pst.setString(1, objIncidencia.getId_alumno());
            pst.setString(2, objIncidencia.getId_empleado());
            pst.setString(3, objIncidencia.getId_curso());
            pst.setString(4, objIncidencia.getDescripcion());
            pst.setString(5, objIncidencia.getFecha_cita());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
            
        } catch (SQLException ex) {
            
        }
        return rpta;
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

    @Override
    public List<Incidencia> ListarIncDocente(String id_empleado,String fecha_ini, String fecha_fin) {
        List<Incidencia> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarIncDocente(?,?,?)}");
            pst.setString(1, id_empleado);
            pst.setString(2, fecha_ini);
            pst.setString(3, fecha_fin);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Incidencia(
                        resultquery.getString(1), 
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
    public List<Incidencia> ListarIncDocenteAlumno(String id_empleado, String id_alumno, String fecha_ini, String fecha_fin) {
        List<Incidencia> lista = new ArrayList<>();
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ListarIncDocenteAlumno(?,?,?,?)}");
            pst.setString(1, id_empleado);
            pst.setString(2, id_alumno);
            pst.setString(3, fecha_ini);
            pst.setString(4, fecha_fin);
            
            ResultSet resultquery = pst.executeQuery();
            while (resultquery.next()) {
                lista.add(new Incidencia(
                        resultquery.getString(1), 
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
    public Incidencia ObtenerIncAlumCurFecha(String id_alumno, String id_curso, String fecha_cita) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        Incidencia objIncidencia = null;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_ObtenerIncAlumCurFecha(?,?,?)}");
            pst.setString(1, id_alumno);
            pst.setString(2, id_curso);
            pst.setString(3, fecha_cita);
            
            ResultSet res = pst.executeQuery();
            if(res.next()){
                objIncidencia = new Incidencia(
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
            objIncidencia = null;
        }
        return objIncidencia;
    }

    @Override
    public boolean EliminarIncAlumCurFecha(String id_alumno, String id_curso, String fecha_cita) {
        BDConnection objBDConnection = new BDConnection();
        Connection conexion = objBDConnection.conectarconBD();
        boolean rpta = false;
        try {
            PreparedStatement pst = conexion.prepareStatement("{call usp_EliminarIncAlumCurFecha(?,?,?)}");
            pst.setString(1,id_alumno);
            pst.setString(2,id_curso);
            pst.setString(3,fecha_cita);
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            objBDConnection.desconectarBD();
        } catch (SQLException ex) {
            
        }
        return rpta;
    }
    
}

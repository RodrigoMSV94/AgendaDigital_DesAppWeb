package com.colegio.controller;

import com.colegio.dao.AlumnoDAO;
import com.colegio.dao.CitacionDAO;
import com.colegio.model.Alumno;
import com.colegio.model.Citacion;
import com.colegio.model.Empleado;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CitacionController", urlPatterns = {"/CitacionController"})
public class CitacionController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        String vista = "/listaCitaciones.jsp";
        session.setAttribute("opcSelect", 4);
        Empleado empleado = (Empleado)session.getAttribute("usuario");
        
        listarAlumnos();
        request.setAttribute("idAlumno", ""); 
        
        int accion = Integer.parseInt((request.getParameter("accion") != null)?request.getParameter("accion"):"0");
        
        vista = accionEnVista(accion);
        
        List<Citacion> listaCitasAlumnos = new CitacionDAO().ListarCitasDocente(empleado.getId_empleado(),"2020-03-01","2020-12-31");
        request.setAttribute("listaCitasAlumnos", listaCitasAlumnos); 
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAlumno = request.getParameter("idAlumno");
        Empleado empleado = (Empleado)session.getAttribute("usuario");
        
        String vista = "/listaCitaciones.jsp";
        boolean res = false;
        String respuesta = "Error al guardar el registro de la citación";
        String colorAlert = "danger";
        
        String operacion = (request.getParameter("operacion") != null)?request.getParameter("operacion"):null;
        if(operacion == null){
            List<Citacion> listaCitasAlumnos = new CitacionDAO().ListarCitDocenAlumno(empleado.getId_empleado(), idAlumno, "2020-03-01","2020-12-31");
            request.setAttribute("listaCitasAlumnos", listaCitasAlumnos); 

            List<Alumno> listaAlumnos = new AlumnoDAO().ListarAlumnos();
            request.setAttribute("listaAlumnos", listaAlumnos); 

        }else {
            if(operacion.equals("Registrar")){
                res = registrarCitacion(empleado);
                vista = "/formCitacion.jsp";
            } else {
                res = actualizarCitacion(empleado);
                vista = "/formCitacion.jsp";
            }
            
            if(res){
                respuesta = "Se guardó el registro de la citación";
                colorAlert = "success";
            }
            request.setAttribute("respuesta", respuesta);
            request.setAttribute("colorAlert", colorAlert);
        }
        request.setAttribute("idAlumno", idAlumno); 
        listarAlumnos();
        RequestDispatcher dispatcher = request.getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public void listarAlumnos(){
        List<Alumno> listaAlumnos = new AlumnoDAO().ListarAlumnos();
        request.setAttribute("listaAlumnos", listaAlumnos); 
    }
    
    public String accionEnVista(int accion){
        String vista = "/listaCitaciones.jsp";
        
        if(accion == 1){
            listarAlumnos();
            vista = "/formCitacion.jsp";
        }else if(accion == 2){
            String id_alumno = request.getParameter("idAlumno");
            int idCita = Integer.parseInt(request.getParameter("idCita"));
            
            Citacion objCitacion = new CitacionDAO().ObtenerCitacion(idCita);
            request.setAttribute("objCitacion", objCitacion);
            
            listarAlumnos();
            
            vista = "/formCitacion.jsp";
        }else if(accion == 3){
            String id_alumno = request.getParameter("idAlumno");
            int idCita = Integer.parseInt(request.getParameter("idCita"));
            
            boolean resultado = new CitacionDAO().EliminarCitacion(idCita);
            String msgEliminar = "Error al eliminar el registro de la citación";
            if(resultado){
                msgEliminar = "Se eliminó el registro de la citación correctamente";
            }
            vista = "/listaCitaciones.jsp";
            request.setAttribute("msgEliminar", msgEliminar);
            listarAlumnos();
        }
        return vista;
    }
    
    public boolean registrarCitacion(Empleado empleado){
        boolean res = false;
        String id_alumno = request.getParameter("idAlumno");
        String motivo = request.getParameter("txtMotivo");
        String fecha_cita = request.getParameter("txtFechaCita");
        String fecha_registro = obtenerFechActual();
        
        Citacion objCitacion = new Citacion(0, id_alumno, empleado.getId_empleado(), motivo, fecha_cita, fecha_registro);
        
        res = new CitacionDAO().RegistrarCitacion(objCitacion);
        return res;
    }
    
    public boolean actualizarCitacion(Empleado empleado){
        boolean res = false;
        int id_cita = Integer.parseInt(request.getParameter("txtIdCita"));
        String id_alumno = request.getParameter("idAlumno");
        String motivo = request.getParameter("txtMotivo");
        String fecha_cita = request.getParameter("txtFechaCita");
        String fecha_registro = obtenerFechActual();
        
        Citacion objCitacion = new Citacion(id_cita, id_alumno, empleado.getId_empleado(), motivo, fecha_cita, fecha_registro);
        
        res = new CitacionDAO().ActualizarCitacion(objCitacion);
        return res;
    }
    
    public String obtenerFechActual(){
        Date objDate = new Date();
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_registro = objSDF.format(objDate);
        return fecha_registro;
    }
}

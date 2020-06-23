package com.colegio.controller;

import com.colegio.dao.AlumnoDAO;
import com.colegio.dao.CursoDAO;
import com.colegio.dao.IncidenciaDAO;
import com.colegio.model.Alumno;
import com.colegio.model.Curso;
import com.colegio.model.Empleado;
import com.colegio.model.Incidencia;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "IncidenciaController", urlPatterns = {"/IncidenciaController"})
public class IncidenciaController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        String vista = "/listaIncidencias.jsp";
        
        session.setAttribute("opcSelect", 3);
        Empleado empleado = (Empleado)session.getAttribute("usuario");
        
        listarAlumnos();
        request.setAttribute("idAlumno", ""); 
        
        int accion = Integer.parseInt((request.getParameter("accion") != null)?request.getParameter("accion"):"0");
        
        vista = accionEnVista(accion);
        
        List<Incidencia> listaIncidenciasAlum = new IncidenciaDAO().ListarIncDocente(empleado.getId_empleado(),"2020-03-01","2020-12-31");
        request.setAttribute("listaIncidenciasAlum", listaIncidenciasAlum); 
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAlumno = request.getParameter("idAlumno");
        Empleado empleado = (Empleado)session.getAttribute("usuario");
        
        String vista = "/listaIncidencias.jsp";
        boolean res = false;
        String respuesta = "Error al guardar el registro de la incidencia";
        String colorAlert = "danger";
        
        String operacion = (request.getParameter("operacion") != null)?request.getParameter("operacion"):null;
        if(operacion == null){
            List<Incidencia> listaIncidenciasAlum = new IncidenciaDAO().ListarIncDocenteAlumno(empleado.getId_empleado(),idAlumno,"2020-03-01","2020-12-31");
            request.setAttribute("listaIncidenciasAlum", listaIncidenciasAlum); 

            List<Alumno> listaAlumnos = new AlumnoDAO().ListarAlumnos();
            request.setAttribute("listaAlumnos", listaAlumnos); 

        }else {
            if(operacion.equals("Registrar")){
                res = registrarIncidencia(empleado);
                vista = "/formIncidencia.jsp";
            } else {
                res = actualizarIncidencia(empleado);
                vista = "/formIncidencia.jsp";
            }
            
            if(res){
                respuesta = "Se guardó el registro de la incidencia";
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
    
    public void listarCursos(){
        List<Curso> listaCursos = new CursoDAO().ListarCursos();
        request.setAttribute("listaCursos", listaCursos);
    }
    
    public String accionEnVista(int accion){
        String vista = "/listaIncidencias.jsp";
        
        if(accion == 1){
            listarAlumnos();
            listarCursos();
            vista = "/formIncidencia.jsp";
        } else if(accion == 2){
            String id_alumno = request.getParameter("idAlumno");
            String id_curso = request.getParameter("idCurso");
            String fechCita = request.getParameter("fechCita");
            Incidencia objIncidencia = new IncidenciaDAO().ObtenerIncAlumCurFecha(id_alumno, id_curso, fechCita);
            request.setAttribute("objIncidencia", objIncidencia);
            
            listarAlumnos();
            listarCursos();
            
            vista = "/formIncidencia.jsp";
        }else if(accion == 3){
            String id_alumno = request.getParameter("idAlumno");
            String id_curso = request.getParameter("idCurso");
            String fechCita = request.getParameter("fechCita");
            boolean resultado = new IncidenciaDAO().EliminarIncAlumCurFecha(id_alumno, id_curso, fechCita);
            String msgEliminar = "Error al eliminar el registro de la incidencia";
            if(resultado){
                msgEliminar = "Se eliminó el registro de la incidencia correctamente";
            }
            vista = "/listaIncidencias.jsp";
            request.setAttribute("msgEliminar", msgEliminar);
            listarAlumnos();
        }
        return vista;
    }
    
    public boolean registrarIncidencia(Empleado empleado){
        boolean res = false;
        String id_alumno = request.getParameter("idAlumno");
        String id_curso = request.getParameter("idCurso");
        String descripcion = request.getParameter("txtDescripcion");
        String fecha_cita = request.getParameter("txtFechIncidencia");
        listarCursos();
        Incidencia objCurso = new Incidencia(id_alumno, empleado.getId_empleado(), id_curso, descripcion, fecha_cita);
        
        res = new IncidenciaDAO().RegistrarIncidencia(objCurso);
        return res;
    }
    
    public boolean actualizarIncidencia(Empleado empleado){
        boolean res = false;
        String id_alumno = request.getParameter("idAlumno");
        String id_curso = request.getParameter("idCurso");
        String descripcion = request.getParameter("txtDescripcion");
        String fecha_cita = request.getParameter("txtFechIncidencia");
        
        Incidencia objCurso = new Incidencia(id_alumno, empleado.getId_empleado(), id_curso, descripcion, fecha_cita);
        listarCursos();
        res = new IncidenciaDAO().ActualizarIncidencia(objCurso);
        return res;
    }
}

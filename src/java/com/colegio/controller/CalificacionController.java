package com.colegio.controller;

import com.colegio.dao.CalificacionDAO;
import com.colegio.dao.CursoDAO;
import com.colegio.dao.GradoDAO;
import com.colegio.dao.PeriodoEscolarDAO;
import com.colegio.model.Calificacion;
import com.colegio.model.Curso;
import com.colegio.model.Grado;
import com.colegio.model.PeriodoEscolar;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CalificacionController", urlPatterns = {"/CalificacionController"})
public class CalificacionController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        session.setAttribute("opcSelect", 5);
        
        String id_grado = (request.getParameter("idGrado") != null)?request.getParameter("idGrado"):null;
        listaGrados();
        
        if(id_grado != null){
            //Llamamos para llevar el combo alumnos
            listaCursoGrado(id_grado);
            listarPeriodosEscolar();
            request.setAttribute("idGrado", id_grado);
            request.setAttribute("idCurso", "0");
        }else{
            request.setAttribute("listaAlumGrado", null);
            request.setAttribute("idGrado", "0");
        }
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/frmCalificacion.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_grado = (request.getParameter("idGrado") != null)?request.getParameter("idGrado"):null;
        String id_curso = (request.getParameter("txtIdCurso") != null)?request.getParameter("txtIdCurso"):null;
        int id_perEscolar = (request.getParameter("idPerEscolar") != null)?Integer.parseInt(request.getParameter("idPerEscolar")):0;
        
        listaGrados();
        listaCursoGrado(id_grado);
        listarPeriodosEscolar();
        
        
        if(id_grado != null && id_curso != null&& id_perEscolar != 0){
            //request.setAttribute("listaCalifAlumno", listaCalifAlumno(id_grado, id_alumno, id_perEscolar));
        }
        request.setAttribute("idGrado", id_grado);
        request.setAttribute("idCurso", id_curso);
        request.setAttribute("idPerEscolar", id_perEscolar);
        System.out.println("envio parametros");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/frmCalificacion.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public List<PeriodoEscolar> listarPeriodosEscolar(){
        List<PeriodoEscolar> listaPerEscolar = new PeriodoEscolarDAO().ListarPeriodosEscolares();
        request.setAttribute("listaPerEscolar", listaPerEscolar);
        return listaPerEscolar;
    }
    
    public void listaGrados(){
        List<Grado> listaGrados = new GradoDAO().ListarGrado();
        request.setAttribute("listaGrados", listaGrados);
    }
    
    public void listaCursoGrado(String id_grado){
        System.out.println("Entro a listaCursoGrado");
        List<Curso> listaCursoGrado = new CursoDAO().ListarCursoGrado(id_grado);
        request.setAttribute("listaCursoGrado", listaCursoGrado);
    }
    
    public List<Calificacion> listaCalifAlumno(String id_grado,String id_alumno,int id_perEscolar){
        System.out.println("Parametros-listaCalifAlumno: " + id_grado+ " - " +id_alumno+ " - " +id_perEscolar);
        List<Calificacion> listaCalifAlumno = new CalificacionDAO().ListarCalifAlum(id_alumno, id_perEscolar);
        request.setAttribute("operacion", "Actualizar");
        if(listaCalifAlumno.size() <= 0){ //Esto indica que no existe alguna asistencia ya guardada el día.
            request.setAttribute("operacion", "Registrar");
            listaCalifAlumno = new CalificacionDAO().ObtenerCalifAlumGrado(id_grado, id_alumno);
        }
        return listaCalifAlumno;
    }
}

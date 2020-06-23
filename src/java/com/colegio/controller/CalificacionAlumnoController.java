package com.colegio.controller;

import com.colegio.dao.CalificacionDAO;
import com.colegio.dao.PeriodoEscolarDAO;
import com.colegio.model.Alumno;
import com.colegio.model.Calificacion;
import com.colegio.model.PeriodoEscolar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CalificacionAlumnoController", urlPatterns = {"/CalificacionAlumnoController"})
public class CalificacionAlumnoController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        session.setAttribute("opcSelect", 4);
        
        Alumno alumno = (Alumno)session.getAttribute("usuario");
        
        List<Calificacion> listaCalifAlumno = new CalificacionDAO().ListarCalifAlumnoPerEscolar(alumno.getId_alumno(), 1);
        request.setAttribute("listaCalifAlumno", listaCalifAlumno); 
        
        listarPeriodosEscolar();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCalifAlumno.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        int idPerEscolar = Integer.parseInt(request.getParameter("idPerEscolar"));
        Alumno alumno = (Alumno)session.getAttribute("usuario");
        
        List<Calificacion> listaCalifAlumno = new CalificacionDAO().ListarCalifAlumnoPerEscolar(alumno.getId_alumno(), idPerEscolar);
        request.setAttribute("listaCalifAlumno", (listaCalifAlumno.size() > 0?listaCalifAlumno:null)); 
        
        request.setAttribute("idPerEscolar", idPerEscolar); 
        
        listarPeriodosEscolar();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCalifAlumno.jsp");
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
}

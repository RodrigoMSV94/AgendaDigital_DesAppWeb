package com.colegio.controller;

import com.colegio.dao.AsistenciaDAO;
import com.colegio.model.Alumno;
import com.colegio.model.Asistencia;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AsistenciaAlumnoController", urlPatterns = {"/AsistenciaAlumnoController"})
public class AsistenciaAlumnoController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        session.setAttribute("opcSelect", 6);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaAsisAlumno.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fecha_consulta = request.getParameter("txtFechConsulta");
        Alumno alumno = (Alumno)session.getAttribute("usuario");
        
        List<Asistencia> listaAsisAlumno = new AsistenciaDAO().ListarAsisAlumnoFecha(alumno.getId_alumno(),fecha_consulta);
        request.setAttribute("listaAsisAlumno", listaAsisAlumno); 
        
        request.setAttribute("fecha_consulta", fecha_consulta);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaAsisAlumno.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

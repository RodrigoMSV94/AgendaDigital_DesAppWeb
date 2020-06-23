package com.colegio.controller;

import com.colegio.dao.CitacionDAO;
import com.colegio.model.Alumno;
import com.colegio.model.Citacion;
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

@WebServlet(name = "CitacionAlumnoController", urlPatterns = {"/CitacionAlumnoController"})
public class CitacionAlumnoController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        session.setAttribute("opcSelect", 3);
        Alumno alumno = (Alumno)session.getAttribute("usuario");
        
        List<Citacion> listaCitasAlumno = new CitacionDAO().ListarCitasAlumno(alumno.getId_alumno());
        request.setAttribute("listaCitasAlumno", listaCitasAlumno); 
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCitacionesAlumno.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fecha_consulta = request.getParameter("txtFechConsulta");
        Alumno alumno = (Alumno)session.getAttribute("usuario");
        
        List<Citacion> listaCitasAlumno = new CitacionDAO().ListarCitasAlumnoFecha(alumno.getId_alumno(),fecha_consulta);
        request.setAttribute("listaCitasAlumno", listaCitasAlumno); 
        
        request.setAttribute("fecha_consulta", fecha_consulta);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCitacionesAlumno.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package com.colegio.controller;

import com.colegio.dao.AlumnoDAO;
import com.colegio.dao.EmpleadoDAO;
import com.colegio.model.Alumno;
import com.colegio.model.BarraNavegacion;
import com.colegio.model.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "BienvenidaController", urlPatterns = {"/BienvenidaController"})
public class BienvenidaController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        session.setAttribute("opcSelect", 1);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bienvenida.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}

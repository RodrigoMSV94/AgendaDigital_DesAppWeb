package com.colegio.controller;


import com.colegio.dao.IncidenciaDAO;
import com.colegio.dao.TareaDAO;
import com.colegio.model.Alumno;
import com.colegio.model.Incidencia;
import com.colegio.model.Tarea;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AgendaController", urlPatterns = {"/AgendaController"})
public class AgendaController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        session.setAttribute("opcSelect", 2);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/agenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fecha_consulta = request.getParameter("txtFechConsulta");
        Alumno alumno = (Alumno)session.getAttribute("usuario");
        
        // Obtener datos de tarea
        List<Tarea> listaTareasGrado = new TareaDAO().ListaTareaGradoFecha(alumno.getId_alumno(), fecha_consulta);
        if(listaTareasGrado.size()>0){
            request.setAttribute("listaTareasGrado", listaTareasGrado);
        }else{
            request.setAttribute("listaTareasGrado", null);
        }
        
        //Obtener datos de incidencias
        List<Incidencia> listaIncsAlumo = new IncidenciaDAO().ListaIncAlumnoFecha(alumno.getId_alumno(), fecha_consulta);
        if(listaIncsAlumo.size()>0){
            request.setAttribute("listaIncsAlumo", listaIncsAlumo);
        }else{
            request.setAttribute("listaIncsAlumo", null);
        }
        
        request.setAttribute("fecha_consulta", fecha_consulta);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/agenda.jsp");
        dispatcher.forward(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

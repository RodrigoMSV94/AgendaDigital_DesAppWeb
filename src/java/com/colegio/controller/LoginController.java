package com.colegio.controller;

import com.colegio.dao.LoginDAO;
import com.colegio.dao.PerfilDAO;
import com.colegio.model.Alumno;
import com.colegio.model.BarraNavegacion;
import com.colegio.model.Empleado;
import com.colegio.model.Perfil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        listarPerfiles();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        
        String vista = "/login.jsp";
        String respuesta = null;
        
        
        ;
        int idPerfil = Integer.parseInt((request.getParameter("idPerfilUsu") != null)?request.getParameter("idPerfilUsu"):"0");
        String correo = request.getParameter("txtCorreo");
        String contrasena = request.getParameter("txtContrasena");
        
        if(idPerfil != 0){
            if(existeUsuario(idPerfil, correo, contrasena)){
                session.setAttribute("barraNav", barraNavegacion(idPerfil));
                //request.setAttribute("barraNav", barraNavegacion(idPerfil));
                session.setAttribute("opcSelect", 1);
                //request.setAttribute("opcSelect", 1);
                session.setAttribute("idPerfilUsu", idPerfil);
                vista = "/bienvenida.jsp";
            }else{
                respuesta = "Correo o contraseña invalido. ";
                request.setAttribute("respuesta", respuesta);
            }
        }
        
        int cerrarSesion = Integer.parseInt((request.getParameter("cerrarSesion") != null)?"1":"0");
        if(cerrarSesion == 1 ){
            request.setAttribute("objEmpleado", null);
            request.setAttribute("objAlumno", null);
            vista = "/login.jsp";
        }
        
        RequestDispatcher disparcher = request.getRequestDispatcher(vista);
        disparcher.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public List<Perfil> listarPerfiles(){
        List<Perfil> listaPerfiles = new PerfilDAO().ListarPerfiles();
        session.setAttribute("listaPerfiles", listaPerfiles);
        return listaPerfiles;
    }
    
    public boolean existeUsuario(int idPerfil,String correo,String contrasena){
        boolean siExiste = false;
        if(idPerfil == 1 | idPerfil == 2){
            Empleado objEmpleado = new LoginDAO().LoginEmpleado(correo,contrasena);
            if(objEmpleado != null){
                session.setAttribute("usuario", objEmpleado);
                siExiste = true;
            }
        }else if(idPerfil == 3){
            Alumno objAlumno = new LoginDAO().LoginAlumno(correo, contrasena);
            if(objAlumno != null){
                session.setAttribute("usuario", objAlumno);
                siExiste = true;
            }
        }
        return siExiste;
    }
    
    public List<BarraNavegacion> barraNavegacion(int idPerfil){
        List<BarraNavegacion> opcBarNav = new ArrayList<>();
        if(idPerfil == 1){ //Opciones para usuario Administrador
            opcBarNav.add(new BarraNavegacion("BienvenidaController", "Bienvenida"));
            opcBarNav.add(new BarraNavegacion("AlumnoController", "Alumnos"));
            opcBarNav.add(new BarraNavegacion("#", "Matriculas"));
            opcBarNav.add(new BarraNavegacion("#", "Docentes"));
            opcBarNav.add(new BarraNavegacion("#", "Gestiones Academicas"));
            opcBarNav.add(new BarraNavegacion("#", "Pensiones"));
            opcBarNav.add(new BarraNavegacion("#", "Control de usuarios"));
        } else if(idPerfil == 2){ //Opciones para usuario Docente
            opcBarNav.add(new BarraNavegacion("BienvenidaController", "Bienvenida"));
            opcBarNav.add(new BarraNavegacion("AlumnoController", "Asistencia"));
            opcBarNav.add(new BarraNavegacion("IncidenciaController", "Incidencia"));
            opcBarNav.add(new BarraNavegacion("CitacionController", "Citación"));
            opcBarNav.add(new BarraNavegacion("RegNotasController", "Registro de notas"));
        } else if(idPerfil == 3){ //Opciones para usuario Alumno
            opcBarNav.add(new BarraNavegacion("BienvenidaController", "Bienvenida"));
            opcBarNav.add(new BarraNavegacion("AgendaController", "Agenda"));
            opcBarNav.add(new BarraNavegacion("#", "Citaciones"));
            opcBarNav.add(new BarraNavegacion("#", "Calificaciones"));
            opcBarNav.add(new BarraNavegacion("#", "Rol Examenes"));
            opcBarNav.add(new BarraNavegacion("#", "Asistencias"));
            opcBarNav.add(new BarraNavegacion("#", "Horario"));
            opcBarNav.add(new BarraNavegacion("#", "Pensiones"));
        }
        return opcBarNav;
    }
}

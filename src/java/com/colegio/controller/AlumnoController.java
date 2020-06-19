package com.colegio.controller;

import com.colegio.dao.AlumnoDAO;
import com.colegio.model.Alumno;
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

@WebServlet(name = "AlumnoController", urlPatterns = {"/AlumnoController"})
public class AlumnoController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
       
        session.setAttribute("opcSelect", 2);
        String vista = "/listaAlumnos.jsp";
        
        int accion = Integer.parseInt((request.getParameter("accion") != null)?request.getParameter("accion"):"0");
        
        int dniABuscar = Integer.parseInt((request.getParameter("txtDNIBuscar") != null)?request.getParameter("txtDNIBuscar"):"0");

        if((dniABuscar == 0 && accion == 1) || (dniABuscar == 0 && accion == 0)){
            listarAlumnos();
            accion = 0;
        }
        
        if(accion != 0){
            vista = accionEnVista(accion);
        }
        
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String vista = "/formAlumno.jsp";
        String operacion = (request.getParameter("operacion") != null)?request.getParameter("operacion"):null;
        
        boolean res = false;
        String respuesta = "Error al guardar el registro del alumno";
        String colorAlert = "danger";
        
        if(operacion != null){
            if(operacion.equals("Registrar")){
                res = registrarAlumno();
            } else {
                res = actualizarAlumno();
            }
            
            if(res){
                respuesta = "Se guardó el registro del alumno correctamente";
                colorAlert = "success";
            }
            request.setAttribute("respuesta", respuesta);
            request.setAttribute("colorAlert", colorAlert);
        }

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
        String vista = "";
        if(accion == 1){
            int dniABuscar = Integer.parseInt(request.getParameter("txtDNIBuscar") );
            if(dniABuscar != 0){
                List<Alumno> listaAlumnos = new AlumnoDAO().ObtenerAlumnoPorDNI(dniABuscar);
                request.setAttribute("listaAlumnos", listaAlumnos);
                vista = "/listaAlumnos.jsp";
            }
        }else if(accion == 2){
            vista = "/formAlumno.jsp";
        }else if(accion == 3){
            String idAlumno = request.getParameter("idAlumno");
            Alumno objAlumno = new AlumnoDAO().ObtenerAlumno(idAlumno);
            request.setAttribute("objAlumno", objAlumno);
            vista = "/formAlumno.jsp";
        }else if(accion == 4){
            String idAlumno = request.getParameter("idAlumno");
            boolean resultado = new AlumnoDAO().EliminarAlumno(idAlumno);
            String msgEliminar = "Error al eliminar el registro del alumno";
            if(resultado){
                msgEliminar = "Se eliminó el registro del alumno correctamente";
            }
            vista = "/listaAlumnos.jsp";
            request.setAttribute("msgEliminar", msgEliminar);
            listarAlumnos();
        }
        return vista;
    }
    
    public boolean registrarAlumno(){
        boolean res = false;
        int dni_alumno = Integer.parseInt(request.getParameter("txtDNI"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String fecha_nacimiento = request.getParameter("txtFechNacimiento");
        System.out.println("fecha_nacimiento: " + fecha_nacimiento);
        String lugar_nacimiento = request.getParameter("txtLugarNacimiento");
        String direccion = request.getParameter("txtDireccion");
        int telefono_emergencia = Integer.parseInt(request.getParameter("txtTelfEmergencia"));
        String correo = request.getParameter("txtCorreo");
        String contrasena = request.getParameter("txtContrasena");
        String nombres_apoderado = request.getParameter("txtNomApoderado");
        String ocupacion = request.getParameter("txtOcupApoderado");
        String fecha_registro = obtenerFechActual();
        int id_perfil = Integer.parseInt(request.getParameter("txtPerfil"));
        String estado = request.getParameter("txtEstado");
        
        Alumno objAlumno = new Alumno("",dni_alumno, nombre, apellido, fecha_nacimiento, lugar_nacimiento, direccion, telefono_emergencia, 
                                        correo, contrasena, nombres_apoderado, ocupacion, fecha_registro, id_perfil, estado);
        res = new AlumnoDAO().RegistrarAlumno(objAlumno);
        
        return res;
    }
    
    public boolean actualizarAlumno(){
        boolean res = false;
        String  id_alumno = request.getParameter("txtIdAlumno");
        int dni_alumno = Integer.parseInt(request.getParameter("txtDNI"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String fecha_nacimiento = request.getParameter("txtFechNacimiento");
        System.out.println("fecha_nacimiento: " + fecha_nacimiento);
        String lugar_nacimiento = request.getParameter("txtLugarNacimiento");
        String direccion = request.getParameter("txtDireccion");
        int telefono_emergencia = Integer.parseInt(request.getParameter("txtTelfEmergencia"));
        String correo = request.getParameter("txtCorreo");
        String contrasena = request.getParameter("txtContrasena");
        String nombres_apoderado = request.getParameter("txtNomApoderado");
        String ocupacion = request.getParameter("txtOcupApoderado");
        String fecha_registro = request.getParameter("txtFechRegistro");
        int id_perfil = Integer.parseInt(request.getParameter("txtPerfil"));
        String estado = request.getParameter("txtEstado");

        Alumno objAlumno = new Alumno(id_alumno,dni_alumno, nombre, apellido, fecha_nacimiento, lugar_nacimiento, direccion, telefono_emergencia, 
                                        correo, contrasena, nombres_apoderado, ocupacion, fecha_registro, id_perfil, estado);
        res = new AlumnoDAO().ActualizarAlumno(objAlumno);
        
        return res;
    }
    
    public String obtenerFechActual(){
        Date objDate = new Date();
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_registro = objSDF.format(objDate);
        return fecha_registro;
    }
}

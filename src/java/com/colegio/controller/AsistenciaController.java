package com.colegio.controller;

import com.colegio.dao.AsistenciaDAO;
import com.colegio.dao.CursoDAO;
import com.colegio.dao.GradoDAO;
import com.colegio.dao.TareaDAO;
import com.colegio.model.Asistencia;
import com.colegio.model.Curso;
import com.colegio.model.Empleado;
import com.colegio.model.Grado;
import com.colegio.model.Tarea;
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

@WebServlet(name = "AsistenciaController", urlPatterns = {"/AsistenciaController"})
public class AsistenciaController extends HttpServlet {
    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        session.setAttribute("opcSelect", 2);
        String id_grado = (request.getParameter("idGrado") != null)?request.getParameter("idGrado"):null;
        System.out.println("id_grado: " + id_grado);
        listaGrados();
        
        if(id_grado != null){
            listaCursoGrado(id_grado);
            request.setAttribute("idGrado", id_grado);
            request.setAttribute("idCurso", "0");
        }else{
            request.setAttribute("listaCursoGrado", null);
            request.setAttribute("idGrado", "0");
            request.setAttribute("objTarea", null);
            
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/frmAsistencias.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Empleado empleado = (Empleado)session.getAttribute("usuario");
        String id_grado = (request.getParameter("idGrado") != null)?request.getParameter("idGrado"):null;
        String id_curso = (request.getParameter("txtIdCurso") != null)?request.getParameter("txtIdCurso"):null;
        System.out.println("id_curso: " + id_curso);
        if(id_grado != null && id_curso != null){
            request.setAttribute("listaAsisAlumnos", listaAsisGraCurFecha(id_grado,id_curso));
            obtenerTarea(id_curso,id_grado);
            System.out.println("Entro aqui 123");
        }
        
        listaGrados();
        listaCursoGrado(id_grado);
        request.setAttribute("idGrado", id_grado);
        request.setAttribute("idCurso", id_curso);
        
        System.out.println("Entrea dopost");
        String selectGrado = "";
        String selectCurso = "";
        boolean res = false;
        try{
            String[] idsAlumnos = request.getParameterValues("idsAlumnos[]");
            String[] nomsAlumnos = request.getParameterValues("nomsAlumnos[]");
            String[] asisAlumnos = request.getParameterValues("asisAlumnos[]");
            selectGrado = request.getParameter("selectGrado");
            selectCurso = request.getParameter("selectCurso");
            String operacion = request.getParameter("operacion");
            String fecha_registro = obtenerFechActual();
            for(int i = 0; i < idsAlumnos.length; i++)
            {
                int asistio = Integer.parseInt(asisAlumnos[i]);
                System.out.println("idsAlumnos[i]: " + idsAlumnos[i]);
                System.out.println("nomsAlumnos[i]: " + nomsAlumnos[i]);
                System.out.println("asisAlumnos[i]: " + asistio);
                System.out.println("selectGrado: " + selectGrado);
                System.out.println("selectCurso: " + selectCurso);
                if(operacion.equals("Actualizar")){
                    System.out.println("idsAlumnos[" + i +"]: " + idsAlumnos[i] + " - selectCurso: " + selectCurso + 
                                        " - selectGrado: " + selectGrado + " - asistio: " + asistio + " - fecha_registro: " + fecha_registro);
                    res = actualizarAsistencia(idsAlumnos[i], selectCurso, selectGrado, asistio, fecha_registro);
                    System.out.println("Actualizar: " + res);
                }else{
                    res = registrarAsistencia(idsAlumnos[i],selectCurso,selectGrado,asistio,fecha_registro);
                    System.out.println("Registrar: " + res);
                }
                
                if(res){
                    System.out.println("Si grabo");
                    if(selectGrado != null && selectCurso != null){
                        request.setAttribute("listaAsisAlumnos", listaAsisGraCurFecha(selectGrado,selectCurso));
                        System.out.println("Entro aqui 476");
                    }
                }else{
                    System.out.println("No grabo");
                }
            }
            
            
        }
        catch(Exception e){
            System.out.println("Asistencia - null");
        }
        System.out.println("Sale dopost----------------------------");
        
        try{
            //Bloque de grabado para Tarea
            String descripcionTarea = request.getParameter("descripcionTarea");
            selectGrado = request.getParameter("selectGrado");
            selectCurso = request.getParameter("selectCurso");
            String operTarea = request.getParameter("operTarea");
            registrarTarea(empleado.getId_empleado(),selectCurso,selectGrado,descripcionTarea,operTarea);
        }catch(Exception e){
            System.out.println("Tarea - null");
        }
        
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/frmAsistencias.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public void listaGrados(){
        List<Grado> listaGrados = new GradoDAO().ListarGrado();
        request.setAttribute("listaGrados", listaGrados);
    }
    
    public void obtenerTarea(String id_curso,String id_grado){
        System.out.println("id_curso: " + id_curso + " - " + "id_grado: " + id_grado);
        String fechaRegistro = obtenerFechActual();
        Tarea objTarea = null;
        objTarea = new TareaDAO().ObtenerTarea(id_curso, id_grado,fechaRegistro);
        if(objTarea != null){
            request.setAttribute("operTarea", "Actualiza");
        }else{
            request.setAttribute("operTarea", "Registra");
        }
        request.setAttribute("objTarea", objTarea);
    }
    
    public void listaCursoGrado(String id_grado){
        System.out.println("Entro a listaCursoGrado");
        List<Curso> listaCursoGrado = new CursoDAO().ListarCursoGrado(id_grado);
        request.setAttribute("listaCursoGrado", listaCursoGrado);
    }
     
    
    public List<Asistencia> listaAsisGraCurFecha(String id_grado, String id_curso){
        String fecha_registro = obtenerFechActual();
        request.setAttribute("operacion", "Actualizar");
        List<Asistencia> listaAsisAlumnos = new AsistenciaDAO().ObtenerListarAsisGraCurFecha(id_grado, id_curso, fecha_registro);
        
        if(listaAsisAlumnos.size() <= 0){ //Esto indica que no existe alguna asistencia ya guardada el día.
            request.setAttribute("operacion", "Registrar");
            listaAsisAlumnos = new AsistenciaDAO().ObtenerListarAsisGra(id_grado);
        }
        
        return listaAsisAlumnos;
    }
    
    public String obtenerFechActual(){
        Date objDate = new Date();
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_registro = objSDF.format(objDate);
        return fecha_registro;
    }
    
    public boolean registrarAsistencia(String id_alumno, String id_curso, String id_grado, int asistio, String fecha_registro){
        boolean res = false;
        
        Asistencia objAsistencia = new Asistencia(id_alumno, id_curso, id_grado, asistio, fecha_registro);
        res = new AsistenciaDAO().RegistrarAsistencia(objAsistencia);
        
        return res;
    }
    
    public boolean actualizarAsistencia(String id_alumno, String id_curso, String id_grado, int asistio, String fecha_registro){
        boolean res = false;

        Asistencia objAsistencia = new Asistencia(id_alumno, id_curso, id_grado, asistio, fecha_registro);
        res = new AsistenciaDAO().ActualizarAsistencia(objAsistencia);
        
        return res;
    }
    
    public boolean registrarTarea(String Id_empleado,String selectCurso,String selectGrado,String descripcionTarea, String operTarea){
        System.out.println("registrarTarea 11121e3321: " + operTarea);
        boolean res = false;
        String fechRegistro = obtenerFechActual();
        Tarea objTarea1 = new TareaDAO().ObtenerTarea(selectCurso, selectGrado,fechRegistro);
        if(objTarea1 != null){
            Tarea objTarea = new Tarea(Id_empleado, selectCurso, selectGrado, descripcionTarea, fechRegistro);
            res = new TareaDAO().ActualizarTarea(objTarea);
        }else{
            Tarea objTarea = new Tarea(Id_empleado, selectCurso, selectGrado, descripcionTarea, fechRegistro);
            res = new TareaDAO().RegistrarTarea(objTarea); 
        }
        
        
//        if(operTarea.equals("Registra")){
//           res = new TareaDAO().RegistrarTarea(objTarea); 
//        }else{
//           res = new TareaDAO().ActualizarTarea(objTarea);
//        }
        
        System.out.println(operTarea + " Tarea?: " + res);
        return res;
    }

}

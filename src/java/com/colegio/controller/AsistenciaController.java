package com.colegio.controller;

import com.colegio.dao.AsistenciaDAO;
import com.colegio.dao.CursoDAO;
import com.colegio.dao.GradoDAO;
import com.colegio.model.Asistencia;
import com.colegio.model.Curso;
import com.colegio.model.Grado;
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
            
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/frmAsistencias.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_grado = (request.getParameter("idGrado") != null)?request.getParameter("idGrado"):null;
        String id_curso = (request.getParameter("txtIdCurso") != null)?request.getParameter("txtIdCurso"):null;
        System.out.println("id_curso: " + id_curso);
        if(id_grado != null && id_curso != null){
            request.setAttribute("listaAsisAlumnos", listaAsisGraCurFecha(id_grado,id_curso));
            System.out.println("Entro aqui 123");
        }
        
        listaGrados();
        listaCursoGrado(id_grado);
        request.setAttribute("idGrado", id_grado);
        request.setAttribute("idCurso", id_curso);
        
        System.out.println("Entrea dopost");

        boolean res = false;
        try{
            String[] idsAlumnos = request.getParameterValues("idsAlumnos[]");
            String[] nomsAlumnos = request.getParameterValues("nomsAlumnos[]");
            String[] asisAlumnos = request.getParameterValues("asisAlumnos[]");
            String selectGrado = request.getParameter("selectGrado");
            String selectCurso = request.getParameter("selectCurso");
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
            System.out.println("null");
        }
        System.out.println("Sale dopost----------------------------");
        
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
}

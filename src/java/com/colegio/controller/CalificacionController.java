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
        request.setAttribute("listaGrados", new GradoDAO().ListarGrado());   
        
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
            request.setAttribute("listaCalifAlumno", listaCalifAlumno(id_grado, id_curso, id_perEscolar));
        }
        
        System.out.println("Entro a post calificacion");
        boolean res = false;
        try{
            
            String[] idsAlumnos = request.getParameterValues("idsAlumnos[]");
            for(int i = 0; i < idsAlumnos.length; i++)
            {
                System.out.println("idsAlumnos[i]: " + idsAlumnos[i]);
            }
            String[] notaPc1s = request.getParameterValues("notaPc1s[]");
            for(int i = 0; i < notaPc1s.length; i++)
            {
                System.out.println("notaPc1s[i]: " + notaPc1s[i]);
            }
            String[] notaPc2s = request.getParameterValues("notaPc2s[]");
            for(int i = 0; i < notaPc2s.length; i++)
            {
                System.out.println("notaPc2s[i]: " + notaPc2s[i]);
            }
            String[] notaPc3s = request.getParameterValues("notaPc3s[]");
            for(int i = 0; i < notaPc3s.length; i++)
            {
                System.out.println("notaPc3s[i]: " + notaPc3s[i]);
            }
            String[] notaExFins = request.getParameterValues("notaExFins[]");
            for(int i = 0; i < notaExFins.length; i++)
            {
                System.out.println("notaExFins[i]: " + notaExFins[i]);
            }
            String selectTrimestre = request.getParameter("selectTrimestre");
            System.out.println("selectTrimestre: " + selectTrimestre);
            String selectCurso = request.getParameter("selectCurso");
            System.out.println("selectCurso: " + selectCurso);
            String operacion = request.getParameter("operacion");
            System.out.println("operacion: " + operacion);
            for(int i = 0; i < idsAlumnos.length; i++)
            {
                System.out.println("idsAlumnos[i]: " + idsAlumnos[i]);
                System.out.println("notaPc1s[i]: " + notaPc1s[i]);
                System.out.println("notaPc2s[i]: " + notaPc2s[i]);
                System.out.println("notaPc3s[i]: " + notaPc3s[i]);
                System.out.println("notaExFins[i]: " + notaExFins[i]);
                System.out.println("selectTrimestre: " + selectTrimestre);
                System.out.println("selectCurso: " + selectCurso);
                if(operacion.equals("Actualizar")){
                    System.out.println("Actualizar-idsAlumnos[" + i +"]: " + idsAlumnos[i] + "notaPc1s[" + i +"]: " + notaPc1s[i] +
                                        "notaPc2s[" + i +"]: " + notaPc2s[i] + "notaPc3s[" + i +"]: " + notaPc3s[i] + "notaExFins[" + i +"]: " + notaExFins[i] +
                                        " - selectTrimestre: " + selectTrimestre + " - selectCurso: " + selectCurso);
                    res = actualizarCalificacion(idsAlumnos[i], selectCurso, Integer.parseInt(notaPc1s[i]), Integer.parseInt(notaPc2s[i]), 
                                                Integer.parseInt(notaPc3s[i]), Integer.parseInt(notaExFins[i]), 0, Integer.parseInt(selectTrimestre));
                    System.out.println("Actualizar: " + res);
                }else{
                    res = registrarAsistencia(idsAlumnos[i], selectCurso, Integer.parseInt(notaPc1s[i]), Integer.parseInt(notaPc2s[i]), 
                                                Integer.parseInt(notaPc3s[i]), Integer.parseInt(notaExFins[i]), 0, id_perEscolar);
                    System.out.println("Registrar: " + res);
                }
                
                if(res){
                    System.out.println("Si grabo");
                }else{
                    System.out.println("No grabo");
                }
            }
        }
        catch(Exception e){
            System.out.println("null");
        }
        request.setAttribute("idGrado", id_grado);
        request.setAttribute("idCurso", id_curso);
        request.setAttribute("idPerEscolar", id_perEscolar);
        System.out.println("salio a post calificacion");
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
    
    public List<Calificacion> listaCalifAlumno(String id_grado,String id_curso,int id_perEscolar){
        System.out.println("Parametros-listaCalifAlumno1111: " + id_grado+ " - " +id_curso+ " - " +id_perEscolar);
        List<Calificacion> listaCalifAlumno = new CalificacionDAO().ListarCalifAlum(id_grado, id_curso, id_perEscolar);
        request.setAttribute("operacion", "Actualizar");
        System.out.println("listaCalifAlumno-Actualizar222: " + listaCalifAlumno.size());
        if(listaCalifAlumno.size() <= 0){ //Esto indica que no existe alguna asistencia ya guardada el día.
            System.out.println("listaCalifAlumno-Registrar");
            request.setAttribute("operacion", "Registrar");
            //listaCalifAlumno = new CalificacionDAO().ObtenerCalifAlumGrado(id_grado, id_curso);
        }
        return listaCalifAlumno;
    }
    
    public boolean registrarAsistencia(String id_alumno, String id_curso, int pc1, int pc2, int pc3, int exfinal, int prom, int id_perEscolar){
        boolean res = false;
        Calificacion objCalif = new Calificacion(id_alumno, id_curso, pc1, pc2, pc3, exfinal, prom, id_perEscolar);
        
        res = new CalificacionDAO().RegistrarCalificacion(objCalif);
        return res;
    }
    
    public boolean actualizarCalificacion(String id_alumno, String id_curso, int pc1, int pc2, int pc3, int exfinal, int prom, int id_perEscolar){
        System.out.println("actualizarCalificacion");
        boolean res = false;
        Calificacion objCalif = new Calificacion(id_alumno, id_curso, pc1, pc2, pc3, exfinal, prom, id_perEscolar);
        
        res = new CalificacionDAO().ActualizarCalificacion(objCalif);
        return res;
    }
}

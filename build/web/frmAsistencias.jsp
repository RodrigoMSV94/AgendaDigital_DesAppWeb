<%@page import="com.colegio.model.Tarea"%>
<%@page import="com.colegio.model.Asistencia"%>
<%@page import="com.colegio.model.Curso"%>
<%@page import="com.colegio.model.Grado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Fonts Google -->
        <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600&display=swap" rel="stylesheet">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Content/bootstrap/bootstrap.min.css">
        <script src="Scripts/jquery/jquery-3-5-1.js" type="text/javascript"></script>
        
        <!-- Nuestro css-->
        <link rel="stylesheet" type="text/css" href="Content/css/estilos.css" th:href="@{Content/css/estilos.css}">    
        <link rel="icon" type="image/jpg" href="Content/img/login-avatar.png">
        <title>Colegio</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <main role="main" class="flex-shrink-0">
            <div class="container">
                <%
                String operacion = (String)request.getAttribute("operacion");
                String operTarea = (String)request.getAttribute("operTarea");
                %>
                <input type="hidden" id="operacion" name="operacion" value="<%=operacion%>"/>
                <br>
                <form action="AsistenciaController" method="post">
                    <div class="form-row justify-content-start form-inline">
                        <div class="col-auto my-1">
                            Seleccionar Grado:
                            <%
                            List<Grado> listaGrados = (List<Grado>)request.getAttribute("listaGrados"); 
                            %>
                            <select class="form-control" id="selectGrado" name="idGrado" onchange="cargaDatosCursoPorGrado()" required>
                                <option value="-1">Seleccionar grado</option> 
                                <%
                                for (Grado objGrado : listaGrados) {
                                    String idGrado = (String)request.getAttribute("idGrado");
                                    if(idGrado.equals(objGrado.getId_grado())){ 

                                %>
                                        <option value="<%=objGrado.getId_grado()%>" selected><%=objGrado.getGrado()%></option>
                                    <%
                                    } else {
                                    %>
                                        <option value="<%=objGrado.getId_grado()%>"><%=objGrado.getGrado()%></option>
                                    <%
                                    }
                                    %>   
                                <%
                                }
                                %>
                            </select>
                        </div>
                        <div class="col-auto my-1">
                            Seleccionar Curso:
                            <select class="form-control" id="selectCurso" name="txtIdCurso" required>
                            <%
                            if(request.getAttribute("listaCursoGrado")!= null){
                                List<Curso> listaCursoGrado = (List<Curso>)request.getAttribute("listaCursoGrado");
                            %>
                                        <option value="-1">Seleccionar curso</option> 
                                    <%
                                    for (Curso objCurso : listaCursoGrado) {
                                        String idCurso = (String)request.getAttribute("idCurso");
                                        if(idCurso.equals(objCurso.getId_curso())){
                                    %>
                                           
                                            <option value="<%=objCurso.getId_curso()%>" selected=""><%=objCurso.getNombre()%></option>
                                        <%
                                        } else {
                                        %>
                                            <option value="<%=objCurso.getId_curso()%>"><%=objCurso.getNombre()%></option>
                                        <%
                                        }
                                        %> 
                                    <%
                                    }
                                    %>
                            </select>
                            <%
                            }else{
                            %>
                                <option value="-1">Seleccionar curso</option>    
                            <%
                            }
                            %>
                            </select>
                        </div>
                        <div class="col-auto my-1 ml-auto">
                            <button type="submit" class="btn btn-dark">
                                <i class="fas fa-search"></i>Buscar
                            </button>
                        </div>
                    </div>
                </form>
                <br>
                <br>
                <%
                List<Asistencia> listaAsisAlumnos = (List<Asistencia>)request.getAttribute("listaAsisAlumnos");
                if(request.getAttribute("listaAsisAlumnos")!= null){ 
                %>
                    <table class="table" id="tabla">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col" class="text-center">Código Alumno</th>
                                <th scope="col" class="text-center">Nombre Alumno</th>
                                <th scope="col" class="text-center">Asistencia</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            for (Asistencia objAsistencia : listaAsisAlumnos) {
                            %>
                                <tr>
                                    <td class="text-center"><%=objAsistencia.getId_alumno()%> </td>
                                    <td class="text-center"><%=objAsistencia.getNomAlumno()%> <%=objAsistencia.getApeAlumno()%></td>
                                    <td class="text-center">
                                        <%
                                        if(objAsistencia.getAsistio() != 0){
                                        %>
                                            <input name="checkbox" type="checkbox" value="1" checked/>
                                        <%
                                        } else {
                                        %>
                                            <input name="checkbox" type="checkbox" value="1" />
                                        <%
                                        }
                                    %>
                                    </td>
                                </tr>
                            <%
                            } 
                            %>
                        </tbody>
                    </table>
                    <br>
                    <div class="form-row justify-content-start form-inline">
                        <div class="col-auto my-1 ml-auto">
                            <button type="button" class="btn btn-success" id="btnGuardar"><i class="far fa-save"></i>  Guardar</button>
                        </div>
                    </div>
                    <br>
                    <div class="card">
                        <div class="card-header">
                            Descripción de tarea:
                        </div>
                        <div class="card-body">
                                <input type="hidden" id="operTarea" name="operTarea" value="<%=operTarea%>"/>
                            <%
                            if(request.getAttribute("objTarea")!= null){ 
                                Tarea objTarea = (Tarea)request.getAttribute("objTarea");
                            %>
                                <input type="text" class="form-control" id="txtDesTarea" name="txtDesTarea" value="<%=objTarea.getDescripcion()%>">
                            <%
                            }else{
                            %>
                                <input type="text" class="form-control" id="txtDesTarea" name="txtDesTarea">
                            <%
                            }
                            %>
                            
                            <br>
                            <div class="col-auto my-1 ml-auto">
                                <button type="button" class="btn btn-info" id="btnTarea"><i class="far fa-save"></i>  Agregar Tarea</button>
                            </div>
                        </div>
                        <br> 
                    </div>
                    <br> 
                    
                <%
                } else {
                %>
                    <p class="card-text">Seleccione el grado y curso a registrar la asistencia. </p>
                <%
                }
                %>
                
            </div>
        </main>
               
        <script src="Scripts/jswebapp/frmAsistencias.js" type="text/javascript"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>

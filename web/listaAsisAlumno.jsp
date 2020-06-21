<%@page import="com.colegio.model.Asistencia"%>
<%@page import="java.util.List"%>
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

        <!-- Nuestro css-->
        <link rel="stylesheet" type="text/css" href="Content/css/estilos.css" th:href="@{Content/css/estilos.css}">
        <link rel="icon" type="image/jpg" href="Content/img/login-avatar.png">
        <title>Colegio</title>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <main role="main" class="flex-shrink-0">
            <div class="container">
                <br>
                <form action="AsistenciaAlumnoController" method="post">
                    <div class="form-row justify-content-start form-inline">
                        <div class="col-auto my-1">
                            Fecha de consulta:
                            <%
                            if(request.getAttribute("fecha_consulta") != null){
                                String fecha_consulta = request.getAttribute("fecha_consulta").toString();
                            %>
                                <input type="Date" class="form-control" id="txtFechConsulta" name="txtFechConsulta" value="<%=fecha_consulta%>">    
                            <%
                            } else {  
                                
                            %>
                                <input type="Date" class="form-control" id="txtFechConsulta" name="txtFechConsulta" required>
                            <%
                            }    
                            %>
                        </div>
                        <div class="col-auto my-1 ml-auto">
                            <button type="submit" class="btn btn-dark">
                                <i class="fas fa-search"></i>Buscar
                            </button>
                        </div>
                    </div>
                </form>
                <br>
                 <%
                List<Asistencia> listaAsisAlumno = (List<Asistencia>) request.getAttribute("listaAsisAlumno");
                    if(request.getAttribute("listaAsisAlumno") != null){
                        if(listaAsisAlumno.size() > 0){
                %>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col" class="text-center">Curso</th>
                                    <th scope="col" class="text-center">Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Asistencia objAsistencia : listaAsisAlumno) {
                                %>
                                <tr>
                                    <th class="text-center"><%=objAsistencia.getNomCurso()%></th>
                                    <%
                                    if(objAsistencia.getAsistio() == 1) {
                                    %>    
                                        <td class="text-center">Asistió</td>
                                    <%
                                    } else {
                                    %>
                                        <td class="text-center">No Asistió</td>
                                    <%
                                    } 
                                    %>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    <%
                        } else {
                    %>
                            <p class="card-text">No tienes registro de asistencia en esa fecha </p>
                    <%
                        }
                    %>
                <%
                    } else {
                %>
                        <p class="card-text">Selecciona la fecha en la que desea ver sus asistencias </p>
                <%
                    }
                %>
                <br>
            </div>
        </main>

        <%@include file="footer.jsp" %>
    </body>
</html>
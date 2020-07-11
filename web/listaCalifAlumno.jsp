<%@page import="com.colegio.model.Calificacion"%>
<%@page import="com.colegio.model.PeriodoEscolar"%>
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
                <form action="CalificacionAlumnoController" method="post">
                    <div class="form-row justify-content-start form-inline">
                        <div class="col-auto my-1">
                            Seleccionar periodo escolar:
                            <%
                                List<PeriodoEscolar> listaPerEscolar = (List<PeriodoEscolar>)request.getAttribute("listaPerEscolar"); 
                            %>
                            <select class="form-control" id="select-group" name="idPerEscolar" required>
                                <%
                                    for (PeriodoEscolar objPerEscolar : listaPerEscolar) {
                                        Integer idPerEscolar = Integer.parseInt((request.getParameter("idPerEscolar") != null)?request.getParameter("idPerEscolar"):"0");
                                        if(idPerEscolar == objPerEscolar.getId_periodoEscolar()){
                                %>
                                            <option value="<%=objPerEscolar.getId_periodoEscolar()%>" selected><%=objPerEscolar.getNombre()%></option>
                                        <%
                                        } else {
                                        %>
                                            <option value="<%=objPerEscolar.getId_periodoEscolar()%>"><%=objPerEscolar.getNombre()%></option>
                                        <%
                                        }
                                        %>
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
                <%
                List<Calificacion> listaCalifAlumno = (List<Calificacion>)request.getAttribute("listaCalifAlumno");
                    if(request.getAttribute("listaCalifAlumno") != null ){
                        
                %>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col" class="text-center">Curso</th>
                                    <th scope="col" class="text-center">Prac. Calificada 1</th>
                                    <th scope="col" class="text-center">Prac. Calificada 2</th>
                                    <th scope="col" class="text-center">Prac. Calificada 3</th>
                                    <th scope="col" class="text-center">Examen Fianl</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Calificacion objCalif : listaCalifAlumno) {
                                %>
                                <tr>
                                    <th class="text-center"><%=objCalif.getNomCurso()%></td>
                                    <td class="text-center"><%=objCalif.getPractica_calificada_1()%></td>
                                    <td class="text-center"><%=objCalif.getPractica_calificada_2()%></td>
                                    <td class="text-center"><%=objCalif.getPractica_calificada_3()%></td>
                                    <td class="text-center"><%=objCalif.getExamen_final()%></td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                <%
                    } else {
                %>
                        <p class="card-text">El alumno aun no tiene notas cargadas de este periodo </p>
                <%
                    }
                %>
                <br>
            </div>
        </main>

        <%@include file="footer.jsp" %>
    </body>
</html>
<%@page import="com.colegio.model.Incidencia"%>
<%@page import="com.colegio.model.Tarea"%>
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
                <form action="AgendaController" method="post">
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
                <div class="card">
                    <div class="card-header">
                        TAREAS EN LOS CURSOS:
                    </div>
                    <div class="card-body">
                        <%
                        List<Tarea> listaTareasGrado = (List<Tarea>) request.getAttribute("listaTareasGrado");
                            if(request.getAttribute("listaTareasGrado") != null){
                                for (Tarea objTareaGrado : listaTareasGrado) {
                        %>
                            <h5 class="card-title">Curso: <%=objTareaGrado.getNomCurso()%></h5>
                            <p class="card-text">Mensaje: <%=objTareaGrado.getDescripcion()%> </p>
                            <%
                            }
                            %>
                        <%    
                        } else {
                        %>
                            <p class="card-text">No tiene tareas </p>
                        <%    
                        }
                        %>
                    </div>

                </div>
                <br>
                <%
                List<Incidencia> listaIncsAlumo = (List<Incidencia>) request.getAttribute("listaIncsAlumo");
                    if(request.getAttribute("listaIncsAlumo") != null){
                %>
                        <div class="card">
                            <div class="card-header">
                                INCIDENCIAS EN LOS CURSOS:
                            </div>
                            <div class="card-body">
                                <%
                                for (Incidencia objIncidenciaAlum : listaIncsAlumo) {
                                %>
                                    <h5 class="card-title">Curso: <%=objIncidenciaAlum.getNomCurso()%></h5>
                                    <p class="card-text">Observación: <%=objIncidenciaAlum.getDescripcion()%> </p>
                                <%
                                }
                                %>
                            </div>
                        </div>
                        <br>
                <%    
                    } 
                %>
                <br>
            </div>
        </main>

        <%@include file="footer.jsp" %>
    </body>
</html>
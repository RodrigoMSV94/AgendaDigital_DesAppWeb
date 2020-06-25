<%@page import="com.colegio.model.Incidencia"%>
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
                <form action="IncidenciaController" method="post">
                    <div class="form-row justify-content-start form-inline">
                        <div class="col-auto my-1">
                            Seleccionar alumno:
                            <%
                            List<Alumno> listaAlumnos = (List<Alumno>)request.getAttribute("listaAlumnos"); 
                            %>
                            <select class="form-control" id="select-group" name="idAlumno" required>
                                <%
                                for (Alumno objAlum : listaAlumnos) {
                                    String idAlumno = (String)request.getAttribute("idAlumno");
                                    if(idAlumno.equals(objAlum.getId_alumno()) ){ 
                                %>
                                        <option value="<%=objAlum.getId_alumno()%>" selected><%=objAlum.getNombre()%> <%=objAlum.getApellido()%></option>
                                    <%
                                    } else {
                                    %>
                                        <option value="<%=objAlum.getId_alumno()%>"><%=objAlum.getNombre()%> <%=objAlum.getApellido()%></option>
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
                <a class="btn btn-primary" href="IncidenciaController?accion=1"><i class="fas fa-user-plus"></i>  Registrar Citación</a>
                <br>
                <br>
                <%
                    if(request.getAttribute("msgEliminar") != null){
                        String msgEliminar = request.getAttribute("msgEliminar").toString();  
                %>
                    <div class="alert alert-warning alert-dismissible fade show" role="alert">
                        <strong><%=msgEliminar%></strong> 
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <%    
                }
                %>
                <%
                List<Incidencia> listaIncidenciasAlum = (List<Incidencia>)request.getAttribute("listaIncidenciasAlum");
                    if(listaIncidenciasAlum.size() > 0 ){ 
                %>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col" class="text-center">Nombre Alumno</th>
                                    <th scope="col" class="text-center">Curso</th>
                                    <th scope="col" class="text-center">Descripción</th>
                                    <th scope="col" class="text-center">Fecha de incidencia</th>
                                    <th scope="col" class="text-center">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                for (Incidencia objIncidencia : listaIncidenciasAlum) {
                                %>
                                    <tr>
                                        <td class="text-center"><%=objIncidencia.getNomAlumno()%> <%=objIncidencia.getApeAlumno()%></td>
                                        <td class="text-center"><%=objIncidencia.getNomCurso()%></td>
                                        <th class="text-center"><%=objIncidencia.getDescripcion()%></th>
                                        <th class="text-center"><%=objIncidencia.getFecha_cita()%></th>
                                        <td class="text-center">
                                            <a class="btn btn-info" href="IncidenciaController?accion=2&idAlumno=<%=objIncidencia.getId_alumno()%>&idCurso=<%=objIncidencia.getId_curso()%>&fechCita=<%=objIncidencia.getFecha_cita()%>">
                                                <i class="fas fa-pen"></i>  Editar
                                            </a> | 
                                            <a class="btn btn-danger" href="IncidenciaController?accion=3&idAlumno=<%=objIncidencia.getId_alumno()%>&idCurso=<%=objIncidencia.getId_curso()%>&fechCita=<%=objIncidencia.getFecha_cita()%>">
                                                <i class="fas fa-trash"></i>  Eliminar
                                            </a>
                                        </td>
                                    </tr>
                                <%
                                } 
                                %>
                            </tbody>
                        </table>
                <%
                    } else {
                %>
                        <p class="card-text">El alumno selecciona no tiene citaciones registradas </p>
                <%
                    }
                %>
                <br>
            </div>
        </main> 

        <%@include file="footer.jsp" %>
    </body>
</html>

<%@page import="com.colegio.model.Citacion"%>
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
                <form action="CitacionController" method="post">
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
                <a class="btn btn-primary" href="CitacionController?accion=1"><i class="fas fa-user-plus"></i>  Registrar Citacion</a>
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
                List<Citacion> listaCitasAlumnos = (List<Citacion>)request.getAttribute("listaCitasAlumnos");
                    if(listaCitasAlumnos.size() > 0 ){ 
                %>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col" class="text-center">Nombre Alumno</th>
                                    <th scope="col" class="text-center">Motivo</th>
                                    <th scope="col" class="text-center">Fecha de incidencia</th>
                                    <th scope="col" class="text-center">Fecha de registro</th>
                                    <th scope="col" class="text-center">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                for (Citacion objCitacion : listaCitasAlumnos) {
                                %>
                                    <tr>
                                        <td class="text-center"><%=objCitacion.getNomAlumno()%> <%=objCitacion.getApeAlumno()%></td>
                                        <td class="text-center"><%=objCitacion.getMotivo()%></td>
                                        <th class="text-center"><%=objCitacion.getFecha_cita()%></th>
                                        <th class="text-center"><%=objCitacion.getFecha_registro()%></th>
                                        <td class="text-center">
                                            <a class="btn btn-info" href="CitacionController?accion=2&idAlumno=<%=objCitacion.getId_alumno()%>&idCita=<%=objCitacion.getId_cita()%>">
                                                <i class="fas fa-pen"></i>  Editar
                                            </a> | 
                                            <a class="btn btn-danger" href="CitacionController?accion=3&idAlumno=<%=objCitacion.getId_alumno()%>&idCita=<%=objCitacion.getId_cita()%>">
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

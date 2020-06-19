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
                <form action="AlumnoController" method="get">
                    <div class="card" >
                        <div class="card-body">
                            <div class="form-row justify-content-start form-inline" >
                                <div class="col-auto my-1">
                                    Buscar por DNI:
                                    <input type="text" class="form-control" id="exampleFormControlInput1" name="txtDNIBuscar" maxlength="8" value="0" >
                                </div>
                                <input type="hidden" id="hddidCurso" name="accion" value="1"/>
                                <div class="col-auto my-1 ml-auto">
                                    <button type="submit" class="btn btn-dark">
                                        <i class="fas fa-search"></i>Buscar
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <br>
                <a class="btn btn-primary" href="AlumnoController?accion=2"><i class="fas fa-user-plus"></i>  Registrar Alumno</a>
                <br>
                <br>
                <%
                List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
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
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col" class="text-center">Código</th>
                            <th scope="col" class="text-center">DNI</th>
                            <th scope="col" class="text-center">Nombre</th>
                            <th scope="col" class="text-center">Apellido</th>
                            <th scope="col" class="text-center">Correo</th>
                            <th scope="col" class="text-center">Telf Emergencia</th>
                            <th scope="col" class="text-center">Estado</th>
                            <th scope="col" class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Alumno objAlumno : listaAlumnos) {
                        %>
                        <tr>
                            <th scope="row" class="text-center"><%=objAlumno.getId_alumno()%></th>
                            <td class="text-center"><%=objAlumno.getDni_alumno()%></td>
                            <td class="text-center"><%=objAlumno.getNombre()%></td>
                            <td class="text-center"><%=objAlumno.getApellido()%></td>
                            <td class="text-center"><%=objAlumno.getCorreo()%></td>
                            <td class="text-center"><%=objAlumno.getTelefono_emergencia()%></td>
                            <td class="text-center"><%=objAlumno.getEstado()%></td>
                            <td class="text-center">
                                <a class="btn btn-info" href="AlumnoController?accion=3&idAlumno=<%=objAlumno.getId_alumno()%>"><i class="fas fa-pen"></i>  Editar</a> | 
                                <a class="btn btn-danger" href="AlumnoController?accion=4&idAlumno=<%=objAlumno.getId_alumno()%>"><i class="fas fa-trash"></i>  Eliminar</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <br>
            </div>
        </main>

        <%@include file="footer.jsp" %>
    </body>
    <!-- jQuery first, then Popper.js, then Bootstrap JS, Fontawesome -->
    <script src="Scripts/jquery/jquery-3.5.1.slim.min.js"></script>
    <script src="Scripts/bootstrap/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/709cccdb82.js" crossorigin="anonymous"></script>
</html>

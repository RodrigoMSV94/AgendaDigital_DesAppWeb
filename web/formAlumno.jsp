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
                <div class="card" >
                    <div class="card-header">
                        Registrar Alumno
                    </div>
                    <div class="card-body">
                        <form method="post" action="AlumnoController">
                        <%
                        if(request.getAttribute("objAlumno") == null){
                        %>
                            
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtDNI">Número de DNI:</label>
                                    <input type="text" class="form-control" id="txtDNI" name="txtDNI" placeholder="Nro. de DNI" required>
                                </div>
                                <div class="col">
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtNombre">Nombres Completos:</label>
                                    <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Nombres" required>
                                </div>
                                <div class="col">
                                    <label for="txtApellido">Apellidos Completos:</label>
                                    <input type="text" class="form-control" id="txtApellido" name="txtApellido" placeholder="Apellidos" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtFechNacimiento">Fecha de Nacimiento:</label>
                                    <input type="Date" class="form-control" id="txtFechNacimiento" name="txtFechNacimiento" required>
                                </div>
                                <div class="col">
                                    <label for="txtLugarNacimiento">Lugar de Nacimiento:</label>
                                    <input type="text" class="form-control" id="txtLugarNacimiento" name="txtLugarNacimiento" placeholder="Lugar de Nacimiento" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtDireccion">Dirección de domicilio:</label>
                                    <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" placeholder="Dirección" required>
                                </div>
                                <div class="col">
                                    <label for="txtTelfEmergencia">Teléfono de Emergencia:</label>
                                    <input type="text" class="form-control" id="txtTelfEmergencia" name="txtTelfEmergencia" placeholder="Tlf. de Emergencia" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtCorreo">Correo Eléctronico:</label>
                                    <input type="text" class="form-control" id="txtCorreo" name="txtCorreo" placeholder="Correo" required>
                                </div>
                                <div class="col">
                                    <label for="txtContrasena">Contraseña:</label>
                                    <input type="text" class="form-control" id="txtContrasena" name="txtContrasena" placeholder="Contraseña" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtNomApoderado">Nombre de Apoderado:</label>
                                    <input type="text" class="form-control" id="txtNomApoderado" name="txtNomApoderado" placeholder="Nombre de Apoderado" required>
                                </div>
                                <div class="col">
                                    <label for="txtOcupApoderado">Ocupación de Apoderado:</label>
                                    <input type="text" class="form-control" id="txtOcupApoderado" name="txtOcupApoderado" placeholder="Ocupación de Apoderado" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="exampleFormControlSelect1">Estado de Registro:</label>
                                    <select class="form-control" id="exampleFormControlSelect1" name="txtEstado" required>
                                        <option value="Activo" selected>Activo</option>
                                        <option value="Inactivo">Inactivo</option>
                                    </select>
                                </div>
                                <div class="col">
                                </div>
                            </div>
                            <input type="hidden" id="txtPerfil" name="txtPerfil" value="3"/>
                            <input type="hidden" id="operacion" name="operacion" value="Registrar"/>
                            <br>   
                        <%
                        } else {
                            Alumno objAlumno = (Alumno)request.getAttribute("objAlumno");
                        %>
                            <input type="hidden" id="txtIdAlumno" name="txtIdAlumno" value="<%=objAlumno.getId_alumno()%>"/>    
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtDNI">Número de DNI:</label>
                                    <input type="text" class="form-control" id="txtDNI" name="txtDNI" placeholder="Nro. de DNI" value="<%=objAlumno.getDni_alumno()%>" required>
                                </div>
                                <div class="col">
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtNombre">Nombres Completos:</label>
                                    <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Nombres" value="<%=objAlumno.getNombre()%>" required>
                                </div>
                                <div class="col">
                                    <label for="txtApellido">Apellidos Completos:</label>
                                    <input type="text" class="form-control" id="txtApellido" name="txtApellido" placeholder="Apellidos" value="<%=objAlumno.getApellido()%>" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtFechNacimiento">Fecha de Nacimiento:</label>
                                    <input type="Date" class="form-control" id="txtFechNacimiento" name="txtFechNacimiento" value="<%=objAlumno.getFecha_nacimiento()%>" required>
                                </div>
                                <div class="col">
                                    <label for="txtLugarNacimiento">Lugar de Nacimiento:</label>
                                    <input type="text" class="form-control" id="txtLugarNacimiento" name="txtLugarNacimiento" placeholder="Lugar de Nacimiento" value="<%=objAlumno.getLugar_nacimiento()%>" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtDireccion">Dirección de domicilio:</label>
                                    <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" placeholder="Dirección" value="<%=objAlumno.getDireccion()%>" required>
                                </div>
                                <div class="col">
                                    <label for="txtTelfEmergencia">Teléfono de Emergencia:</label>
                                    <input type="text" class="form-control" id="txtTelfEmergencia" name="txtTelfEmergencia" placeholder="Tlf. de Emergencia" value="<%=objAlumno.getTelefono_emergencia()%>" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtCorreo">Correo Eléctronico:</label>
                                    <input type="text" class="form-control" id="txtCorreo" name="txtCorreo" placeholder="Correo" value="<%=objAlumno.getCorreo()%>" required>
                                </div>
                                <div class="col">
                                    <label for="txtContrasena">Contraseña</label>
                                    <input type="text" class="form-control" id="txtContrasena" name="txtContrasena" placeholder="Contraseña" value="<%=objAlumno.getContrasena()%>" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="txtNomApoderado">Nombre de Apoderado</label>
                                    <input type="text" class="form-control" id="txtNomApoderado" name="txtNomApoderado" placeholder="Nombre de Apoderado" value="<%=objAlumno.getNombres_apoderado()%>" required>
                                </div>
                                <div class="col">
                                    <label for="txtOcupApoderado">Ocupación de Apoderado</label>
                                    <input type="text" class="form-control" id="txtOcupApoderado" name="txtOcupApoderado" placeholder="Ocupación de Apoderado" value="<%=objAlumno.getOcupacion()%>" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col">
                                    <label for="exampleFormControlSelect1">Estado de Registro:</label>
                                    <select class="form-control" id="exampleFormControlSelect1" name="txtEstado">
                                    <%
                                    if(objAlumno.getEstado().equals("Activo")){
                                    %>
                                        <option value="Activo" selected>Activo</option>
                                        <option value="Inactivo">Inactivo</option>
                                    <%
                                    } else {
                                    %>
                                        <option value="Activo">Activo</option>
                                        <option value="Inactivo" selected>Inactivo</option>
                                    <%
                                    }
                                    %>    
                                    </select>
                                </div>
                                <div class="col">
                                </div>
                            </div>
                            <input type="hidden" id="txtPerfil" name="txtPerfil" value="<%=objAlumno.getId_perfil()%>"/>
                            <input type="hidden" id="txtFechRegistro" name="txtFechRegistro" value="<%=objAlumno.getFecha_registro()%>"/>
                            <input type="hidden" id="operacion" name="operacion" value="Actualizar"/>
                            <br>

                        <%
                        }    
                        %>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                            <a class="btn btn-secondary" href="AlumnoController">Volver a lista</a>
                        </form>
                    </div>
                    <div class="container">
                        <%
                        if(request.getAttribute("respuesta") != null){
                            String colorAlert = (String)request.getAttribute("colorAlert");
                        %>
                            <div class="alert alert-<%=colorAlert%>" role="alert">
                                <%=request.getAttribute("respuesta")%>
                            </div>
                        <%
                        }
                        %>
                    </div>
                </div>
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
